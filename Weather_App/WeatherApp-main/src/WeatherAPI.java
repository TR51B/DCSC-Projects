import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.IOException;

public class WeatherAPI {
    private static final String API_KEY = "b4fcb43685f640fd3666a9e8133505c8"; 

    public static String getWeatherData(String city) {
        String weatherInfo = "";

        try {
            String apiUrl = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + API_KEY;
            URL url = new URL(apiUrl);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            JSONParser parser = new JSONParser();
            JSONObject jsonResponse = (JSONObject) parser.parse(response.toString());
            System.out.println(jsonResponse);
            weatherInfo = response.toString();

            /*if (jsonResponse.containsKey("weather")) {
                JSONArray weatherArray = (JSONArray) jsonResponse.get("weather");
                JSONObject weatherObject = (JSONObject) weatherArray.get(0);

                String description = (String) weatherObject.get("description");
                String icon = (String) weatherObject.get("icon");

                weatherInfo = description + "," + "http://openweathermap.org/img/w/" + icon + ".png";
            }*/
            
            
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return weatherInfo;
    }
}
