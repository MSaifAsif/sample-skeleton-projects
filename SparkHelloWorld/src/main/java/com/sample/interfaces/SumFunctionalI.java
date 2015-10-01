package com.sample.interfaces;

/**
 * A functional interface to perform sum operations on 
 * Numbers and on strings. A default implementaion has been provided to the
 * sumNumber method for classes that do not want to go through the hassle to 
 * implement all methods in the interface and also to keep this interface as FunctionalInterface
 * i.e an interface responsible for only a single operation
 * 
 * @author saifasif
 *
 */
public interface SumFunctionalI {

    /**
     * Returns the sum of two {@link Number}s
     * Implementation has been kept default to maintain the functional state of the interface
     * @param numA
     * @param numB
     * @return
     */
    default Number sumNumber(Number numA, Number numB){
        return numA.doubleValue() + numB.doubleValue();
    }

    /**
     * The functional method.
     *  To concatenate two strings
     * @param tokenA
     * @param tokenB
     * @return
     */
    public String concatStrings(String tokenA, String tokenB);

}
