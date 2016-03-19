package com.example.geraldtec.procompiv1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by geraldtec on 04/03/16.
 */
public class Creator extends AppCompatActivity implements Constants{
    private Intent _Screen;
    private EditText _CreatorEdit;
    private EditText _GameEdit;

    /**
     *
     * @param v
     */
    public void onClick(View v){
        if (v.getId()==R.id.buttoncontinue1){
            //gwc.set_gameText("hey hey");
            _Screen=new Intent(this, Alphabeth.class);
            _Screen.putExtra("name",_CreatorEdit.getText().toString());
            _Screen.putExtra("gamename",_GameEdit.getText().toString());
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
        setContentView(R.layout.creador);
        _CreatorEdit=(EditText)findViewById(R.id.creatortext1);
        _GameEdit=(EditText)findViewById(R.id.gametext1);
    }

    /**
     *
     */
    @Override
    public void onBackPressed(){
        _Screen=new Intent(this, typegame.class);
        startActivity(_Screen);
        finish();
    }

}
