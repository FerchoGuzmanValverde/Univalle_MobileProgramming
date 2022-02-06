package com.example.fruitfragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements DataListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public  void sendData(Fruta fruton){
        ContenidoFragment contenidoFragment = (ContenidoFragment) getSupportFragmentManager().findFragmentById(R.id.contenidoFragment);
        contenidoFragment.renderText(fruton);
    }
}
