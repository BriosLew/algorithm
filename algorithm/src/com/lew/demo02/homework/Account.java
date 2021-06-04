package com.lew.demo02.homework;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Account {
    private String name;
    private int id;
    private float balance;
    private float annualInterestRate;
    private Date createDate = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-04-18 15:23:53"));
    private Date changedDate;

    public Account() throws ParseException {
        changedDate = createDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public float getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(float annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public void withdraw(float money){
        if(money > this.balance){
            System.out.println("取款失败，卡上余额不足");
            return;
        }
        Calendar calendar=Calendar.getInstance();
        double months = Math.floor((calendar.getTime().getTime()-changedDate.getTime())/1000/60/60/24/30);
        this.balance=Float.parseFloat(new DecimalFormat("##.00").format(this.balance*(1+this.annualInterestRate*months/12)-money));
        changedDate = calendar.getTime();
        System.out.println("取款成功，取出金额："+money+"￥,卡上余额为："+this.balance+"￥");
    }

    public void deposit(float money) throws ParseException {
        DecimalFormat decimalFormat = new DecimalFormat("##.00");
        Calendar calendar=Calendar.getInstance();
        double months = Math.floor((calendar.getTime().getTime()-changedDate.getTime())/1000/60/60/30/24);
        this.balance=(float) (this.balance*(1+this.annualInterestRate*months/12)+money);
        this.balance=Float.parseFloat(decimalFormat.parse(this.balance+"").toString());
        changedDate=calendar.getTime();
        System.out.println("成功存入："+money+"￥,卡上余额为："+this.balance+"￥");
    }
}
