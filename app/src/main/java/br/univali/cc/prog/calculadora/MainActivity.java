package br.univali.cc.prog.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText num1;
    EditText num2;
    TextView resultado;
    ListView historicoListView;
    List<String> historico  = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.etNumero1);
        num2 = findViewById((R.id.etNumero2));
        resultado = findViewById(R.id.tvResultado);
        historicoListView = findViewById(R.id.lvHistorico);

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
            gravaResultado("+", num1St, num2St, res);



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
            gravaResultado("-", num1St, num2St, res);
        }
    }
    public void divisao (View v){
        resultado.setText("");
        String num1St = num1.getText().toString().trim();
        String num2St = num2.getText().toString().trim();

        if (num1St.equals("") || num2St.equals("")){
            Toast.makeText(this, "Por favor, informe os dois valores!", Toast.LENGTH_LONG).show();
        }else {
            if (num2St.equals("0")) {
                resultado.setText("NÃO É POSSIVEL DIVIDIR POR 0");
            } else {
                Float res = Float.valueOf(num1St) / Float.valueOf(num2St);
                resultado.setText("Resultado: " + res);
                gravaResultado("/", num1St, num2St, res);
            }
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
            gravaResultado("x", num1St, num2St, res);

        }

    }
    public void limparResultado (View v){
        historico.clear();
        historicoListView.setAdapter(null);
    }

    public void gravaResultado(String op, String n1, String n2, Float r){
        String texto = n1 + op + n2 + " = " + r;
        historico.add(texto);
        ArrayAdapter<String> resArrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, historico);
        historicoListView.setAdapter(resArrayAdapter);
    }
}
