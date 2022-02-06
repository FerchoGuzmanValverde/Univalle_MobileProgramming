package com.example.hilosparte1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnEjecutar;
    ProgressBar barra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnEjecutar=findViewById(R.id.btnEjecutar);
        barra=findViewById(R.id.pbar);

        btnEjecutar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                barra.setVisibility(View.VISIBLE);
                new Hilo1().start();
            }
        });
    }
    public class Hilo1 extends Thread{
        @Override
        public void run(){
            try{
                Thread.sleep(10000);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this,"Proceso teriminado",Toast.LENGTH_LONG).show();
                        barra.setVisibility(View.INVISIBLE);
                    }
                });
            }catch(InterruptedException ex)
            {

            }
        }
    }
}
