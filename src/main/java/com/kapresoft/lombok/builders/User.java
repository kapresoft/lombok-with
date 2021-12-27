package com.kapresoft.lombok.builders;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder(toBuilder = true)
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class User {

    @Getter
    String firstName;
    @Getter
    String lastName;
    @Getter
    String email;

    public boolean isSuperUser() {
        return false;
    }

}
