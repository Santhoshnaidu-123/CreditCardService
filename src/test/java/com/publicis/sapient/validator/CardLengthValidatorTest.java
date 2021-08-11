package com.publicis.sapient.validator;

import com.publicis.sapient.model.CreditCard;
import com.publicis.sapient.process.ProcessingContext;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardLengthValidatorTest {

    @Test
    public void greaterThanMaxLength(){
        CreditCard creditCard = new CreditCard();
        creditCard.setCardNumber("12345678912345678912");
        ProcessingContext processingContext = new ProcessingContext();
        CardLengthValidator cardLengthValidator = new CardLengthValidator();
        cardLengthValidator.validate(creditCard,processingContext);
        assertEquals(1,processingContext.getErrorCount());
    }
    @Test
    public void maxLength(){
        CreditCard creditCard = new CreditCard();
        creditCard.setCardNumber("1234578912345789");
        ProcessingContext processingContext = new ProcessingContext();
        CardLengthValidator cardLengthValidator = new CardLengthValidator();
        cardLengthValidator.validate(creditCard,processingContext);
        assertEquals(0,processingContext.getErrorCount());
    }
}
