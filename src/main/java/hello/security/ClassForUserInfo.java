package hello.security;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@Qualifier("ClassForUserInfo")
public class ClassForUserInfo {

    public   String getCurrentUserName()//вернёт имя пользователся в системе
     { Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    public  Collection getRoles(){
        Collection authentication=SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        return authentication;
    }
}
