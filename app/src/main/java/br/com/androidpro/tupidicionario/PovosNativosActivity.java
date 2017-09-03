package br.com.androidpro.tupidicionario;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PovosNativosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_povos_nativos);


        String[] povosArray = getResources().getStringArray(R.array.povos_nativos);
        final String[] descpovos = getResources().getStringArray(R.array.povos_nativos_desc);

        ArrayList<Item> itens = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            String titulo = povosArray[i];
            String desc = descpovos[i];

            Item item = new Item(titulo, desc, R.drawable.ic_povos_nativos);
            itens.add(item);


            ItemAdapter adapter = new ItemAdapter(this, itens, R.color.povos_nativos_categoria);


            ListView listView = (ListView) findViewById(R.id.rootPovosNativos);


            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    String desc = descpovos[i];

                    Toast.makeText(PovosNativosActivity.this, desc, Toast.LENGTH_LONG).show();
                }
            });


            listView.setAdapter(adapter);


        }
    }
}