package demo.myfirstexample.rest.service;

import demo.myfirstexample.rest.model.ChildOneEntity;
import demo.myfirstexample.rest.model.SimpleResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by abhilash on 21/3/16.
 */
@Controller
@RequestMapping("/simple-service")
public class SimpleRestService {

    @RequestMapping(value = "/get-response",
                    method= RequestMethod.GET,
                    consumes = "application/json",
                    produces = "application/json")
    public  @ResponseBody SimpleResponse getResponse(HttpServletRequest request){
        return response();
    }

    private SimpleResponse response() {
        SimpleResponse simpleResponse= new SimpleResponse();
        ChildOneEntity ch1= new ChildOneEntity();
        ch1.setChildOne("CHILD 1");
        ch1.setEname("ENTITY 1");
        simpleResponse.setEntity(ch1);
        System.out.println("SIMPLE RESPONSE:-"+simpleResponse);
        return simpleResponse;
    }
}
