//package com.example.relation.controller;
//
//
//import com.example.relation.dao.CustomerDAO;
//import com.example.relation.entitie.Customer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/customer")
//public class CustomerController {
//
//    @Autowired
//    private CustomerDAO customerDAO;
//    @PostMapping("/create")
//    public Customer createCustomer(@RequestBody Customer customer){
//        System.out.println("id"+customer.getCustomerId());
//        System.out.println("name"+customer.getCustomerName());
////        System.out.println("id"+customer.getPosts());
//        System.out.println("safi mzahhfjjjd");
////        return "hhhhhhhhh";
////        System.out.println("id"+customer.getCustomerId());
//        return this.customerDAO.create(customer);
//    }
//}
