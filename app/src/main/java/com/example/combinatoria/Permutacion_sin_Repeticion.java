package com.example.combinatoria;

public class Permutacion_sin_Repeticion {
    int PermutacionSinRepeticion(int m){

        int resultado = 1;

        //factorial de M
        if (m>0){
            for (int i=1; i<=m; i++){
                resultado = resultado * i;
            }
        }
        return resultado;
    }
}
