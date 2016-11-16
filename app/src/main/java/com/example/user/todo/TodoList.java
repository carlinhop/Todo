package com.example.user.todo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by user on 10/11/2016.
 */

public class TodoList {

    private ArrayList<Task> tasks;

    public TodoList(){
        this.tasks = new ArrayList<Task>();

        Task firstTask = new Task("Create your first task!");
        this.tasks.add(firstTask);

    }

    public TodoList(JSONArray taskJsonArray){

        this.tasks = new ArrayList<Task>();

        for(Task task: this.jsonArrayToTaskArray(taskJsonArray)){
            this.tasks.add(task);
        }

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
            todoString += String.format(task.text);
        }
        return todoString;
    }

    public ArrayList<Task> jsonArrayToTaskArray(JSONArray jsonArray){

        ArrayList<Task> newTasks = new ArrayList<Task>();
        for(int i = 0; i < jsonArray.length(); i++){

            try {
                JSONObject object = jsonArray.getJSONObject(i);
                Task task = new Task(object.get("text").toString());
                task.setDate((object.get("date").toString()));
                newTasks.add(task);
            }
            catch (JSONException e){
                e.printStackTrace();
            }
        }
        return newTasks;
    }
}
