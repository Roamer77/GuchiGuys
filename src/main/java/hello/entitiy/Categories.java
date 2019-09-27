package hello.entitiy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categories {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO )
    private Integer id;

    private String name;
    private  Integer productCounter;

    public Categories() {
    }

    public Categories(String name, Integer productCounter) {
        this.name = name;
        this.productCounter = productCounter;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProductCounter() {
        return productCounter;
    }

    public void setProductCounter(Integer productCounter) {
        this.productCounter = productCounter;
    }
}
