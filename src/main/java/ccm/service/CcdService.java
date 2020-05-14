package ccm.service;

import ccm.data.entity.YesterdayFinal;
import ccm.data.repository.YesterdayFinalRepo;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ccm.data.entity.DataModel;
import ccm.data.repository.DataModelRepo;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Stack;


@Service
public class CcdService {
    private final DataModelRepo dataModelRepo;
    private final YesterdayFinalRepo yesterdayFinalRepo;

    @Autowired
    public CcdService(DataModelRepo dataModelRepo, YesterdayFinalRepo yesterdayFinalRepo) {
        this.dataModelRepo = dataModelRepo;
        this.yesterdayFinalRepo = yesterdayFinalRepo;
    }

    /**
     * Parse the data per hours
     */
    @Scheduled(cron = "0 0 * * *  ? ")//fixedRate = 3600000, one hour
    public void autoSaveData(){
        HttpsURLConnection connection;
        StringBuffer response;
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
                Gson gson = new Gson();
                DataModel data = gson.fromJson(String.valueOf(response),DataModel.class);
                data.setTime(new Timestamp(System.currentTimeMillis()).toString());   //new Timestamp(System.currentTimeMillis()));
                /*
                If the data is 0 before the midnight, reset to highest
                 */
                if ((data.getTodayCases() == 0) && (dataModelRepo.findTop1ByOrderByTodayCases() != null)){
                    data.setTodayCases(dataModelRepo.findTop1ByOrderByTodayCases().getTodayCases());
                }
                if(findYesterday()!=null) {
                    data.setTodayCritical(data.getCritical() - findYesterday().getDailyCritical());
                    data.setTodayDeath(data.getDeaths() - findYesterday().getDailyDeaths());
                    data.setTodayRecovered(data.getRecovered() - findYesterday().getDailyRecovered());
                    data.setTodayTest(data.getTests() - findYesterday().getDailyTests());
                }else {
                    data.setTodayCritical(0);
                    data.setTodayDeath(0);
                    data.setTodayRecovered(0);
                    data.setTodayTest(0);
                }
                dataModelRepo.save(data);
                in.close();
            } else {
                System.out.println("gg");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Ereryday 23:29, auto save the date from that data
     */
    @Scheduled(cron = "0 59 23 1/1 * ? ")
    public void autoSaveDailyData(){
        HttpsURLConnection connection;
        StringBuffer response;
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
                Gson gson = new Gson();
                DataModel data = gson.fromJson(String.valueOf(response),DataModel.class);
                YesterdayFinal yesterdayFinal = new YesterdayFinal();
                yesterdayFinal.setDailyCritical(data.getCritical());
                yesterdayFinal.setDailyDeaths(data.getDeaths());
                yesterdayFinal.setDailyRecovered(data.getRecovered());
                yesterdayFinal.setDailyTests(data.getTests());
                Date d = new Date();
                SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
                yesterdayFinal.setDate(ft.format(d));

                yesterdayFinalRepo.save(yesterdayFinal);
                in.close();
            } else {
                System.out.println("gg");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//    public List<DataModel> getDataByDate(Timestamp ts){
//        List<DataModel> dataModels = dataModelRepo.findDataModelByTime(new Timestamp(ts.getTime()));
//        return dataModels;
//    }

    /**
     * Clean the data every night
     */
    @Scheduled(cron = "59 59 23 1/1 * ? ")
    public void revomeData(){
        dataModelRepo.deleteAll();
    }

    public Iterable<DataModel> getAll(){
        Iterable<DataModel> dataModels = dataModelRepo.findAll();
        return dataModels;
    }

    public YesterdayFinal findYesterday(){

        Instant now = Instant.now();
        Instant yesterday = now.minus(1, ChronoUnit.DAYS);
        String y = yesterday.toString().substring(0,10);
        YesterdayFinal ys = yesterdayFinalRepo.findByDate(y);
        return ys;

    }

}
