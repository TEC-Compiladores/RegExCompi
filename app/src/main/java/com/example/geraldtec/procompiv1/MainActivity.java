package com.example.geraldtec.procompiv1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements Constants{
    private Intent _Screen;

    /**
     * Metodo que ejecuta los elementos graficos presentes en un activity de Android.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * metodo tipo listener para los botones cuando sean apretados
     * @param v
     */
    public void onClick(View v){
        switch (v.getId()){
            case R.id.start:
                //_Screen = new Intent(this, Connection.class );
                _Screen = new Intent(this, Connection.class );
                startActivity(_Screen);
                finish();
                break;
            case R.id.button:
                _Screen = new Intent(this, Help.class );
                startActivity(_Screen);
                finish();
                break;
            case R.id.b_aboutUs:
                _Screen = new Intent(this, About.class );
                startActivity(_Screen);
                finish();
                break;
        }
    }

    /**
     * metodo para indicar que hacer cuando se aprete el boton <back>
     */
    @Override
    public void onBackPressed(){
        finish();
    }
}
