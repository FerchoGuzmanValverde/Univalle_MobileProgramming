package com.example.gymapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;

public class Pierna extends AppCompatActivity {

    ImageView ivPierna;
    AnimationDrawable frameAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pierna);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ivPierna=findViewById(R.id.ivPierna);
        ivPierna.setImageResource(0);

        //configurar el xml con las imagenes
        ivPierna.setBackgroundResource(R.drawable.animacionpierna);

        //obtener el background a mostrar en la animacion
        frameAnimation=(AnimationDrawable) ivPierna.getBackground();

        frameAnimation.start();
    }

}
