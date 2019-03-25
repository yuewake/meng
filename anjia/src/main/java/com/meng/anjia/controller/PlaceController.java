package com.meng.anjia.controller;

import com.meng.anjia.pojo.Place;
import com.meng.anjia.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlaceController {
    @Autowired
    PlaceService placeService;

    @GetMapping("/places")
    public List<Place> list(){
        return placeService.list();
    }
}
