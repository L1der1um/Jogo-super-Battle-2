package com.example.jogo2;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class sobre extends AppCompatActivity {

    private Button voltarInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sobre);

        voltarInicio = findViewById(R.id.voltarInicio);
        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.soundbutton);

        //ESCUTA O BOTAO VOLTAR INICIO
        voltarInicio.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                mediaPlayer.start();
                Intent intent = new Intent(sobre.this, InicioGame.class);
                startActivity(intent);

            }
        });


    }
}
