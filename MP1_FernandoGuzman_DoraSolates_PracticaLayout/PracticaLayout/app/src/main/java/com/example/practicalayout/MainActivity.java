package com.example.practicalayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnCalcular;
    EditText txtp1,txtp2;
    TextView lblresp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCalcular = findViewById(R.id.btnCalcular);
        txtp1 = findViewById(R.id.txtp1);
        txtp2 = findViewById(R.id.txtp2);
        lblresp = findViewById(R.id.lblresp);
    }

    public void calcular(View v)
    {
        int p1,p2;
        String s1 = txtp1.getText().toString();
        String s2 = txtp2.getText().toString();
        p1 = Integer.parseInt(s1);
        p2 = Integer.parseInt(s2);
        double resp = (51 - (((p1+p2)/2)*0.7))/0.3;
        if(resp > 100)
        {
            lblresp.setText("Es imposible que apruebes aunque saques 100 :(");
        }
        else
        {
            lblresp.setText("Necesitas "+resp + " para aprobar.");
        }

    }
}
