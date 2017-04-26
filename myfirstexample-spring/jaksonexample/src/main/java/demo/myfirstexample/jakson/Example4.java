package demo.myfirstexample.jakson;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.spark.SparkConf;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;

import java.io.IOException;


/**
 * Created by anya on 22/4/17.
 */
public class Example4 {
    interface DoSomething{
        int doneSomthing();
    }

    public static void main(String[] args) throws IOException {
        SparkConf conf = new SparkConf()
                .setAppName("Example4")
                .setMaster("local[*]");
       JavaSparkContext sc = new JavaSparkContext(conf);
        SQLContext javaSQLCtx=new SQLContext(sc);
        SQLContext sqlContext = new org.apache.spark.sql.SQLContext(sc);
        DataFrame df = sqlContext.read().json("/home/anya/work/workspace/myfisrtexample/myfirstexample-spring/jaksonexample/src/main/resources/test123.json");
//      Dataset<Row> ds= javaSQLCtx.read().json("test123.json");
        System.out.println("JSON TO STRING"+df.toJSON().toString());
        ObjectMapper mapper = new ObjectMapper();
        JsonFactory factory = mapper.getFactory();


        for (Row row:df.collect()){
            for (int i=0; i<row.size(); i++){
                if(row.getString(i).equalsIgnoreCase("[") || row.getString(i).equalsIgnoreCase("]")){
                    break;
                }else {
                    System.out.println("_+_+_" + row.getString(i));
                    JsonParser parser = factory.createParser(String.valueOf(row.getString(i)));
                    JsonNode actualObj = mapper.readTree(parser);
                    System.out.println("ACTUAL OBJ :-" + actualObj);
                }
            }
//
        }
        df.show();
   }
}
