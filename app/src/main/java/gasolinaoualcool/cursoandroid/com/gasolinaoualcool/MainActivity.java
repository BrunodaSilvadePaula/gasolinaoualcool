package gasolinaoualcool.cursoandroid.com.gasolinaoualcool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnVerificar;
    private EditText precoAlcool;
    private EditText precoGasolina;
    private TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        precoAlcool = (EditText) findViewById(R.id.textAlcool);
        precoGasolina = (EditText) findViewById(R.id.textGasolina);
        btnVerificar = (Button) findViewById(R.id.btnValidar);
        result = (TextView) findViewById(R.id.textresult);

        btnVerificar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // recupera valores digitados
                String alcool = precoAlcool.getText().toString();
                String gasolina = precoGasolina.getText().toString();
                // valida se foi digitado algum valor
                if(!alcool.isEmpty() && !gasolina.isEmpty()){
                    //converte valores para Double
                    Double valorAlcool = Double.parseDouble(alcool);
                    Double valorGasolina= Double.parseDouble(gasolina);
                    //regra de negocio
                    // valorAlcool / valorGasoline
                    double resultado = valorAlcool / valorGasolina;
                    if(resultado >= 0.7){
                        result.setText("Compensa utilizar Gasolina!");
                    }else{
                        result.setText("Compensa utilizar o Alcool!");
                    }
                }else{
                    //String vazia
                    result.setText("Você deve informar o valor de ambos os combustiveis!!!");
                }
            }
        });
    }
}
