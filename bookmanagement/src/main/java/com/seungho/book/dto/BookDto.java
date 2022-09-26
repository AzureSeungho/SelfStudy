package com.seungho.book.dto;

public class BookDto {
    private String name;
    private String author;
    private String publisher;
    private String date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    @Override
    public String toString() {
        return
                "이름='" + name + '\'' +
                ", 저자='" + author + '\'' +
                ", 출판사='" + publisher + '\'' +
                ", 등록일='" + date + '\'';
    }
}
