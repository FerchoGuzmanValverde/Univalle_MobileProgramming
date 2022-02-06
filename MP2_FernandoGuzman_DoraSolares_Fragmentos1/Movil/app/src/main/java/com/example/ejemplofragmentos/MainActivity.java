package com.example.ejemplofragmentos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements DataListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public  void sendData(String texto, int size, String color){
        DetailsFragment detailsFragmento = (DetailsFragment)getSupportFragmentManager().findFragmentById(R.id.detailsFragment);
        detailsFragmento.renderText(texto, size, color);
    }
}
