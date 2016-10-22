package demo.myfirstexample.rest.model;

/**
 * Created by abhilash on 21/3/16.
 */
public class SimpleResponse {
    private Entity entity;

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    @Override
    public String toString() {
        return "SimpleResponse{" +
                "entity=" + entity +
                '}';
    }
}
