package com.crm.controllers;

import com.crm.models.Customer;
import com.crm.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    //Inject the Customer service - so we don't talk to the DAO directly
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model model) {
        // get the customers from the DAO
        List<Customer> customerList = customerService.getCustomers();

        // Add the customers to the model object
        model.addAttribute("customerList", customerList);

        return "list-customers";
    }
}
