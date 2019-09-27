package hello.entitiy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class OrderComposition {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long oderId; // ключ к таблице Заказы

    private  Integer accountId; //ключ к таблице Аккаутны
    private Integer productId; // ключ к таблице Продукты
    private Integer amountOfProducts;

    private  String productName;
    private  String customerName;
    private  String customerSecondName;
    private  String customerAddress;

    public OrderComposition() {
    }

    public OrderComposition(Integer accountId, Integer productId, Integer amountOfProducts, String customerName, String customerSecondName, String customerAddress,String productName) {
        this.accountId = accountId;
        this.productId = productId;
        this.amountOfProducts = amountOfProducts;
        this.customerName = customerName;
        this.customerSecondName = customerSecondName;
        this.customerAddress = customerAddress;
        this.productName=productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerSecondName() {
        return customerSecondName;
    }

    public void setCustomerSecondName(String customerSecondName) {
        this.customerSecondName = customerSecondName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Long getOderId() {
        return oderId;
    }

    public void setOderId(Long oderId) {
        this.oderId = oderId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getAmountOfProducts() {
        return amountOfProducts;
    }

    public void setAmountOfProducts(Integer amountOfProducts) {
        this.amountOfProducts = amountOfProducts;
    }
}
