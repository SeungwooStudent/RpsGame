package com.seungwoo.gym.model;

import java.text.SimpleDateFormat;

public class GameMember {

    String id;
    String passWord;
    String passWordCheck;
    String name;

    public String getId() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }

    public String getpassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    public String getPassWordCheck() {
        return passWordCheck;
    }

    public void setPassWordCheck(String passWordCheck) {
        this.passWord = passWordCheck;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    GameMember(String name, String age, String phoneNumber, String date) {
        this.id = id;
        this.passWord = passWord;
        this.passWordCheck = passWordCheck;
        this.name = name;
    }

//    public void introduceMyself() {
//        System.out.println("회원님의 ID는 : " + id);
//        System.out.println("내 이름은 :" + name);
//        System.out.println("내 나이는 :" + age);
//        System.out.println("전화번호는 :" + phoneNumber);
//        System.out.println("가입날짜는 :" + date);
//        System.out.println();
//
//    }

}

