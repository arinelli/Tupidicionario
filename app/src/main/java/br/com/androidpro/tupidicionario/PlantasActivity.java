package br.com.androidpro.tupidicionario;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PlantasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plantas);


        String[] plantasArray = getResources().getStringArray(R.array.plantas);

        final String[] descPlantasArray = getResources().getStringArray(R.array.plantas_desc);

        ArrayList<Item> itens = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            String titulo = plantasArray[i];
            String desc = descPlantasArray[i];

            Item item = new Item(titulo, desc, R.drawable.ic_plantas);
            itens.add(item);


            ItemAdapter adapter = new ItemAdapter(this, itens, R.color.plantas_categoria);


            ListView listView = (ListView) findViewById(R.id.rootPlantas);


            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    String desc = descPlantasArray[i];

                    Toast.makeText(PlantasActivity.this, desc, Toast.LENGTH_LONG).show();
                }
            });

            listView.setAdapter(adapter);


        }
    }
}