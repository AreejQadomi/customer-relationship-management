package com.crm.controllers;

import com.crm.dao.CustomerDAO;
import com.crm.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    //Inject the CustomerDAO
    @Autowired
    private CustomerDAO customerDAO;

    @RequestMapping("/list")
    public String listCustomers(Model model) {
        // get the customers from the DAO
        List<Customer> customerList = customerDAO.getCustomers();

        // Add the customers to the model object
        model.addAttribute("customerList", customerList);

        return "list-customers";
    }
}
