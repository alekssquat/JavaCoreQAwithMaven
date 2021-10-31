package JsonGarageTest;

public class Car {

    String name;
    String color;
    String code;

    public Car(String name, String color, String code) {
        this.name = name;
        this.color = color;
        this.code = code;
    }

    public Car() {
        //super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
