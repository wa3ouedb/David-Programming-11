package com.example.friendsbook;

public class Friend {
    private String name;
    private String phoneNumber;
    private int age;

    public Friend (String name, String phoneNumber, int age){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }
    public Friend(){ this("","",0);}

    public String getName() {return name;}
    public void setName(String name){this.name = name;}

    public String getPhoneNumber(){return phoneNumber;}
    public void setPhoneNumber(String phoneNumber){this.phoneNumber = phoneNumber;}

    public int getAge(){return age;}
    public void setAge(int age){this.age = age;}

    public String toString(){
        return name;
    }





}
