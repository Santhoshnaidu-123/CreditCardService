package com.publicis.sapient.validator;

import com.publicis.sapient.model.CreditCard;
import com.publicis.sapient.process.ProcessingContext;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component("balanceValidator")
public class BalanceValidator implements IValidator<CreditCard>{
    @Override
    public boolean validate(CreditCard creditCard, ProcessingContext processingContext) {
        if(!creditCard.getBalance().equals(new BigDecimal(0.0))){
            processingContext.setErrorCount(processingContext.getErrorCount()+1);
            processingContext.getErrors().add(validationFailureMessage());
            return false;
        }
        return  true;
    }
}
