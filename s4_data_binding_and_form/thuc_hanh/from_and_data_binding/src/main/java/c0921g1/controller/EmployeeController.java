package c0921g1.controller;

import c0921g1.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {
    @GetMapping("showform")
    public String showForm(ModelMap modelMap){
        modelMap.addAttribute("employee", new Employee());
        return "create";
    }

    @PostMapping("addEmployee")
    public String submit(@ModelAttribute Employee employee, ModelMap modelMap){
        modelMap.addAttribute("name",employee.getName());
        modelMap.addAttribute("contactNumber",employee.getContactNumber());
        modelMap.addAttribute("id",employee.getId());
        return "info";
    }
}
