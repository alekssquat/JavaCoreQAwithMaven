package WeatherTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class DailyForecasts {

    static OkHttpClient client= new OkHttpClient();
    static ObjectMapper objectMapper= new ObjectMapper();

    public static String detectedWeather (String cityCode) throws IOException {

        //Создаем URL запроса, прописываем тело

        HttpUrl detectedCityURL=new HttpUrl.Builder()
                .scheme(BaseParams.scheme)
                .host(BaseParams.HOST)
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("1day")
                .addPathSegment(cityCode)
                .addQueryParameter("apikey",BaseParams.API_KEY)
                .addQueryParameter("metric", "true")
                .build();

        //Создаем тело запроса
        Request request=new Request.Builder()
                .addHeader("Accept","application/json")
                .url(detectedCityURL)
                .build();

        //Запарашиваем ответ
        Response response = client.newCall(request).execute();


        //If Response Failed
        if(!response.isSuccessful()){

            throw new IOException("Request failed"
                    +" code - "+response.code()
                    +" body - "+response.body().string());
        }

        return response.body().string();
    }






}