package com.example.geraldtec.procompiv1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by GeraldF on 11/03/2016.
 */
public class Help extends AppCompatActivity {
    private Intent _Screen;

    /**
     * Metodo que ejecuta los elementos graficos presentes en un activity de Android.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help);
    }

    /**
     * metodo tipo listener para los botones cuando sean apretados
     * @param v
     */
    public void onClick(View v){
        if(v.getId()==R.id.start){
            _Screen = new Intent(this, typegame.class );
            startActivity(_Screen);
            finish();
        }
    }

    /**
     * metodo para indicar que hacer cuando se aprete el boton <back>
     */
    @Override
    public void onBackPressed(){
        _Screen = new Intent(this, MainActivity.class );
        startActivity(_Screen);
        finish();
    }
}
