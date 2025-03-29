package com.guilhermylg.calculadoraimc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CalculoIMCActivity extends Activity {
    private EditText etPeso, etAltura;
    private Button btnCalcular, btnLimpar, btnFechar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_imc);

        etPeso = findViewById(R.id.etPeso);
        etAltura = findViewById(R.id.etAltura);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnFechar = findViewById(R.id.btnFechar);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pesoStr = etPeso.getText().toString();
                String alturaStr = etAltura.getText().toString();

                if(TextUtils.isEmpty(pesoStr) || TextUtils.isEmpty(alturaStr)) {
                    Toast.makeText(CalculoIMCActivity.this, getString(R.string.error_input), Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    double peso = Double.parseDouble(pesoStr);
                    double altura = Double.parseDouble(alturaStr);
                    if(altura == 0) {
                        Toast.makeText(CalculoIMCActivity.this, getString(R.string.error_altura_zero), Toast.LENGTH_SHORT).show();
                        return;
                    }
                    double imc = peso / (altura * altura);
                    String classificacao;
                    Class<?> destinoActivity;

                    if(imc < 18.5) {
                        classificacao = getString(R.string.classificacao_abaixo);
                        destinoActivity = AbaixoDoPesoActivity.class;
                    } else if(imc < 25) {
                        classificacao = getString(R.string.classificacao_normal);
                        destinoActivity = PesoNormalActivity.class;
                    } else if(imc < 30) {
                        classificacao = getString(R.string.classificacao_sobrepeso);
                        destinoActivity = SobrepesoActivity.class;
                    } else if(imc < 35) {
                        classificacao = getString(R.string.classificacao_obesidade1);
                        destinoActivity = Obesidade1Activity.class;
                    } else if(imc < 40) {
                        classificacao = getString(R.string.classificacao_obesidade2);
                        destinoActivity = Obesidade2Activity.class;
                    } else {
                        classificacao = getString(R.string.classificacao_obesidade3);
                        destinoActivity = Obesidade3Activity.class;
                    }

                    Intent intent = new Intent(CalculoIMCActivity.this, destinoActivity);
                    intent.putExtra("peso", peso);
                    intent.putExtra("altura", altura);
                    intent.putExtra("imc", imc);
                    intent.putExtra("classificacao", classificacao);
                    startActivity(intent);

                } catch(NumberFormatException e) {
                    Toast.makeText(CalculoIMCActivity.this, getString(R.string.error_input), Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etPeso.setText("");
                etAltura.setText("");
            }
        });

        btnFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); // Retorna para a MainActivity
            }
        });
    }
}
