package hello.dao;

import hello.entitiy.Product;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer> {
ArrayList<Product> findAll();
ArrayList<Product> findAllByCategoryId(Integer category);
ArrayList<Product> findAllByNameContainingIgnoreCase(String name);
ArrayList<Product> findAllByNameStartingWith(String name);
ArrayList<Product> findAllByNameEndingWith(String name);
ArrayList<Product> findAllByNameLike(String name);
Product findProductById(Integer id);
}
