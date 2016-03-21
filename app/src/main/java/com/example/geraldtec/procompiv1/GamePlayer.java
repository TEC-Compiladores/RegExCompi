package com.example.geraldtec.procompiv1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import nl.flotsam.xeger.Xeger;

/**
 * Created by GeraldF on 10/03/2016.
 */
public class GamePlayer extends AppCompatActivity implements Constants{
    private Intent _Screen;
    private Intent _IN;
    private TextView _ScreenTextView;
    private TextView _TVprimero,_TVsegundo,_TVtercero, TV_cuarto, _TVquinto;
    private String _primero,_segundo,_tercero,_cuarto,_quinto,pattern;
    private String GameName;
    private TextView _Q,_W,_E,_R,_T,_Y,_U,_I,_O,_P;
    private TextView _A,_S,_D,_F,_G,_H,_J,_K,_L,_Ñ;
    private TextView _Z,_X,_C,_V,_B,_N,_M;
    private TextView _0,_1,_2,_3,_4,_5,_6,_7,_8,_9;
    private TextView _33,_34,_35,_36,_37,_38,_39,_40,_41,_42,_43,_44,_45,_46,_47,_58,_59,_60,_61,_62,_63;
    private TextView _64,_91,_92,_93,_94,_95,_123,_124,_125,_128,_170,_167;
    private ArrayList<TextView> _ListAlphabeth;
    private String _TextScreen="";
    private boolean _boolCaps=true;
    private ArrayList<String> Samples;
    private int contJugadas=0;
    private String GamePlayer;

    /**
     *
     */
    public void loadAlphabethTextsView(){
        _Q=((TextView) findViewById(R.id.BQ));
        _W=((TextView) findViewById(R.id.BW));
        _E=((TextView) findViewById(R.id.BE));
        _R=((TextView) findViewById(R.id.BR));
        _T=((TextView) findViewById(R.id.BT));
        _Y=((TextView) findViewById(R.id.BY));
        _U=((TextView) findViewById(R.id.BU));
        _I=((TextView) findViewById(R.id.BI));
        _O=((TextView) findViewById(R.id.BO));
        _P=((TextView) findViewById(R.id.BP));
        _A=((TextView) findViewById(R.id.BA));
        _S=((TextView) findViewById(R.id.BS));
        _D=((TextView) findViewById(R.id.BD));
        _F=((TextView) findViewById(R.id.BF));
        _G=((TextView) findViewById(R.id.BG));
        _H=((TextView) findViewById(R.id.BH));
        _J=((TextView) findViewById(R.id.BJ));
        _K=((TextView) findViewById(R.id.BK));
        _L=((TextView) findViewById(R.id.BL));
        _Ñ=((TextView) findViewById(R.id.BÑ));
        _Z=((TextView) findViewById(R.id.BZ));
        _X=((TextView) findViewById(R.id.BX));
        _C=((TextView) findViewById(R.id.BC));
        _V=((TextView) findViewById(R.id.BV));
        _B=((TextView) findViewById(R.id.BB));
        _N=((TextView) findViewById(R.id.BN));
        _M=((TextView) findViewById(R.id.BM));
        _0=((TextView) findViewById(R.id.B48));
        _1=((TextView) findViewById(R.id.B49));
        _2=((TextView) findViewById(R.id.B50));
        _3=((TextView) findViewById(R.id.B51));
        _4=((TextView) findViewById(R.id.B52));
        _5=((TextView) findViewById(R.id.B53));
        _6=((TextView) findViewById(R.id.B54));
        _7=((TextView) findViewById(R.id.B55));
        _8=((TextView) findViewById(R.id.B56));
        _9=((TextView) findViewById(R.id.B57));
    }

    /**
     *
     */
    public void loadSimbolsTextsView(){
        _33=((TextView) findViewById(R.id.B33));
        _34=((TextView) findViewById(R.id.B34));
        _35=((TextView) findViewById(R.id.B35));
        _36=((TextView) findViewById(R.id.B36));
        _37=((TextView) findViewById(R.id.B37));
        _38=((TextView) findViewById(R.id.B38));
        _39=((TextView) findViewById(R.id.B39));
        _40=((TextView) findViewById(R.id.B40));
        _41=((TextView) findViewById(R.id.B41));
        _42=((TextView) findViewById(R.id.B42));
        _43=((TextView) findViewById(R.id.B43));
        _44=((TextView) findViewById(R.id.B44));
        _45=((TextView) findViewById(R.id.B45));
        _46=((TextView) findViewById(R.id.B46));
        _47=((TextView) findViewById(R.id.B47));
        _58=((TextView) findViewById(R.id.B58));
        _59=((TextView) findViewById(R.id.B59));
        _60=((TextView) findViewById(R.id.B60));
        _61=((TextView) findViewById(R.id.B61));
        _62=((TextView) findViewById(R.id.B62));
        _63=((TextView) findViewById(R.id.B63));
        _64=((TextView) findViewById(R.id.B64));
        _91=((TextView) findViewById(R.id.B91));
        _92=((TextView) findViewById(R.id.B92));
        _93=((TextView) findViewById(R.id.B93));
        _94=((TextView) findViewById(R.id.B94));
        _95=((TextView) findViewById(R.id.B95));
        _123=((TextView) findViewById(R.id.B123));
        _124=((TextView) findViewById(R.id.B124));
        _125=((TextView) findViewById(R.id.B125));
        _128=((TextView) findViewById(R.id.B128));
        _167=((TextView) findViewById(R.id.B167));
        _170=((TextView) findViewById(R.id.B170));
    }

