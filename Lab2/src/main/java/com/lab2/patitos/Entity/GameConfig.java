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

    public String[][] runGame(){

        int columns = this.numeroColumnas;
        int rows = this.numeroFilas;

        String[][] Tablero = new String[rows][columns];

        String[] listaPosiciones = this.posicionesIniciales.split(" ");

        for (String posiciones : listaPosiciones) {
            String[] arrayCoords = posiciones.split(",");

            String coordX = arrayCoords[0].replaceAll("[^0-9]", "");
            String coordY = String.valueOf(Integer.parseInt(arrayCoords[1].replaceAll("[^0-9]", "")));

            Tablero[Integer.parseInt(coordX)][Integer.parseInt(coordY)] = "cuack";
        }

        showTablero(Tablero);

        return Tablero;
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

    public List<String> tableroArrayToList(String[][] Tablero){

        List<String> listaPosiciones = new ArrayList<>();
        int columns = this.numeroColumnas;
        int rows = this.numeroFilas;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){

                if(Tablero[i][j] == "cuack"){
                    listaPosiciones.add("cuack");
                } else {
                    listaPosiciones.add("///");
                }
            }
        }
        return listaPosiciones;
    }

    public int cantidadDePatitos(String[][] Tablero){

        int columns = this.numeroColumnas;
        int rows = this.numeroFilas;

        int numerodeCuacks = 0;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){

                if(Tablero[i][j] == "cuack"){
                    numerodeCuacks += 1;
                }
            }
        }
        return numerodeCuacks;
     }


}
