package com.sena.demo.controller;

import com.sena.demo.model.Client;
import com.sena.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;

    public String getClients(){
    }

}
