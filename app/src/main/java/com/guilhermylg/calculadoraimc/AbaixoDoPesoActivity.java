package com.guilhermylg.calculadoraimc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AbaixoDoPesoActivity extends Activity {
    private TextView tvResultado;
    private Button btnFechar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abaixo_do_peso);

        tvResultado = findViewById(R.id.tvResultado);
        btnFechar = findViewById(R.id.btnFechar);

        // Recupera os dados enviados via Intent
        Intent intent = getIntent();
        double peso = intent.getDoubleExtra("peso", 0);
        double altura = intent.getDoubleExtra("altura", 0);
        double imc = intent.getDoubleExtra("imc", 0);
        String classificacao = intent.getStringExtra("classificacao");

        String resultado = getString(R.string.label_peso) + ": " + peso + " kg\n" +
                getString(R.string.label_altura) + ": " + altura + " m\n" +
                getString(R.string.label_imc) + ": " + String.format("%.2f", imc) + "\n" +
                getString(R.string.label_classificacao) + ": " + classificacao + "\n\n" +
                getString(R.string.msg_motivacional_abaixo);

        tvResultado.setText(resultado);
        btnFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AbaixoDoPesoActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}
