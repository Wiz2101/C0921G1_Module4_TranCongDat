package c0921g1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

@Controller
public class ConvertController {
    @GetMapping("/convert")
    public String homepage(){
        return "index";
    }
    @PostMapping("/converted")
    public ModelAndView convertVND(@RequestParam double usd, @RequestParam int rate){
        double vnd = usd*rate;
        return new ModelAndView("index","result",vnd);
    }
}
