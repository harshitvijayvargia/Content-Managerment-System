package com.searchengine.instaindex.Implementations;

import com.searchengine.instaindex.interfaces.Document;
import org.springframework.stereotype.Component;

@Component
public class DocumentImpl implements Document {

    int id;
    String text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public DocumentImpl() {
    }

    public DocumentImpl(int id, String text) {
        this.id = id;
        this.text = text;
    }


}