    /**
     *
     */
    public void loadListAlphabeth(){
        _ListAlphabeth=new ArrayList<TextView>();
        _ListAlphabeth.add(0,_Q);
        _ListAlphabeth.add(1,_W);
        _ListAlphabeth.add(2,_E);
        _ListAlphabeth.add(3,_R);
        _ListAlphabeth.add(4,_T);
        _ListAlphabeth.add(5,_Y);
        _ListAlphabeth.add(6,_U);
        _ListAlphabeth.add(7,_I);
        _ListAlphabeth.add(8,_O);
        _ListAlphabeth.add(9,_P);
        _ListAlphabeth.add(10,_A);
        _ListAlphabeth.add(11,_S);
        _ListAlphabeth.add(12,_D);
        _ListAlphabeth.add(13,_F);
        _ListAlphabeth.add(14,_G);
        _ListAlphabeth.add(15,_H);
        _ListAlphabeth.add(16,_J);
        _ListAlphabeth.add(17,_K);
        _ListAlphabeth.add(18,_L);
        _ListAlphabeth.add(19,_Ñ);
        _ListAlphabeth.add(20,_Z);
        _ListAlphabeth.add(21,_X);
        _ListAlphabeth.add(22,_C);
        _ListAlphabeth.add(23,_V);
        _ListAlphabeth.add(24,_B);
        _ListAlphabeth.add(25,_N);
        _ListAlphabeth.add(26,_M);
    }

    /**
     *
     */
    public void setCaps(){
        if (_boolCaps==false){
            _ListAlphabeth.get(0).setText("Q");
            _ListAlphabeth.get(1).setText("W");
            _ListAlphabeth.get(2).setText("E");
            _ListAlphabeth.get(3).setText("R");
            _ListAlphabeth.get(4).setText("T");
            _ListAlphabeth.get(5).setText("Y");
            _ListAlphabeth.get(6).setText("U");
            _ListAlphabeth.get(7).setText("I");
            _ListAlphabeth.get(8).setText("O");
            _ListAlphabeth.get(9).setText("P");
            _ListAlphabeth.get(10).setText("A");
            _ListAlphabeth.get(11).setText("S");
            _ListAlphabeth.get(12).setText("D");
            _ListAlphabeth.get(13).setText("F");
            _ListAlphabeth.get(14).setText("G");
            _ListAlphabeth.get(15).setText("H");
            _ListAlphabeth.get(16).setText("J");
            _ListAlphabeth.get(17).setText("K");
            _ListAlphabeth.get(18).setText("L");
            _ListAlphabeth.get(19).setText("Ñ");
            _ListAlphabeth.get(20).setText("Z");
            _ListAlphabeth.get(21).setText("X");
            _ListAlphabeth.get(22).setText("C");
            _ListAlphabeth.get(23).setText("V");
            _ListAlphabeth.get(24).setText("B");
            _ListAlphabeth.get(25).setText("N");
            _ListAlphabeth.get(26).setText("M");
            _boolCaps=true;
        }else{
            _ListAlphabeth.get(0).setText("q");
            _ListAlphabeth.get(1).setText("w");
            _ListAlphabeth.get(2).setText("e");
            _ListAlphabeth.get(3).setText("r");
            _ListAlphabeth.get(4).setText("t");
            _ListAlphabeth.get(5).setText("y");
            _ListAlphabeth.get(6).setText("u");
            _ListAlphabeth.get(7).setText("i");
            _ListAlphabeth.get(8).setText("o");
            _ListAlphabeth.get(9).setText("p");
            _ListAlphabeth.get(10).setText("a");
            _ListAlphabeth.get(11).setText("s");
            _ListAlphabeth.get(12).setText("d");
            _ListAlphabeth.get(13).setText("f");
            _ListAlphabeth.get(14).setText("g");
            _ListAlphabeth.get(15).setText("h");
            _ListAlphabeth.get(16).setText("j");
            _ListAlphabeth.get(17).setText("k");
            _ListAlphabeth.get(18).setText("l");
            _ListAlphabeth.get(19).setText("ñ");
            _ListAlphabeth.get(20).setText("z");
            _ListAlphabeth.get(21).setText("x");
            _ListAlphabeth.get(22).setText("c");
            _ListAlphabeth.get(23).setText("v");
            _ListAlphabeth.get(24).setText("b");
            _ListAlphabeth.get(25).setText("n");
            _ListAlphabeth.get(26).setText("m");
            _boolCaps=false;
        }
    }

