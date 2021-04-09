package com.searchengine.instaindex.Datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> children = new HashMap();
    List<Integer> keys = new ArrayList<>();

    public TrieNode() {
    }
}
