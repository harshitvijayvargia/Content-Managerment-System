package com.searchengine.instaindex.Datastructure;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class Trie {
    TrieNode trie = null;

    public Trie() {
        trie = new TrieNode();
    }

    public void addWord(String word, Integer key) {
        TrieNode node = trie;
        for (char ch : word.toCharArray()) {
            if (!node.children.containsKey(ch)) {
                node.children.put(ch, new TrieNode());
            }
            node = node.children.get(ch);
        }
        node.keys.add(key);
    }

    public void removeWord(String word, Integer key) {
        TrieNode node = trie;
        for(char ch:word.toCharArray()) {
            node = node.children.get(ch);
        }
        node.keys.remove(new Integer(key));
    }

    public List<Integer> searchWord(String word) {
        TrieNode node = trie;
        List<Integer> list = new ArrayList<>();
        int index = 0;
        for (char ch : word.toCharArray()) {
            if (!node.children.containsKey((ch)))
                return null;
//            if (node.keys.size() != 0)
//                list.addAll(node.keys);
            node = node.children.get(ch);

            index++;
        }
        if (node.keys.size() != 0) {
            list.addAll(node.keys);
        }
        Collections.reverse(list);
        return list;
    }
}
