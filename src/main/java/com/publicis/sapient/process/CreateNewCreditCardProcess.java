package com.publicis.sapient.process;

import com.publicis.sapient.exception.InValidInputException;
import com.publicis.sapient.model.CreditCard;
import com.publicis.sapient.repository.ICreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CreateNewCreditCardProcess extends GenericProcess<CreditCard>{

    private List<String> validatorList = Arrays.asList("creditCardNumberValidator","balanceValidator","cardLengthValidator");

    @Autowired
    private ICreditCardRepository creditCardRepository;

    @Override
    public CreditCard execute(CreditCard creditCard) throws  InValidInputException{
        creditCard.setId(UniqueIDGenerator.getUniqueId());
        CreditCard persistedCard = creditCardRepository.save(creditCard);
        return persistedCard;
    }
    @Override
    public List<String> getValidatorList() {
        return Arrays.asList("creditCardNumberValidator","balanceValidator","cardLengthValidator");
    }
}
