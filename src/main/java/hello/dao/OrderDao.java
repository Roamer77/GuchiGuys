package hello.dao;

import hello.entitiy.OrderComposition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface OrderDao extends JpaRepository<OrderComposition,Long> {
    ArrayList<OrderComposition> findAll();
}
