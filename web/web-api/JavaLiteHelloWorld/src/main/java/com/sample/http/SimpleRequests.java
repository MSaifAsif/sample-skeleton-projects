package com.sample.http;

import org.apache.log4j.Logger;
import org.javalite.http.Get;
import org.javalite.http.Http;
import org.javalite.http.Post;

/**
 * Helper class to call {@link Http} functions
 *
 * @author saifasif
 */
public class SimpleRequests {

    private static final Logger log = Logger.getLogger(SimpleRequests.class);
    private static final int connectionTimeout = 2500;
    private static final int readTimeout = 2500;

    /**
     * Retrieve the page text.
     *
     * @param url
     * @return
     */
    public static String getPageText(String url) {
        String res = null;
        log.debug("Fetching page " + url);
        try {
            Get get = Http.get(url, connectionTimeout, readTimeout);
            log.debug("Got response as: " + get.responseMessage() + "(" + get.responseCode() + ")");
            res = get.text();  // After this, the stream is closed. Any further calls will result in an exception
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        return res;
    }

    public static String performPostOnPage(String url, byte[] postContent) {
        String res = null;
        log.debug("Fetching page " + url);
        try {
            Post post = Http.post(url, postContent, connectionTimeout, readTimeout);
            log.debug("Got response as: " + post.responseMessage() + "(" + post.responseCode() + ")");
            res = post.text();  // After this, the stream is closed. Any further calls will result in an exception
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        return res;
    }

}
