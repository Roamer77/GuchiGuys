package hello.controllers;

import hello.entitiy.Account;
import hello.security.ClassForUserInfo;
import hello.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@RestController
@RequestMapping("/main")
public class MainRestController {
    Logger logger=Logger.getLogger(this.getClass().getName());
    @Autowired
    private ClassForUserInfo classForUserInfo;
    @Autowired
    private AccountService accountService;
    @GetMapping("/checkUserName")
    public Response checkUserName(){
        return  new Response("Done",classForUserInfo.getCurrentUserName());
    }

    @PostMapping("/registration")
    public  void registration(@RequestParam Map<String,String > allParams){
        //парамметр role будем пока что ставить руками. Потом придумать что получьше
        accountService.createAccount(allParams.get("login"),bCyptPass(allParams.get("password")),allParams.get("email"),"USER");
        logger.info("Только что я создал новый аккаунт с парамметрами: "+allParams.entrySet());
    }
    @GetMapping("/regPage")
    private ModelAndView returnTest(){
        ModelAndView modelAndView  =new ModelAndView();
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    private  String  bCyptPass(String password){
        PasswordEncoder passwordEncoder=PasswordEncoderFactories.createDelegatingPasswordEncoder();
      return   passwordEncoder.encode(password);
    }

    @GetMapping("/getUserRole")
    private Response sentAnswer(){
        return  new Response("Done",classForUserInfo.getRoles());
    }


    @GetMapping("/helloAndroid")
    private void helloAndroid (@RequestParam Map<String,String> allParams){
        logger.info("ответ"+ allParams.entrySet());
    }
    @GetMapping("/hello")
    private Response helloAndroid (){
        return new Response("Done","Hello Android");
    }
}
