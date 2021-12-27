package com.kapresoft.lombok.builders;

import lombok.EqualsAndHashCode;
import lombok.Singular;
import lombok.Value;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Value
@EqualsAndHashCode(callSuper = true)
@SuperBuilder(toBuilder = true)
public class SuperUser extends User {

    @Singular
    List<String> permissions;

    @Override
    public boolean isSuperUser() {
        return true;
    }

}
