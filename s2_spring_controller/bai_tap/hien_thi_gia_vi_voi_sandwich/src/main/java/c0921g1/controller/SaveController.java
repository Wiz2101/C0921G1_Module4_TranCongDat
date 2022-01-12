package c0921g1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SaveController {

    @GetMapping("/home")
    public String homePage(){
        return "index";
    }
    @RequestMapping("/save")
    public String save(@RequestParam String[] condiment, Model model) {
        List<String> condimentList = new ArrayList<>();
        for (String st:condiment){
            condimentList.add(st);
        }
        model.addAttribute("condiment",condimentList);
        return "index";
    }
}
