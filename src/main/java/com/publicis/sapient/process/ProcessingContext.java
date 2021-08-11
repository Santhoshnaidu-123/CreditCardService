package com.publicis.sapient.process;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class ProcessingContext {

    private int errorCount = 0;
    private List<String> errors = new ArrayList<>();

    public String getAllErrors(){
        return errors.stream().collect(Collectors.joining());
    }
}
