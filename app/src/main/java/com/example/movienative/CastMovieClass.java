package com.example.movienative;

import java.io.Serializable;

public class CastMovieClass implements Serializable {
    private String[] name;
    private int[] actorImageUrl;

    public CastMovieClass(String[] name, int[] actorImageUrl) {
        this.name = name;
        this.actorImageUrl = actorImageUrl;
    }
    public String[] getActorName(){
        return this.name;
    }
    public int[] getActorImageUrl(){
        return this.actorImageUrl;
    }
}