    /**
     *
     * @param v
     */
    public void onClick(View v){
        switch (v.getId()){
            case R.id.BQ:
                _TextScreen+=(_ListAlphabeth.get(0)).getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.BW:
                _TextScreen+=(_ListAlphabeth.get(1)).getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.BE:
                _TextScreen+=(_ListAlphabeth.get(2)).getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.BR:
                _TextScreen+=(_ListAlphabeth.get(3)).getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.BT:
                _TextScreen+=(_ListAlphabeth.get(4)).getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.BY:
                _TextScreen+=(_ListAlphabeth.get(5)).getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.BU:
                _TextScreen+=(_ListAlphabeth.get(6)).getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.BI:
                _TextScreen+=(_ListAlphabeth.get(7)).getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.BO:
                _TextScreen+=(_ListAlphabeth.get(8)).getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.BP:
                _TextScreen+=(_ListAlphabeth.get(9)).getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.BA:
                _TextScreen+=(_ListAlphabeth.get(10)).getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.BS:
                _TextScreen+=(_ListAlphabeth.get(11)).getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.BD:
                _TextScreen+=(_ListAlphabeth.get(12)).getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.BF:
                _TextScreen+=(_ListAlphabeth.get(13)).getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.BG:
                _TextScreen+=(_ListAlphabeth.get(14)).getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.BH:
                _TextScreen+=(_ListAlphabeth.get(15)).getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.BJ:
                _TextScreen+=(_ListAlphabeth.get(16)).getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.BK:
                _TextScreen+=(_ListAlphabeth.get(17)).getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.BL:
                _TextScreen+=(_ListAlphabeth.get(18)).getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.BÑ:
                _TextScreen+=(_ListAlphabeth.get(19)).getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.BZ:
                _TextScreen+=(_ListAlphabeth.get(20)).getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.BX:
                _TextScreen+=(_ListAlphabeth.get(21)).getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.BC:
                _TextScreen+=(_ListAlphabeth.get(22)).getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.BV:
                _TextScreen+=(_ListAlphabeth.get(23)).getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.BB:
                _TextScreen+=(_ListAlphabeth.get(24)).getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.BN:
                _TextScreen+=(_ListAlphabeth.get(25)).getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.BM:
                _TextScreen+=(_ListAlphabeth.get(26)).getText();
                setScreenPantallaCreator(_TextScreen);
                break;


            case R.id.B48:
                _TextScreen+=_0.getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.B49:
                _TextScreen+=_1.getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.B50:
                _TextScreen+=_2.getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.B51:
                _TextScreen+=_3.getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.B52:
                _TextScreen+=_4.getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.B53:
                _TextScreen+=_5.getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.B54:
                _TextScreen+=_6.getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.B55:
                _TextScreen+=_7.getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.B56:
                _TextScreen+=_8.getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.B57:
                _TextScreen+=_9.getText();
                setScreenPantallaCreator(_TextScreen);
                break;


            case R.id.B33:
                _TextScreen+=_33.getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.B34:
                _TextScreen+=_34.getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.B35:
                _TextScreen+=_35.getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.B36:
                _TextScreen+=_36.getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.B37:
                _TextScreen+=_37.getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.B38:
                _TextScreen+=_38.getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.B39:
                _TextScreen+=_39.getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.B40:
                _TextScreen+=_40.getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.B41:
                _TextScreen+=_41.getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.B42:
                _TextScreen+=_42.getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.B43:
                _TextScreen+=_43.getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.B44:
                _TextScreen+=_44.getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.B45:
                _TextScreen+=_45.getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.B46:
                _TextScreen+=_46.getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.B47:
                _TextScreen+=_47.getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.B58:
                _TextScreen+=_58.getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.B59:
                _TextScreen+=_59.getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.B60:
                _TextScreen+=_60.getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.B61:
                _TextScreen+=_61.getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.B62:
                _TextScreen+=_62.getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.B63:
                _TextScreen+="?";
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.B64:
                _TextScreen+=_64.getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.B91:
                _TextScreen+=_91.getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.B92:
                _TextScreen+=_92.getText().toString().split(".");
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.B93:
                _TextScreen+=_93.getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.B94:
                _TextScreen+=_94.getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.B95:
                _TextScreen+=_95.getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.B123:
                _TextScreen+=_123.getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.B124:
                _TextScreen+=_124.getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.B125:
                _TextScreen+=_125.getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.B128:
                _TextScreen+=_128.getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.B167:
                _TextScreen+=_167.getText();
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.B170:
                _TextScreen+=_170.getText();
                setScreenPantallaCreator(_TextScreen);
                break;


            case R.id.bSpace:
                _TextScreen+=" ";
                setScreenPantallaCreator(_TextScreen);
                break;
            case R.id.bDelete:
                setScreenPantallaCreator("");
                _TextScreen="";
                Toast.makeText(getApplicationContext(), "Delete", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bCaps:
                setCaps();
                System.out.println(_boolCaps);
                break;
            case R.id.bDeleteS:
                if (_TextScreen.length()!=0){
                    _TextScreen=_TextScreen.substring(0,_TextScreen.length()-1);
                    setScreenPantallaCreator(_TextScreen);
                }
                else{
                    System.out.println();
                }
                break;
            case R.id.bGotIt:
                if(client.checkConnection()) {
                    if (!_TextScreen.equals("")) {
                        if (contJugadas == 4) {
                            Toast.makeText(getApplicationContext(), "You lost!!", Toast.LENGTH_SHORT).show();
                            client.sendMessage(createXml(this.GameName, "GameLost"));
                            _Screen = new Intent(this, typegame.class);
                            startActivity(_Screen);
                            finish();
                        } else {
                            Boolean valid = this.validate(_TextScreen);
                            if (valid) {
                                Toast.makeText(getApplicationContext(), "You Win!!", Toast.LENGTH_SHORT).show();
                                client.sendMessage(createXml(this.GameName, "GameWin"));
                                _Screen = new Intent(this, typegame.class);
                                startActivity(_Screen);
                                finish();
                            } else {
                                client.sendMessage(mensaje());
                                Toast.makeText(getApplicationContext(), "Try again!!", Toast.LENGTH_SHORT).show();
                                contJugadas += 1;
                            }
                        }

                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "Lost connection with the server", Toast.LENGTH_SHORT).show();
                    _Screen = new Intent(this, MainActivity.class);
                    startActivity(_Screen);
                    finish();
                }


                break;
        }

    }
    /**
     *1
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
     *
     * @param pText
     */
    public void setScreenPantallaCreator(String pText){
        _ScreenTextView=(TextView) findViewById(R.id.textPantallacreador);
        _ScreenTextView.setText(pText);
    }

    /**
     *
     * @return
     */
    public String getScreenPantallaCreator(){
        _ScreenTextView=(TextView) findViewById(R.id.textPantallacreador);
        return (_ScreenTextView.getText()).toString();
    }

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameplayer);
        setScreenPantallaCreator("Welcome!!");
        _TVprimero =(TextView)findViewById(R.id.TVOpcion1);
        _TVsegundo=(TextView)findViewById(R.id.TVOpcion2);
        _TVtercero=(TextView)findViewById(R.id.TVOpcion3);
        TV_cuarto =(TextView)findViewById(R.id.TVOpcion4);
        _TVquinto =(TextView)findViewById(R.id.TVOpcion5);
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

        this.loadAlphabethTextsView();
        this.loadListAlphabeth();
        this.loadSimbolsTextsView();
        Samples=new ArrayList<String>();
    }
    /**
     *
     */
    public void generateSamples(String pPattern){
        Xeger generator=new Xeger(pPattern);
        if(Samples.size()!=0){
            Samples.clear();
        }
        for(int i=0; i<50;i++){
            String result=generator.generate();
            assert result.matches(pPattern);
            Samples.add(result);
        }
    }
    /**
     *
     */
    public Boolean validate(String pPattern){
        this.generateSamples(pPattern);
        Pattern patron=Pattern.compile(this.pattern);
        Boolean flag;
        for(int i=0;i<50;i++){
            Matcher matc=patron.matcher(Samples.get(i));
            if(matc.find()){
                if(!matc.group(0).equals(Samples.get(i))){
                    flag=false;
                    return flag;
                }
            }else{
                flag=false;
                return flag;
            }
        }
        flag=true;
        return flag;
    }

    /**
     *
     */
    @Override
    public void onBackPressed(){
        _Screen=new Intent(this, Mode.class);
        startActivity(_Screen);
        finish();
    }
}
