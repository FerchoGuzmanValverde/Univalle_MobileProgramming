package com.example.practicalayout;
import android.nfc.FormatException;
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
        try{
            p1 = Integer.parseInt(txtp1.getText().toString());
            if(p1 < 0 || p1 > 100)
            {
                throw new Exception("La nota del primer parcial esta fuera del rango(0-100=).");
            }
        }
        catch(FormatException e)
        {
            lblresp.setText("La nota del primer parcial debe ser un valor entero entre 0 y 100.");
            return;
        }
        catch(Exception e)
        {
            lblresp.setText(e.getMessage());
            return;
        }
        try{
            p2 = Integer.parseInt(txtp2.getText().toString());
            if(p2 < 0 || p2 > 100)
            {
                throw new Exception("La nota del segundo parcial esta fuera del rango(0-100).");
            }
        }
        catch(FormatException e)
        {
            lblresp.setText("La nota del segundo parcial debe ser un valor entero entre 0 y 100.");
            return;
        }
        catch(Exception e)
        {
            lblresp.setText(e.getMessage());
            return;
        }

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
