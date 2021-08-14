package com.publicis.sapient.process;

import com.publicis.sapient.exception.InValidInputException;
import com.publicis.sapient.validator.IValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class GenericProcess<T> implements IProcess<T>{

    private List<String> validatorList;
    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public T process(T t) throws InValidInputException {
        ProcessingContext processingContext = new ProcessingContext();
        validate(t,processingContext);
        t = execute(t);
        return t;
    }


    public void validate(T t,ProcessingContext processingContext){
        getValidatorList().stream().forEach(validator->{
            IValidator<T> iValidator = (IValidator<T>) applicationContext.getBean(validator);
            iValidator.validate(t,processingContext);
        });
        if(processingContext.getErrorCount()>0){
            throw new InValidInputException("Input validation failed ["+processingContext.getAllErrors()+"]");
        }
    }

    public List<String> getValidatorList() {
        return validatorList;
    }
    public T execute(T t){
        return t;
    };
}
