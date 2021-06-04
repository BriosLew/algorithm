package com.lew.demo02.homework;

public class Book {
    private String name;
    private int totalPages;

    {
        totalPages = 200;
    }

    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        if (totalPages<200){
            System.out.println("页数不能少于200页");
            return;
        }
        this.totalPages = totalPages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", totalPages=" + totalPages +
                "}";
    }
}
