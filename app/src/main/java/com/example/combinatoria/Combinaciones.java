package com.example.combinatoria;

public class Combinaciones {

    int Combinaciones (int m, int n){
        //Combinaciones.
        int Resta,Multiplicacion,Division=0;
        int FactorealDeM=1;
        int FactorealDeN=1;
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

            //FactorealDeN
            if (n>0) {
                for (int i=1;i<=n;i++) {
                    FactorealDeN=FactorealDeN*i;
                }

            }

            Multiplicacion=FactorealDeResta*FactorealDeN;
            Division=FactorealDeM/Multiplicacion;
        }
        return Division;
    }
}
