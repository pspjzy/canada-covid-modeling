package ccm.controller;


import com.google.gson.Gson;
import ccm.data.entity.DataModel;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class ParseData {


    private static HttpsURLConnection connection;
    private StringBuffer response;
    public DataModel getData() {
        try {
            String APIUrl = "https://corona.lmao.ninja/v2/countries/Canada";
            URL url = new URL(APIUrl);
            connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5500);
            connection.setReadTimeout(5500);
            connection.setRequestProperty("User-Agent","Mozilla/5.0");


            int status = connection.getResponseCode();
            if (status==200){
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                in.close();
            } else {
                return null;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        DataModel data = gson.fromJson(String.valueOf(response),DataModel.class);
        return data;


    }


    public static void main(String[] args) throws IOException{
        Instant now = Instant.now();
        Instant yesterday = now.minus(1, ChronoUnit.DAYS);
        System.out.println(now);
        String y = yesterday.toString().substring(0,10);
        System.out.println(y);
    }



}
