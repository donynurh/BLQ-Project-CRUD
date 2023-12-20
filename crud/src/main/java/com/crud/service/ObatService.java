package com.crud.service;

import com.crud.Entity.ObatModel;
import com.crud.repository.ObatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObatService {

    @Autowired
    ObatRepository repository;


    public List<ObatModel> getObat(){
        return repository.findAll();
    }

    public ObatModel getObatById(Long id){
        return repository.findById(id).orElse(null);
    }

    public ObatModel addObat(ObatModel obat){
        return repository.save(obat);
    }

    public ObatModel updateObat(long id, ObatModel obat) {
        ObatModel existingObat = repository.findById(id).orElse(null);
        existingObat.setName(obat.getName());
        existingObat.setCategory(obat.getCategory());
        existingObat.setDescription(obat.getDescription());
        return repository.save(existingObat);
    }

    public String deleteObat(long id) {
        repository.findById(id).orElseThrow(null);
        repository.deleteById(id);
        return "Obat berhasil dihapus";
    }
}
