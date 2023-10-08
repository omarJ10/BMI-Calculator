package com.example.tp3_ex2;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calculButton = findViewById(R.id.button6);
        Button raz = findViewById(R.id.button7);

        RadioGroup RG = findViewById(R.id.radioGroup);

        calculButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText editText = findViewById(R.id.editTextText1);
                String poids = editText.getText().toString();

                EditText editText2 = findViewById(R.id.editTextText2);
                String taille = editText2.getText().toString();

                TextView tv = findViewById(R.id.textView3);
                String resulats = tv.getText().toString();
                if(!taille.isEmpty() || !poids.isEmpty()){

                    float p = Float.parseFloat(poids);
                    float t = Float.parseFloat(taille);
                    float IMC = 0;

                    if(p > 0 && t > 0){
                        int x = RG.getCheckedRadioButtonId();
                        RadioButton r=findViewById(x);

                        if(x == -1){
                            Toast.makeText(MainActivity.this, "Choose a type of measure", Toast.LENGTH_SHORT).show();
                        }else{
                            if(r.getText().equals("Centimétre")){
                                t = t/100;
                                IMC = p/(t*t);
                                resulats = "Resultat:\nVotre IMC est "+  Math.round(IMC * 10.0) / 10.0; //Math.round(nbr * 100.0) / 100.0
                            }else if(r.getText().equals("Métre")){
                                IMC = p/(t*t);
                                resulats = "Resultat:\nVotre IMC est "+ Math.round(IMC * 10.0) / 10.0;
                            }

                            tv.setText(resulats);
                        }
                    }else{
                        Toast.makeText(MainActivity.this, "Enter un poids positive !", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(MainActivity.this, "Enter un taille et un poids !", Toast.LENGTH_SHORT).show();

                }
            }
        });

        raz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = findViewById(R.id.textView3);
                String resulats = tv.getText().toString();

                resulats = "Resultat:\nVous devez cliquer sur le bouton Caculer L'IMC pour obtenir un resultat !";
                tv.setText(resulats);

                int x = RG.getCheckedRadioButtonId();
                RadioButton r=findViewById(x);
                r.setChecked(false);

                EditText editText = findViewById(R.id.editTextText1);
                editText.setText("");


                EditText editText2 = findViewById(R.id.editTextText2);
                editText2.setText("");
            }
        });


    }
}