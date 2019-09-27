package hello.entitiy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String  name;
    @JsonProperty("description")
    private  String description;
    @JsonProperty("uri")
    private  String ImageURI;
    @JsonProperty("price")
    private  Double cost;
    @JsonProperty("productCounter")
    private  Integer productCounter;
    @JsonIgnore
    private  Integer categoryId; //id котигории к которой отниситья продукт. Ключ к таблице котегории
    @JsonIgnore
    private  Integer producerId; // id производителя товара. Ключ к таблице производителей

    public Product() {
    }

    public Product(String name, String description, String imageURI, Double cost, Integer productCounter, Integer categoryId, Integer producerId) {
        this.name = name;
        this.description = description;
        ImageURI = imageURI;
        this.cost = cost;
        this.productCounter = productCounter;
        this.categoryId = categoryId;
        this.producerId = producerId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURI() {
        return ImageURI;
    }

    public void setImageURI(String imageURI) {
        ImageURI = imageURI;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getProductCounter() {
        return productCounter;
    }

    public void setProductCounter(Integer productCounter) {
        this.productCounter = productCounter;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getProducerId() {
        return producerId;
    }

    public void setProducerId(Integer producerId) {
        this.producerId = producerId;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ImageURI='" + ImageURI + '\'' +
                ", cost=" + cost +
                ", productCounter=" + productCounter +
                ", categoryId=" + categoryId +
                ", producerId=" + producerId +
                '}';
    }
}
