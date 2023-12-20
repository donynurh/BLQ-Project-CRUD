package com.crud.restcontroller;

import com.crud.Entity.ApotekModel;
import com.crud.Entity.ObatModel;
import com.crud.service.ApotekService;
import com.crud.service.ObatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ObatRestcontroller {

    @Autowired
    ObatService service;

    @GetMapping("/getobat")
    public List<ObatModel> getAll(){
        return service.getObat();
    }

    @GetMapping("/getobatbyid/{id}")
    public ObatModel getById(@PathVariable Long id){
        return service.getObatById(id);
    }

    @PostMapping ("/addobat")
    public ObatModel addObat(@RequestBody ObatModel obat){
        return service.addObat(obat);
    }

    @PutMapping("/updateobat/{id}")
    public ObatModel updateObat(@PathVariable long id, @RequestBody ObatModel obat) {
        return service.updateObat(id, obat);
    }


    @DeleteMapping("/deleteobat/{id}")
    public String deleteObat(@PathVariable Long id) {
        return service.deleteObat(id);
    }
}
