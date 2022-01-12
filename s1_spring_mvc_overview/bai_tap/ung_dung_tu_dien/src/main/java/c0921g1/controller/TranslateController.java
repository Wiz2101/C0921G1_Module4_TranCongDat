package c0921g1.controller;

import c0921g1.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TranslateController {

    @Autowired
    IDictionaryService dictionaryService;

    @GetMapping("/dictionary")
    public String goToHomePage() {
        return "index";
    }

    @GetMapping("/translated")
    public ModelAndView translate(@RequestParam String keyword) {
        String result = null;
        if (keyword == "") {
            result = "Not Found!";
        } else {
            result = dictionaryService.translate(keyword);
        }
        return new ModelAndView("index", "result", result);
    }
}
