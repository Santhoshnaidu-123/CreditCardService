package com.publicis.sapient.process;

import com.publicis.sapient.exception.InValidInputException;
import com.publicis.sapient.model.CreditCard;
import com.publicis.sapient.repository.ICreditCardRepository;
import com.publicis.sapient.validator.BalanceValidator;
import com.publicis.sapient.validator.CardLengthValidator;
import com.publicis.sapient.validator.CreditCardNumberValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@Import({CreateNewCreditCardProcess.class, CardLengthValidator.class, CreditCardNumberValidator.class, BalanceValidator.class})
@ActiveProfiles("test")
@DataJpaTest()
public class CreateNewCreditCardProcessTest {

    @Autowired
    private CreateNewCreditCardProcess createNewCreditCardProcess;

    @Test(expected = InValidInputException.class)
    public void processInvalidCreditCard(){
        CreditCard creditCard = new CreditCard();
        creditCard.setCardNumber("79927398712");
        creditCard.setBalance(new BigDecimal(0.0));
        creditCard.setOwner("Arnab Saha");
        createNewCreditCardProcess.process(creditCard);
    }

    @Test
    public void processValidCreditCard(){
        CreditCard creditCard = new CreditCard();
        creditCard.setCardNumber("79927398713");
        creditCard.setBalance(new BigDecimal(0.0));
        creditCard.setOwner("Arnab Saha");
        creditCard = createNewCreditCardProcess.process(creditCard);
        assertEquals(true,creditCard.getId()!=null);

    }

}
