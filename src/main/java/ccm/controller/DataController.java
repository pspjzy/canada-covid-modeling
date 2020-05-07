package ccm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ccm.data.entity.DataModel;
import ccm.service.*;

@RestController
@RequestMapping("/data")
@CrossOrigin(origins = "http://127.0.0.1:4200")
public class DataController {
    private final CcdService cS;

    @Autowired
    public DataController(CcdService cS) {
        this.cS = cS;
    }
    @GetMapping("/api")
    @CrossOrigin(origins = "http://127.0.0.1:4200")
    public Iterable<DataModel> getAllDatas(){
        return cS.getAll();
    }
}
