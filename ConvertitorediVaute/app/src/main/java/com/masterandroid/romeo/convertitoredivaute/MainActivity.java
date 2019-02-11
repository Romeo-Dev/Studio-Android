package com.masterandroid.romeo.convertitoredivaute;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.masterandroid.romeo.convertitoredivaute.R;

public class MainActivity extends AppCompatActivity {

    EditText Euro;
    TextView resDollari,valutaEur,valutaDoll;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Euro = (EditText) findViewById(R.id.importo);
        resDollari = (TextView) findViewById(R.id.resDollari);
        valutaEur = (TextView) findViewById(R.id.tvEuro);
        valutaDoll = (TextView) findViewById(R.id.tvDollari);

    }


    public void converti(View view) {
        final double tasso= 0.72;
        // prendo il valore dell importo

        if (!isEmpty(Euro)) {
            double imp = Double.parseDouble(Euro.getText().toString());
            double calcolo = imp / tasso;
            //setto la view
            resDollari.setText(String.format("%.2f", calcolo) + "$");
        }else{
            Toast.makeText(this, "Importo inserito nullo", Toast.LENGTH_SHORT).show();
        }
        Euro.setText("");
    }

    private boolean isEmpty(EditText euro) {
        String debug = Euro.getText().toString().trim();
        return debug.length() == 0;
    }

    public void changeValuta(View view) {

        /*TODO: id ripresi dalla vista creare il metodo per cambiare valuta da dollari a euro*/
    }
}
