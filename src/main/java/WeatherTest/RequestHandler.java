package WeatherTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class RequestHandler {
    static OkHttpClient client= new OkHttpClient();
    static ObjectMapper objectMapper= new ObjectMapper();

    public static String detectedCity (String cityName) throws IOException {

        //Создаем URL запроса прописываем тело

        HttpUrl detectedCityURL=new HttpUrl.Builder()
                .scheme(BaseParams.scheme)
                .host(BaseParams.HOST)
                .addPathSegment("locations")
                .addPathSegment("v1")
                .addPathSegment("cities")
                .addPathSegment("search")
                .addQueryParameter("apikey",BaseParams.API_KEY)
                .addQueryParameter("q",cityName)
                .build();

        //Создаем тело запроса
        Request request=new Request.Builder()
                .addHeader("Accept","application/json")
                .url(detectedCityURL)
                .build();

        //Запарашиваем ответ
        Response response = client.newCall(request).execute();

        String json=response.body().string();

        //If Response Failed
        if(!response.isSuccessful()){

            throw new IOException("Request failed"
                    +" code - "+response.code()
                    +" body - "+response.body().string());
        }

        if(objectMapper.readTree(json).size()>0){

            String cityCode = objectMapper.readTree(json).get(0).at("/LocalizedName").asText();
            String country=objectMapper.readTree(json).get(0).at("/Country/LocalizedName").asText();
            System.out.println(cityCode+" - "+country);

        }else {

            throw new IOException("Server response is empty");

        }





        return objectMapper.readTree(json).get(0).at("/Key").asText();
    }

}
