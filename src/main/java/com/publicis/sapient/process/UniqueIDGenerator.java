package com.publicis.sapient.process;

import java.util.UUID;

public class UniqueIDGenerator {

    public static String getUniqueId(){
        return UUID.randomUUID().toString();
    }
}
