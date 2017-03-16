package com.nyc.events.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
        InputStream iSteamReader = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(iSteamReader));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
            response.append('\r');
        }
        reader.close();
        return Base64.getEncoder().encodeToString(response.toString().getBytes("utf-8"));
    }
}
