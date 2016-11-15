package com.example.user.todo;

import junit.framework.Assert;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by user on 10/11/2016.
 */

public class todoListTest {

    TodoList todo;
    Task task1;

    @Before
    public void before(){
        task1  = new Task("First test flying!!!!!");
        todo = new TodoList();
        todo.setTask(task1);

    }

    @Test
    public void todoCanHaveTask(){
        assertTrue( todo.getTasks().size() > 0);
    }

    @Test
    public void todoCanPrintTasks(){
        assertTrue(todo.getTasksString() != "");
    }

//    @Test
    // Test is not possible without mocking json objects

//    public void todoCanReadJson(){
//        JSONArray dataTest = new JSONArray();
//        JSONObject objectTest = new JSONObject();
//        try{
//        objectTest.put("text","This is a todo");
//        dataTest.put(objectTest);}
//        catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(dataTest.toString());
//
//        assertTrue(("[{\"text\": \"This is a todo\"}]").equals(dataTest));
//    }







}
