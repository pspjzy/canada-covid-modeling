package test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import test.data.entity.DataModel;
import test.service.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
