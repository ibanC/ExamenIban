package com.example.dm2.exameniban;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Actividad1 extends AppCompatActivity {

    private EditText txtNombre,resultadoSuma;
    private Spinner spinnerProvincias;
    private int numRandom1;
    private int numRandom2;
    private TextView num1,num2,txtContadorCandidatos;
    private RadioButton butMasculino,butFemenino;
    private CheckBox checkPHP,checkJAVA,checkHTML,checkCSS;
    private int contadorFallos=0;
    private int contadorCandidatos=0;
    private Button btnevaluar,btnSalir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1);

        txtNombre=(EditText)findViewById(R.id.txtnombre);
        resultadoSuma=(EditText)findViewById(R.id.resultadoIntroducir);
        num1=(TextView) findViewById(R.id.num1);
        num2=(TextView) findViewById(R.id.num2);
        butMasculino=(RadioButton)findViewById(R.id.btnmasculino);
        butFemenino=(RadioButton)findViewById(R.id.btnfemenino);
        checkPHP=(CheckBox)findViewById(R.id.chkPHP);
        checkJAVA=(CheckBox)findViewById(R.id.chkJAVA);
        checkHTML=(CheckBox)findViewById(R.id.chkHTML);
        checkCSS=(CheckBox)findViewById(R.id.chkCSS);
        txtContadorCandidatos=(TextView)findViewById(R.id.lblnumeroCandidados);
        txtContadorCandidatos.setText(String.valueOf(contadorCandidatos));
        btnevaluar=(Button)findViewById(R.id.butEvaluar);
        btnSalir=(Button)findViewById(R.id.butsalir);

        //hacer spinner
        spinnerProvincias=(Spinner)findViewById(R.id.spinner);

        final String[] datos=new String[]{"Alava","Bizkaia","Gipuzkoa","Nafarroa"};

        ArrayAdapter<String> adaptador=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,datos);

        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerProvincias.setAdapter(adaptador);

        //random
        numRandom1 = (int)((Math.random()*100)+1);
        num1.setText(numRandom1 +"");
        numRandom2 = (int)((Math.random()*100)+1);
        num2.setText(numRandom2 +"");
    }
    public void evaluar(View v)
    {
        if(txtNombre.getText().equals("")||resultadoSuma.getText().equals(""))
        {
            Toast.makeText(getApplicationContext(),"Datos obligatorios no introducidos",Toast.LENGTH_LONG).show();
        }
        else
        {
            String provincia=spinnerProvincias.getSelectedItem().toString();
            String sexo="";
            //radiobuttons
            if(butFemenino.isSelected())
            {
                sexo=butFemenino.getText().toString();
            }
            else
            {
                sexo=butMasculino.getText().toString();
            }

            String conocimientos="";
            //checkboxes
            if(checkPHP.isSelected())
            {
                conocimientos=conocimientos+checkPHP.getText().toString();
            }
            else
            {
                if(checkJAVA.isSelected())
                {
                    conocimientos=conocimientos+checkJAVA.getText().toString();
                }
                else
                {
                    if(checkHTML.isSelected())
                    {
                        conocimientos=conocimientos+checkHTML.getText().toString();
                    }
                    else
                    {
                        conocimientos=conocimientos+checkCSS.getText().toString();
                    }
                }
            }

            //resultado
            int resultado=numRandom1+numRandom2;

            String resRecibidoString=resultadoSuma.getText().toString();
            int resultadoRecibido=Integer.parseInt(resRecibidoString);

            //comparar resultado
            if(resultado==resultadoRecibido)
            {
                Intent intent=new Intent(Actividad1.this,Actividad1b.class);
                intent.putExtra("nombre",txtNombre.getText().toString());
                intent.putExtra("provincia",provincia);
                intent.putExtra("sexo",sexo);
                intent.putExtra("conocimientos",conocimientos);
                startActivityForResult(intent,1);
            }
            else
            {
                contadorFallos++;
                if(contadorFallos==3)
                {
                    finish();
                }
            }
        }
    }
    public void onActivityResult (int requestCode,int resultCode,Intent data)
    {
        if(requestCode==1&&resultCode==RESULT_OK)
        {
            contadorCandidatos++;
            txtContadorCandidatos.setText(String.valueOf(contadorCandidatos));
            numRandom1 = (int)((Math.random()*100)+1);
            num1.setText(numRandom1 +"");
            numRandom2 = (int)((Math.random()*100)+1);
            num2.setText(numRandom2 +"");
        }

        if(contadorCandidatos==4)
        {
            btnSalir.setVisibility(View.VISIBLE);
            btnevaluar.setVisibility(View.INVISIBLE);
        }

    }
    public void salir(View v)
    {
        finish();
    }
}
