package com.example.puzzles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Juego {
    private int[][] puzzles;
    private int[] puzzleCorrecto;
    private int[] puzzleMostrado;
    private ArrayList<Integer> idMostrado;
    private boolean hasGanado = false;

    public Juego(){
        this.puzzles = new int[5][3];
    }

    public void setPuzzle(int[][] puzzles){
        this.puzzles = puzzles;
    }

    public int[] getPuzzleMostrado(){
        return this.puzzleMostrado;
    }

    public void iniciarJuego(){
        Random rand = new Random();
        for (int i = 0; i < this.puzzles.length; i++) {
            int indice = rand.nextInt(this.puzzles.length);
            int[] temp = this.puzzles[indice];
            this.puzzles[indice] = this.puzzles[i];
            this.puzzles[i] = temp;
        }

        this.puzzleCorrecto = this.puzzles[(int)(Math.random() * 4)];

        ArrayList<Integer> ids = new ArrayList<Integer>();
        do{
            this.puzzleMostrado = new int[3];
            ids.clear();
            for(int i = 0; i < 3; i++){
                int id = (int)(Math.random() * 4);
                ids.add(id);
                puzzleMostrado[i] = this.puzzles[id][i];
            }
        }while(ids.get(0) == ids.get(1) || ids.get(0) == ids.get(2) || ids.get(1) == ids.get(2));
        this.idMostrado = ids;
    }

    public void subir(int seccion){
        int id = (this.idMostrado.get(seccion))+1;

        if(id == 5){
            this.idMostrado.set(seccion, 0);
        }else{
            this.idMostrado.set(seccion, id);
        }

        this.puzzleMostrado[seccion] = this.puzzles[this.idMostrado.get(seccion)][seccion];
        comprobarIntento();
    }

    public void comprobarIntento(){
        if(this.puzzleMostrado[0] == this.puzzleCorrecto[0] && this.puzzleMostrado[1] == this.puzzleCorrecto[1] && this.puzzleMostrado[2] == this.puzzleCorrecto[2]){
            this.hasGanado = true;
        }
    }

    public boolean getHasGanado(){
        return this.hasGanado;
    }

    public int[] getPuzzleCorrecto(){
        return this.puzzleCorrecto;
    }
}
