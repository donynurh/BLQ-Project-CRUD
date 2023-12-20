package com.crud.service;

import com.crud.Entity.ApotekModel;
import com.crud.repository.ApotekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApotekService {

    @Autowired
    ApotekRepository repository;

    //Get All Data drom Apotek Table
    public List<ApotekModel> getApotek(){
        return repository.findAll();
    }
}
