package ccm.service;

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
import java.util.List;


@Service
public class ccdService {
    private final DataModelRepo dataModelRepo;

    @Autowired
    public ccdService(DataModelRepo dataModelRepo) {
        this.dataModelRepo = dataModelRepo;
    }

    @Scheduled(fixedRate = 600000)//(cron = "0 0 */1 * * *")
    public void autoSetData(){
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
                data.setTime(new Timestamp(System.currentTimeMillis()));
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


    public List<DataModel> getDataByDate(Timestamp ts){
        List<DataModel> dataModels = dataModelRepo.findDataModelByTime(new Timestamp(ts.getTime()));
        return dataModels;
    }

    public Iterable<DataModel> getAll(){
        Iterable<DataModel> dataModels = dataModelRepo.findAll();
        return dataModels;
    }

}
