package com.crud.restcontroller;

import com.crud.Entity.ApotekModel;
import com.crud.service.ApotekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApotekRestcontroller {

    @Autowired
    ApotekService service;

    @GetMapping("/getapotek")
    public List<ApotekModel> getAll(){
        return service.getApotek();
    }
}
