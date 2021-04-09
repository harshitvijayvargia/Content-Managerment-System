package com.searchengine.instaindex.controllers;

import com.searchengine.instaindex.Datastructure.Result;
import com.searchengine.instaindex.Implementations.DocumentImpl;
import com.searchengine.instaindex.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/")
public class API {

    @Autowired
    Service service;

    @GetMapping("/search")
    Result getDocument(@RequestParam String query) {
        return service.getDocument(query);
    }

    @PostMapping("/document")
    void saveDocument(@RequestBody DocumentImpl document, @RequestParam(required = false) String delimeter) {
        service.saveDocument(document,delimeter);
    }

}
