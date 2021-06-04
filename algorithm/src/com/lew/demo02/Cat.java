package com.lew.demo02;

import java.util.List;

public class Cat {
    private String name;
    private static int age;
    public Cat(String name,int age){
        this.name = name;
        System.out.println("是吗？");
    }

    public void Say(){
        System.out.println(name+"喵喵叫。。。。");
    }

    public static void Hello(){
        System.out.println(age);
    }

    static {
        System.out.println("我来了");
    }
}
