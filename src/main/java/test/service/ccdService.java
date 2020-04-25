package test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.data.entity.DataModel;
import test.data.repository.DataModelRepo;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ccdService {
    private final DataModelRepo dataModelRepo;

    @Autowired
    public ccdService(DataModelRepo dataModelRepo) {
        this.dataModelRepo = dataModelRepo;
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
