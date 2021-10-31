package WeatherTest;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String cityName = sc.nextLine();
        String cityCode = RequestHandler.detectedCity(cityName);

        System.out.println(DailyForecasts.detectedWeather(cityCode));
        //System.out.println(RequestHandler.detectedCity(sc.nextLine()));
    }
}