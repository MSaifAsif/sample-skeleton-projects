package com.sample.db.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.sample.crawler.ContentList;

public class DBTests {

    @Test
    public void testSingletonNature(){
        ContentList.insertKey("ONE", "1");
        assertNotNull(ContentList.getContentMap());
        assertEquals(ContentList.getContentMap().size(), 1);
        assertTrue(ContentList.isContentInMap("ONE"));
    }
}
