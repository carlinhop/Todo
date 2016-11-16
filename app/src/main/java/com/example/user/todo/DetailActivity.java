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

import java.util.Calendar;
import java.util.Date;

/**
 * Created by user on 14/11/2016.
 */

public class DetailActivity extends AppCompatActivity {

    EditText mEditText;
    Task task;
    String text;
    Button mButton;
    TodoList todoList;
    CalendarView mCalendar;
    CheckBox mCheckBox;
    String mNewDate;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);


        todoList = new TodoList();

        mEditText = (EditText) findViewById(R.id.editText);

        mButton = (Button) findViewById(R.id.save_button);

        mCalendar = (CalendarView) findViewById(R.id.calendarView);

        mCheckBox = (CheckBox) findViewById(R.id.checkBox);

        mButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

                String textToSave = mEditText.getText().toString();


                Boolean isDone = mCheckBox.isChecked();


                JSONArray jsonArray = new JSONArray();
                String savedText = SavedTextPreferences.getStoredText(DetailActivity.this);

                if(savedText != null && !savedText.isEmpty()) {
                    try {

                        jsonArray = new JSONArray(savedText);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                JSONObject object = new JSONObject();
                try{
                    object.put("text", textToSave);
                    object.put("date", mNewDate);
//                    object.put("isDone", isDone);
                    jsonArray.put(object);
                }
                catch (JSONException e) {
                    e.printStackTrace();
                }

                Log.d("Todo", "Button clicked ");


                Context context = view.getContext();

                SavedTextPreferences.setStoredText(context, jsonArray.toString());

                Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        mCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                mNewDate = Integer.toString(dayOfMonth) + "/" + Integer.toString(month+1)+ "/"+year;
//                //Log.d("Calendar", Integer.toString(mCalendar.getDateTextAppearance()));
//
//                //Log.d("Calendar", d.toString() );
//
//                Calendar calendar = Calendar.getInstance();
//                calendar.setTimeInMillis(mNewDate);
//
//                Log.d("Calendar: ", Integer.toString(calendar.DATE));
                Toast.makeText(getApplicationContext(), mNewDate, Toast.LENGTH_SHORT).show();

            }
        });



    }



}
