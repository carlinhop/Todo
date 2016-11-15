package com.example.user.todo;

import java.util.Date;

/**
 * Created by user on 13/11/2016.
 */

public class Task {

    public String text;
    public Date date;
    public Boolean isDone;


    public Task(String text){
        this.text = text;
        this.date = new Date();
        this.isDone = false;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }

    @Override
    public String toString(){
          return String.format("%s on:  %td/%tm/%ty %n",this.text, this.date,this.date,this.date);
    }

}
