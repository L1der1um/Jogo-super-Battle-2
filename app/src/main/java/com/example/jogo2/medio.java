package com.example.jogo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;


public class medio extends AppCompatActivity {

    private int playerScore = 0;
    private int enemyScore = 0;

    private ImageView playerHealthbar;
    private ImageView enemyHealthbar;

    private ArrayList<Integer> playerHealth = new ArrayList<>();
    private ArrayList<Integer> enemyHealth = new ArrayList<>();

    private TextView playerScoreText;

    private TextView enemyScoretext;

    private Button playerAttackButton;
    private Button enemyAttackButton;

    private ImageView playerStickCharacter;
    private ImageView enemyStickCharacter;

    private Button botaoInicio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerHealthbar = findViewById(R.id.player_health_bar);
        enemyHealthbar = findViewById(R.id.enemy_health_bar);
        playerScoreText = findViewById(R.id.player_score_text);
        enemyScoretext = findViewById(R.id.enemy_score_text);
        playerAttackButton = findViewById(R.id.player_attack_button);
        enemyAttackButton = findViewById(R.id.enemy_attack_button);
        enemyStickCharacter = findViewById(R.id.enemy_stick_character);
        playerStickCharacter = findViewById(R.id.player_stick_character);
        Animation slideInLeft = AnimationUtils.loadAnimation(this, R.anim.slide_in_left);
        Animation slideInRight = AnimationUtils.loadAnimation(this, R.anim.slide_in_right);
        botaoInicio = findViewById(R.id.botaoInicio);
        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.soundbutton);
        final MediaPlayer win = MediaPlayer.create(this,R.raw.win);

        //ESCUTANDO O BOTAO VOLTAR INICIO
        botaoInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mediaPlayer.start();
                Intent intent = new Intent(medio.this, InicioGame.class);
                startActivity(intent);

            }
        });

        //ESCUTANDO O BOTAO DO PLAYER
        playerAttackButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                //ciclo for que remove o elemento de vida do inimigo
                if(enemyHealth.size() > 0){

                    playerStickCharacter.startAnimation(slideInRight);

                    //remove o elemento do arraylist do elemento zero
                    enemyHealth.remove(0);

                    enemyHealthbar.setScaleX((float) enemyHealth.size() / 10);
                }

                //identifica se o inimigo foi derrotado
                if(enemyHealth.size() == 0){
                    //Aumenta o score do inimigo
                    playerScore ++;
                    //INFORMA NA TELA O SCORE DO PLAYER
                    playerScoreText.setText("Pontuação do Jogador:" + playerScore);
                    Toast.makeText(getApplicationContext(),"INIMIGO FOI DERROTADO", Toast.LENGTH_SHORT).show();

                    //RESETA A VIDA DOS BONECO CRIANDO UMA NOVA ARRAYLIST COM 10 ELEMENTOS
                    playerHealth = new ArrayList<Integer>(Collections.nCopies(10, 10));
                    enemyHealth = new ArrayList<Integer>(Collections.nCopies(10, 10));

                    //Redefine a escala horizontal da barra de vida
                    enemyHealthbar.setScaleX(1);
                    playerHealthbar.setScaleX(1);

                    //VERIFICA SE O JOGO ACABOU
                    if(playerScore == 10){
                        //MOSTRA NA TELA QUE O JOGADOR GANHOU
                        Toast.makeText(getApplicationContext(),"JOGADOR GANHOU!", Toast.LENGTH_LONG).show();

                        win.start();
                        Intent intent = new Intent(medio.this, jogadorGanhou.class);
                        startActivity(intent);
                    }
                }

            }
        });


        //ESCUTANDO O BOTAO DO INIMIGO
        enemyAttackButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                //ciclo for que remove o elemento de vida do inimigo
                if(playerHealth.size() > 0){

                    //INICIA ANIMAÇÃO DO INIMIGO
                    enemyStickCharacter.startAnimation(slideInLeft);

                    //remove o elemento do arraylist do elemento zero
                    playerHealth.remove(0);

                    playerHealthbar.setScaleX((float) playerHealth.size() / 10);
                }

                //identifica se o player foi derrotado
                if(playerHealth.size() == 0){

                    //Aumenta o score do inimigo
                    enemyScore ++;
                    enemyScoretext.setText("Pontuação do Inimigo:" + enemyScore);
                    Toast.makeText(getApplicationContext(),"JOGADOR FOI DERROTADO", Toast.LENGTH_SHORT).show();

                    //RESETA A VIDA DOS BONECO CRIANDO UMA NOVA ARRAYLIST COM 10 ELEMENTOS
                    playerHealth = new ArrayList<Integer>(Collections.nCopies(10, 10));
                    enemyHealth = new ArrayList<Integer>(Collections.nCopies(10, 10));

                    //Redefine a escala horizontal da barra de vida
                    playerHealthbar.setScaleX(1);
                    enemyHealthbar.setScaleX(1);

                    //VERIFICA SE O JOGO ACABOU
                    if(enemyScore == 10){
                        //MOSTRA NA TELA QUE O JOGADOR GANHOU
                        Toast.makeText(getApplicationContext(),"INIMIGO GANHOU!", Toast.LENGTH_LONG).show();

                        win.start();
                        Intent intent = new Intent(medio.this, inimigoGanhou.class);
                        startActivity(intent);
                    }
                }

            }
        });


    }
}