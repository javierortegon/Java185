package com.sena.demo.controller;

import com.sena.demo.model.Purchase;
import com.sena.demo.service.ClientService;
import com.sena.demo.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private ClientService clientService;

    @GetMapping("/purchase/all")
    public String getPurchases(Model model){
        model.addAttribute("purchases", purchaseService.getPurchases());
        return "purchase/all";
    }

    @GetMapping("/purchase/new")
    public String showNewPurchase(Model model){
        model.addAttribute("purchase", new Purchase());
        model.addAttribute("clients", clientService.getClients());
        return "purchase/new";
    }

    @PostMapping("/purchase/save")
    public String savePurchase(Purchase purchase){
        purchaseService.savePurchase(purchase);
        return "redirect:/purchase/all";
    }

    @GetMapping("/purchase/update/{id}")
    public String showUpdatePurchase(@PathVariable Long id, Model model){
        model.addAttribute("purchase", purchaseService.getPurchase(id));
        return "purchase/update";
    }

    @PostMapping("/purchase/update/{id}")
    public String updatePurchase(@PathVariable Long id, Purchase purchase){
        purchase.setId(id);
        purchaseService.updatePurchase(purchase);
        return "redirect:/purchase/all";
    }

    @GetMapping("/purchase/delete/{id}")
    public String deletePurchase(@PathVariable Long id){
        purchaseService.deletePurchase(id);
        return "redirect:/purchase/all";
    }

}

