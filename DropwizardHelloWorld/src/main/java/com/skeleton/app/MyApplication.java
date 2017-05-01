package com.skeleton.app;

import com.skeleton.config.MyConfiguration;
import com.skeleton.resources.MyResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

/**
 * The main entry point of the application
 *
 * @author saifasif
 */
public class MyApplication extends Application<MyConfiguration> {

    public static void main(String[] args) throws Exception {
        new MyApplication().run(args);
    }

    @Override
    public void run(MyConfiguration configuration, Environment environment) throws Exception {
        // each resource has to be registered here individually
        final MyResource resource = new MyResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        environment.jersey().register(resource);
    }
}
