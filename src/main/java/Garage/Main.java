package Garage;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Car car1=new Car("Dacha","moonlight","sa1234");
        Car car2=new Car("Lada","purple","nah228");
        ArrayList<Car>carArrayList=new ArrayList<Car>();
        carArrayList.add(car1);
        carArrayList.add(car2);

        Garage garage=new Garage("WCC",carArrayList);
        ObjectMapper objectMapper=new ObjectMapper();

        try {
            objectMapper.writeValue(new File("car.json"),garage);
        } catch (IOException e) {
            System.out.println("Write is corrupted");
            e.printStackTrace();
        }


        //String s="{\"title\":\"WCC\",\"garage\":[{\"name\":\"Dacha\",\"color\":\"moonlight\",\"code\":\"sa1234\"},{\"name\":\"Lada\",\"color\":\"purple\",\"code\":\"nah228\"}]}";



        ObjectMapper objectMapper1=new ObjectMapper();
        Garage garage1= null;
        try {
            garage1= objectMapper.readValue(new File("car.json"), Garage.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(garage1.title);
    }
}
