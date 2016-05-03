package com.theironyard.clt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;


@Controller
public class HibernatinController {
    @Autowired
    CustomerRepository customer;

    @Autowired
    PurchasesRepository purchases;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, String category) {
        List<Purchase> purchaseList;
        if (category == null) {
            purchaseList = (List<Purchase>) purchases.findAll();
        } else {
            purchaseList = purchases.findPurchasesByCategory(category);
        }
        model.addAttribute("purchases", purchaseList);
        return "home";

    }

    @PostConstruct
    public void init() throws IOException{

        File f = new File("customers");
        File g = new File("purchases");
        Scanner fileScanner = new Scanner(g);
        Scanner fileScanner2 = new Scanner(f);
        fileScanner.nextLine();
        fileScanner2.nextLine();

        if (customer.count() == 0) {
            while (fileScanner2.hasNext()) {
                Customer c = new Customer();
                String[] vals = fileScanner2.nextLine().split(",");
                c.name = vals[0];
                c.eMail = vals[1];
                customer.save(c);
            }
        }

        if (purchases.count() == 0) {
            while (fileScanner.hasNext()) {
                Purchase p = new Purchase();
                String[] vals = fileScanner.nextLine().split(",");
                p.category = vals[4];
                p.purchaseTime = LocalDateTime.parse(vals[1]);
                p.creditCard = vals[2];
                p.cvv = Integer.valueOf(vals[3]);
                int id = Integer.valueOf(vals[0]);
                p.customer = customer.getCustomerById(id);
                purchases.save(p);

            }
        }


        

    }




}
