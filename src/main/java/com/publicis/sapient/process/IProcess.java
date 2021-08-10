package com.publicis.sapient.process;

import com.publicis.sapient.exception.InValidInputException;

public interface IProcess<T> {

    public T process(T t) throws  InValidInputException;
}
