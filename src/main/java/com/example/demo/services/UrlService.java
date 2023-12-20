package com.example.demo.services;


import com.example.demo.entities.Url;
import com.example.demo.repositories.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class UrlService {

    @Autowired
    UrlRepository urlRepository;

    /**
     * Generate a Short Code
     * return a String of 8 characters (uppercase, lowercase, and numbers)
     */
    private String generateShortCode() {
        final String ALLOWED_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        final SecureRandom random = new SecureRandom();

        StringBuilder sb = new StringBuilder(8);

        for(int i = 0 ; i < 8 ; i++) {
            int randomIndex = random.nextInt(ALLOWED_CHARACTERS.length());
            char c = ALLOWED_CHARACTERS.charAt(randomIndex);
            sb.append(c);
        }
        return sb.toString();
    }

    public Url save(Url url) {
        String code = generateShortCode();
        url.setShortCode(code);

        return urlRepository.save(url);
    }

    public Url findByShortCode(String shortCode) {
        return urlRepository.findByShortCode(shortCode);
    }
}
