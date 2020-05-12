package com.example.puzzles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    public Juego juego;
    private final int idsMostrado[] = { R.id.mostrado1,R.id.mostrado2,R.id.mostrado3};
    private final int idsCorrecto[] = { R.id.correcto1,R.id.correcto2,R.id.correcto3};

    private final int idsImagenes[][] = {
            {R.drawable.a1, R.drawable.a2, R.drawable.a3},
            {R.drawable.av1, R.drawable.av2, R.drawable.av3},
            {R.drawable.c1, R.drawable.c2, R.drawable.c3},
            {R.drawable.h1, R.drawable.h2, R.drawable.h3},
            {R.drawable.o1, R.drawable.o2, R.drawable.o3}
    };

    private int[] puzzleCorrecto;
    private int[] puzzleMostrado;

    private TextView ganado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        juego = new Juego();
        super.onCreate(savedInstanceState);
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            setContentView(R.layout.activity_main);
        }else{
            setContentView(R.layout.horizontal);
        }
        ganado = (TextView) findViewById(R.id.textView3);

        juego.setPuzzle(idsImagenes);
        juego.iniciarJuego();

        puzzleCorrecto = juego.getPuzzleCorrecto();
        puzzleMostrado = juego.getPuzzleMostrado();

        actualizarImageView();
    }
    private void actualizarImageView(){
        for(int i = 0; i < 3; i++){
            ImageView img= (ImageView) findViewById(idsCorrecto[i]);
            img.setImageResource(puzzleCorrecto[i]);
            ImageView img2= (ImageView) findViewById(idsMostrado[i]);
            img2.setImageResource(puzzleMostrado[i]);
        }
    }

    public void pulsado1(View v){
        if(!juego.getHasGanado()){
            juego.subir(0);
            actualizarImageView();
            comprobarGanado();
        }

    }

    public void pulsado2(View v){
        if(!juego.getHasGanado()){
            juego.subir(1);
            actualizarImageView();
            comprobarGanado();
        }
    }

    public void pulsado3(View v){
        if(!juego.getHasGanado()){
            juego.subir(2);
            actualizarImageView();
            comprobarGanado();
        }
    }

    private void comprobarGanado(){
        if(juego.getHasGanado()){
            ganado.setText("¡Enhorabuena, has ganado!");
        }
    }
}
