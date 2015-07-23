package com.sample.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class JsoupTest {

	private static final Logger log = Logger.getLogger(JsoupTest.class);
	private static final int LONG_TIMEOUT = 1500;

	ExpectedException expectedExc = ExpectedException.none();

	@BeforeClass
	public static void init(){
		BasicConfigurator.configure();
	}
	
	@Test
	public void testConnectionOne(){
		String url = "http://www.google.com";
		Connection conn = Jsoup.connect(url).timeout(LONG_TIMEOUT);
		try {
			Document documentObject = conn.get();
			log.debug("Fetching title for: " + url);
			assertEquals("Google", documentObject.title());
		} catch (IOException e) {
			if (e instanceof java.net.UnknownHostException){
				// means we are having trouble connecting to the internet, dont fail the test
				log.warn("Handling network host exception\n" + e);
			} else {
				fail(e.getMessage());				
			}
		}
	}

	@Test
	public void testConnectionTwo(){
		String url = "http://www.hotmail.com";
		Connection conn = Jsoup.connect(url).timeout(LONG_TIMEOUT);
		try {
			Document documentObject = conn.get();
			log.debug("Fetching title for: " + url);
			assertEquals("Sign In", documentObject.title());
		} catch (IOException e) {
			if (e instanceof java.net.UnknownHostException){
				// means we are having trouble connecting to the internet, dont fail the test
				log.warn("Handling network host exception\n" + e);
			} else {
				fail(e.getMessage());				
			}
		}
	}

	@Test(expected=java.net.UnknownHostException.class)
	public void testConnectionThree() throws IOException{
		String url = "http://www.localhost.com";
		Connection conn = Jsoup.connect(url).timeout(LONG_TIMEOUT);
		try {
			Document documentObject = conn.get();
			log.debug("Fetching title for: " + url);
			assertEquals("Google", documentObject.title());
		} catch (IOException e) {
			throw e;
		}
	}

	@Test(expected=java.net.UnknownHostException.class)
	public void testConnectionFour() throws IOException{
		String url = "http://www.google2.com";
		Connection conn = Jsoup.connect(url).timeout(LONG_TIMEOUT);
		try {
			Document documentObject = conn.get();
			log.debug("Fetching title for: " + url);
			assertEquals("Google", documentObject.title());
		} catch (IOException e) {
			throw e;
		}
	}

	@Test
	public void testConnectionFive(){

		String url = "http://www.google.com";
		Connection conn = Jsoup.connect(url).timeout(LONG_TIMEOUT);
		try {
			Document documentObject = conn.get();
			log.debug("Fetching title for: " + url);
			assertEquals("Google", documentObject.title());
		} catch (IOException e) {
			if (e instanceof java.net.UnknownHostException){
				// means we are having trouble connecting to the internet, dont fail the test
				log.warn("Handling network host exception\n" + e);
			} else {
				fail(e.getMessage());				
			}
		}
	}

}
