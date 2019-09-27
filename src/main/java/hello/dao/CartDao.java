package hello.dao;

import hello.entitiy.Cart;
import hello.entitiy.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface CartDao extends JpaRepository<Cart,Long> {
  ArrayList<Cart> findAllByUserName(String userName);
  Cart findCartByproductId(Integer id);
  Cart findCartByUserNameAndProductId(String userName,Integer id);

  @Query("Select SUM(productCounter) from Cart where userName =:name")
  Integer getSumOfProductCountersForCurrentUser(@Param ("name")String userName);


}
