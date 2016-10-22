package demo.myfirstexample.rest.model;

/**
 * Created by abhilash on 21/3/16.
 */
public class Entity {
    private String ename;

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "ename='" + ename + '\'' +
                '}';
    }
}
