package com.example.user.todo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


/**
 * Created by user on 13/11/2016.
 */

public class Task {

    public String text;
    private String date;
    public Boolean isDone;


    public Task(String text){
        this.text = text;
        this.date = "no data";
        this.isDone = false;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String newDate) {

        this.date = newDate;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }

    @Override
    public String toString(){
        //Date nDate = new String(this.date);
        //

          return String.format("%s on: %s. %s" , this.text, this.date, this.isDone);
    }

}
