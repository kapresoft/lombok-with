package com.kapresoft.lombok.builders;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Singular;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void builder() {
        final User johnDoe = User.builder().firstName("John")
                .lastName("Doe")
                .build();
        assertThat(johnDoe.getFirstName()).as("FirstName")
                .isEqualTo("John");
        assertThat(johnDoe.getLastName()).as("LastName")
                .isEqualTo("Doe");
    }

    @Test
    void builder_IsNotSuperUser() {
        final User johnDoe = User.builder().firstName("John")
                .build();
        assertThat(johnDoe.isSuperUser()).as("IsSuperUser")
                .isFalse();
    }

    @Test
    void toBuilder() {
        final User janeDoe = User.builder().firstName("Jane")
                .lastName("Doe")
                .build();

        final User janeDoeCopy = janeDoe.toBuilder().build();
        assertThat(janeDoe).isNotSameAs(janeDoeCopy);

        assertThat(janeDoe.getFirstName()).as("FirstName")
                .isEqualTo(janeDoeCopy.getFirstName());
        assertThat(janeDoe.getLastName()).as("LastName")
                .isEqualTo(janeDoeCopy.getLastName());

        assertThat(janeDoe.hashCode()).isEqualTo(janeDoeCopy.hashCode());
        assertThat(janeDoe).isEqualTo(janeDoeCopy);
    }

}