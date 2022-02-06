package com.example.gymapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;

public class Lunes extends AppCompatActivity {

    ImageView ivPecho;
    AnimationDrawable frameAnimation;
    ImageView ivHombro;
    AnimationDrawable frameAnimation1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunes);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ivPecho=findViewById(R.id.ivPecho);
        ivPecho.setImageResource(0);

        ivHombro=findViewById(R.id.ivHombro);
        ivHombro.setImageResource(0);

        //configurar el xml con las imagenes
        ivPecho.setBackgroundResource(R.drawable.animacionpecho);
        ivHombro.setBackgroundResource(R.drawable.animacionhombro);

        //obtener el background a mostrar en la animacion
        frameAnimation=(AnimationDrawable) ivPecho.getBackground();
        frameAnimation1=(AnimationDrawable) ivHombro.getBackground();

        frameAnimation.start();
        frameAnimation1.start();
    }

}
