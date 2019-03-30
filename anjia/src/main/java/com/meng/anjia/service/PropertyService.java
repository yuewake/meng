package com.meng.anjia.service;

import com.meng.anjia.dao.PropertyDAO;
import com.meng.anjia.pojo.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author shine10076
 * @date 2019/3/19 15:19
 */
@Service
public class PropertyService {
    @Autowired
    PropertyDAO propertyDAO;
    public List<Property> list(){
        return propertyDAO.findAll();
    }
}
