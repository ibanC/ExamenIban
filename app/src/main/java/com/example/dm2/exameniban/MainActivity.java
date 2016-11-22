package com.example.dm2.exameniban;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button b1,b2,b3,b4,salir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=(Button)findViewById(R.id.but1);
        b2=(Button)findViewById(R.id.but2);
        b3=(Button)findViewById(R.id.but3);
        salir=(Button)findViewById(R.id.salir);
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    public void click(View v)
    {
        if(v.getId()==b1.getId())
        {
            Intent intent=new Intent(MainActivity.this,Actividad1.class);
            startActivity(intent);
        }
        else
        {
            if(v.getId()==b2.getId())
            {
              Intent intent=new Intent(MainActivity.this,Actividad2.class);
                startActivity(intent);
            }
            else
            {
                if(v.getId()==b3.getId())
                {
                    Toast.makeText(getApplicationContext(),getString(R.string.toastActividad3),Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
