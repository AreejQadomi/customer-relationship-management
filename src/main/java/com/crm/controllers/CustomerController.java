package com.crm.controllers;

import com.crm.models.Customer;
import com.crm.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @PostMapping("/saveCustomer")
    public String saveCustomer(HttpServletRequest request, HttpServletResponse response) {

        Customer newCustomer = new Customer();
        if (request.getParameter("id") != null)
            newCustomer.setId(Integer.parseInt(request.getParameter("id")));

        newCustomer.setFirstName(request.getParameter("firstName"));
        newCustomer.setLastName(request.getParameter("lastName"));

        String email = request.getParameter("username").concat("@").concat(request.getParameter("domain")).concat(".com");
        newCustomer.setEmail(email);

        customerService.saveCustomer(newCustomer);
        return "redirect:/customer/list";
    }

    // jackson-databind dependency is added to pom.xml
    @GetMapping(path = "/showCustomerDetails", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Customer getCustomer(@RequestParam("id") int id) {

        // get the customer from the database
        // return customer details as Json data

        return customerService.getCustomer(id);
    }

}
