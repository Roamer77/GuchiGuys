package hello.tryBean;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("BeanClass")
public class BeanClass {
    public  String    doSmth(){
        return "Hello VAl!)";
    }
}
