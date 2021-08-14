package com.publicis.sapient.validator;

import com.publicis.sapient.model.CreditCard;
import com.publicis.sapient.process.ProcessingContext;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class BalanceValidatorTest {

    @Test
    public void validateErrorCount(){
        CreditCard creditCard = new CreditCard();
        creditCard.setBalance(new BigDecimal(100.0));
        ProcessingContext processingContext = new ProcessingContext();
        BalanceValidator balanceValidator = new BalanceValidator();
        balanceValidator.validate(creditCard,processingContext);
        assertEquals(1,processingContext.getErrorCount());

    }

    @Test
    public void validateNoError(){
        CreditCard creditCard = new CreditCard();
        creditCard.setBalance(new BigDecimal(0.0));
        ProcessingContext processingContext = new ProcessingContext();
        BalanceValidator balanceValidator = new BalanceValidator();
        balanceValidator.validate(creditCard,processingContext);
        assertEquals(0,processingContext.getErrorCount());

    }
}
