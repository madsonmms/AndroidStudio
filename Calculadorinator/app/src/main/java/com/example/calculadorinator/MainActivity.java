package com.example.calculadorinator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView txtCalculo;
    float numeroA = 0;
    String operacao = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCalculo = findViewById(R.id.txtCalculo);
        txtCalculo.setText("0");
    }

    public void clicaBotao(View view) {
        switch (view.getId()){
            case R.id.btnClear:
                txtCalculo.setText("0");
                numeroA = 0;
                operacao = "";
                break;
            case R.id.btnAdicao:
                calculaNumeros("+");
                break;
            case R.id.btnSubtracao:
                calculaNumeros("-");
                break;
            case R.id.btnMultiplicacao:
                calculaNumeros("X");
                break;
            case R.id.btnDivisao:
                calculaNumeros("/");
                break;
            case R.id.btnIgual:
                mostraResultado();
                break;
            default:
                String numb;
                numb = ((Button)view).getText().toString();
                getKeyboard(numb);
                break;
        }
    }

    public void calculaNumeros(String tipoOperacao) {
        numeroA = Float.parseFloat(txtCalculo.getText().toString());
        operacao = tipoOperacao;
        txtCalculo.setText("0");
    }

    public void getKeyboard (String str) {
        String ScrCurrent = txtCalculo.getText().toString();
        ScrCurrent += str;
        txtCalculo.setText(ScrCurrent);
    }

    public void mostraResultado() {
        float numeroB = Integer.parseInt(txtCalculo.getText().toString());
        float resultado = 0;

        switch(operacao) {
            case "+":
                resultado = numeroB + numeroA;
                break;
            case "-":
                resultado = numeroB - numeroA;
                break;
            case "*":
                resultado = numeroB * numeroA;
                break;
            case "/":
                resultado = numeroB / numeroA;
                break;
        }
        txtCalculo.setText(String.valueOf(resultado));
    }

}
