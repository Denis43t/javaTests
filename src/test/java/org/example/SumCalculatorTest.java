package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;



class SumCalculatorTest {
    SumCalculator sumCalculator;



    @BeforeEach
    void setUp(){
        sumCalculator=new SumCalculator();
    }

    @Test
    void successfullySumCalculator(){
        int input=3;
        int expected=6;

        int result= sumCalculator.sum(input);

        Assertions.assertEquals(expected,result);
    }
    @Test
    void successfullySumCalculatorWithInputOne(){
        int input=1;
        int expected=1;

        int result= sumCalculator.sum(input);

        Assertions.assertEquals(expected,result);
    }
    @Test
    void exceptionSumCalculator(){
        int input=0;



        Assertions.assertThrowsExactly(IllegalArgumentException.class,()-> sumCalculator.sum(input));
    }

    @ParameterizedTest(name="{0}")
    @MethodSource("getIntParams")
    void succesfullyParamsSumCalculator(String name,int input, int expected){


        int result= sumCalculator.sum(input);

        Assertions.assertEquals(expected,result);
    }

    private static Stream<Arguments> getIntParams() {
        return Stream.of(
                Arguments.of("successfullyTestWithInt1", 1,1),
                Arguments.of("successfullyTest",3,6)
        );
    }
}