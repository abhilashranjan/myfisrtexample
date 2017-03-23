package demo.myfirstexample.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GreetingController {
    @Autowired
    private GreetingService greetingService;

    @RequestMapping("/get-greeting/{username}")
    public String getGreeting(@PathVariable("username") String username) {
        return greetingService.getGreeting(username);

    }
}