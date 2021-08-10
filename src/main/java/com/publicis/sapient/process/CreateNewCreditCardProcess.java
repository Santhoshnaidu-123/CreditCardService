package com.publicis.sapient.process;

import com.publicis.sapient.exception.InValidInputException;
import com.publicis.sapient.model.CreditCard;
import com.publicis.sapient.repository.ICreditCardRepository;
import com.publicis.sapient.validator.IValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CreateNewCreditCardProcess implements IProcess<CreditCard>{

    private List<String> validatorList = Arrays.asList("creditCardNumberValidator","balanceValidator","cardLengthValidator");
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private ICreditCardRepository creditCardRepository;

    @Override
    public CreditCard process(CreditCard creditCard) throws  InValidInputException{
        ProcessingContext processingContext = new ProcessingContext();
        validatorList.stream().forEach(validator->{
            IValidator<CreditCard> iValidator = (IValidator<CreditCard>) applicationContext.getBean(validator);
            iValidator.validate(creditCard,processingContext);
        });
        if(processingContext.getErrorCount()>0){
            throw new InValidInputException("Input validation failed");
        }
        creditCard.setId(UniqueIDGenerator.getUniqueId());
        CreditCard persistedCard = creditCardRepository.save(creditCard);
        return persistedCard;
    }
}
