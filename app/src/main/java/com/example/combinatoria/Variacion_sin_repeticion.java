package com.example.combinatoria;

public class Variacion_sin_repeticion {

    int variacionSinRepeticion (int m, int n){

        //Variacion sin Repeticion.
        int Resta=1,resultado=1;
        int FactorealDeM=1;
        int FactorealDeResta=1;

        if (m>n){
            //FactorealDeM
            if (m>0) {
                for (int i=1;i<=m;i++) {
                    FactorealDeM=FactorealDeM*i;
                }
            }

            Resta=m-n;

            //FactorealDeResta
            if (Resta>0) {
                for (int i=1;i<=Resta;i++) {
                    FactorealDeResta=FactorealDeResta*i;
                }
            }

            resultado=FactorealDeM/FactorealDeResta;

        }
        return resultado;
    }
}
