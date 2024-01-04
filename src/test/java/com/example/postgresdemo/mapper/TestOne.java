package com.example.postgresdemo.mapper;

import lombok.Builder;
import lombok.Data;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class TestOne {
    @Test()
    public void myTest() {
        Offer.OfferBuilder myOffer = Offer.builder()
                .startDate(LocalDate.now().toString())
                .coverages(List.of(Coverage.builder()
                        .grossPremium(Money.of(CurrencyUnit.EUR, BigDecimal.ONE))
                        .netPremium(Money.of(CurrencyUnit.EUR, BigDecimal.TEN))
                        .subcoverages(List.of(Coverage.SubCoverage.builder()
                                .cantidad(Money.of(CurrencyUnit.EUR, BigDecimal.ONE))
                                .cantidadNeta(Money.of(CurrencyUnit.EUR, BigDecimal.ZERO))
                                .build()))
                        .build()));


        Integer valor = 2;

        List<Coverage> collect = myOffer.coverages.stream().filter(coverage -> valor != null || myOffer == null).collect(Collectors.toList());

        int cantidad = myOffer.coverages.stream()
                .flatMapToInt(coverage -> coverage.getSubcoverages().stream().mapToInt(sub -> {
                    var x = sub.getCantidad().getAmount().toBigInteger().intValue();
                    return x;
                }))
                .sum();

        System.out.println(myOffer);
        System.out.println(cantidad);

    }


    @Data
    @Builder
    public static class Offer {
        String startDate;
        List<Coverage> coverages;
    }

    @Data
    @Builder
    static class Coverage {

        Money netPremium;
        Money grossPremium;
        List<SubCoverage> subcoverages;

        @Data
        @Builder
        static class SubCoverage {
            Money cantidad;
            Money cantidadNeta;
        }
    }


}
