package com.meng.anjia.dao;

import com.meng.anjia.pojo.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyDAO extends JpaRepository<Property, Integer> {
}
