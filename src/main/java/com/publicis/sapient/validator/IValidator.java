package com.publicis.sapient.validator;

import com.publicis.sapient.process.ProcessingContext;

public interface IValidator<T> {
    boolean validate(T t, ProcessingContext processingContext);

    default String validationFailureMessage(){
        return " Validation failed : "+this.getClass();
    }
}
