package com.kapresoft.lombok.builders;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SuperUserTest {

    @Test
    void builder_IsSuperUser() {
        User superUser = SuperUser.builder()
                .firstName("John").lastName("Doe")
                .permission("canUpdate").permission("canDelete")
                .build();
        assertThat(superUser.isSuperUser())
                .isTrue();
    }

    @Test
    void builder_ShouldNotHaveSimilarHashCodes() {
        User user = User.builder().firstName("John").lastName("Doe").build();
        User superUser = SuperUser.builder()
                .firstName("John").lastName("Doe")
                .permission("canUpdate").permission("canDelete")
                .build();
        assertThat(user.hashCode()).isNotEqualTo(superUser.hashCode());
    }

    @Test
    void copyConstructor_ShouldHaveEqualFieldValues() {
        SuperUser johnDoe = SuperUser.builder()
                .email("johndoe@gmail.com")
                .permission("canUpdate").permission("canDelete")
                .build();
        SuperUser johnDoeCopy = johnDoe.toBuilder().build();
        assertThat(johnDoe).hasToString(johnDoeCopy.toString());
    }

    @Test
    void copyConstructor_ShouldNotEqualInValue_WhenPropertiesAreDifferent() {
        SuperUser johnDoe = SuperUser.builder()
                .email("johndoe@gmail.com")
                .permission("canUpdate").permission("canDelete")
                .build();
        SuperUser janeDoe = johnDoe.toBuilder().firstName("janedoe@email.com")
                .permission("canUpdate")
                .build();
        assertThat(johnDoe).isNotEqualTo(janeDoe);
    }

}