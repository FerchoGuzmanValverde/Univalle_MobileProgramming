package com.example.gymapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;

public class Gluteos extends AppCompatActivity {

    ImageView ivGluteo;
    AnimationDrawable frameAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gluteos);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ivGluteo=findViewById(R.id.ivGluteo);
        ivGluteo.setImageResource(0);

        //configurar el xml con las imagenes
        ivGluteo.setBackgroundResource(R.drawable.animaciongluteo);

        //obtener el background a mostrar en la animacion
        frameAnimation=(AnimationDrawable) ivGluteo.getBackground();

        frameAnimation.start();
    }

}
