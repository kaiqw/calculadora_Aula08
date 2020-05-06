package br.univali.cc.prog.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText num1;
    EditText num2;
    TextView resultado;
    TextView historico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.etNumero1);
        num2 = findViewById((R.id.etNumero2));
        resultado = findViewById(R.id.tvResultado);
        historico = findViewById(R.id.tvHistorico);

    }

    public void adicao (View v){
        resultado.setText("");
        String num1St = num1.getText().toString().trim();
        String num2St = num2.getText().toString().trim();

        if (num1St.equals("") || num2St.equals("")){
            Toast.makeText(this, "Por favor, informe os dois valores!", Toast.LENGTH_LONG).show();
        }else{
            Float res = Float.valueOf(num1St) + Float.valueOf(num2St);
            resultado.setText("Resultado: " + res);
            historico.setText(num1St + " + " + num2St + " = " + res);
        }


    }

    public void subtracao (View v){
        resultado.setText("");
        String num1St = num1.getText().toString().trim();
        String num2St = num2.getText().toString().trim();

        if (num1St.equals("") || num2St.equals("")){
            Toast.makeText(this, "Por favor, informe os dois valores!", Toast.LENGTH_LONG).show();
        }else{
            Float res = Float.valueOf(num1St) - Float.valueOf(num2St);
            resultado.setText("Resultado: " + res);
        }


    }
    public void divisao (View v){
        resultado.setText("");
        String num1St = num1.getText().toString().trim();
        String num2St = num2.getText().toString().trim();

        if (num1St.equals("") || num2St.equals("")){
            Toast.makeText(this, "Por favor, informe os dois valores!", Toast.LENGTH_LONG).show();
        }

        if (num2St.equals("0")){
            resultado.setText("NÃO É POSSIVEL DIVIDIR POR 0");
        }
        else{
            Float res = Float.valueOf(num1St) / Float.valueOf(num2St);
            resultado.setText("Resultado: " + res);
        }


    }
    public void multiplicacao (View v){
        resultado.setText("");
        String num1St = num1.getText().toString().trim();
        String num2St = num2.getText().toString().trim();

        if (num1St.equals("") || num2St.equals("")){
            Toast.makeText(this, "Por favor, informe os dois valores!", Toast.LENGTH_LONG).show();
        }else{
            Float res = Float.valueOf(num1St) * Float.valueOf(num2St);
            resultado.setText("Resultado: " + res);
        }


    }
}
