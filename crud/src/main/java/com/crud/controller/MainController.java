package com.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/dashboard")
    public String dash(){
        return "/dashboard";
    }

    @GetMapping("/obat")
    public String pageObat(){
        return "/obat";
    }

    @GetMapping("/obatadd")
    public String obatAdd(){
        return "/addObat";
    }

    @GetMapping("/obatupdate")
    public String obatUpdate(){
        return "/updateObat";
    }

    @GetMapping("/obatdelete")
    public String obatDelete(){
        return "/deleteObat";
    }

}
