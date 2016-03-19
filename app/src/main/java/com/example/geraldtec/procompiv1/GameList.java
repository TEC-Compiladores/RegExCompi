package com.example.geraldtec.procompiv1;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

/**
 * Created by geraldtec on 04/03/16.
 */
public class GameList extends AppCompatActivity implements Constants{
    private int cont=1;
    private int ind=0;
    private int ind1=0;
    private Intent _Screen;
    private Intent _IN;
    private String _Link1;
    private TextView textolink1;
    private ArrayList<TextView> _gameList;
    private TextView _tv0,_tv1,_tv2,_tv3,_tv4,_tv5,_tv6,_tv7,_tv8,_tv9;
    private TextView _tv10,_tv11,_tv12,_tv13,_tv14,_tv15,_tv16,_tv17,_tv18,_tv19;
    private int _lenXml;
    private String GamePlayer;
    private boolean flag=true;

    /**
     *
     * @param pind
     */
    public void setTVList(int pind){
        (_gameList.get(pind)).setText("Change");
    }

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listajuegos);


        textolink1=(TextView) findViewById(R.id.link1textview);


        _tv0=((TextView) findViewById(R.id.tv0));
        _tv1=((TextView) findViewById(R.id.tv1));
        _tv2=((TextView) findViewById(R.id.tv2));
        _tv3=((TextView) findViewById(R.id.tv3));
        _tv4=((TextView) findViewById(R.id.tv4));
        _tv5=((TextView) findViewById(R.id.tv5));
        _tv6=((TextView) findViewById(R.id.tv6));
        _tv7=((TextView) findViewById(R.id.tv7));
        _tv8=((TextView) findViewById(R.id.tv8));
        _tv9=((TextView) findViewById(R.id.tv9));
        _tv10=((TextView) findViewById(R.id.tv10));
        _tv11=((TextView) findViewById(R.id.tv11));
        _tv12=((TextView) findViewById(R.id.tv12));
        _tv13=((TextView) findViewById(R.id.tv13));
        _tv14=((TextView) findViewById(R.id.tv14));
        _tv15=((TextView) findViewById(R.id.tv15));
        _tv16=((TextView) findViewById(R.id.tv16));
        _tv17=((TextView) findViewById(R.id.tv17));
        _tv18=((TextView) findViewById(R.id.tv18));
        _tv19=((TextView) findViewById(R.id.tv19));

        _gameList=new ArrayList<TextView>();
        _gameList.add(0,_tv0);
        _gameList.add(1,_tv1);
        _gameList.add(2,_tv2);
        _gameList.add(3,_tv3);
        _gameList.add(4,_tv4);
        _gameList.add(5,_tv5);
        _gameList.add(6,_tv6);
        _gameList.add(7,_tv7);
        _gameList.add(8,_tv8);
        _gameList.add(9,_tv9);
        _gameList.add(10,_tv10);
        _gameList.add(11,_tv11);
        _gameList.add(12,_tv12);
        _gameList.add(13,_tv13);
        _gameList.add(14,_tv14);
        _gameList.add(15,_tv15);
        _gameList.add(16,_tv16);
        _gameList.add(17,_tv17);
        _gameList.add(18, _tv18);
        _gameList.add(19, _tv19);

        while(ind<20){
            _gameList.get(ind).setText("");
            ind+=1;
        }
        String reply=null;

        long tiempoIni=System.currentTimeMillis();

        while (flag){
            long tiempoFin=System.currentTimeMillis();
            if(tiempoFin-tiempoIni>=500){
                reply = client.getMessage();
                flag=false;
            }
        }

        _IN =getIntent();
        GamePlayer=_IN.getStringExtra("nameGuest");



        fillList(reply);


    }
    /**
     *
     */
    public void fillList(String pXML){
        if(pXML.equals(null))
            return;
        Document documento=XML.parseToDocument(pXML);
        _lenXml = Integer.valueOf(documento.getFirstChild().getChildNodes().item(0).getTextContent());
        if(_lenXml==0){
            Toast.makeText(getApplicationContext(), "Game list is empty", Toast .LENGTH_SHORT).show();
        }else{
            if (_lenXml>=20){
                while(ind1<20){
                    _gameList.get(ind1).setText(documento.getFirstChild().getChildNodes().item(ind1+1).getTextContent());
                    ind1+=1;
                }
            }
            else{
                while(ind1<_lenXml){
                    _gameList.get(ind1).setText(documento.getFirstChild().getChildNodes().item(ind1+1).getTextContent());
                    ind1+=1;
                }
            }
        }
    }
    /**
     *
     */
    public String createXml(String pGame){
        Document document=XML.createEmptyDoc();

        Element root=document.createElement("Request");
        document.appendChild(root);

        Element message=document.createElement("message");
        message.appendChild(document.createTextNode("GameInfo"));
        root.appendChild(message);

        Element gamename=document.createElement("gameName");
        gamename.appendChild(document.createTextNode(pGame));
        root.appendChild(gamename);

        return XML.parseToString(document);
     }


    /**
     *
     * @param v
     */
    public void onClick(View v){
        switch (v.getId()){
            case R.id.link1textview:
                _Screen=new Intent(this, Mode.class);
                break;
            case R.id.tv0:
                _Screen=new Intent(this, GameInstanceInfo.class);
                client.sendMessage(createXml(_tv0.getText().toString()));
                _Screen.putExtra("nameGuest", GamePlayer);
                _Screen.putExtra("GameName", _tv0.getText().toString());
                startActivity(_Screen);
                break;
            case R.id.tv1:
                _Screen=new Intent(this, GameInstanceInfo.class);
                client.sendMessage(createXml(_tv1.getText().toString()));
                _Screen.putExtra("nameGuest", GamePlayer);
                _Screen.putExtra("GameName", _tv1.getText().toString());
                startActivity(_Screen);
                break;
            case R.id.tv2:
                _Screen=new Intent(this, GameInstanceInfo.class);
                client.sendMessage(createXml(_tv2.getText().toString()));
                _Screen.putExtra("nameGuest", GamePlayer);
                _Screen.putExtra("GameName", _tv2.getText().toString());
                startActivity(_Screen);
                break;
            case R.id.tv3:
                _Screen=new Intent(this, GameInstanceInfo.class);
                client.sendMessage(createXml(_tv3.getText().toString()));
                _Screen.putExtra("nameGuest", GamePlayer);
                _Screen.putExtra("GameName", _tv3.getText().toString());
                startActivity(_Screen);
                break;
            case R.id.tv4:
                _Screen=new Intent(this, GameInstanceInfo.class);
                client.sendMessage(createXml(_tv4.getText().toString()));
                _Screen.putExtra("nameGuest", GamePlayer);
                _Screen.putExtra("GameName", _tv4.getText().toString());
                startActivity(_Screen);
                break;
            case R.id.tv5:
                _Screen=new Intent(this, GameInstanceInfo.class);
                client.sendMessage(createXml(_tv5.getText().toString()));
                _Screen.putExtra("nameGuest", GamePlayer);
                _Screen.putExtra("GameName", _tv5.getText().toString());
                startActivity(_Screen);
                break;
            case R.id.tv6:
                _Screen=new Intent(this, GameInstanceInfo.class);
                client.sendMessage(createXml(_tv6.getText().toString()));
                _Screen.putExtra("nameGuest", GamePlayer);
                _Screen.putExtra("GameName", _tv6.getText().toString());
                startActivity(_Screen);
                break;
            case R.id.tv7:
                _Screen=new Intent(this, GameInstanceInfo.class);
                client.sendMessage(createXml(_tv7.getText().toString()));
                _Screen.putExtra("nameGuest", GamePlayer);
                _Screen.putExtra("GameName", _tv7.getText().toString());
                startActivity(_Screen);
                break;
            case R.id.tv8:
                _Screen=new Intent(this, GameInstanceInfo.class);
                client.sendMessage(createXml(_tv8.getText().toString()));
                _Screen.putExtra("nameGuest", GamePlayer);
                _Screen.putExtra("GameName", _tv8.getText().toString());
                startActivity(_Screen);
                break;
            case R.id.tv9:
                _Screen=new Intent(this, GameInstanceInfo.class);
                client.sendMessage(createXml(_tv9.getText().toString()));
                _Screen.putExtra("nameGuest", GamePlayer);
                _Screen.putExtra("GameName", _tv9.getText().toString());
                startActivity(_Screen);
                break;
            case R.id.tv10:
                _Screen=new Intent(this, GameInstanceInfo.class);
                client.sendMessage(createXml(_tv10.getText().toString()));
                _Screen.putExtra("nameGuest", GamePlayer);
                _Screen.putExtra("GameName", _tv10.getText().toString());
                startActivity(_Screen);
                break;
            case R.id.tv11:
                _Screen=new Intent(this, GameInstanceInfo.class);
                client.sendMessage(createXml(_tv11.getText().toString()));
                _Screen.putExtra("nameGuest", GamePlayer);
                _Screen.putExtra("GameName", _tv11.getText().toString());
                startActivity(_Screen);
                break;
            case R.id.tv12:
                _Screen=new Intent(this, GameInstanceInfo.class);
                client.sendMessage(createXml(_tv12.getText().toString()));
                _Screen.putExtra("nameGuest", GamePlayer);
                _Screen.putExtra("GameName", _tv12.getText().toString());
                startActivity(_Screen);
                break;
            case R.id.tv13:
                _Screen=new Intent(this, GameInstanceInfo.class);
                client.sendMessage(createXml(_tv13.getText().toString()));
                _Screen.putExtra("nameGuest", GamePlayer);
                _Screen.putExtra("GameName", _tv13.getText().toString());
                startActivity(_Screen);
                break;
            case R.id.tv14:
                _Screen=new Intent(this, GameInstanceInfo.class);
                client.sendMessage(createXml(_tv14.getText().toString()));
                _Screen.putExtra("nameGuest", GamePlayer);
                _Screen.putExtra("GameName", _tv14.getText().toString());
                startActivity(_Screen);
                break;
            case R.id.tv15:
                _Screen=new Intent(this, GameInstanceInfo.class);
                client.sendMessage(createXml(_tv15.getText().toString()));
                _Screen.putExtra("nameGuest", GamePlayer);
                _Screen.putExtra("GameName", _tv15.getText().toString());
                startActivity(_Screen);
                break;
            case R.id.tv16:
                _Screen=new Intent(this, GameInstanceInfo.class);
                client.sendMessage(createXml(_tv16.getText().toString()));
                _Screen.putExtra("nameGuest", GamePlayer);
                _Screen.putExtra("GameName", _tv16.getText().toString());
                startActivity(_Screen);
                break;
            case R.id.tv17:
                _Screen=new Intent(this, GameInstanceInfo.class);
                client.sendMessage(createXml(_tv17.getText().toString()));
                _Screen.putExtra("nameGuest", GamePlayer);
                _Screen.putExtra("GameName", _tv17.getText().toString());
                startActivity(_Screen);
                break;
            case R.id.tv18:
                _Screen=new Intent(this, GameInstanceInfo.class);
                client.sendMessage(createXml(_tv18.getText().toString()));
                _Screen.putExtra("nameGuest", GamePlayer);
                _Screen.putExtra("GameName", _tv18.getText().toString());
                startActivity(_Screen);
                break;
            case R.id.tv19:
                _Screen=new Intent(this, GameInstanceInfo.class);
                client.sendMessage(createXml(_tv19.getText().toString()));
                _Screen.putExtra("nameGuest",GamePlayer);
                _Screen.putExtra("GameName",_tv19.getText().toString());
                startActivity(_Screen);
                break;
        }
        if (v.getId()==R.id.link1textview){
            _Screen=new Intent(this, Mode.class);
            startActivity(_Screen);
        }
    }


    /**
     *
     */
    @Override
    public void onBackPressed(){
        _Screen=new Intent(this, Guest.class);
        startActivity(_Screen);
        finish();
    }
}
