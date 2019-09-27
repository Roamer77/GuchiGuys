package hello.controllers;

import hello.services.CartService;
import hello.services.OrderService;
import hello.tryBean.BeanClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/admin")
public class AdminRestController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private CartService cartService;
    @Autowired
    @Qualifier("beanClass")
    private BeanClass beanClass;
    @GetMapping("/info")
    private String getAdminInfo(){
        return  "Hello Admin";
    }

    @GetMapping("/userInfo")
    private  void getUserInfo(){
        cartService.getInfoByUserName("admin");
    }

    @GetMapping("/baenClass")
    private  String doThis(){
       return beanClass.doSmth();
    }

    @GetMapping("/ListOfOrders")
    private  ModelAndView listOfOrders(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("orders");
        return modelAndView;
    }
    @GetMapping("/getListOfOrders")
    private  Response getListOfOrders(){
        return new Response("Done",orderService.getAllOrders());
    }
}
