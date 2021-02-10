package com.example.combinatoria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Permutacion_con_repeticion extends AppCompatActivity {
    int FactorialDeCantidad=1, FacTodLetras=1, Division=0;
    int m, n, r;   int contador = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permutacion_con_repeticion);
        final EditText edt_M = (EditText)findViewById(R.id.editTextNumber);
        final EditText edt_N = (EditText)findViewById(R.id.editTextNumber2);
        final EditText edt_R = (EditText)findViewById(R.id.editTextNumber3);

        final TextView resultado = (TextView)findViewById(R.id.tv_resultado);
        final TextView titulo = (TextView)findViewById(R.id.textView);
        final Button btn = (Button)findViewById(R.id.button);
        final Button btn_iterar = (Button)findViewById(R.id.button4);
        final Button btn_limpiar = (Button)findViewById(R.id.button2);

        edt_R.setEnabled(false);

        Intent i = this.getIntent();
        final String operacion = i.getStringExtra("operacion");
        titulo.setText(titulo.getText() + "\n" + operacion);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n1_st = edt_M.getText().toString();
                String n2_st = edt_N.getText().toString();
                m = Integer.parseInt(n1_st);
                n = Integer.parseInt(n2_st);

                edt_M.setEnabled(false);
                edt_N.setEnabled(false);
                edt_R.setEnabled(true);

                //FactorialDeLetras
                if (m>0) {
                    for (int i=1;i<=m;i++) {
                        FacTodLetras=FacTodLetras*i;
                    }
                }
                resultado.setText("Ingrese el valor repitiente ("+contador+")");
                btn.setEnabled(false);
            }
        });

        btn_iterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String r_st = edt_R.getText().toString();
                r = Integer.parseInt(r_st);

                contador++;
                edt_R.setText("");
                resultado.setText("Ingrese el valor repitiente ("+contador+")");
                if (r>0) {
                    for (int a=1;a<=r;a++) {
                        FactorialDeCantidad=FactorialDeCantidad*a;
                    }
                }

                Division=FacTodLetras/FactorialDeCantidad;

                if (contador==n+1){
                    String rta = String.valueOf(Division);
                    resultado.setText(rta);
                    btn_iterar.setEnabled(false);
                }
            }
        });

        btn_limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setEnabled(true);
                btn_iterar.setEnabled(true);
                edt_R.setEnabled(false);
                edt_M.setEnabled(true);
                edt_N.setEnabled(true);
                edt_M.setText("");
                edt_N.setText("");
                edt_R.setText("");
                resultado.setText("Resultado:");
            }
        });
    }
}