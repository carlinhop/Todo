package com.example.user.todo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import org.json.*;
/**
 * Created by user on 14/11/2016.
 */

public class DetailActivity extends AppCompatActivity {

    EditText mEditText;
    Task task;
    String text;
    Button mButton;
    TodoList todoList;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);


        todoList = new TodoList();

        mEditText = (EditText) findViewById(R.id.editText);

        mButton = (Button) findViewById(R.id.save_button);

        mButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

                String textToSave = mEditText.getText().toString();

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
                    object.put("Task Text", textToSave);
                    jsonArray.put(object);
                }
                catch (JSONException e) {
                    e.printStackTrace();
                }

                Log.d("Todo", "Button clicked ");

                Task task = new Task(text);

                todoList.setTask(task);
                Context context = view.getContext();

                SavedTextPreferences.setStoredText(context, jsonArray.toString());

                Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                startActivity(intent);



            }
        });




    }



}
