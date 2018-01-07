package com.example.tjmovie.dto;

public class ActorNumber {

    private String actor;

    private int number;

    private String director;

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public ActorNumber(String s, int i, String d){
        this.actor = s;
        this.number = i;
        this.director =d;
    }
}
