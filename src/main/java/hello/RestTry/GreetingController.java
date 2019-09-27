package hello.RestTry;

import hello.entitiy.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@Controller
public class GreetingController {
    @RequestMapping("/home")
    private  String homePage(){
       return "index";
   }
}
