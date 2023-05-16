package com.example.jogo2;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;



public class InicioGame extends AppCompatActivity {

    private Button sobre;

    private Button dificuldade;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);

        sobre = findViewById(R.id.sobre);
        dificuldade = findViewById(R.id.dificuldade);
        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.soundbutton);



        //ESCUTA O BOTAO INICIAR JOGO
        sobre.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                mediaPlayer.start();
                Intent intent = new Intent(InicioGame.this, sobre.class);
                startActivity(intent);

            }
        });



        //ESCUTA O BOTAO DIFICULDADE
        dificuldade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mediaPlayer.start();
                Intent intent = new Intent(InicioGame.this, dificuldade.class);
                startActivity(intent);

            }
        });

    }


}
