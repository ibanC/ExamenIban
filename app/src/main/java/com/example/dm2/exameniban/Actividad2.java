package com.example.dm2.exameniban;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Actividad2 extends AppCompatActivity {

    private ListView lstwebs;
    private Localidad[] datos;
    private int[] imagenes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);

        lstwebs=(ListView)findViewById(R.id.lstWebs);

        datos= new Localidad[]{
                new Localidad("157 hab (2015)","Añana","21,92 Km2","http://www.cuadrilladeanana.es/anana"),
                new Localidad("1892 hab (2015)","Mundaka","4,01 Km2","http://www.mundaka.org"),
                new Localidad("16763 hab (2015)","Gernika-Lumo","8,60 km2","http://www.gernika-lumo.net"),
                new Localidad("1520 hab (2015)","Laguardia","81,08km2","http://www.laguardia-alava.net"),
                new Localidad("243918 hab (2015)","Vitoria-Gasteiz","276,08 km2","www.vitoria-gasteiz.org"),
        };

        imagenes = new int[]{
                R.drawable.aniana,
                R.drawable.mundaka,
                R.drawable.gernika,
                R.drawable.laguardia,
                R.drawable.gasteiz,
        };

        AdaptadorLocalidades adaptador=new AdaptadorLocalidades(this,datos,imagenes);
        lstwebs.setAdapter(adaptador);

        lstwebs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String url=((Localidad)adapterView.getItemAtPosition(i)).getWeb();
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

    }
}
