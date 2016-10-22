package demo.myfirstexample.rest.model;

/**
 * Created by abhilash on 21/3/16.
 */
public class ChildOneEntity extends Entity {
    private String childOne;

    public String getChildOne() {
        return childOne;
    }

    public void setChildOne(String childOne) {
        this.childOne = childOne;
    }

    @Override
    public String toString() {
        return "ChildOneEntity{" +
                "childOne='" + childOne + '\'' +
                '}';
    }
}
