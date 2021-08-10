package com.publicis.sapient.controller;

import com.publicis.sapient.model.CreditCard;
import com.publicis.sapient.poho.CreditCardSearchResponse;
import com.publicis.sapient.process.CreateNewCreditCardProcess;
import com.publicis.sapient.repository.ICreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CreditCardController {

    @Autowired
    private ICreditCardRepository creditCardRepository;

    @Autowired
    private CreateNewCreditCardProcess createNewCreditCardProcess;

    @PostMapping(value="/add", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreditCard> write(@RequestBody CreditCard creditCard){
        try{
            CreditCard persistedCard = createNewCreditCardProcess.process(creditCard);
            return  new ResponseEntity<>(persistedCard,HttpStatus.OK);
        }catch (Exception exception){
            return  new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping(value = "getall",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreditCardSearchResponse> read(@RequestParam(defaultValue = "0")  int page,@RequestParam(defaultValue = "2")int size){
        try{
            Pageable pageable = PageRequest.of(page,size);
            Page<CreditCard> creditCards = creditCardRepository.findAll(pageable);


            if (null== creditCards.getContent() || creditCards.getContent().isEmpty()){
                return  new ResponseEntity(HttpStatus.NOT_FOUND);
            }
            CreditCardSearchResponse creditCardSearchResponse = new CreditCardSearchResponse();
            creditCardSearchResponse.setCreditCardList(creditCards.getContent());
            creditCardSearchResponse.setCurrentPage(creditCards.getNumber());
            creditCardSearchResponse.setTotalPages(creditCards.getTotalPages());
            creditCardSearchResponse.setTotalItems(creditCards.getTotalElements());
            return  new ResponseEntity<>(creditCardSearchResponse,HttpStatus.OK);
        }catch (Exception ex){
            return  new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
