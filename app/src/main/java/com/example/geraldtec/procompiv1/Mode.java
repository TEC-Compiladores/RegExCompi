package com.example.geraldtec.procompiv1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * Created by GeraldF on 11/03/2016.
 */
public class Mode extends AppCompatActivity implements Constants{
    private Intent _Screen;
    private Intent _IN;
    private String _primero,_segundo,_tercero,_cuarto,_quinto;
    private String _pattern;
    private String GameName;
    private String GamePlayer;
    /**
     *
     * @param v
     */
    public void onClick(View v){
        switch(v.getId()){
            case R.id.search:
                _Screen=new Intent(this, GamePlayer.class);
                _Screen.putExtra("_pattern",_pattern);
                _Screen.putExtra("_primero",_primero);
                _Screen.putExtra("_segundo",_segundo);
                _Screen.putExtra("_tercero",_tercero);
                _Screen.putExtra("_cuarto",_cuarto);
                _Screen.putExtra("_quinto",_quinto);
                _Screen.putExtra("GameName",GameName);
                _Screen.putExtra("nameGuest",GamePlayer);
                startActivity(_Screen);
                finish();
                break;
            case R.id.complete:
                _Screen=new Intent(this, GamePlayerComplStrings.class);
                _Screen.putExtra("_pattern",_pattern);
                _Screen.putExtra("_primero",_primero);
                _Screen.putExtra("_segundo",_segundo);
                _Screen.putExtra("_tercero",_tercero);
                _Screen.putExtra("_cuarto",_cuarto);
                _Screen.putExtra("_quinto",_quinto);
                _Screen.putExtra("GameName",GameName);
                _Screen.putExtra("nameGuest",GamePlayer);
                startActivity(_Screen);
                finish();
                break;
        }
    }

    /**
     *
     * @return
     */
    public String createXml(){
        Document document=XML.createEmptyDoc();

        Element root=document.createElement("Request");
        document.appendChild(root);

        Element message=document.createElement("message");
        message.appendChild(document.createTextNode("GameList"));
        root.appendChild(message);

        return XML.parseToString(document);
    }

    /**
     *
     */
    public void readXML(String pString){
        Document documento=XML.parseToDocument(pString);
        System.out.println(pString+"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        this._pattern=documento.getFirstChild().getChildNodes().item(0).getChildNodes().item(0).getTextContent();
        Node ejemplos=documento.getFirstChild().getChildNodes().item(0).getChildNodes().item(1);
        this._primero=ejemplos.getChildNodes().item(0).getTextContent();
        this._segundo=ejemplos.getChildNodes().item(1).getTextContent();
        this._tercero=ejemplos.getChildNodes().item(2).getTextContent();
        this._cuarto=ejemplos.getChildNodes().item(3).getTextContent();
        this._quinto=ejemplos.getChildNodes().item(4).getTextContent();
    }

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState){
        int conn = 0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mode);
        _IN =getIntent();
        this.GameName= _IN.getStringExtra("GameName");
        this.GamePlayer=_IN.getStringExtra("nameGuest");
        System.out.println(this.GamePlayer+"11111111111111111111222222222222222222222222222333333333");

        String reply=null;
        boolean flag=true;



        long tiempoIni=System.currentTimeMillis();

        while (flag){
            long tiempoFin=System.currentTimeMillis();
            if(tiempoFin-tiempoIni>=1000){
                reply = client.getMessage();
                flag=false;
            }
        }
        this.readXML(reply);

    }

    /**
     *
     */
    @Override
    public void onBackPressed(){
        if(client.checkConnection()) {
            _Screen = new Intent(this, GameList.class);
            client.sendMessage(this.createXml());
            startActivity(_Screen);
            finish();
        }
        else{
            Toast.makeText(getApplicationContext(), "Lost connection with the server", Toast.LENGTH_SHORT).show();
            _Screen = new Intent(this, MainActivity.class);
            startActivity(_Screen);
            finish();
        }
    }
}
