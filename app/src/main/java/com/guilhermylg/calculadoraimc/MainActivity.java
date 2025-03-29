package com.guilhermylg.calculadoraimc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    private Button btnCalculadoraIMC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalculadoraIMC = findViewById(R.id.btnCalculadoraIMC);
        btnCalculadoraIMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CalculoIMCActivity.class);
                startActivity(intent);
            }
        });
    }
}
