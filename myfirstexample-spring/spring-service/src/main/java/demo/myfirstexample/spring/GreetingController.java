package demo.myfirstexample.spring;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public interface GreetingController {
    @RequestMapping("/greeting/{username}")
    String greeting(@PathVariable("username") String username);
}