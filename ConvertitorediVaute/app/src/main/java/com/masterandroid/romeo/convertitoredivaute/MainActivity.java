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
        final double tassoD= 1.38;
        final double tassoE=0.72;
        //TODO: creare un if esterno che valuta il testo della text view tvEuro

        if (!isEmpty(Euro)) {
            double imp = Double.parseDouble(Euro.getText().toString());
            if (valutaEur.getText().toString().equals("Euro")) {
                double calcolo = imp * tassoD;
                resDollari.setText(String.format("%.2f", calcolo) + "$");
            }else{
                double calcolo = imp * tassoE;
                resDollari.setText(String.format("%.2f", calcolo) + "$");
            }
        }else{
            Toast.makeText(this, "Importo inserito nullo", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isEmpty(EditText euro) {
        String debug = Euro.getText().toString().trim();
        return debug.length() == 0;
    }

    public void changeValuta(View view) {

        String Euro = valutaEur.getText().toString();
        String Dol = valutaDoll.getText().toString();
        valutaDoll.setText(Euro);
        valutaEur.setText(Dol);

    }
}
