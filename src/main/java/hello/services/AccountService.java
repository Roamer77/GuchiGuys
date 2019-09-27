
package hello.services;

import hello.dao.AccountDao;
import hello.entitiy.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class AccountService  {

    @Autowired
    AccountDao accountDao;

    public void createAccount(String login,String password,String email,String role){
        this.accountDao.save(new Account(login,password,email,role));
    }
    public Account findAccountByLogin(String login){
        return  this.accountDao.findAccountByLogin(login);
    }

}

