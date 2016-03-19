package com.example.geraldtec.procompiv1;

import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by geraldtec on 04/03/16.
 */
public class typegame extends AppCompatActivity implements Constants{
    private Intent _Screen;

    /**
     *
     * @param v
     */
    public void onClick(View v){
        if (v.getId()==R.id.creator){
            _Screen=new Intent(this, Creator.class);
            startActivity(_Screen);
            finish();
        }
        if (v.getId()==R.id.player){
            _Screen=new Intent(this, Guest.class);
            startActivity(_Screen);
            finish();
        }
    }

    /**
     *
     * @param savedInstanceState
     */
     @Override
     protected void onCreate(Bundle savedInstanceState){
         super.onCreate(savedInstanceState);
         setContentView(R.layout.tipo_juego);
     }

    /**
     *
     */
    @Override
    public void onBackPressed(){
        _Screen=new Intent(this, Connection.class);
        startActivity(_Screen);
        finish();
    }
}
