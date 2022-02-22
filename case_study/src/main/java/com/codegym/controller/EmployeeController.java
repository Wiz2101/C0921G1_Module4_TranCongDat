package com.codegym.controller;

import com.codegym.dto.EmployeeDto;
import com.codegym.dto.UserDto;
import com.codegym.model.*;
import com.codegym.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;
    @Autowired
    IPositionService positionService;
    @Autowired
    IEducationDegreeService educationDegreeService;
    @Autowired
    IDivisionService divisionService;

    @Autowired
    IUserService userService;

    @GetMapping
    public String findAll(@RequestParam(defaultValue = "") String keyword,
                          @RequestParam(defaultValue = "") String positionId, @RequestParam(defaultValue = "") String educationDegreeId,
                          @RequestParam(defaultValue = "") String divisionId, Model model,
                          @PageableDefault(value = 5) Pageable pageable) {
        Page<Employee> employeeList = employeeService.findAll(pageable);
        List<Position> positionList = positionService.findAll();
        List<EducationDegree> educationDegreeList = educationDegreeService.findAll();
        List<Division> divisionList = divisionService.findAll();
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("positionList", positionList);
        model.addAttribute("educationDegreeList", educationDegreeList);
        model.addAttribute("divisionList", divisionList);
            Page<Employee> employees = employeeService.searchByNameAndSelect("%" + keyword + "%", "%" + positionId + "%", "%" + educationDegreeId + "%", "%" + divisionId + "%", pageable);
            model.addAttribute("employeeList",employees);
        return "/employee/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model, Pageable pageable) {
        List<Position> positionList = positionService.findAll();
        List<EducationDegree> educationDegreeList = educationDegreeService.findAll();
        List<Division> divisionList = divisionService.findAll();
        model.addAttribute("employeeDto", new EmployeeDto());
        model.addAttribute("positionList", positionList);
        model.addAttribute("educationDegreeList", educationDegreeList);
        model.addAttribute("divisionList", divisionList);
        return "employee/create";
    }

    @PostMapping("/create")
    public String createEmployee(@Validated @ModelAttribute EmployeeDto employeeDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        String employeeBirthday = employeeDto.getEmployeeBirthday().substring(0,4);
        if (!(Calendar.getInstance().get(Calendar.YEAR)-Integer.parseInt(employeeBirthday)>18)){
            bindingResult.rejectValue("employeeBirthday","employeeBirthday.rejected","The employee must be older than 18 years old");
            model.addAttribute("employeeDto",employeeDto);
        }
        if (userService.existsByUser(employeeDto.getUsername())){
            bindingResult.rejectValue("username","username.rejected","This username already exist!");
            model.addAttribute("employeeDto",employeeDto);
        }
        new EmployeeDto().validate(employeeDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("employeeDto", employeeDto);
            model.addAttribute("positionList", positionService.findAll());
            model.addAttribute("educationDegreeList", educationDegreeService.findAll());
            model.addAttribute("divisionList", divisionService.findAll());
            return "employee/create";
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        User user = new User();
        user.setUser(employeeDto.getUsername());
        user.setPassword("$2a$10$.rZojlqr4qQ0YdCOm2Khuur48ONXnaRhkOmOLfH8AC6oUidFRzFga");
        userService.save(user);
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("createSC", "Create Sucessfully!");
        return "redirect:/employee";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable Long id, Model model, Pageable pageable) {
        Optional<Employee> employee = employeeService.findById(id);
        if (!employee.isPresent()) {
            return "error404";
        }
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee.get(), employeeDto);
        model.addAttribute("employeeDto", employeeDto);
        model.addAttribute("positionList", positionService.findAll());
        model.addAttribute("educationDegreeList", educationDegreeService.findAll());
        model.addAttribute("divisionList", divisionService.findAll());
        return "employee/edit";
    }

    @PostMapping("/edit")
    public String editEmployee(@Validated @ModelAttribute EmployeeDto employeeDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        new EmployeeDto().validate(employeeDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("employeeDto", employeeDto);
            model.addAttribute("positionList", positionService.findAll());
            model.addAttribute("educationDegreeList", educationDegreeService.findAll());
            model.addAttribute("divisionList", divisionService.findAll());
            return "employee/edit";
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("UpdateSC", "Update Successfully!");
        return "redirect:/employee";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        employeeService.remove(id);
        redirectAttributes.addFlashAttribute("DeleteSC", "Delete Successfully!");
        return "redirect:/employee";
    }

    @GetMapping("/view/{id}")
    public String viewDetail(@PathVariable Long id, Model model) {
        Optional<Employee> employee = employeeService.findById(id);
        if (!employee.isPresent()) {
            return "error404";
        }
        model.addAttribute("employee", employee);
        return "employee/detail";
    }
}
