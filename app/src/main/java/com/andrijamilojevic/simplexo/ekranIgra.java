package com.andrijamilojevic.simplexo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class ekranIgra extends AppCompatActivity {

    static int igracNaPotezu = 1;

    Button[] listaDugmica = new Button[]{
            findViewById(R.id.dugme1),
            findViewById(R.id.dugme2),
            findViewById(R.id.dugme3),
            findViewById(R.id.dugme4),
            findViewById(R.id.dugme5),
            findViewById(R.id.dugme6),
            findViewById(R.id.dugme7),
            findViewById(R.id.dugme8),
            findViewById(R.id.dugme9)
    };

    int[] polja = new int[]{ 0 ,0, 0, 0, 0, 0, 0, 0, 0 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ekran_igra);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE); //krijemo naslov aplikacije
    }

    private void promeniPotez(){
        if(igracNaPotezu == 1){
            igracNaPotezu = 2;
        }else{
            igracNaPotezu = 1;
        }
    }

    private void dugmeKlik(int id){
        if(polja[id] != 0){ //da li je polje odigrano

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
