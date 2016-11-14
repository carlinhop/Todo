package com.example.user.todo;

import org.junit.Before;
import org.junit.Test;
import static junit.framework.Assert.assertTrue;

/**
 * Created by user on 13/11/2016.
 */

public class taskTest {

    TodoList list;
    Task task1;

    @Before
    public void before(){
        task1 = new Task("Do my homework");
        list = new TodoList();
        list.setTask(task1);
    }

    @Test
    public void todoCanShowDate(){
        assertTrue(task1.date!= null);
    }

}
