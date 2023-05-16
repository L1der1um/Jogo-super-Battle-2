package com.example.jogo2;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class jogadorGanhou extends AppCompatActivity {

    private Button voltarInicio;

    private TextView playerScoretext;

    private int playerScore = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jogadorganhou);

        voltarInicio = findViewById(R.id.voltarInicio);
        playerScoretext = findViewById(R.id.player_score_text);
        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.soundbutton);


        playerScoretext.setText("Pontuação Jogador:" + playerScore);

        //ESCUTA O BOTAO VOLTAR
        voltarInicio.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                mediaPlayer.start();
                Intent intent = new Intent(jogadorGanhou.this, InicioGame.class);
                startActivity(intent);

            }
        });


    }


}
