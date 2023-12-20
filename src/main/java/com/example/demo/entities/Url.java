package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "urls")
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long Id;

    @Column (unique = true)
    String ShortCode;

    @Column
    String OriginalUrl;

    public Url() {
    }

    public Url(String shortCode, String originalUrl) {
        ShortCode = shortCode;
        OriginalUrl = originalUrl;
    }

    public String getShortCode() {
        return ShortCode;
    }

    public void setShortCode(String shortCode) {
        ShortCode = shortCode;
    }

    public String getOriginalUrl() {
        return OriginalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        OriginalUrl = originalUrl;
    }
}
