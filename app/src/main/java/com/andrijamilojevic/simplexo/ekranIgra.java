package com.andrijamilojevic.simplexo;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ekranIgra extends AppCompatActivity {

    final Context context = this;
    static int igracNaPotezu = 1;

    List<Button> listaDugmica = new ArrayList<Button>();

    int[] polja = new int[]{ 0 ,0, 0, 0, 0, 0, 0, 0, 0 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ekran_igra);
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE); //krijemo naslov aplikacije
        listaDugmica.add((Button)findViewById(R.id.dugme1));
        listaDugmica.add((Button)findViewById(R.id.dugme2));
        listaDugmica.add((Button)findViewById(R.id.dugme3));
        listaDugmica.add((Button)findViewById(R.id.dugme4));
        listaDugmica.add((Button)findViewById(R.id.dugme5));
        listaDugmica.add((Button)findViewById(R.id.dugme6));
        listaDugmica.add((Button)findViewById(R.id.dugme7));
        listaDugmica.add((Button)findViewById(R.id.dugme8));
        listaDugmica.add((Button)findViewById(R.id.dugme9));
    }

    private void promeniPotez(){
        if(igracNaPotezu == 1){
            igracNaPotezu = 2;
        }else{
            igracNaPotezu = 1;
        }
        EditText naPotezuTekst = (EditText) findViewById(R.id.textPotez);
        naPotezuTekst.setText("Na potezu je: Igrac " + igracNaPotezu + "(" + (igracNaPotezu == 1? "X" : "O") + ")");
    }

    private void resetujSve(){
        for(int i = 0; i < 9; i++){
            polja[i] = 0;
            listaDugmica.get(i).setText(" ");
        }
    }

    private void imamoPobednika(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);
        alertDialogBuilder.setTitle("Kraj Igre!");
        alertDialogBuilder
                .setMessage("Pobednik je Igrac " + igracNaPotezu + "(" + (igracNaPotezu == 1 ? "X" : "O") + ")!")
                .setCancelable(false)
                .setPositiveButton("Izadji",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        ekranIgra.this.finish();
                    }
                })
                .setNegativeButton("Ponovo",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        resetujSve();
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void proveriKraj(){
        for(int i = 0; i <= 2; i++){
            if(polja[i*3] == polja[i*3+1] && polja[i*3+1] == polja[i*3+2] && polja[i*3] != 0){
                imamoPobednika();
            }
            if(polja[i] == polja[i+3] && polja[i+3] == polja[i+6] && polja[i] != 0){
                imamoPobednika();
            }
        }
        if(polja[0] == polja[4] && polja[4] == polja[8] && polja[0] != 0){
            imamoPobednika();
        }
        if(polja[6] == polja[4] && polja[4] == polja[2] && polja[6] != 0){
            imamoPobednika();
        }

    }

    private void dugmeKlik(int id){
        if(polja[id] == 0){ //da li je vec polje odigrano
            polja[id] = igracNaPotezu;
            listaDugmica.get(id).setText(igracNaPotezu == 1 ? "X" : "O");
            proveriKraj();
            promeniPotez();
        }
    }

    public void onClick(View v) { //metoda koja se poziva kada se klikne na neko dugme
        switch (v.getId()) { //proveravamo koje je dugme u pitanju
            case  R.id.dugme1: {
                dugmeKlik(0);
                break;
            }
            case  R.id.dugme2: {
                dugmeKlik(1);
                break;
            }
            case  R.id.dugme3: {
                dugmeKlik(2);
                break;
            }
            case  R.id.dugme4: {
                dugmeKlik(3);
                break;
            }
            case  R.id.dugme5: {
                dugmeKlik(4);
                break;
            }
            case  R.id.dugme6: {
                dugmeKlik(5);
                break;
            }
            case  R.id.dugme7: {
                dugmeKlik(6);
                break;
            }
            case  R.id.dugme8: {
                dugmeKlik(7);
                break;
            }
            case  R.id.dugme9: {
                dugmeKlik(8);
                break;
            }
        }
    }
}
