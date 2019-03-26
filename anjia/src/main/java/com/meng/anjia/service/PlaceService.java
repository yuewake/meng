package com.meng.anjia.service;

import com.meng.anjia.dao.PlaceDAO;
import com.meng.anjia.pojo.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import java.util.List;

@Service
public class PlaceService {
    @Autowired
    PlaceDAO placeDAO;

    public List<Place> list(){
        return placeDAO.findAll();
    }
    public Place get(int id) {
        return placeDAO.findById(id).isPresent() ? placeDAO.findById(id).get() : null;
    }
}
