package com.seungwoo.gym.model;

public class Ranker {
    private String name;
    private int winCount;

    public Ranker(String name, int winCount) {
        this.name = name;
        this.winCount = winCount;
    }

    public String getName() {
        return name;
    }

    public int getWinCount() {
        return winCount;
    }

}
