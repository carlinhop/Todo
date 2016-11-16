

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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by user on 16/11/2016.
 */

public class EditActivity extends DetailActivity {


    //Button mButton;
    TodoList todoList;
    //CalendarView mCalendar;
    //CheckBox mCheckBox;
    String mNewDate;
    Date editDate;

    @Override
    protected void onCreate(final Bundle savedInstanceState){
        super.onCreate(savedInstanceState);


        Intent intent = getIntent();


        mEditText.setText(intent.getStringExtra("text"));

        SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");

        Calendar editCalendar = Calendar.getInstance();

        try{

        editDate = ft.parse(intent.getStringExtra("date"));

        }

        catch(ParseException e ){
            e.printStackTrace();
        }

        editCalendar.setTime(editDate);

        Log.d("Edit Calendar", Long.toString(editCalendar.getTimeInMillis()));

        long editMillis= (editCalendar.getTimeInMillis());

        mCalendar.setDate(editMillis, true, true);

        mCheckBox.setChecked(Boolean.parseBoolean(intent.getStringExtra("isDone")));





    }

}
