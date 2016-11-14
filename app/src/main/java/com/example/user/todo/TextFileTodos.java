package com.example.user.todo;

import java.io.InputStream;
import java.util.ArrayList;

import java.util.Scanner;

/**
 * Created by user on 14/11/2016.
 */

public class TextFileTodos {

    private ArrayList<String> mTasks;
    private Scanner mFileReader;

    public TextFileTodos(InputStream file){
        this.mTasks  = new ArrayList<String>();
        this.mFileReader = new Scanner(file);
        setUpList();
    }

    private void setUpList(){
        boolean moreLinesToRead = mFileReader.hasNextLine();
        while(moreLinesToRead){

            String lineOfText =  mFileReader.nextLine();
            mTasks.add(lineOfText);
            moreLinesToRead = mFileReader.hasNextLine();
        }
    }

    public ArrayList<String> getTasks(){

        return mTasks;

    }

    public void writeTask(String data){

    }
}
