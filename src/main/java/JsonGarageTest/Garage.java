package JsonGarageTest;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;

@JsonRootName(value = "West Coast Costumes")
@JsonDeserialize(as=Garage.class)

public class Garage {
String title;
ArrayList<Car>garage;

    public Garage(String title, ArrayList<Car> garage) {
        this.title = title;
        this.garage = garage;
    }

    public Garage() {
        //super();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Car> getGarage() {
        return garage;
    }

    public void setGarage(ArrayList<Car> garage) {
        this.garage = garage;
    }
}
