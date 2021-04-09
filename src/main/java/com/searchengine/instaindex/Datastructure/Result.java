package com.searchengine.instaindex.Datastructure;

import com.searchengine.instaindex.interfaces.Document;

import java.util.ArrayList;
import java.util.List;

public class Result {

    public Result(){}
    public Result(int count, List<Document> documents)
    {
        this.count = count;
        this.documentList = documents;
    }
    int count = 0;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Document> getDocumentList() {
        return documentList;
    }

    public void setDocumentList(List<Document> documentList) {
        this.documentList = documentList;
    }

    List<Document> documentList = new ArrayList<>();
}
