package com.publicis.sapient.controller;

import com.publicis.sapient.exception.InValidInputException;
import com.publicis.sapient.exception.ResourceNotFoundException;
import com.publicis.sapient.exception.RestRuntimeException;
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

@RestController
@RequestMapping("/card")
public class CreditCardController {

    @Autowired
    private ICreditCardRepository creditCardRepository;

    @Autowired
    private CreateNewCreditCardProcess createNewCreditCardProcess;

    @PostMapping(value="/add", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreditCard> write(@RequestBody CreditCard creditCard){
        try {
            CreditCard persistedCard = createNewCreditCardProcess.process(creditCard);
            return new ResponseEntity<>(persistedCard, HttpStatus.OK);
        }catch (InValidInputException exception){
            throw new RestRuntimeException(exception.getMessage(),HttpStatus.BAD_REQUEST);
        }
        catch (Exception exception){
            throw new RestRuntimeException(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping(value = "getall",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreditCardSearchResponse> read(@RequestParam(defaultValue = "0")  int page,@RequestParam(defaultValue = "2")int size){
        CreditCardSearchResponse creditCardSearchResponse = new CreditCardSearchResponse();
        try{
            Pageable pageable = PageRequest.of(page,size);
            Page<CreditCard> creditCards = creditCardRepository.findAll(pageable);

            creditCardSearchResponse.setCreditCardList(creditCards.getContent());
            creditCardSearchResponse.setCurrentPage(creditCards.getNumber());
            creditCardSearchResponse.setTotalPages(creditCards.getTotalPages());
            creditCardSearchResponse.setTotalItems(creditCards.getTotalElements());

        }catch (Exception exception){
            throw new RestRuntimeException(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (null== creditCardSearchResponse.getCreditCardList()|| creditCardSearchResponse.getCreditCardList().isEmpty()){
            throw new ResourceNotFoundException("No data found",HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(creditCardSearchResponse,HttpStatus.OK);
    }
}
