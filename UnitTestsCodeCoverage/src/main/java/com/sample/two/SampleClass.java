package com.sample.two;

public class SampleClass {

    public static final int NUMBER_FOUR = 4;
    private int index = 0;
    
    public SampleClass(){
        super();
    }
    
    public SampleClass(int index){
        this.index = index;
    }
    
    
    public double getRandomInt(){
        return Math.random() + index;
    }
    
    public static String getGreetMessage(){
        return "Hello, world !";
    }
    
    @SuppressWarnings("unused")
    private Integer getLargerInteger(Integer a, Integer b){
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }

}
