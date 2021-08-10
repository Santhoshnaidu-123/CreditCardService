package com.publicis.sapient.validator;

import com.publicis.sapient.process.ProcessingContext;

public interface IValidator<T> {
    public boolean validate(T t, ProcessingContext processingContext);
}
