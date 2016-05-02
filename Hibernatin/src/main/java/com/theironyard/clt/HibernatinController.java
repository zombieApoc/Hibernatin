package com.theironyard.clt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


@Controller
public class HibernatinController {
    @Autowired
    CustomerRepository customer;

    @Autowired
    PurchasesRepository purchases;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model) {
        List<Purchases> purchasesList = (List<Purchases>) purchases.findAll();
        model.addAttribute("purchases", purchasesList);
        return "home";

    }

    @PostConstruct
    public void init() throws IOException{
        FileWriter fr = new FileWriter("purchases.txt");


    }




}
