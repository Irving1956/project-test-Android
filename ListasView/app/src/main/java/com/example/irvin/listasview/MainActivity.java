package com.example.irvin.listasview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<String> names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

        //datos a mostrar
        names = new ArrayList<String>();
        names.add("Irving");
        names.add("alan");
        names.add("Medina");
        names.add("Juarez");

        //adaptador de forma visual en que mostraremos los datos
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);

        //Enlazamos el adapter con el listview
        listView.setAdapter(adapter);

        //click en el item de la lista
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this, "Clicked: " + names.get(position), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}
