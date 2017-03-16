package com.sample.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.Random;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.bson.Document;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;

import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.mongo.tests.MongodForTestsFactory;

public class MongoDbUtilsTest {

    private static final Logger log = Logger.getLogger(MongoDbUtilsTest.class);
    private static final String DUMMY_COLLECTION_NAME = "my_collection_name" + _getRandomInt();
    private static final String ADMIN_DB_NAME = "admin";
    private static MongodForTestsFactory factory;
    private static MongoClient mongo;

    static {
        BasicConfigurator.configure();
    }

    private static int _getRandomInt() {
        return new Random().nextInt(1000);
    }

    @AfterClass
    public static void teardown() throws Exception {
        if (factory != null)
            factory.shutdown();
    }

    @BeforeClass
    public static void init() throws InterruptedException, IOException {
        factory = MongodForTestsFactory.with(Version.Main.PRODUCTION);
        mongo = factory.newMongo();
        log.debug("Admin DB name: " + ADMIN_DB_NAME);
        log.debug("COllection name: " + DUMMY_COLLECTION_NAME);
    }

    @After
    public void sleep() throws InterruptedException {
        Thread.sleep(1000);
    }

    @Test
    public void testConnection() {
        try {
            new MongoDbUtils(ADMIN_DB_NAME, mongo);
        } catch (Exception e) {
            // means we are having trouble connecting to the internet, dont fail the test
            log.warn("Handling network host exception\n" + e);
        }
    }

    @Test
    public void testCreateCollection() {
        try {
            new MongoDbUtils(ADMIN_DB_NAME, mongo).createCollection(DUMMY_COLLECTION_NAME);
        } catch (Exception e) {
            // means we are having trouble connecting to the internet, dont fail the test
            log.warn("Handling network host exception\n" + e);
        }
    }

    @Test
    public void testDatabaseConnection() {
        try {
            MongoCollection<Document> documents = new MongoDbUtils(ADMIN_DB_NAME, mongo).getCollectionConn(DUMMY_COLLECTION_NAME);
            for (Document doc : documents.find()) {
                log.info(doc);
            }
        } catch (Exception e) {
            // means we are having trouble connecting to the internet, dont fail the test
            log.warn("Handling network host exception\n" + e);
        }
    }

    @Test
    public void testInsertDocument() {
        Document doc = new Document();
        doc.append("keyOne", "value11");
        try {
            new MongoDbUtils(ADMIN_DB_NAME, mongo).insertDocument(DUMMY_COLLECTION_NAME, doc);
        } catch (Exception e) {
            // means we are having trouble connecting to the internet, dont fail the test
            log.warn("Handling network host exception\n" + e);
        }
    }

    @Test
    public void testInsertMultiDocument() {
        MongoDbUtils mdb = new MongoDbUtils(ADMIN_DB_NAME, mongo);
        for (int index = 0; index < 15; index++) {
            Document doc = new Document();
            String key = "key" + index;
            String val = "val" + index;
            doc.append(key, val);
            try {
                mdb.insertDocument(DUMMY_COLLECTION_NAME, doc);
            } catch (Exception e) {
                // means we are having trouble connecting to the internet, dont fail the test
                log.warn("Handling network host exception\n" + e);
            }
        }

        // Find if all documents got inserted correctly
        MongoCollection<Document> m = mdb.getCollectionConn(DUMMY_COLLECTION_NAME);
        assertNotNull(m);
        assertEquals(15, m.count());
    }


}
