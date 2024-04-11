package com.lab2.patitos.Entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameConfig {

    private int numeroFilas;
    private int numeroColumnas;
    private String posicionesIniciales;
    private int fotosTomadas;

    public int getNumeroFilas() {
        return numeroFilas;
    }

    public void setNumeroFilas(int numeroFilas) {
        this.numeroFilas = numeroFilas;
    }

    public int getNumeroColumnas() {
        return numeroColumnas;
    }

    public void setNumeroColumnas(int numeroColumnas) {
        this.numeroColumnas = numeroColumnas;
    }

    public String getPosicionesIniciales() {
        return posicionesIniciales;
    }

    public void setPosicionesIniciales(String posicionesIniciales) {
        this.posicionesIniciales = posicionesIniciales;
    }

    public int getFotosTomadas() {
        return fotosTomadas;
    }

    public void setFotosTomadas(int fotosTomadas) {
        this.fotosTomadas = fotosTomadas;
    }

    public void runGame(){

        int columns = this.numeroColumnas;
        int rows = this.numeroFilas;

        String[][] Tablero = new String[rows][columns];

        String[] listaPosiciones = this.posicionesIniciales.split(" ");

        for (String posiciones : listaPosiciones) {
            String[] arrayCoords = posiciones.split(",");
            String coordX = arrayCoords[0].split("")[1];
            String coordY = arrayCoords[1].split("")[0];

            String[][] coordenada = new String[2][1];
            coordenada[0][0] = coordX;
            coordenada[1][0] = coordY;

            Tablero[Integer.parseInt(coordX)][Integer.parseInt(coordY)] = "cuack";
        }

        showTablero(Tablero);

    }

    public void showTablero(String[][] Tablero){

        int columns = this.numeroColumnas;
        int rows = this.numeroFilas;

        int numerodeCuacks = 0;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){

                if(Tablero[i][j] == "cuack"){
                    numerodeCuacks += 1;
                }

                System.out.println(Tablero[i][j]);
            }
        }

        System.out.println(numerodeCuacks);
    }


}
