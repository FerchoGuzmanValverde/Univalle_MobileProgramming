package com.example.gymapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;

public class Viernes extends AppCompatActivity {

    ImageView ivAbs;
    AnimationDrawable frameAnimation;
    ImageView ivPierna;
    AnimationDrawable frameAnimation1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viernes);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ivAbs=findViewById(R.id.ivAbs);
        ivAbs.setImageResource(0);

        ivPierna=findViewById(R.id.ivPierna);
        ivPierna.setImageResource(0);

        //configurar el xml con las imagenes
        ivAbs.setBackgroundResource(R.drawable.animacionabs);
        ivPierna.setBackgroundResource(R.drawable.animacionpierna);

        //obtener el background a mostrar en la animacion
        frameAnimation=(AnimationDrawable) ivAbs.getBackground();
        frameAnimation1=(AnimationDrawable) ivPierna.getBackground();

        frameAnimation.start();
        frameAnimation1.start();
    }

}
