package com.kapresoft.lombok.builders;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResidentTest {

    @Test
    void createSingleResident() {
        final Resident johnDoe = Resident.builder()
                .streetAddress("100 Main St")
                .city("Bellevue").state("WA")
                .fullName("John Doe")
                .phoneNumber("425-555-1000")
                .city("Bellevue").state("WA").zipCode("98004")
                .build();
        assertThat(johnDoe.getFullName()).as("Full Name")
                .isEqualTo("John Doe");
        assertThat(johnDoe.getPhoneNumber()).as("Phone Number")
                .isEqualTo("425-555-1000");
        assertThat(johnDoe.getCity()).as("City")
                .isEqualTo("Bellevue");
        assertThat(johnDoe.getState()).as("State")
                .isEqualTo("WA");
        assertThat(johnDoe.getZipCode()).as("ZipCode")
                .isEqualTo("98004");
    }

    @Test
    void createResidents() {
        final Resident johnDoe = Resident.builder()
                .streetAddress("100 Main St")
                .city("Bellevue").state("WA")
                .fullName("John Doe")
                .phoneNumber("425-555-1000")
                .city("Bellevue").state("WA").zipCode("98004")
                .build();
        assertThat(johnDoe.getFullName()).as("Full Name")
                .isEqualTo("John Doe");
        assertThat(johnDoe.getPhoneNumber()).as("Phone Number")
                .isEqualTo("425-555-1000");

        final Resident janeDoe = johnDoe
                .withFullName("Jane Doe")
                .withPhoneNumber("425-555-1001");
        assertThat(janeDoe.getFullName()).as("Full Name")
                .isEqualTo("Jane Doe");
        assertThat(janeDoe.getPhoneNumber()).as("Phone Number")
                .isEqualTo("425-555-1001");

        final Resident teenageDaughter = johnDoe.withFullName("Jennifer Doe")
                .withPhoneNumber("425-555-1002");
        assertThat(teenageDaughter.getFullName()).as("Full Name")
                .isEqualTo("Jennifer Doe");
        assertThat(teenageDaughter.getPhoneNumber()).as("Phone Number")
                .isEqualTo("425-555-1002");

    }

}