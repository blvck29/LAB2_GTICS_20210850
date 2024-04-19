package com.lab2.patitos.Entity;

import java.util.*;

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


    public List<String> execGame(){

        List<String[][]> listaDeTableros = new ArrayList<>(this.fotosTomadas);

        String[][] tableroInicial = iniciarTablero();
        listaDeTableros.add(tableroInicial);

        String[][] oldTablero = tableroInicial;
        int columns = this.numeroColumnas;
        int rows = this.numeroFilas;

        for (int i = 1; i<(this.fotosTomadas); i++){

            String[][] newTablero = new String[rows][columns];

            for(int j = 0; j < rows; j++){
                for(int k = 0; k < columns; k++){

                    int x = j;
                    int y = k;

                    boolean existePato = false;

                    try {

                        if (oldTablero[x][y].equals("cuack")){
                            existePato = true;
                        }

                    } catch (NullPointerException nullEx) {
                        System.out.println("No hay pato en esta nueva posicion");
                    }


                    int patoCounter = 0;

                    List<Integer> minusList = Arrays.asList(-1, -1, 0, -1, 1, -1, -1, 1, 0, 1, 1, 1, -1, 0, 1, 0);

                    for (int z = 0; z<16; z=z+2){
                        String pato;

                        try {
                            try {
                                pato = oldTablero[x + minusList.get(z)][y + minusList.get(z+1)];
                            } catch (ArrayIndexOutOfBoundsException outEx) {
                                pato = "nulo";
                            }

                            if (pato.equals("nulo") || pato.isEmpty()){
                                System.out.println("Se salió del arreglo");
                            } else if (pato.equals("cuack")) {
                                patoCounter++;
                                System.out.println("Pato encontrado");
                            }

                        } catch (NullPointerException nullEx) {
                            System.out.println("El pato es nulo");
                        }

                    }

                    System.out.println();
                    System.out.println("##########################################");
                    System.out.println("Resultados para Algoritmo en: [" + x + " ; " + y + "]");
                    System.out.println("Cantidad de patos hallados: " + patoCounter);

                    if (patoCounter == 3){
                        newTablero[x][y] = "cuack";
                        System.out.println("El patito sobrevive");
                    } else if (patoCounter == 2 && existePato){
                        newTablero[x][y] = "cuack";
                        System.out.println("El patito sobrevive");
                    } else if (patoCounter == 2 && !existePato){
                        newTablero[x][y] = null;
                        System.out.println("El patito debe morir");
                    } else {
                        newTablero[x][y] = null;
                        System.out.println("El patito debe morir");
                    }


                }
            }

            listaDeTableros.add(newTablero);
            oldTablero = newTablero;


        }


        System.out.println("A" + Arrays.deepToString(listaDeTableros.get(0)));
        System.out.println("B" + Arrays.deepToString(listaDeTableros.get(1)));

        return listaDeTablerosToList(listaDeTableros);

    }

    public String[][] iniciarTablero(){

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
        return Tablero;
    }

    public String[][] algoritmoDelPatito (String[][] Tablero, String coordX, String coordY){

        int x = Integer.parseInt(coordX);
        int y = Integer.parseInt(coordY);

        boolean existePato = false;

        try {

            if (Tablero[x][y].equals("cuack")){
                existePato = true;
            }

        } catch (NullPointerException nullEx) {
            System.out.println("No hay pato en esta nueva posicion");
        }


        int patoCounter = 0;

        List<Integer> minusList = Arrays.asList(-1, -1, 0, -1, 1, -1, -1, 1, 0, 1, 1, 1, -1, 0, 1, 0);

        for (int i = 0; i<16; i=i+2){
            String pato;

            try {
                try {
                    pato = Tablero[x + minusList.get(i)][y + minusList.get(i+1)];
                } catch (ArrayIndexOutOfBoundsException outEx) {
                    pato = "nulo";
                }

                if (pato.equals("nulo") || pato.isEmpty()){
                    System.out.println("Se salió del arreglo");
                } else if (pato.equals("cuack")) {
                    patoCounter++;
                    System.out.println("Pato encontrado");
                }

            } catch (NullPointerException nullEx) {
                System.out.println("El pato es nulo");
            }

        }

        System.out.println();
        System.out.println("##########################################");
        System.out.println("Resultados para Algoritmo en: [" + x + " ; " + y + "]");
        System.out.println("Cantidad de patos hallados: " + patoCounter);

        if (patoCounter == 3){
            Tablero[x][y] = "cuack";
            System.out.println("El patito sobrevive");
        } else if (patoCounter == 2 && existePato){
            Tablero[x][y] = "cuack";
            System.out.println("El patito sobrevive");
        } else if (patoCounter == 2 && !existePato){
            Tablero[x][y] = null;
            System.out.println("El patito debe morir");
        } else {
            Tablero[x][y] = null;
            System.out.println("El patito debe morir");
        }

        return Tablero;
    }

    public List<String> listaDeTablerosToList(List<String[][]> listaDeTableros){

        List<String> listaTotalDePosiciones = new ArrayList<>();

        int columns = this.numeroColumnas;
        int rows = this.numeroFilas;

        for (int i = 0; i<(this.fotosTomadas); i++){

            String[][] tableroActual = listaDeTableros.get(i);

            for(int j = 0; j < rows; j++){
                for(int k = 0; k < columns; k++){

                    if(Objects.equals(tableroActual[j][k], "cuack")){
                        listaTotalDePosiciones.add("cuack");
                    } else {
                        listaTotalDePosiciones.add("///");
                    }

                }
            }
        }
        System.out.println(listaTotalDePosiciones);
        return listaTotalDePosiciones;
    }

    public List<Integer> getIndicesFotos (){
        List<Integer> indicesFotos = new ArrayList<>();

        for (int i = 0; i<(this.fotosTomadas); i++){
            indicesFotos.add(i);
        }
        return indicesFotos;
    }

    public int cantidadDePatitos(String[][] Tablero){

        int columns = this.numeroColumnas;
        int rows = this.numeroFilas;

        int numerodeCuacks = 0;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){

                if(Objects.equals(Tablero[i][j], "cuack")){
                    numerodeCuacks += 1;
                }
            }
        }
        return numerodeCuacks;
     }




}
