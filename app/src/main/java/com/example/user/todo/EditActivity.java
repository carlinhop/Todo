

package com.example.user.todo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import org.json.*;

/**
 * Created by user on 16/11/2016.
 */

public class EditActivity extends DetailActivity {

    EditText mEditText;
    Button mButton;
    TodoList todoList;
    CalendarView mCalendar;
    CheckBox mCheckBox;
    String mNewDate;

    @Override
    protected void onCreate(final Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        Log.d("EditActivity","Hola");



    }

}