package com.meng.anjia.dao;

import com.meng.anjia.pojo.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceDAO extends JpaRepository<Place, Integer> {
}
