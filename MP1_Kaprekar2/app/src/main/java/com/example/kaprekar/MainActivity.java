package com.example.kaprekar;

import android.nfc.FormatException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    Button btnCalcular;
    EditText txtMostrar, txtNum;
    TextView lblIteraciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCalcular=findViewById(R.id.btnCalcular);
        txtNum=findViewById(R.id.txtnum);
        txtMostrar=findViewById(R.id.txtmostrar);
        lblIteraciones=findViewById(R.id.lbliteraciones);
    }

    public void btnCalcularOnClick(View v) {
        String number;
        try{
            number=txtNum.getText().toString();
            if(number.length() != 4)
            {
                throw new Exception("El valor ingresado debe tener 4 dígitos.");
            }
            else if(number.charAt(0) == (number.charAt(1)) && (number.charAt(1) == number.charAt(2)) && (number.charAt(2) == number.charAt(3)))
            {
                throw new Exception("No pueden ser iguales todos los dígitos del número.");
            }
            else
            {
                lblIteraciones.setText("" + Kaprekar(number));
            }
        }
        catch(FormatException e)
        {
            txtMostrar.setText("El valor ingresado debe ser entero de 4 dígitos.");
            return;
        }
        catch(Exception e)
        {
            txtMostrar.setText(e.getMessage());
            return;
        }


    }

    public int Kaprekar(String num){
        int cont=0;

        if(num.equals("6174")){
            txtMostrar.setText(("7641 - 1467 = 6174"));
            return 1;
        }else{
            txtMostrar.setText("");
            while(!num.equals("6174")){
                String invertedNum;
                int[] aNum = new int[4];
                int i, j, aux, mNum, lNum;

                for(i=0; i<num.length(); i++){
                    aNum[i] = num.charAt(i) - '0';
                }

                for(i=0; i<aNum.length; i++){
                    for(j=0; j<aNum.length-i-1; j++){
                        if(aNum[j+1] > aNum[j]){
                            aux = aNum[j+1];
                            aNum[j+1] = aNum[j];
                            aNum[j] = aux;
                        }
                    }
                }

                num = Integer.toString(aNum[0]) + Integer.toString(aNum[1]) + Integer.toString(aNum[2]) + Integer.toString(aNum[3]);

                invertedNum = new StringBuilder(num).reverse().toString();

                mNum = Integer.parseInt(num);
                lNum = Integer.parseInt(invertedNum);

                num = Integer.toString(mNum - lNum);

                txtMostrar.append(mNum + " - " + lNum + " = " + num + "\n");
                cont++;
            }

            return cont;
        }
    }
}
