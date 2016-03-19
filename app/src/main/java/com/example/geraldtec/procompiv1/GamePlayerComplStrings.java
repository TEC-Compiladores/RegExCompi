package com.example.geraldtec.procompiv1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import nl.flotsam.xeger.Xeger;

/**
 * Created by GeraldF on 11/03/2016.
 */
public class GamePlayerComplStrings extends AppCompatActivity implements Constants{
    private Intent _Screen;
    private Intent _IN;
    private TextView _TVprimero,_TVsegundo,_TVtercero, TV_cuarto, _TVquinto;
    private String _primero,_segundo,_tercero,_cuarto,_quinto,pattern;
    private EditText _ET1,_ET2,_ET3,_ET4,_ET5;
    private String Con1,Con2,Con3,Con4,Con5;
    private String GameName;
    private String GamePlayer;
    private ArrayList<String> Samples;

    /**
     * Metodo que ejecuta los elementos graficos presentes en un activity de Android.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameplayercomplstrings);
        _TVprimero=(TextView)findViewById(R.id.TVOpcion1);
        _TVsegundo=(TextView)findViewById(R.id.TVOpcion2);
        _TVtercero=(TextView)findViewById(R.id.TVOpcion3);
        TV_cuarto=(TextView)findViewById(R.id.TVOpcion4);
        _TVquinto=(TextView)findViewById(R.id.TVOpcion5);

        _ET1=(EditText)findViewById(R.id.et1);
        _ET2=(EditText)findViewById(R.id.et2);
        _ET3=(EditText)findViewById(R.id.et3);
        _ET4=(EditText)findViewById(R.id.et4);
        _ET5=(EditText)findViewById(R.id.et5);

        _IN =getIntent();
        this._primero= _IN.getStringExtra("_primero");
        this._segundo= _IN.getStringExtra("_segundo");
        this._tercero= _IN.getStringExtra("_tercero");
        this._cuarto= _IN.getStringExtra("_cuarto");
        this._quinto= _IN.getStringExtra("_quinto");
        this.pattern= _IN.getStringExtra("_pattern");
        this.GameName=_IN.getStringExtra("GameName");
        this.GamePlayer= _IN.getStringExtra("nameGuest");

        _TVprimero.setText(this._primero);
        _TVsegundo.setText(this._segundo);
        _TVtercero.setText(this._tercero);
        TV_cuarto.setText(this._cuarto);
        _TVquinto.setText(this._quinto);

        Samples=new ArrayList<String>();
    }

    /**
     *
     */
    public Boolean validate(){
        Pattern patron=Pattern.compile(this.pattern);
        Boolean flag;


        Con1=_TVprimero.getText().toString()+_ET1.getText().toString();
        Con2=_TVsegundo.getText().toString()+_ET2.getText().toString();
        Con3=_TVtercero.getText().toString()+_ET3.getText().toString();
        Con4=TV_cuarto.getText().toString()+_ET4.getText().toString();
        Con5=_TVquinto.getText().toString()+_ET5.getText().toString();
        ArrayList<String> cadenas = new ArrayList<String>();
        cadenas.add(0, Con1);
        cadenas.add(1, Con2);
        cadenas.add(2, Con3);
        cadenas.add(3, Con4);
        cadenas.add(4, Con5);


        for(int i=0; i<cadenas.size(); i++){
            Matcher matc = patron.matcher(cadenas.get(i));
            if(matc.find()){
                if(!matc.group(0).equals(cadenas.get(i))){
                    flag = false;
                    return flag;
                }
            }
            else{
                flag = false;
                return flag;
            }
        }
        flag=true;
        return flag;

    }

    /**
     *
     * @return
     */
    public String mensaje(){
        Document document=XML.createEmptyDoc();
        Element root=document.createElement("Request");
        document.appendChild(root);

        Element message=document.createElement("message");
        message.appendChild(document.createTextNode("NewAttempt"));
        root.appendChild(message);

        Element gamename=document.createElement("gameName");
        gamename.appendChild(document.createTextNode(this.GameName));
        root.appendChild(gamename);

        return XML.parseToString(document);
    }

    /**
     * metodo tipo listener para los botones cuando sean apretados
     * @param v
     */
    public void onClick(View v){
        switch (v.getId()){
            case R.id.bGotIt3:
                System.out.println(_ET1.getText().toString()+"99999999999999999999999999999999999999999999999999999999999999");
                if (((_ET1.getText().toString().equals(""))||(_ET2.getText().toString().equals("")))
                        ||((_ET3.getText().toString().equals(""))||(_ET4.getText().toString().equals("")))
                        ||(_ET5.getText().toString().equals(""))){
                    Toast.makeText(getApplicationContext(), "You have to fill all boxes", Toast.LENGTH_SHORT).show();
                }else{
                    boolean flag = this.validate();
                    if(flag){
                        Toast.makeText(getApplicationContext(), "You Win!!!!", Toast.LENGTH_SHORT).show();
                        client.sendMessage(createXml(this.GameName,"GameWin"));
                        _Screen = new Intent(this, typegame.class );
                        startActivity(_Screen);
                        finish();
                    }
                    else{
                        client.sendMessage(mensaje());
                        Toast.makeText(getApplicationContext(), "You lost!!!!", Toast.LENGTH_SHORT).show();
                        client.sendMessage(createXml(this.GameName,"GameLost"));
                        _Screen = new Intent(this, typegame.class );
                        startActivity(_Screen);
                        finish();
                    }
                }



                break;
        }
    }
    /**
     *
     */
    public String createXml(String pGame,String pMessage){
        Document document=XML.createEmptyDoc();

        Element root=document.createElement("Request");
        document.appendChild(root);

        Element message=document.createElement("message");
        message.appendChild(document.createTextNode(pMessage));
        root.appendChild(message);

        Element gamename=document.createElement("gameName");
        gamename.appendChild(document.createTextNode(pGame));
        root.appendChild(gamename);

        Element username=document.createElement("userName");
        username.appendChild(document.createTextNode(GamePlayer));
        root.appendChild(username);

        return XML.parseToString(document);
    }


    /**
     * metodo para indicar que hacer cuando se aprete el boton <back>
     */
    @Override
    public void onBackPressed(){
        _Screen = new Intent(this, Mode.class );
        startActivity(_Screen);
        finish();
    }
}
