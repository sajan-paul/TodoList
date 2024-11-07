package com.sp.todosqlite;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private ListView lvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvItems = findViewById(R.id.lvItems);
        items = new ArrayList<>();
        itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        lvItems.setAdapter(itemsAdapter);


        setupListViewListener();
    }

    private void setupListViewListener() {
        lvItems.setOnItemLongClickListener((adapter, item, pos, id) -> {
            // Remove the item within array at position
            items.remove(pos);
            // Refresh the adapter
            itemsAdapter.notifyDataSetChanged();
            // Return true to indicate the event was handled
            return true;
        });
    }

    public void onAddItem(View v) {
        EditText etNewItem = findViewById(R.id.etNewItem);
        String itemText = etNewItem.getText().toString();
        if (!itemText.isEmpty()) {
            itemsAdapter.add(itemText);
            etNewItem.setText("");
        }
    }
}
