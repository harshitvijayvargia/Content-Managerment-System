package com.searchengine.instaindex.Implementations;

import com.searchengine.instaindex.Datastructure.Trie;
import com.searchengine.instaindex.interfaces.Datastore;
import com.searchengine.instaindex.interfaces.Document;
import com.searchengine.instaindex.services.Tokeniser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
@Primary
public class DatastoreTRIEImpl implements Datastore {
    @Autowired
    Trie trie;
    @Autowired
    Tokeniser tokeniser;
    HashMap<Integer, Document> map = new HashMap<>();

    @Override
    public void insertDocument(int id, String text, String delimeter) {
        try {
            String[] arr = tokeniser.tokenise(text, delimeter);
            if (map.containsKey(id))
            {
                deleteDocument(id, arr);
            }
            for (String word : arr) {
                trie.addWord(word, id);
            }
            Document doc = new DocumentImpl(id, text);
            map.put(id, doc);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteDocument(int id, String[] arr)
    {
        for(String word:arr)
        {
            trie.removeWord(word, id);
        }
    }

    @Override
    public List<Document> fetchDocument(String word) {
        List<Document> result = new ArrayList<>();
        try {
            List<Integer> keys = trie.searchWord(word);
            if (keys == null || keys.size() == 0)
                return null;
            for (int key : keys) {
                result.add(map.get(key));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}
