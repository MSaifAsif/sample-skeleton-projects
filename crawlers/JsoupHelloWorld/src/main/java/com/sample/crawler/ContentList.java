package com.sample.crawler;

import java.util.HashMap;
import java.util.Map;

public class ContentList {

    private static Map<String, String> instanceMap = new HashMap<>();

    private ContentList() {

    }

    static boolean isContentInMap(String key) {
        return instanceMap.containsKey(key);
    }

    static void insertKey(String k, String v) {
        instanceMap.put(k, v);
    }

}
