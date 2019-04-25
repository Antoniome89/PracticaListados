package com.example.listados;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaDinamicaActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listaDinamica;
    ArrayList<Elemento> textos;
    EditText nuevoTexto;
    SharedPreferences sharedPreferences;

    Elemento estudiar = new Elemento("estudiar", R.drawable.ic_fiber_manual_record_black_24dp, R.drawable.ic_library_books_black_24dp);
    Elemento pasear = new Elemento("pasear", R.drawable.ic_check_circle_black_24dp, R.drawable.ic_directions_walk_black_24dp);
    Elemento comprar = new Elemento("comprar", R.drawable.ic_fiber_manual_record_black_24dp, R.drawable.ic_shopping_basket_black_24dp);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_dinamica);

        listaDinamica = findViewById(R.id.listaDinamica);
        nuevoTexto = findViewById(R.id.nuevoTexto);

        textos = new ArrayList<>();
        textos.add (estudiar);
        textos.add (pasear);
        textos.add (comprar);

        ListAdapter adapter = new MiAdapter(this,R.layout.item,textos);

        listaDinamica.setAdapter(adapter);

        listaDinamica.setOnItemClickListener(this);

        sharedPreferences = getSharedPreferences("tareas", MODE_PRIVATE);
        String nombre = sharedPreferences.getString("tareas","");

    }

    public void agregar (View view) {
        Elemento texto = new Elemento (nuevoTexto.getText().toString(),R.drawable.ic_fiber_manual_record_black_24dp, R.drawable.ic_add_black_24dp);
        textos.add(texto);

        String json = texto.toJson();




        ArrayAdapter adapter = (ArrayAdapter)listaDinamica.getAdapter();
        adapter.notifyDataSetChanged();

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("tareas",json);
        editor.apply();
    }

    public void borrar (View view) {

        int size =textos.size();
        Elemento texto = textos.get(size -1);
        textos.remove(texto);
        ArrayAdapter adapter = (ArrayAdapter)listaDinamica.getAdapter();
        adapter.notifyDataSetChanged();

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        ArrayAdapter adapter = (ArrayAdapter) listaDinamica.getAdapter();

        if (textos.get(position).imagen == R.drawable.ic_fiber_manual_record_black_24dp) {
            textos.get(position).imagen = R.drawable.ic_check_circle_black_24dp;}
            else if(textos.get(position).imagen == R.drawable.ic_check_circle_black_24dp) {
             textos.get(position).imagen = R.drawable.ic_fiber_manual_record_black_24dp;
        }

        adapter.notifyDataSetChanged();
    }
}
