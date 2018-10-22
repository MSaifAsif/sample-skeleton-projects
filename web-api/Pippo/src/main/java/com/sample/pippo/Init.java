package com.sample.pippo;

import com.sample.pippo.basic.App;
import org.apache.log4j.BasicConfigurator;
import ro.pippo.core.Pippo;

/**
 * @author saifasif
 */
public class Init {
    public static void main(String[] args) {
        BasicConfigurator.configure();
        Pippo pippo = new Pippo(new App());
        pippo.start();

    }
}
