package c0921g1.controller;

import c0921g1.model.Customer;
import c0921g1.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/customer")
    public ModelAndView showList(){
        List<Customer> customerList = customerService.showList();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("customerList",customerList);
        return modelAndView;
    }

    @GetMapping("/customer/edit/{id}")
    public ModelAndView showEditForm(@PathVariable int id){
        Customer customer = customerService.selectbyId(id);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("customer",customer);
        return modelAndView;
    }

    @PostMapping("/customer/edit")
    public ModelAndView editCustomer(@RequestParam int id, @RequestParam String name, @RequestParam String email, @RequestParam String address){
        Customer customer = new Customer(id, name, email, address);
        customerService.editCustomer(customer);
        List<Customer> customerList = customerService.showList();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("customerList",customerList);
        return modelAndView;
    }

    @GetMapping("customer/delete/{id}")
    public ModelAndView deleteCustomer(@PathVariable int id){
        customerService.deleteCustomer(id);
        List<Customer> customerList = customerService.showList();
        return new ModelAndView("index","customerList",customerList);
    }


}
