package com.kapresoft.lombok.builders;

import lombok.Builder;
import lombok.Value;

@Value
public class User {

    String firstName;
    String lastName;

    @Builder(toBuilder = true)
    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
