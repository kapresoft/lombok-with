package com.kapresoft.lombok.builders;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Value;
import lombok.With;

@Value
@Builder
public class Resident {

    @With(value = AccessLevel.PACKAGE)
    String fullName;
    @With
    String phoneNumber;
    String streetAddress;
    String city;
    String state;
    String zipCode;
    String country;

}
