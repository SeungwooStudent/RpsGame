package com.seungwoo.gym;

import android.util.Log;

import java.util.LinkedList;

public class GameManager {
    private int userChoice;
    private int computerChoice;
    private int winCount = 0;

    LinkedList<GameMember> members = new LinkedList<>();

    public void addMember(GameMember gamemember) {
        members.add(gamemember);
    }

    public void setUserChoice(int userChoice) {
        this.userChoice = userChoice;
    }

    public void setComputerChoice(int computerChoice) {
        this.computerChoice = computerChoice;
    }

    //1은 가위
    //2는 바위
    //3은 보

    public boolean finishGame() {
        if (userChoice == 1) { //가위
            if (computerChoice == 1) { //가위
                winCount = 0;
                return false;
            } else if (computerChoice == 2) { //바위
                winCount = 0;
                return false;
            } else {
                winCount++;
                return true;
            }
        } else if (userChoice == 2) { //바위
            if (computerChoice == 2) { //바위
                winCount = 0;
                return false;
            } else if (computerChoice == 1) { //가위
                winCount++;
                return true;
            } else {
                winCount = 0;
                return false;
            }
        } else {
            if (computerChoice == 3) { //보
                winCount = 0;
                return false;
            } else if (computerChoice == 2) { //바위
                winCount++;
                return true;
            } else {
                winCount = 0;
                return false;
            }
        }
    }

    public int getWinCount() {
        return winCount;
    }

    public String compare() {
        Log.d("seungwoo", "user = " + userChoice);
        Log.d("seungwoo", "computer = " + computerChoice);
        if (userChoice == 1) { //가위
            if (computerChoice == 1) { //가위
                winCount = 0;
                return "비겼습니다";
            } else if (computerChoice == 2) { //바위
                winCount = 0;
                return "computer 승 !";
            } else {
                winCount++;
                return "user 승 !"; //보

            }
        } else if (userChoice == 2) { //바위
            if (computerChoice == 2) { //바위
                winCount = 0;
                return "비겼습니다";
            } else if (computerChoice == 1) { //가위
                winCount++;
                return "user 승 !";
            } else {
                winCount = 0;
                return "computer 승 !";
            }
        } else {
            if (computerChoice == 3) { //보
                winCount = 0;
                return "비겼습니다";
            } else if (computerChoice == 2) { //바위
                winCount++;
                return "user 승 !";
            } else {
                winCount = 0;
                return "computer 승 !";
            }
        }
    }

}

