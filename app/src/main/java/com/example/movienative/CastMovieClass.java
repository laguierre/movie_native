package com.example.movienative;

public class CastMovieClass {
    private String name;
    private String actorImageUrl;

    public CastMovieClass(String name, String actorImageUrl) {
        this.name = name;
        this.actorImageUrl = actorImageUrl;
    }
    public String getActorName(){
        return this.name;
    }
    public String getActorImageUrl(){
        return this.actorImageUrl;
    }
}

