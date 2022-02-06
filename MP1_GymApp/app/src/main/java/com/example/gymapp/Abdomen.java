package com.example.gymapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;

public class Abdomen extends AppCompatActivity {

    ImageView ivAbs;
    AnimationDrawable frameAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abdomen);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ivAbs=findViewById(R.id.ivAbs);
        ivAbs.setImageResource(0);

        //configurar el xml con las imagenes
        ivAbs.setBackgroundResource(R.drawable.animacionabs);

        //obtener el background a mostrar en la animacion
        frameAnimation=(AnimationDrawable) ivAbs.getBackground();

        frameAnimation.start();
    }

}
