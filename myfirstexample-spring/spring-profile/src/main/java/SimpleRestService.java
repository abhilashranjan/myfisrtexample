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
    public  @ResponseBody String getResponse(HttpServletRequest request){

        return "Hello world";
    }


}
