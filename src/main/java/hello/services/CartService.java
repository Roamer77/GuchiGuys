package hello.services;

import hello.dao.CartDao;
import hello.entitiy.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class CartService {

    @Autowired
    private CartDao cartDao;

    public  ArrayList<Integer> getInfoByUserName(String userName){
        ArrayList<Integer> listOfProductIdForCurrentUser=new ArrayList<>();
        cartDao.findAllByUserName(userName).forEach(s->{ System.out.println("Логин: "+s.getUserName()+" ID товара:"+s.getProductId());
                                            listOfProductIdForCurrentUser.add(s.getProductId());                                 });
        return  listOfProductIdForCurrentUser;
    }
    public Integer getCounterForProductForCurrentUser(String userName,Integer productID){
       return cartDao.findCartByUserNameAndProductId(userName,productID).getProductCounter();
    }

    public Cart addProductToCart(String userName,Integer productId,Integer productCounter){
        return  this.cartDao.save(new Cart(userName,productId,productCounter));
    }
    public  void  deleteProductFromCart(Integer productID){
         this.cartDao.delete(cartDao.findCartByproductId(productID));
    }
    public  Cart findCartByProductId(Integer id ){
        return cartDao.findCartByproductId(id);
    }
    //метод для сохранения состояния
    public  void saveChanges(Cart cart){
        this.cartDao.save(cart);
    }
    public  Cart findCartByUserNameAndProductId(String userName,Integer productID){
       return this.cartDao.findCartByUserNameAndProductId(userName,productID);
    }

    public  Integer getSumOfProductCountersForCurrentUser(String userName){
        return  this.cartDao.getSumOfProductCountersForCurrentUser(userName);
    }
}
