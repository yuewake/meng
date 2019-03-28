package com.meng.anjia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author shine10076
 * @date 2019/3/27 19:51
 */
@Controller
public class SearchQuestionController {

    @RequestMapping("/searchQuestion")
    public String getSearchQuestionPath()
    {
        return "searchQuestion";
    }

}
