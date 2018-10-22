package com.sample.utils;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.apache.log4j.Logger;
import org.bson.Document;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * A collection of utility function to create, insert, bulk insert documents
 * into mongo
 *
 * @author saifasif
 */
public class MongoDbUtils {

    private static final Logger log = Logger.getLogger(MongoDbUtils.class);
    private static String URI = "mongodb://%s:%s@%s:%s/%s";
    private String userName;
    private String passWord;
    private String host;
    private String port;

    private String dbName;
    private MongoClientURI mongoClientURI;
    private MongoClient mongoClient;
    private Properties properties = new Properties();

    public MongoDbUtils(String dbName) {
        _loadPropertiesFile();
        this.dbName = dbName;
        _initConnection(dbName);
    }

    public MongoDbUtils(String dbName, MongoClient mongoClient) {
        this.dbName = dbName;
        this.mongoClient = mongoClient;
    }

    /**
     * Load the properties file
     */
    private void _loadPropertiesFile() {
        try {
            properties.load(new FileReader("./src/main/resources/connection.properties"));
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        this.userName = properties.getProperty("mongo.db.username", "admin");
        this.passWord = properties.getProperty("mongo.db.password", "admin");
        this.host = properties.getProperty("mongo.db.host");
        this.port = properties.getProperty("mongo.db.port");
        log.debug("Properties loaded");
    }

    /**
     * Initialize the connection to the DB
     *
     * @param dbName
     */
    private void _initConnection(String dbName) {
        String connectionString = String.format(URI, userName, passWord, host, port, this.dbName);
        log.debug("Attempting connection:::" + connectionString);
        this.mongoClientURI = new MongoClientURI(connectionString);
        this.mongoClient = new MongoClient(this.mongoClientURI);
        log.debug("Connected to mongo");
    }

    /**
     * Get the current DB connection
     *
     * @return {@link MongoDatabase} connection
     */
    private MongoDatabase _getCurrentDB() {
        return this.mongoClient.getDatabase(this.dbName);
    }

    /**
     * Inserts documents into the collection
     *
     * @param collectionName
     * @param documents
     */
    private void _insertDocuments(String collectionName, List<Document> documents) {
        getCollectionConn(collectionName).insertMany(documents);
    }

    /**
     * To insert a single document into the mongo collection
     *
     * @param collectionName
     * @param document
     */
    public void insertDocument(String collectionName, Document document) {
        log.debug("Inserting document:" + document.toJson().toString());
        ArrayList<Document> docList = new ArrayList<>();
        docList.add(document);
        _insertDocuments(collectionName, docList);
        log.debug("Document inserted:" + document.toJson().toString());
    }

    /**
     * Create a collection
     *
     * @param collectionName
     */
    public void createCollection(String collectionName) {
        _getCurrentDB().createCollection(collectionName);
    }

    /**
     * Get the connection to the collection with respect to the current database
     *
     * @param collectionName
     * @return
     */
    public MongoCollection<Document> getCollectionConn(String collectionName) {
        return _getCurrentDB().getCollection(collectionName);
    }

}
