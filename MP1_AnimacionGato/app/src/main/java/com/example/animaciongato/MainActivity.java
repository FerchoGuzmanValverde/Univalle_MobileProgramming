package com.example.animaciongato;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView ivGato;
    AnimationDrawable frameAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivGato=findViewById(R.id.ivGato);
        ivGato.setImageResource(0);

        //configurar el xml con las imagenes
        ivGato.setBackgroundResource(R.drawable.animacion);

        //obtener el background a mostrar en la animacion
        frameAnimation=(AnimationDrawable) ivGato.getBackground();

    }

    public void start(View view) {
        frameAnimation.start();
    }
    public void stop(View view) {
        if(frameAnimation.isRunning()) {
            frameAnimation.stop();
            frameAnimation.selectDrawable(0);
        }
    }

}
