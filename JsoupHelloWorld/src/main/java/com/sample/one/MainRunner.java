package com.sample.one;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class MainRunner {

    static final String URL = "http://www.google.com";
    static final int LONG_TIMEOUT = 1000;
    static final String hrefLink = "link[href~=.*\\.(ico|png)]";
    static final String imgMeta = "meta[itemprop=image]";

    public static void main(String[] args) {
        String faviconImagePath = "";

        Connection conn = Jsoup.connect(URL).timeout(LONG_TIMEOUT);
        try {
            Document documentObject = conn.get();
            System.out.println("URL title: " + documentObject.title());

            Element domElement = documentObject.head().select(hrefLink).first();
            if (domElement == null) {
                domElement = documentObject.head().select(imgMeta).first();
                faviconImagePath = domElement.attr("content");
            }
            System.out.println("Favicon img: " + faviconImagePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
