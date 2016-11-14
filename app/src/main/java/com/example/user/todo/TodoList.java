package com.example.user.todo;

import java.util.ArrayList;

/**
 * Created by user on 10/11/2016.
 */

public class TodoList {

    private ArrayList<Task> tasks;

    public TodoList(){
        this.tasks = new ArrayList<Task>();

    }

    public ArrayList<Task> getTasks(){
        return this.tasks;
    }

    public void setTask(Task task){
        this.tasks.add(task);
    }

    public String getTasksString(){
        String todoString = "";
        for(Task task: this.getTasks()){
            todoString += String.format("Task: %s \n",task.text);
        }
        return todoString;
    }
}
