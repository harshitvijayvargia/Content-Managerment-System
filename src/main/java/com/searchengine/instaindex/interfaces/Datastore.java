package com.searchengine.instaindex.interfaces;

import java.util.List;

public interface Datastore {
    void insertDocument(int id, String content, String delimeter);

    List<Document> fetchDocument(String word);

    public void deleteDocument(int id, String[] arr);
}
