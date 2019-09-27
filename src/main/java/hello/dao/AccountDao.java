package hello.dao;

import hello.entitiy.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface AccountDao extends JpaRepository<Account,Integer> {
    Account findAccountByLogin(String login);

}
