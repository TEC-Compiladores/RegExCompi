package com.example.geraldtec.procompiv1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by gerald, albin, diego & juan on 26/02/16.
 */
public class Connection extends AppCompatActivity implements Constants{
    private Intent _Screen;
    private EditText ip;
    private EditText port;
    private String _IP;
    private int _PORT;

    /**
     * metodo tipo listener para los botones cuando sean apretados
     */
    public void onClick(View v){
        //extractData();
        switch (v.getId()){
            case R.id.makeconnection:
                if (ip.getText().toString().equals("")||port.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Enter a valid IP or PORT",Toast.LENGTH_SHORT);
                }else{
                    extractData();
                    new Thread(client).start();
                }
                break;
            case R.id.play:
                if (client.ifConnection()){
                    _Screen= new Intent(this, typegame.class);
                    ip.setFocusable(false);
                    port.setFocusable(false);
                    startActivity(_Screen);
                }else{
                    _Screen=new Intent(this, MainActivity.class);
                    startActivity(_Screen);
                    finish();
                }
                break;
        }

    }

    /**
     * metodo pra cargar elementos graficos
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conexion);
        ip = (EditText) findViewById(R.id.textIp);
        port =(EditText) findViewById(R.id.textPort);
    }

    /**
     * metodo para indicar que hacer cuando se aprete el boton <back>
     */
    @Override
    public void onBackPressed(){
        _Screen = new Intent(this, MainActivity.class);
        startActivity(_Screen);
        finish();
    }

    /**
     * Metodo para extraer los datos que se introduciran en la ventana de conexion.
     */
    public void extractData(){
        this._IP=ip.getText().toString();
        this._PORT=Integer.parseInt(port.getText().toString());
        client.setIP(this._IP);
        client.set_PORT(this._PORT);
    }
}
