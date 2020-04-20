package test;


import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class test_jsonparse {

    public static HttpsURLConnection connection;
    public void getData() {
        try {
            String APIUrl = "https://corona.lmao.ninja/v2/countries/Canada";
            URL url = new URL(APIUrl);
            connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5500);
            connection.setReadTimeout(5500);

            int status = connection.getResponseCode();
            System.out.println(status);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public static void main(String[] args){
        test_jsonparse t = new test_jsonparse();
        t.getData();


    }

}
