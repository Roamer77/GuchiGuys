package hello.entitiy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cart {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer id;

    private  Integer productId;
    private  String userName;
    private Integer productCounter;

    public Cart() {
    }

    public Cart( String userName,Integer productId,Integer productCounter) {
        this.userName = userName;
        this.productId=productId;
        this.productCounter=productCounter;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductCounter() {
        return productCounter;
    }

    public void setProductCounter(Integer productCounter) {
        this.productCounter = productCounter;
    }
}
