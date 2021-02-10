package com.example.combinatoria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TableRow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        //IMPORTA EL ORDEN DE COLOCACION
        RadioButton rbtn_si_orden = (RadioButton)findViewById(R.id.rbtn_si_orden);
        RadioButton rbtn_no_orden = (RadioButton)findViewById(R.id.rbtn_no_orden);

        //SE TOMAN TODOS LOS ELEMENTOS
        RadioButton rbtn_si_elementos = (RadioButton)findViewById(R.id.rbtn_si_elementos);
        RadioButton rbtn_no_elementos = (RadioButton)findViewById(R.id.rbtn_no_elementos);

        //HAY REPETICION
        RadioButton rbtn_si_repeticion = (RadioButton)findViewById(R.id.rbtn_si_repeticion);
        RadioButton rbtn_no_repeticion = (RadioButton)findViewById(R.id.rbtn_no_repeticion);

        //SI IMPORTA EL ORDEN = PERMUTACION / VARIACION
        rbtn_si_orden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rbtn_si_elementos.setEnabled(true);
                rbtn_no_elementos.setEnabled(true);
                rbtn_si_repeticion.setEnabled(true);
                rbtn_no_repeticion.setEnabled(true);
            }
        });


        rbtn_si_elementos.setEnabled(false);
        rbtn_no_elementos.setEnabled(false);
        rbtn_si_repeticion.setEnabled(false);
        rbtn_no_repeticion.setEnabled(false);
        //NO IMPORTA EL ORDEN = COMBINATORIA
        rbtn_no_orden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rbtn_si_elementos.setEnabled(false);
                rbtn_no_elementos.setEnabled(false);
                rbtn_si_repeticion.setEnabled(false);
                rbtn_no_repeticion.setEnabled(false);
            }
        });

        final Button btn_iniciar = (Button)findViewById(R.id.btn_IniciarOp);



        btn_iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Operaciones_activity.class);
                if (rbtn_no_orden.isChecked()==true){ // 1. ORDEN = NO
                    //COMBINATORIA
                    String operacion = "Combinaciones";
                    i.putExtra("operacion", operacion);
                    startActivity(i);
                } else if (rbtn_si_orden.isChecked()==true){ // 1. ORDEN = SI
                    //PERMUTACION
                    if (rbtn_si_elementos.isChecked()==true){
                        if (rbtn_si_repeticion.isChecked()==true){ //repeticion = si
                            Intent a = new Intent(getApplicationContext(), Permutacion_con_repeticion.class);
                            String operacion = "Permutacion con repeticion";
                            a.putExtra("operacion", operacion);
                            startActivity(a);
                            if (rbtn_si_repeticion.isChecked()==false){
                                Toast.makeText(getApplicationContext(), "Seleccione una opcion de repeticion", Toast.LENGTH_LONG).show();
                            }
                        } else if (rbtn_no_repeticion.isChecked()==true){ //repeticion = no
                            String operacion = "Permutacion sin repeticion";
                            i.putExtra("operacion", operacion);
                            startActivity(i);
                        } else {
                            Toast.makeText(getApplicationContext(), "Seleccione una opcion de repeticion", Toast.LENGTH_LONG).show();
                        }

                    } else if (rbtn_no_elementos.isChecked()==true){// VARIACION
                        if (rbtn_si_repeticion.isChecked()==true){ //repeticion = si
                            String operacion = "Variacion con repeticion";
                            i.putExtra("operacion", operacion);
                            startActivity(i);
                            if (rbtn_si_repeticion.isChecked()==false){
                                Toast.makeText(getApplicationContext(), "Seleccione una opcion de repeticion", Toast.LENGTH_LONG).show();
                            }
                        } else if (rbtn_no_repeticion.isChecked()==true){ //repeticion = no
                            String operacion = "Variacion sin repeticion";
                            i.putExtra("operacion", operacion);
                            startActivity(i);
                        } else {
                            Toast.makeText(getApplicationContext(), "Seleccione una opcion de repeticion", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Seleccione una opcion de elementos", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Seleccione una opcion de orden", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}