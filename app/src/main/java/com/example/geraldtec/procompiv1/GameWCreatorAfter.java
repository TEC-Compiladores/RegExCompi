package com.example.geraldtec.procompiv1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.Date;
import java.util.Random;

import nl.flotsam.xeger.Xeger;

/**
 * Created by GeraldF on 11/03/2016.
 */
public class GameWCreatorAfter extends AppCompatActivity implements Constants{
    private Intent _Screen;
    private TextView _primero,_segundo,_tercero,_cuarto,_quinto, _patternView;
    private String _cadenaAleatoria;
    private Random _rL,_rN;
    private String pattern;
    private String name;
    private String gamename;
    private Intent _IN;
    private String alfabeto;

    /**
     * Metodo que ejecuta los elementos graficos presentes en un activity de Android.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamewcreatorafter);
        _primero=(TextView)findViewById(R.id.TVOpcion1);
        _segundo=(TextView)findViewById(R.id.TVOpcion2);
        _tercero=(TextView)findViewById(R.id.TVOpcion3);
        _cuarto=(TextView)findViewById(R.id.TVOpcion4);
        _quinto=(TextView)findViewById(R.id.TVOpcion5);
        _IN=getIntent();
        this.pattern=_IN.getStringExtra("pattern");
        this.name=_IN.getStringExtra("name");
        this.gamename=_IN.getStringExtra("gamename");
        this.alfabeto=_IN.getStringExtra("alfabeto");
        _primero.setText(createOptions());
        _segundo.setText(createOptions());
        _tercero.setText(createOptions());
        _cuarto.setText(createOptions());
        _quinto.setText(createOptions());
    }

    /**
     *
     * @return
     */
    public String generateXML(){
        Document document =XML.createEmptyDoc();

        Element root=document.createElement("Request");
        document.appendChild(root);

        Element message=document.createElement("message");
        message.appendChild(document.createTextNode("NewGame"));
        root.appendChild(message);

        Element game=document.createElement("Game");
        Element name=document.createElement("name");
        name.appendChild(document.createTextNode(this.gamename));
        game.appendChild(name);

        Element creator=document.createElement("creator");
        creator.appendChild(document.createTextNode(this.name));
        game.appendChild(creator);

        Element date=document.createElement("date");
        Date dat = new Date();
        date.appendChild(document.createTextNode(String.valueOf(dat.getTime())));
        game.appendChild(date);

        Element attempts=document.createElement("attempts");
        attempts.appendChild(document.createTextNode("0"));
        game.appendChild(attempts);

        Element pattern=document.createElement("pattern");
        pattern.appendChild(document.createTextNode(this.pattern));
        game.appendChild(pattern);

        Element alfabeto=document.createElement("alphabet");
        alfabeto.appendChild(document.createTextNode(this.alfabeto));
        game.appendChild(alfabeto);

        Element examples = document.createElement("Examples");
        Element exp1=document.createElement("example");
        exp1.appendChild(document.createTextNode(this._primero.getText().toString()));
        examples.appendChild(exp1);

        Element exp2=document.createElement("example");
        exp2.appendChild(document.createTextNode(this._segundo.getText().toString()));
        examples.appendChild(exp2);

        Element exp3=document.createElement("example");
        exp3.appendChild(document.createTextNode(this._tercero.getText().toString()));
        examples.appendChild(exp3);

        Element exp4=document.createElement("example");
        exp4.appendChild(document.createTextNode(this._cuarto.getText().toString()));
        examples.appendChild(exp4);

        Element exp5=document.createElement("example");
        exp5.appendChild(document.createTextNode(this._quinto.getText().toString()));
        examples.appendChild(exp5);
        game.appendChild(examples);
        root.appendChild(game);

        String result = XML.parseToString(document);

        return result;
    }
    public String createOptions(){
        Xeger generator=new Xeger(this.pattern);
        String result=generator.generate();
        assert result.matches(this.pattern);
        return result;
    }

    /**
     * metodo tipo listener para los botones cuando sean apretados
     * @param v
     */
    public void onClick(View v){
        switch (v.getId()){
            case R.id.bGotIt2:
                _Screen = new Intent(this, typegame.class );
                client.sendMessage(this.generateXML());
                startActivity(_Screen);
                finish();
                break;
            case R.id.TVOpcion1:
                _primero.setText(createOptions());
                break;
            case R.id.TVOpcion2:
                _segundo.setText(createOptions());
                break;
            case R.id.TVOpcion3:
                _tercero.setText(createOptions());
                break;
            case R.id.TVOpcion4:
                _cuarto.setText(createOptions());
                break;
            case R.id.TVOpcion5:
                _quinto.setText(createOptions());
                break;
        }
        if(v.getId()==R.id.start){
            //_Screen = new Intent(this, Connection.class );

        }
    }
    private String getCadenaAlfanumAleatoria(int longitud){
        this._cadenaAleatoria = "";
        long milis = new java.util.GregorianCalendar().getTimeInMillis();
        this._rL = new Random(milis);
        int i = 0;
        while ( i < longitud){
            char c = (char)this._rL.nextInt(255);
            if (((c >= '0' && c <='9')||(c >='A' && c <='Z'))||(c >='a' && c <='z')){
                this._cadenaAleatoria += c;
                i ++;
            }
        }
        return this._cadenaAleatoria;
    }
    private String getCadenaNumAleatoria(int longitud){
        this._cadenaAleatoria = "";
        long milis = new java.util.GregorianCalendar().getTimeInMillis();
        this._rL = new Random(milis);
        int i = 0;
        while ( i < longitud){
            char c = (char)this._rL.nextInt(255);
            if ((c >= '0' && c <='9')){
                this._cadenaAleatoria += c;
                i ++;
            }
        }
        return this._cadenaAleatoria;
    }

    /**
     * metodo para indicar que hacer cuando se aprete el boton <back>
     */
    @Override
    public void onBackPressed(){
        _Screen = new Intent(this, Creator.class );
        startActivity(_Screen);
        finish();
    }
}
