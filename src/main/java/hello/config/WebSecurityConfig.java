

package hello.config;


import hello.entitiy.Account;
import hello.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private AccountService accountService;

    @Autowired
    private DataSource dataSource;
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder= PasswordEncoderFactories.createDelegatingPasswordEncoder();
       auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select LOGIN,PASSWORD,1 as enabled from ACCOUNT where LOGIN=?").
               authoritiesByUsernameQuery("select LOGIN,ROLE from ACCOUNT where LOGIN=?").passwordEncoder(passwordEncoder);


    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        //страницы без авторизации
        http.authorizeRequests().antMatchers("/","/products/*").permitAll().
       antMatchers("/admin/*").access("hasAuthority('ADMIN')")
                .and().formLogin().permitAll();
        http.authorizeRequests().antMatchers("/login").authenticated();

    }
}


