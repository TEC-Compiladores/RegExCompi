package com.example.geraldtec.procompiv1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by geraldtec on 26/02/16.
 */
public class Game extends AppCompatActivity implements Constants {
    private Intent _Screen;
    private String _PATTERN="1[0|1]*1";

    /**
     *
     */
    public void sendMessage(){
        client.sendMessage(_PATTERN);
    }

    /**
     *
     */
    public void extractData(){
        EditText _text=(EditText) findViewById(R.id.textGame);
        _PATTERN=_text.getText().toString();
    }

    /**
     *
     */
    public void onClick(View v){
        if (v.getId()==R.id.send_data){
            extractData();
            Toast.makeText(getApplicationContext(), _PATTERN, Toast.LENGTH_SHORT).show();
            sendMessage();
        }
    }

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
    }

    /**
     *
     */
    @Override
    public void onBackPressed(){
        _Screen= new Intent(this, Connection.class);
        startActivity(_Screen);
        client.sendMessage("exit");
        finish();
    }
}
