package com.example.a82;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Context context = null;
    BottleDispenser bd = BottleDispenser.getInstance();
    TextView textView;
    TextView textView2;
    SeekBar seekBar;
    Spinner spinner;
    ArrayList<String> bottles = bd.getStringBottles();
    int valinta;
    double lisays;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;

        textView = findViewById(R.id.textView);
        spinner = findViewById(R.id.spinner);
        seekBar = findViewById(R.id.seekBar);
        textView2 = findViewById(R.id.textView2);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textView2.setText("Adding "+String.valueOf(i)+" € to balance!");
                lisays = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                valinta = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }

        });

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,bottles);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(aa);

    }


    public void addMoney(View v){
        bd.addMoney(lisays);
        textView.setText("You added "+String.valueOf(lisays)+" € to balance!");
        seekBar.setProgress(0);

    }

    public void returnMoney(View v){
        DecimalFormat df = new DecimalFormat("0.00");
        textView.setText("Klink klink. Money came out! You got "+df.format(bd.getMoney())+"€ back");
        bd.returnMoney();
    }

    public void buyDrink(View v){
        switch(bd.buyBottle(valinta)){
            case 1:
                textView.setText("KACHUNK! "+bd.getBottleArray().get(valinta).getName()+" came out of the dispenser!");
                break;
            case 2:
                textView.setText("Add money first!");
                break;
            case 3:
                textView.setText("Out of bottles!");
                break;
        }

    }

    public void writeFile(View v){
        try{
            OutputStreamWriter ows = new OutputStreamWriter(context.openFileOutput("Kuitti.txt", Context.MODE_PRIVATE));

            String s = "****RECEIPT****\n"+"Your last purchase was:\n"+String.valueOf(bd.getBottleArray().get(valinta).getName())+" "+String.valueOf(bd.getBottleArray().get(valinta).getSize())+" L"+"\n"+String.valueOf(bd.getBottleArray().get(valinta).getPrice())+" €";

            ows.write(s);
            ows.close();

        } catch (IOException e){
            Log.e("IOException", "Virhe syötteessä");
        } finally {
            textView.setText("Receipt printed!");
        }
    }

}