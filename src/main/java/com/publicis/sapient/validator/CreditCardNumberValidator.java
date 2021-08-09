package com.publicis.sapient.validator;

import com.publicis.sapient.model.CreditCard;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Component("creditCardNumberValidator")
public class CreditCardNumberValidator implements IValidator<CreditCard>{

    @Override
    public boolean validate(CreditCard creditCard) {
        String cardNumber = creditCard.getCardNumber();
        int []cardDigitArray = new int[cardNumber.length()];
        for(int i=0;i<cardDigitArray.length;++i){
            char c = cardNumber.charAt(i);
            cardDigitArray[i]=  Integer.parseInt(""+c);
        }
        for(int i=cardDigitArray.length-2; i>=0; i=i-2){
            int number = cardDigitArray[i];
            number = number * 2;
            if(number>9){
                number = number%10 + number/10;
            }
            cardDigitArray[i]=number;
        }
        int sum = sumOfArrayElements(cardDigitArray);
        if( sum%10 ==0) {
            return true;
        }
        return false;
    }
    public static int sumOfArrayElements(int[] cardDigitArray){
        return Arrays.stream(cardDigitArray).sum();
    }
}
