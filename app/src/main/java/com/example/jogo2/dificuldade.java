package com.example.jogo2;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class dificuldade extends AppCompatActivity {

    private Button facil;
    private Button medio;
    private Button dificil;
    private Button voltarInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dificuldade);

        facil = findViewById(R.id.facil);
        medio = findViewById(R.id.medio);
        dificil = findViewById(R.id.dificil);
        voltarInicio = findViewById(R.id.voltarInicio);
        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.soundbutton);

        //ESCUTA O BOTAO JOGAR NO FACIL
        facil.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                mediaPlayer.start();
                Intent intent = new Intent(dificuldade.this, facil.class);
                startActivity(intent);

            }
        });



        //ESCUTA O BOTAO JOGAR NO MEDIO
        medio.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                mediaPlayer.start();
                Intent intent = new Intent(dificuldade.this, medio.class);
                startActivity(intent);

            }
        });



        //ESCUTA O BOTAO JOGAR NO DIFICIL
        dificil.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                mediaPlayer.start();
                Intent intent = new Intent(dificuldade.this, dificil.class);
                startActivity(intent);

            }
        });

        //ESCUTA O BOTAO VOLTAR INICIO
        voltarInicio.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                mediaPlayer.start();
                Intent intent = new Intent(dificuldade.this, InicioGame.class);
                startActivity(intent);

            }
        });


    }
}
