package com.example.demo.controllers;


import com.example.demo.entities.Url;
import com.example.demo.services.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class UrlController {

    @Autowired
    UrlService urlService;

    @PostMapping()
    public ResponseEntity<?> save(@RequestBody Url url) {
        return ResponseEntity.ok(urlService.save(url));
    }

    @GetMapping("{shortCode}")
    public ResponseEntity<?> fingByShortCode(@PathVariable String shortCode) {
        Url url = urlService.findByShortCode(shortCode);

        return ResponseEntity.ok(url);
    }
}
