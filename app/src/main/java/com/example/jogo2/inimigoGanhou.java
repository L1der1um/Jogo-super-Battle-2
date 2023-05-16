package com.example.jogo2;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class inimigoGanhou extends AppCompatActivity {


    private Button voltarInicio;

    private TextView enemyScoretext;

    private int enemyScore = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inimigoganhou);

        voltarInicio = findViewById(R.id.voltarInicio);
        enemyScoretext = findViewById(R.id.enemy_score_text);
        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.soundbutton);


        enemyScoretext.setText("Pontuação Inimigo:" + enemyScore);

        //ESCUTA O BOTAO VOLTAR
        voltarInicio.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                mediaPlayer.start();
                Intent intent = new Intent(inimigoGanhou.this, InicioGame.class);
                startActivity(intent);

            }
        });


    }


}
