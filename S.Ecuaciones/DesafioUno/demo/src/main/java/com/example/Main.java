
package com.example;
import Jama.Matrix;
public class Main {
    public static double []multiplicar(double[][]X,double[]B){
        double []resultado=new double [3];
        for (int i = 0; i < X.length; i++) {
            for (int j = 0; j < X.length; j++) {
                resultado[i]=+resultado[i]+X[i][j]*B[j];
            }
        }
        return resultado;
    }
    public static void main(String[] args) {
        double[][] data = {
            {0.52, 0.2, 0.25},
            {0.3, 0.5, 0.2},
            {0.18, 0.3, 0.55}
        };
        double []X={4800,5810,5690};
        Matrix matriz = new Matrix(data);
        // Calcular la inversa de la matriz
        Matrix inversa = matriz.inverse();
        double []resultado=multiplicar(inversa.getArray(), X);
        // Imprimir la matriz inversa
        System.out.println("Matriz Inversa:");
        inversa.print(3,3);
        
        System.out.println("Contenedor 1: "+resultado[0]);
        System.out.println("Contenedor 2: "+resultado[1]);
        System.out.println("Contenedor 3: "+resultado[2]);
    }
}