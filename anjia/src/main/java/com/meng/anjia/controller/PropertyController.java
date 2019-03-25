package com.meng.anjia.controller;

import com.meng.anjia.pojo.Property;
import com.meng.anjia.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PropertyController {
    @Autowired
    PropertyService propertyService;

    @GetMapping("/properties")
    public List<Property> list(){
        return propertyService.list();
    }
}
