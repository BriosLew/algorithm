package com.lew.demo02;

import com.lew.demo02.homework.Account;
import com.lew.demo02.homework.Book;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Study {
    public static void main(String[] args) {
        new Cat("Andy",21).Hello();
        new Cat("Andy",20).Hello();
        new Cat("Andy",11).Hello();
        new Cat("Andy",21).Hello();
        for(int i = 0;i <10;i++)
        {
            for (int j = 0;j<6;j++) {
                if (i == 0)
                    System.out.print("*");
                else if(i == 9){
                    System.out.print("*");
                }
                else {
                    if (j==0||j==5)
                        System.out.print("*");
                    else
                        System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    @Test
    public void test() throws ParseException {
        Book book = new Book("朝花夕拾");
        //book.setTotalPages(300);
        System.out.println(book);
        Account account = new Account();
        account.setName("Jane Smith");
        account.setId(1000);
        account.setAnnualInterestRate(0.0123F);
        account.setBalance(2000);
        account.deposit(100);
        account.withdraw(960);
        account.withdraw(2000);
    }
}
