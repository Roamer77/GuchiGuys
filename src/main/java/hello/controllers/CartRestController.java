package hello.controllers;

import hello.entitiy.Cart;
import hello.entitiy.OrderComposition;
import hello.entitiy.Product;
import hello.security.ClassForUserInfo;
import hello.services.CartService;
import hello.services.OrderService;
import hello.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Logger;

@RestController
@RequestMapping("/cart")
public class CartRestController {
    private Logger logger=Logger.getLogger(this.getClass().getName());

    @Autowired
    private OrderService orderService;
    @Autowired
    @Qualifier("ClassForUserInfo")
    private  ClassForUserInfo classForUserInfo;
   @Autowired
   private  CartService cartService;
    @Autowired
    private ProductService productService;
/* Данный метод вернёт содержимое карзины для пользователя(текущего) вошедшего в систему */
    @GetMapping("/getCartFoCurrentUser")
    public  Response getCartFoCurrentUser(){
        classForUserInfo=new ClassForUserInfo();
        ArrayList<Integer> productIdForCurrentUser= cartService.getInfoByUserName(classForUserInfo.getCurrentUserName());//наёдёт всё содержимое из таблицы "Cart" для нужного пользователя
        ArrayList<Product> listOfProductsInUserCart=new ArrayList<>();
        productIdForCurrentUser.forEach(System.out::println);
        for(Integer id:productIdForCurrentUser){
            listOfProductsInUserCart.add(productService.getProductById(id));
            productService.getProductById(id).setProductCounter(cartService.getCounterForProductForCurrentUser(classForUserInfo.getCurrentUserName(),id));

        }

        return new  Response("Done",listOfProductsInUserCart);
    }

    /*Метод для добавления в карзуну товаров текущем пользователем (вощедшим в систему)*/
    @GetMapping ("/addToProductToCart")
    @ResponseBody
    public void  addProductToCart(@RequestParam String  id){
        System.out.println("ID который пришел "+id);
        String  currentUserName= classForUserInfo.getCurrentUserName();
        System.out.println("Новое поле добавлено в таблицу 'Cart' ");
        if(!currentUserName.equals("anonymousUser")){
            Cart tmpProduct=cartService.findCartByUserNameAndProductId(currentUserName,Integer.parseInt(id));
            if (tmpProduct!=null){
                logger.info("Данные текущем продукте который будем изменять: ");
                logger.info("id продукта "+tmpProduct.getProductId()+","+"Колво-продуктов в карзине: "+tmpProduct.getProductCounter()+"Имя пользователя "+tmpProduct.getUserName());

                tmpProduct.setProductCounter(tmpProduct.getProductCounter()+1);
                cartService.saveChanges(tmpProduct);

                logger.info("Я из метода addProductToCart и сейчас изменил счётчит ковара ");
            }else {
                cartService.addProductToCart(currentUserName,Integer.parseInt(id),1);

                logger.info("Я из метода addProductToCart и сейчас добавил новый товар ");
            }
        } else{
            logger.info("Так как пользователь являеться- "+currentUserName+". Добавить в карзину запрет");
        }

    }
    @GetMapping("/userInfo")
    private  Response getUserInfo(){
       return new Response("Done",classForUserInfo.getCurrentUserName());
    }

    @GetMapping ("/yourCart")
    private ModelAndView showCartHtml(){
        ModelAndView modelAndView  =new ModelAndView();
        modelAndView.setViewName("cart");
        return modelAndView;
    }
    @GetMapping("/makeOrder")
    @ResponseBody
    private OrderComposition makeOrder(@RequestParam Map<String,String> allParams){
        System.out.println(allParams.entrySet());
        System.out.println("Добавил новый заказ в таблицу OrderComposition");
        String productName=productService.getProductById(Integer.parseInt(allParams.get("productID"))).getName();
        return  orderService.addOrder(allParams.get("name"),allParams.get("secondName"),allParams.get("address"),
              Integer.parseInt(allParams.get("productID")) ,Integer.parseInt(allParams.get("productCounter")),1, productName);
    }
    @GetMapping("/deleteFromCart")
    @ResponseBody
    private  void deleteFromCart(@RequestParam (value = "id") Integer productID){
        System.out.println("Из карзины был удалёт  продукт с ID: "+productID);

        Cart tmpProduct=cartService.findCartByUserNameAndProductId(classForUserInfo.getCurrentUserName(),productID);
        if(tmpProduct!=null&& tmpProduct.getProductCounter()!=1){
            tmpProduct.setProductCounter(tmpProduct.getProductCounter()-1);
            cartService.saveChanges(tmpProduct);
        }else  if(tmpProduct!=null&& tmpProduct.getProductCounter()==1){
            cartService.deleteProductFromCart(productID);
        }
    }

    @GetMapping("/checkProductCounterInCart")
    private Response checkProductCounterInCart(){
       String userName= classForUserInfo.getCurrentUserName();
        return  new Response("Done",cartService.getSumOfProductCountersForCurrentUser(userName));
    }


}
