package com.sample.crawler;

import java.io.IOException;
import java.sql.SQLException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/**
 * TODO Need to add a fast database to make sure that the same page doesnt get hit twice
 * @author saifasif
 *
 */
public class Crawler {

    public static void main(String[] args) throws SQLException, IOException {
        processPage("http://www.mit.edu");
    }

    public static void processPage(String URL) throws SQLException, IOException{
        //check if the given URL is already in database
        //get useful information
        if (ContentList.isContentInMap(URL)){
            return;
        }
        Document doc = null;
        try{
            doc = Jsoup.connect(URL).timeout(5000).get();
            if(doc.text().contains("research")){
                System.out.println(URL);
                ContentList.insertKey(URL, URL);
            }
            
            //get all links and recursively call the processPage method
            Elements questions = doc.select("a[href]");
            for(Element link: questions){
                if(link.attr("href").contains("mit.edu"))
                    processPage(link.attr("abs:href"));
            }
        } catch (Exception e){
            System.out.println("skipping .... " + URL);
        }

    }
}