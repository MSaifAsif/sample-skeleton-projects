package com.sample.one.pages;


import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

/**
 * A sample page that will show a message on the page located at <code>com.sample.one.pages.GreetingsPage.html</code>
 *
 * @author saifasif
 */
public class GreetingsPage extends WebPage {

    public GreetingsPage(final PageParameters pageParameters) {
        /*
         * Renders an attribute named 'greetingmessage'
         */
        add(new Label("greetingmessage", "Greetings, Hello World !"));
    }

}
