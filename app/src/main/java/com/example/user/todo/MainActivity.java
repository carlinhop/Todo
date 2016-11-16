package com.example.user.todo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.view.View;
import org.json.*;



/**
 * Created by user on 10/11/2016.
 */

public class MainActivity extends AppCompatActivity {


    //TextView mTextView;
    Button mButton;
    TodoList todoList;
    JSONArray jsonTasks;
    ListView mListView;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);



        String savedText = SavedTextPreferences.getStoredText(MainActivity.this);

        try {
            jsonTasks = new JSONArray(savedText);
            todoList = new TodoList(jsonTasks);
        }
        catch (Exception e){
            e.printStackTrace();
            todoList = new TodoList();

        }


        mListView = (ListView)findViewById(R.id.my_listview);



        mButton = (Button) findViewById(R.id.create_button);


        ArrayAdapter<Task> adapter =
                new ArrayAdapter<Task>(MainActivity.this,
                        android.R.layout.simple_list_item_1,
                        todoList.getTasks());

        mListView.setAdapter(adapter);




        mButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){


                Log.d("Todo", "Button clicked ");


                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                startActivityForResult(intent,1);


            }
        });


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Task selected = (Task) mListView.getItemAtPosition(position);
                Log.d("ListView:", selected + " selected");


                Intent intent = new Intent(MainActivity.this, EditActivity.class);
                intent.putExtra("text", selected.getText());
                startActivity(intent);


            }


        });





    }

}
