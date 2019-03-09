package com.meng.anjia.controller;

import com.meng.anjia.pojo.AvgPrice;
import com.meng.anjia.service.AvgPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AvgPriceController {
    @Autowired
    AvgPriceService avgPriceService;

    @GetMapping("/avgprice")
    public List<AvgPrice> list() throws Exception{
        return avgPriceService.list();
    }

    @GetMapping("/places/{pid}/avgprice")
    public List<AvgPrice> list(@PathVariable("pid") int pid) throws Exception {
        return avgPriceService.list(pid);
    }
}
