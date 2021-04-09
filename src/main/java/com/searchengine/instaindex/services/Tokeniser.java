package com.searchengine.instaindex.services;

import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class Tokeniser {
    public String[] tokenise(String content, String delimeter) {
        String arr[] = content.split(delimeter);
        return normalise(arr);
    }

    public String[] normalise(String[] arr) {
        HashSet<String> set = new HashSet<>();
        for (String str : arr) {
            if (str == "" || str.length() == 0)
                continue;
            set.add(str.toLowerCase());
        }
        return set.toArray(new String[0]);
    }
}
