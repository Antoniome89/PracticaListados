package com.example.listados;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView lista;
    Elemento[] tareas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tareas = new Elemento[4];
        tareas [0] = new Elemento("estudiar", R.drawable.ic_fiber_manual_record_black_24dp, R.drawable.ic_library_books_black_24dp);
        tareas [1] = new Elemento("comprar", R.drawable.ic_check_circle_black_24dp, R.drawable.ic_shopping_basket_black_24dp);
        tareas [2] = new Elemento("pasear", R.drawable.ic_check_circle_black_24dp, R.drawable.ic_directions_walk_black_24dp);


        lista = findViewById(R.id.lista);


    }


}
