package com.sample.utilities;

/**
 * Group of random methods
 * 
 * @author saifasif
 *
 */
public class TransformationUtils {

    private TransformationUtils(){
        // Dont init
    }

    /**
     * Get sum of bytes
     * @return
     */
    public static String getSumOfBytes(){
        return String.valueOf((Math.random()*1000 + Math.random()*1000));
    }

    /**
     * Retrieve a sample object from {@link MyBean}
     * @param caller
     * @return
     */
    public static MyBean getObj(String caller){
        MyBean myBean = new MyBean();
        myBean.setEpoch(System.currentTimeMillis());
        myBean.setGender('m');
        myBean.setIndex(1);
        myBean.setName(caller);
        return myBean;
    }

}
