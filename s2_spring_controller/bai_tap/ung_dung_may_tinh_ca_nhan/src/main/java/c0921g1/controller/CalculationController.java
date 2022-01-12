package c0921g1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculationController {
    @GetMapping("/calculator")
    public String homePage() {
        return "index";
    }

    @GetMapping("/calculate")
    public String calculation(@RequestParam double number1, double number2, String formula, Model model) {
        double result = 0;
        switch (formula) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
                result = number1 / number2;
                break;
        }
        model.addAttribute("result", result);
        model.addAttribute("input1", number1);
        model.addAttribute("input2", number2);
        return "index";
    }
}
