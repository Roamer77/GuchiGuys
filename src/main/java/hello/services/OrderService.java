package hello.services;

import hello.dao.OrderDao;
import hello.entitiy.OrderComposition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;

    public OrderComposition addOrder(String customerName,String  customerSecondName,String customerAddress,
                                     Integer productId,Integer productCounter,Integer accountID,String productName){
        return  this.orderDao.save(new OrderComposition(accountID,productId,productCounter,customerName,customerSecondName,customerAddress,productName));
    }

    public ArrayList<OrderComposition> getAllOrders(){
        return  orderDao.findAll();
    }
}
