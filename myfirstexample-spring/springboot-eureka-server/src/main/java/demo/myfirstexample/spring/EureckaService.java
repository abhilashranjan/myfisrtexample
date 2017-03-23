package demo.myfirstexample.spring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by anya on 23/3/17.
 */
@RestController
public class EureckaService {

    @RequestMapping( value = "/hello",method = RequestMethod.GET,path = "/hello")
    public String helloWorld(){
        return "Hello World";
    }
}
