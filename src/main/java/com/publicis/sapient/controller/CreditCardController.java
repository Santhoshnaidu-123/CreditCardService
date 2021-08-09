package com.publicis.sapient.controller;

import com.publicis.sapient.model.CreditCard;
import com.publicis.sapient.repository.ICreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CreditCardController {

    @Autowired
    private ICreditCardRepository creditCardRepository;

    @PostMapping(value="/add")
    public CreditCard write(@RequestBody CreditCard creditCard){
        CreditCard persistedCard = creditCardRepository.save(creditCard);
        return  persistedCard;
    }
    @GetMapping(value = "getall")
    public ResponseEntity<List<CreditCard>> read(){
        List<CreditCard> creditCards = creditCardRepository.findAll();
        if (null== creditCards || creditCards.isEmpty()){
            return  new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(creditCards,HttpStatus.OK);
    }
}
