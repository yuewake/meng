package com.meng.anjia.service;

import com.meng.anjia.dao.AvgPriceDAO;
import com.meng.anjia.pojo.AvgPrice;
import com.meng.anjia.pojo.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvgPriceService {
    @Autowired
    AvgPriceDAO avgPriceDAO;
    @Autowired
    PlaceService placeService;
    public List<AvgPrice> list(){

        return avgPriceDAO.findByYearAndMonth(2019,3);
    }

    public List<AvgPrice> list(int pid) {
        Place place = placeService.get(pid);
        return avgPriceDAO.findByPlaceAndYearAndMonth(place, 2019, 3);
    }

}
