package com.publicis.sapient.validator;

import com.publicis.sapient.model.CreditCard;
import com.publicis.sapient.process.ProcessingContext;
import org.springframework.stereotype.Component;

@Component("cardLengthValidator")
public class CardLengthValidator implements IValidator<CreditCard>{
    @Override
    public boolean validate(CreditCard creditCard, ProcessingContext processingContext) {
        if(null == creditCard.getCardNumber() || creditCard.getCardNumber().isEmpty()||creditCard.getCardNumber().length()>19){
            processingContext.setErrorCount(processingContext.getErrorCount()+1);
            processingContext.getErrors().add(validationFailureMessage());
            return false;
        }
        return true;
    }
}
