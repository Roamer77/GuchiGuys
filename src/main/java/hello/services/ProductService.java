package hello.services;

import hello.dao.ProductDao;
import hello.entitiy.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductDao productDao;

    public  Product addProduct(Product product){
        return this.productDao.save(product);
    }
    public  Product getProductById(Integer id ){
        return  productDao.findProductById(id);
    }
}
