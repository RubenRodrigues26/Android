package com.example.ruben.assingment2.LiteSQL;

public class Comment {
    private int id;
    private String comments;

    public Comment(){

    }
    public Comment(String comments){
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
