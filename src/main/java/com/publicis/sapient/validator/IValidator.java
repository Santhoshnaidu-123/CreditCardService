package com.publicis.sapient.validator;

public interface IValidator<T> {
    public boolean validate(T t);
}
