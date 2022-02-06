package com.example.gymapp;

import android.os.Bundle;
import android.graphics.drawable.AnimationDrawable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class Brazo extends AppCompatActivity {

    ImageView ivBrazo;
    AnimationDrawable frameAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brazo);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ivBrazo=findViewById(R.id.ivBrazo);
        ivBrazo.setImageResource(0);

        //configurar el xml con las imagenes
        ivBrazo.setBackgroundResource(R.drawable.animacionbrazo);

        //obtener el background a mostrar en la animacion
        frameAnimation=(AnimationDrawable) ivBrazo.getBackground();

        frameAnimation.start();


    }

}
