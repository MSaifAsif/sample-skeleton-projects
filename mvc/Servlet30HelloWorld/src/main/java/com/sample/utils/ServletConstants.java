package com.sample.utils;

public class ServletConstants {

    private ServletConstants() {
        // Don't init
    }

    /**
     * Generate a new session ID
     *
     * @return
     */
    public static String getNewSessionID() {
        return String.valueOf(Math.random()).replace('.', '\0');
    }

}
