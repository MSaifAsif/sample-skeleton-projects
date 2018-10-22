package com.sample.one.apps;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

import com.sample.one.pages.GreetingsPage;

/**
 * Entry point of the application.
 *
 * @author saifasif
 */
public class Application extends WebApplication {

    @Override
    public Class<? extends Page> getHomePage() {
        return GreetingsPage.class;
    }

}
