package com.lew.demo02.test;

public class MainClass {
    public static void main(String[] args) {
        Man man = new Man();

/*        Human woman = new Woman();
        say(man);
        say(woman);*/
    }

    public static void say(Human human){
        System.out.println("Human......");
    }

    public static void say(Man man){
        System.out.println("man......");
    }

    public static void say(Woman woman){
        System.out.println("woman......");
    }
}
