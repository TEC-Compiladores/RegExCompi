package com.example.geraldtec.procompiv1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.Date;

/**
 * Created by GeraldF on 11/03/2016.
 */
public class GameInstanceInfo extends AppCompatActivity implements Constants{
    private Intent _Screen;
    private Intent _IN;
    private String _Creator;
    private String _Intents;
    private String _Date;
    private String GameName;
    private String GamePlayer;
    private TextView _tvCname,_tvIntents,_tvDate;

    /**
     * Metodo que ejecuta los elementos graficos presentes en un activity de Android.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameinstanceinfo);
        getInfo();
        _tvCname=(TextView)findViewById(R.id.TVCName);
        _tvIntents=(TextView)findViewById(R.id.TVIntents);
        _tvDate=(TextView)findViewById(R.id.TVDate);

        _IN =getIntent();
        this.GameName= _IN.getStringExtra("GameName");
        this.GamePlayer=_IN.getStringExtra("nameGuest");
        _tvCname.setText(_Creator);
        _tvIntents.setText(_Intents);
        _tvDate.setText(_Date);

    }
    /**
     *
     */
    public void getInfo(){
        String xml=null;
        boolean flag=true;

        long tiempoIni=System.currentTimeMillis();

        while (flag){
            long tiempoFin=System.currentTimeMillis();
            if(tiempoFin-tiempoIni>=1000){
                xml = client.getMessage();
                flag=false;
            }
        }
        Document documento=XML.parseToDocument(xml);
        Node info=documento.getFirstChild().getChildNodes().item(0);
        _Creator=info.getChildNodes().item(0).getTextContent();
        _Intents=info.getChildNodes().item(1).getTextContent();
        long time = Long.parseLong(info.getChildNodes().item(2).getTextContent());
        _Date=this.obtainDate(time);
    }
    /**
     *
     */
    public String obtainDate(long pDate){
        Date actual=new Date();
        Date past=new Date(pDate);
        String time="";
        int difference=(int)((actual.getTime()-past.getTime()));
        if(difference/1000<60){
            time=difference/1000+" seconds";
        }else if(difference/(1000*60)<60){
            time=difference/(1000*60)+" minutes";
        }else if(difference/(1000*60*60)<24){
            time=difference/(1000*60*60)+" hours";
        }else
            time=difference/(1000*60*60*24)+" days";
        return time;
    }
    /**
     *
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
    public String solXml(String pGame){
        Document document=XML.createEmptyDoc();

        Element root=document.createElement("Request");
        document.appendChild(root);

        Element message=document.createElement("message");
        message.appendChild(document.createTextNode("PlayInfo"));
        root.appendChild(message);

        Element gamename=document.createElement("gameName");
        gamename.appendChild(document.createTextNode(pGame));
        root.appendChild(gamename);

        return XML.parseToString(document);
    }
    /**
     *
     */
    public String startGameXml(String pGame){
        Document document=XML.createEmptyDoc();

        Element root=document.createElement("Request");
        document.appendChild(root);

        Element message=document.createElement("message");
        message.appendChild(document.createTextNode("GameStart"));
        root.appendChild(message);

        Element gamename=document.createElement("gameName");
        gamename.appendChild(document.createTextNode(pGame));
        root.appendChild(gamename);

        Element namePlayer=document.createElement("userName");
        namePlayer.appendChild(document.createTextNode(GamePlayer));
        root.appendChild(namePlayer);

        return XML.parseToString(document);
    }

    /**
     * metodo tipo listener para los botones cuando sean apretados
     * @param v
     */
    public void onClick(View v){
        switch (v.getId()){
            case R.id.bPlay:
                _Screen = new Intent(this, Mode.class);
                client.sendMessage(startGameXml(GameName));
                client.sendMessage(solXml(GameName));

                _Screen.putExtra("nameGuest",GamePlayer);
                _Screen.putExtra("GameName",this.GameName);
                startActivity(_Screen);
                break;
            case R.id.bBack:
                _Screen = new Intent(this, GameList.class);
                client.sendMessage(this.createXml());
                _Screen.putExtra("GameName",this.GameName);
                startActivity(_Screen);
                break;
        }
    }

    /**
     * metodo para indicar que hacer cuando se aprete el boton <back>
     */
    @Override
    public void onBackPressed(){
        _Screen = new Intent(this, GameList.class);
        client.sendMessage(this.createXml());
        _Screen.putExtra("GameName",this.GameName);
        startActivity(_Screen);
        finish();
    }
}
