package com.example.dm2.exameniban;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Actividad1b extends AppCompatActivity {

    private TextView nombre,provincia,sexo,conocimientos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1b);

        Bundle extras=getIntent().getExtras();

        nombre=(TextView)findViewById(R.id.lblnombreRecibido);
        nombre.setText(nombre.getText()+" "+extras.getString("nombre"));

        provincia=(TextView)findViewById(R.id.lblprovinciaRecibida);
        provincia.setText(provincia.getText()+" "+extras.getString("provincia"));

        sexo=(TextView)findViewById(R.id.lblsexoRecibido);
        sexo.setText(sexo.getText()+" "+extras.getString("sexo"));

        conocimientos=(TextView)findViewById(R.id.lblconocimientosRecibidos);
        conocimientos.setText(conocimientos.getText()+" "+extras.getString("conocimientos"));



    }
    public void aceptar(View v)
    {
        Intent intent=new Intent();
        setResult(RESULT_OK,intent);
        finish();
    }
    public void rechazar(View v)
    {
        finish();
    }
}
