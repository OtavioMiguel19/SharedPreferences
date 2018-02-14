package com.vidroid.com.br.apps.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;
    EditText editText;
    static final String ARQUIVO_PREFERENCIA = "arquivoPreferencia";
    CustomSharedPreferences preferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferencias = new CustomSharedPreferences(getApplicationContext());

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();


                //Validar o campo
                if(editText.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Preencha o campo", Toast.LENGTH_LONG).show();
                }
                else{
                    String texto = editText.getText().toString();
                    editor.putString("texto", texto);
                    editor.commit();


                    textView.setText("Texto salvo: " + texto);
                }
            }
        });

        //Recuperar dados salvos
        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA, 0);

        //Validar se existe
        if(sharedPreferences.contains("texto")){
            String texto = sharedPreferences.getString("texto", "");
            textView.setText("Texto salvo:  " + texto);
        }

    }
}
