package com.searchengine.instaindex.services;

import com.searchengine.instaindex.Datastructure.Result;
import com.searchengine.instaindex.interfaces.Datastore;
import com.searchengine.instaindex.interfaces.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

@Component
public class Service {

    @Autowired
    Datastore ds;

    public Result getDocument(String word) {
        word = word.toLowerCase();
        List<Document> documents = ds.fetchDocument(word);
        if(documents==null || documents.size()==0)
            return new Result();
        Result res = new Result(documents.size(), documents);
        return res;
    }

    public void saveDocument(Document document, String delimeter) {
        if(delimeter==null)
            delimeter=" ";
        ds.insertDocument(document.getId(), document.getText(), delimeter);
    }

}