package hello.controllers;

import hello.dao.ProductDao;
import hello.entitiy.Product;
import hello.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/products")
public class ProductRestcontroller {
    Logger logger = Logger.getLogger(this.getClass().getName());
    @Autowired
    private ProductService productService;
    @Autowired
    ProductDao productDao;

    private int productOnPageCounter = 0;
    private int pageCounter = 2;
    private Pattern pattern;

    @GetMapping("/loadMore")
    public Response loadMore() {

        Response response = new Response("Done", this.productDao.findAll(PageRequest.of(productOnPageCounter, 3)));
        if (productOnPageCounter < pageCounter) {
            productOnPageCounter++;
        } else {
            productOnPageCounter = 0;
        }

        return response;
    }

    @GetMapping(value = "/loadProductByCategotyTel")
    public Response loadProductByCategoryTel() {
        Response response = new Response("Done", this.productDao.findAllByCategoryId(3));
        if (productOnPageCounter < pageCounter) {
            productOnPageCounter++;
        } else {
            productOnPageCounter = 0;
        }
        return response;
    }

    @GetMapping(value = "/loadProductByCategotyTv")
    public Response loadProductByCategoryTV() {
        Response response = new Response("Done", this.productDao.findAllByCategoryId(2));
        if (productOnPageCounter < pageCounter) {
            productOnPageCounter++;
        } else {
            productOnPageCounter = 0;
        }

        return response;
    }

    @GetMapping(value = "/findProductByName")
    @ResponseBody
    public Response findProductByName(@RequestParam String  name) {

        ArrayList<Product> list1 = this.productDao.findAllByNameContainingIgnoreCase(name);

        return new Response("Done", list1);
    }

}
