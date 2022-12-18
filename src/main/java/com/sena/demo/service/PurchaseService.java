package com.sena.demo.service;

import com.sena.demo.model.Purchase;
import com.sena.demo.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Purchase> getPurchases(){
        return purchaseRepository.findAll();
    }

    public Purchase savePurchase(Purchase purchase){
        return purchaseRepository.save(purchase);
    }

    public Purchase getPurchase(Long id){
        return purchaseRepository.findById(id).get();
    }

    public Purchase updatePurchase(Purchase purchase){
        return purchaseRepository.save(purchase);
    }

    public void deletePurchase(Long id){
        purchaseRepository.deleteById(id);
    }

}
