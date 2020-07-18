package com.sid.tennisgame.enums;

public enum Point {
    ZERO ("0"),
    FIFTEEN ("15"),
    THIRTY ("30"),
    FORTY ("40"),
    ADVANTAGE("ADVANTAGE"),
    WIN ("win");

    private String pointGame = "";

    Point(String name){
        this.pointGame = name;
    }

    @Override
    public String toString(){
        return pointGame;
    }
}
