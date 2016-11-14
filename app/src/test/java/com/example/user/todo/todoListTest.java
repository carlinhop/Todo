package com.example.user.todo;

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






}
