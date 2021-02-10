package com.example.combinatoria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Operaciones_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operaciones_activity);
        getSupportActionBar().hide();

        final TextView Mensaje = (TextView)findViewById(R.id.tv_Mensaje);
        final EditText m = (EditText)findViewById(R.id.edt_m);
        final EditText n = (EditText)findViewById(R.id.edt_n);
        final TextView tv_resultado = (TextView)findViewById(R.id.tv_resultado);
        final Button btnCalcular = (Button)findViewById(R.id.btnCalcular);
        final Button btnRepetir = (Button)findViewById(R.id.btnClean);

        Intent i = this.getIntent();
        final String operacion = i.getStringExtra("operacion");
        Mensaje.setText(Mensaje.getText() + "\n" + operacion);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Permutacion sin repeticion
                if (operacion.equals("Permutacion sin repeticion")){
                        String num_st = m.getText().toString();
                        int numero = Integer.parseInt(num_st);

                        Permutacion_sin_Repeticion psr = new Permutacion_sin_Repeticion();
                        tv_resultado.setText(" " + psr.PermutacionSinRepeticion(numero));
                }

                // Variacion con repeticion
                if (operacion.equals("Variacion con repeticion")){
                    String num_st = m.getText().toString();
                    String num_st2 = n.getText().toString();
                    int numero_m = Integer.parseInt(num_st);
                    int numero_n = Integer.parseInt(num_st2);

                    Variacion_con_repeticion  psr = new Variacion_con_repeticion();
                    // validar que m debe sea mayor que n ??
                    tv_resultado.setText(" " + psr.variacionConRepeticion(numero_m, numero_n));
                }

                // Variacion sin repeticion
                if (operacion.equals("Variacion sin repeticion")){
                    String num_st = m.getText().toString();
                    String num_st2 = n.getText().toString();
                    int numero_m = Integer.parseInt(num_st);
                    int numero_n = Integer.parseInt(num_st2);

                    Variacion_sin_repeticion  psr = new Variacion_sin_repeticion();
                    // validar que m debe sea mayor que n ??
                    tv_resultado.setText(" " + psr.variacionSinRepeticion(numero_m, numero_n));
                }

                // Combinaciones
                if (operacion.equals("Combinaciones")){
                    String num_st = m.getText().toString();
                    String num_st2 = n.getText().toString();
                    int numero_m = Integer.parseInt(num_st);
                    int numero_n = Integer.parseInt(num_st2);

                    Combinaciones  psr = new Combinaciones();
                    // validar que m debe sea mayor que n ??
                    tv_resultado.setText(" " + psr.Combinaciones(numero_m, numero_n));
                }
            }
        });

        // LIMPIAR LOS RESULTADOS DE LOS COMPONENTES
        btnRepetir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Se limpian las casillas numericas y la etiqueta resultado
                m.setText("");
                n.setText("");
                tv_resultado.setText("");
            }
        });
    }
}