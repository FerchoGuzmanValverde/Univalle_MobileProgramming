package com.example.gymapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;

public class hombros extends AppCompatActivity {

    ImageView ivHombro;
    AnimationDrawable frameAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hombros);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ivHombro=findViewById(R.id.ivHombro);
        ivHombro.setImageResource(0);

        //configurar el xml con las imagenes
        ivHombro.setBackgroundResource(R.drawable.animacionhombro);

        //obtener el background a mostrar en la animacion
        frameAnimation=(AnimationDrawable) ivHombro.getBackground();

        frameAnimation.start();
    }

}
