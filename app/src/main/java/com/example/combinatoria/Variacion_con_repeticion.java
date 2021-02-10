package com.example.combinatoria;

public class Variacion_con_repeticion {

    int variacionConRepeticion (int m,int n){

        //variaciones con repeticion
        int  resultado=1 ;
        resultado = funcion_pow(m,n);
        return resultado;
    }

    int funcion_pow(int x1, int exponente){

        int resultado;
        resultado = x1;

        if (exponente == 0) resultado = 1;
        else if (exponente == 1) resultado = x1;
        else {
            for (int i = 1; i < exponente; i++) {
                resultado *= x1;
            }
            if (exponente < 0) resultado = 1 / resultado; //Si el exponente es negativo...
        }
        return resultado;
    }
}
