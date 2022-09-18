package com.xww.springboot.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class YearController {
    @GetMapping(value = "/index")
    public String index(){
        return "year";
    }

    @GetMapping(value = "/isYear")
    public String getYear(String yearPrint, Model model){
        int yearPrintInt = Integer.parseInt(yearPrint);
        if((yearPrintInt%100 != 0 || yearPrintInt % 4==0) && yearPrintInt % 400 == 0){
            model.addAttribute("show","闰年");
        }else{
            model.addAttribute("show","平年");
        }
        return "year";
    }
}
