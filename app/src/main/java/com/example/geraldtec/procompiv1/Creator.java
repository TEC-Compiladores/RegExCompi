package com.example.geraldtec.procompiv1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
            if(this.validateInput()) {
                _Screen = new Intent(this, Alphabeth.class);
                _Screen.putExtra("name", _CreatorEdit.getText().toString());
                _Screen.putExtra("gamename", _GameEdit.getText().toString());
                startActivity(_Screen);
                finish();
            }
            else
                Toast.makeText(getApplicationContext(), "The names of the creator and the game shouldn't be empty or above 6 characters long", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Método para obtener el nombre del creador
     * @return Nombre del creador
     */
    private String getCreatorName(){
        return _CreatorEdit.getText().toString();
    }


    /**
     * Método para obtener el nombre del juego
     * @return Nombre del juego
     */
    private String getGameName(){
        return _GameEdit.getText().toString();
    }


    /**
     * Método para validar las entradas del creador del juego
     * @return True o false si las entradas son correctas
     */
    private boolean validateInput(){
        boolean flag = false;

        if(this.getCreatorName().length() <= 6 && this.getGameName().length() <= 6){
            if(this.getCreatorName().length() > 0 && this.getGameName().length() > 0){
                flag = true;
            }
        }

        return flag;

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
