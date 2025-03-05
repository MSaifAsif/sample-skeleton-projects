package com.sample.one.apps;

import com.sample.one.pages.GreetingsPage;
import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

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
