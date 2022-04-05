package com.seungwoo.gym.model;

import java.text.SimpleDateFormat;

public class Member {

    String id; //primary key
    int age;
    String name;
    String phoneNumber;
    String date;

    public String getID() {
        return id;
    }

    public void setID(String iD) {
        id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    Member(String name, int age, String phoneNumber, String date) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.id = makeId();
    }

    public String makeId(){
        String str[] = date.split("-");
        String year = str[0];
        String month = str[1];

        String s[] = phoneNumber.split("-");
        String lastNumber = s[2];
        return year + month + lastNumber;
    }

    public void introduceMyself() {
        System.out.println("회원님의 ID는 : " + id);
        System.out.println("내 이름은 :" + name);
        System.out.println("내 나이는 :" + age);
        System.out.println("전화번호는 :" + phoneNumber);
        System.out.println("가입날짜는 :" + date);
        System.out.println();

    }

}

