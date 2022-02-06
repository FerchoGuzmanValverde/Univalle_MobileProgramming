package com.example.gymapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;

public class Jueves extends AppCompatActivity {

    ImageView ivPierna;
    AnimationDrawable frameAnimation;
    ImageView ivGluteo;
    AnimationDrawable frameAnimation1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jueves);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ivPierna=findViewById(R.id.ivPierna);
        ivPierna.setImageResource(0);

        ivGluteo=findViewById(R.id.ivGluteo);
        ivGluteo.setImageResource(0);

        //configurar el xml con las imagenes
        ivPierna.setBackgroundResource(R.drawable.animacionpierna);
        ivGluteo.setBackgroundResource(R.drawable.animaciongluteo);

        //obtener el background a mostrar en la animacion
        frameAnimation=(AnimationDrawable) ivPierna.getBackground();
        frameAnimation1=(AnimationDrawable) ivGluteo.getBackground();

        frameAnimation.start();
        frameAnimation1.start();
    }

}
