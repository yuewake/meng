package com.meng.anjia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author shine10076
 * @date 2019/3/27 15:25
 */
@Controller
public class BuildingResultController {

    public static  final String RESULTBUILDING = "result_building";

    @RequestMapping("/resultBuilding")
    public String getResultBuildingPath()
    {
        return RESULTBUILDING;
    }
}
