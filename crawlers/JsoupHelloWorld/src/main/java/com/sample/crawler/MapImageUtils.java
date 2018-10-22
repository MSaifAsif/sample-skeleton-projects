package com.sample.crawler;

import org.apache.commons.io.IOUtils;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

/**
 * @author saifasif
 */
public class MapImageUtils {

    private static final String URL = "http://maps.googleapis.com/maps/api/staticmap?";
    private static final String key = "ZzZAIzaSyCutiGe5lu9qYuvBjndQOlW9qg086PRYbk";

    public static final String getImageStream(String latitude, String longitude) throws IOException {
        String urlString = URL + "center=" + latitude + "," + longitude;
        urlString += "&key=" + key;
        urlString += "&zoom=12&size=400x400";
        System.out.println(urlString);
        URL url = new URL(urlString);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setUseCaches(false);
        connection.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
        wr.close();

        try (InputStream iSteamReader = connection.getInputStream()) {
            byte[] bytes = IOUtils.toByteArray(iSteamReader);
            return Base64.getEncoder().encodeToString(bytes);
        }
    }
}
