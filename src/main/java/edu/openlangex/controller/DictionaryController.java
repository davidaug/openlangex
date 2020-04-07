package edu.openlangex.controller;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/dictionary")
public class DictionaryController {

    @GetMapping
    @Cacheable(value = "dictionary-cache")
    public String Hello(){
        return "Hello World";
    }
}
