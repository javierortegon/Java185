package com.sena.demo.controller;

import com.sena.demo.model.Client;
import com.sena.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.security.PublicKey;
import java.util.List;

@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/client/all")
    public String getClients(Model model){
        model.addAttribute("clients", clientService.getClients());
        return "client/all";
    }

    @GetMapping("/client/new")
    public String showNewClient(Model model){
        model.addAttribute("client", new Client());
        return "client/new";
    }

    @PostMapping("/client/save")
    public String saveClient(Client client){
        clientService.saveClient(client);
        return "redirect:/client/all";
    }

    @GetMapping("/client/update/{id}")
    public String showUpdateClient(@PathVariable Long id, Model model){
        model.addAttribute("client", clientService.getClient(id));
        return "client/update";
    }

    @PostMapping("/client/update/{id}")
    public String updateClient(@PathVariable Long id, Client client){
        client.setId(id);
        clientService.updateClient(client);
        return "redirect:/client/all";
    }

    @GetMapping("/client/delete/{id}")
    public String deleteClient(@PathVariable Long id){
        clientService.deleteClient(id);
        return "redirect:/client/all";
    }

}
