package ccm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ccm.data.entity.DataModel;
import ccm.service.*;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/data")
public class dataController {
    private final ccdService cS;

    @Autowired
    public dataController(ccdService cS) {
        this.cS = cS;
    }
    @GetMapping("/api")
    public Iterable<DataModel> getAllDatas(){
        return cS.getAll();
    }

}
