package com.example.postgresdemo.model;


import org.junit.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class StaticUtilsTest {

    @Test
    public void givenStaticMethodWithNoArgs_whenMocked_thenReturnsMockSuccessfully() {
/*
        assertThat(StaticUtils.name()).isEqualTo("Baeldung");
*/


        String ho = getAgentNumber("hoa");

        System.out.println(ho);

        try (MockedStatic<UUID> utilities = Mockito.mockStatic(UUID.class)) {
            UUID uuid = UUID.fromString("54ee5fe7-1489-488a-a6c1-b3b6ce5b3ad1");
            utilities.when(UUID::randomUUID).thenReturn(uuid);
            assertThat(UUID.randomUUID()).isEqualTo(UUID.fromString("54ee5fe7-1489-488a-a6c1-b3b6ce5b3ad1"));
        }

/*
        assertThat(StaticUtils.name()).isEqualTo("Baeldung");
*/
    }

    public String getAgentNumber(String contract) {
        if (contract.equalsIgnoreCase("hola")) return contract.toUpperCase();

        return null;
    }
}
