package com.searchengine.instaindex.Implementations;

import com.searchengine.instaindex.interfaces.Datastore;
import com.searchengine.instaindex.interfaces.Document;
import com.searchengine.instaindex.services.Tokeniser;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class DatastoreHMImpl implements Datastore {

    Tokeniser tokeniser = new Tokeniser();
    HashMap<String, List<Integer>> wordToFileMap = new HashMap<>();
    HashMap<Integer, Document> documentHashMap = new HashMap<>();

    public DatastoreHMImpl() {
    }

    @Override
    public void insertDocument(int id, String text, String delimeter) {
        try {
            String[] arr = tokeniser.tokenise(text," ");
            for (String word : arr) {
                if (wordToFileMap.containsKey(word))
                    wordToFileMap.get(word).add(id);
                else {
                    List<Integer> list = new ArrayList<>();
                    list.add(id);
                    wordToFileMap.put(word, list);
                }
            }
            Document doc = new DocumentImpl(id, text);
            documentHashMap.put(id, doc);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Document> fetchDocument(String word) {
        List<Document> docs = new ArrayList<>();
        try {
            if (wordToFileMap.containsKey(word)) {
                List<Integer> list = wordToFileMap.get(word);
                for (int key : list)
                    docs.add(documentHashMap.get(key));
                return docs;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void deleteDocument(int id, String[] arr) {

    }
}
