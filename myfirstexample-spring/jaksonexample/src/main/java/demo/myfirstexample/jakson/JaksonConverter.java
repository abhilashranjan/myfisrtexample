package demo.myfirstexample.jakson;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by anya on 21/4/17.
 */
public class JaksonConverter {
    public static void main(String[] args) throws IOException {
        String jsonString = "{\"k1\":\"v1\",\"k2\":\"v2\"}";
 String str= "[{\"k1\":\"v1\",\"k2\":\"v2\"},\n" +
         "{\"k1\":\"v1\",\"k2\":\"v2\"}]";
        ObjectMapper mapper = new ObjectMapper();
        JsonFactory factory = mapper.getFactory();
        JsonParser parser = factory.createParser(str);
        JsonNode actualObj = mapper.readTree(parser);
        System.out.println("ACTUAL OBJ :-"+actualObj);

    }
}
