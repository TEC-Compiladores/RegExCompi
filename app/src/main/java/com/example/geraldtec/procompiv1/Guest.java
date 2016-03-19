package com.example.geraldtec.procompiv1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Created by geraldtec on 04/03/16.
 */
public class Guest extends AppCompatActivity implements Constants{
    private Intent _Screen;
    private EditText _nameGuest;

    /**
     *
     * @param v
     */
    public void onClick(View v){
        if(v.getId()==R.id.buttoncontinue2){
            client.sendMessage(this.make_Xml());
            client.sendMessage(this.createXml());
            _Screen = new Intent(this, GameList.class );
            _Screen.putExtra("nameGuest",get_nameGuest());
            _nameGuest.setFocusable(false);
            startActivity(_Screen);
        }
    }

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guest);
        _nameGuest=((EditText)findViewById(R.id.nametext));

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

    public String get_nameGuest() {
        return _nameGuest.getText().toString();
    }

    public void set_nameGuest(String p_nameGuest) {
        this._nameGuest.setText(p_nameGuest);
    }
    public String make_Xml(){
        Document document=XML.createEmptyDoc();

        Element root=document.createElement("Request");
        document.appendChild(root);

        Element message=document.createElement("message");
        message.appendChild(document.createTextNode("NewPlayer"));
        root.appendChild(message);

        Element playerName=document.createElement("name");
        playerName.appendChild(document.createTextNode(get_nameGuest()));
        root.appendChild(playerName);

        return XML.parseToString(document);
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
}
