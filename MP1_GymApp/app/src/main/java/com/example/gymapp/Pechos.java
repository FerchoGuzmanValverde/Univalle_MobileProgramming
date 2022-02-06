package com.example.gymapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;

public class Pechos extends AppCompatActivity {

    ImageView ivPecho;
    AnimationDrawable frameAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pechos);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ivPecho=findViewById(R.id.ivPecho);
        ivPecho.setImageResource(0);

        //configurar el xml con las imagenes
        ivPecho.setBackgroundResource(R.drawable.animacionpecho);

        //obtener el background a mostrar en la animacion
        frameAnimation=(AnimationDrawable) ivPecho.getBackground();

        frameAnimation.start();
    }

}
