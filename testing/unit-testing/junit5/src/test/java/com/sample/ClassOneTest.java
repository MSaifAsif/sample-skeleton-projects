package com.sample;

import org.junit.jupiter.api.*;

import static com.sample.ClassOne.floatingPointDivision;
import static com.sample.ClassOne.wholeNumberDivision;


class ClassOneTest {

    @BeforeEach
    void setUp() {
        System.out.println("Setting up Test");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Tearing down test");
    }


    @Test
    @DisplayName("Case 1 - Test normal flow")
    void testDivisionRegularCase() {
        double result = floatingPointDivision(2d, 2d);
        Assertions.assertEquals(1d, result);
    }


    @Test
    @DisplayName("Case 1 - Test Division by Zero")
    void testDivisionDivideByZero() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            double result = wholeNumberDivision(1, 0);
            System.out.println(result);
        });
    }
}