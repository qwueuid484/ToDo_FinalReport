package com.f74373063.todo_finalreport;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView mLvItem;
    private Button mbtnAddItem;
    private ArrayList<String> items;
    private ArrayAdapter<String>itemsAdapter;
    private EditText etNewItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialButton();

        items = new ArrayList<String>();
        items.add("test1");
        items.add("test2");

        itemsAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);

        mLvItem = (ListView)findViewById(R.id.lvItems);
        mLvItem.setAdapter(itemsAdapter);
    }

    private void initialButton() {
        mbtnAddItem = (Button)findViewById(R.id.btnAdd);
        mbtnAddItem.setOnClickListener(addItemToListView);
    }
    private View.OnClickListener addItemToListView = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            EditText etNew = (EditText)findViewById(R.id.etNewItem);
            itemsAdapter.add(etNew.getText().toString());
            etNew.setText("");
        }
    };
}
