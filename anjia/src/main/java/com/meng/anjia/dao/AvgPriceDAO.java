package com.meng.anjia.dao;

import com.meng.anjia.pojo.AvgPrice;
import com.meng.anjia.pojo.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvgPriceDAO extends JpaRepository<AvgPrice, Integer>{
    /**
     *
     * @param year
     * @param month
     * @return
     */
    List<AvgPrice> findByYearAndMonth(int year, int month);

    /**
     *
     * @param place
     * @param year
     * @param month
     * @return
     */
    List<AvgPrice> findByPlaceAndYearAndMonth(Place place, int year, int month);
}
