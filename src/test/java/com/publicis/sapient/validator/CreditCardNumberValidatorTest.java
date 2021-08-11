package com.publicis.sapient.validator;

import com.publicis.sapient.model.CreditCard;
import com.publicis.sapient.process.ProcessingContext;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CreditCardNumberValidatorTest {

    @Test
    public void validCardNumber(){
        CreditCard creditCard = new CreditCard();
        creditCard.setCardNumber("79927398713");
        ProcessingContext processingContext = new ProcessingContext();
        CreditCardNumberValidator creditCardNumberValidator = new CreditCardNumberValidator();
        creditCardNumberValidator.validate(creditCard,processingContext);
        assertEquals(0,processingContext.getErrorCount());
    }

    @Test
    public void inValidCardNumber(){
        CreditCard creditCard = new CreditCard();
        creditCard.setCardNumber("79927398712");
        ProcessingContext processingContext = new ProcessingContext();
        CreditCardNumberValidator creditCardNumberValidator = new CreditCardNumberValidator();
        creditCardNumberValidator.validate(creditCard,processingContext);
        assertEquals(1,processingContext.getErrorCount());
    }
}
