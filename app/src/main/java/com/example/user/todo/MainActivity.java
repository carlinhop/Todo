package com.example.user.todo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

import java.io.InputStream;


/**
 * Created by user on 10/11/2016.
 */

public class MainActivity extends AppCompatActivity {


    TextView mTextView;
    Button mButton;
    TodoList todoList;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        todoList = new TodoList();

        String savedText = SavedTextPreferences.getStoredText(MainActivity.this);


        Task task = new Task(savedText);
        todoList.setTask(task);

        mTextView = (TextView) findViewById(R.id.saved_tasks);

        mTextView.setText(todoList.getTasksString());

        mButton = (Button) findViewById(R.id.create_button);



        mButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){


                Log.d("Todo", "Button clicked ");







                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                startActivityForResult(intent,1);






            }
        });




    }



}
