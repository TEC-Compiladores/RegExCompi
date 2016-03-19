package com.example.geraldtec.procompiv1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by GeraldF on 15/03/2016.
 */
public class Alphabeth extends AppCompatActivity{
    private Intent _Screen;
    private Intent _IN;
    private String name,gamename;
    private ImageButton _ima1,_ima2,_ima3,_ima4,_ima5,_ima6,_ima7,_ima8;
    private TextView _Alpha;
    private String _Alphabet;
    private boolean _bol1=false,_bol2=false,_bol3=false,_bol4=false,_bol5=false,_bol6=false,_bol7=false,_bol8=false;

    /**
     * Metodo que ejecuta los elementos graficos presentes en un activity de Android.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alphabeth);
        _Alpha=(TextView)findViewById(R.id._TVAlphabet);
        _Alpha.setText("Selected Alphabet");
        _ima1=(ImageButton)findViewById(R.id.ima1);
        _ima2=(ImageButton)findViewById(R.id.ima2);
        _ima3=(ImageButton)findViewById(R.id.ima3);
        _ima4=(ImageButton)findViewById(R.id.ima4);
        _ima5=(ImageButton)findViewById(R.id.ima5);
        _ima6=(ImageButton)findViewById(R.id.ima6);
        _ima7=(ImageButton)findViewById(R.id.ima7);
        _ima8=(ImageButton)findViewById(R.id.ima8);
        _Alphabet="";
        _IN =getIntent();
        this.name= _IN.getStringExtra("name");
        this.gamename= _IN.getStringExtra("gamename");
    }

    /**
     * metodo tipo listener para los botones cuando sean apretados
     * @param v
     */
    public void onClick(View v){
        switch (v.getId()){
            case R.id.ima1:
                _Alphabet+="!·$%&/()=?¿Ç^*¨\";:_|@#¬'¡}[]{`+´-.,ºª";
                _ima1.setClickable(false);
                _Alpha.setText("You selected: Alphabet with all symbols differents to letters and numbers");
                break;
            case R.id.ima2:
                _Alphabet+="0123456789";
                _ima2.setClickable(false);
                _Alpha.setText("You selected: Alphabet with all numbers");
                break;
            case R.id.ima3:
                _Alphabet+="0123456789ABCDEFabcdef";
                _ima3.setClickable(false);
                _Alpha.setText("You selected: Alphabet with hexadecimal characters");
                break;
            case R.id.ima4:
                _Alphabet+="0123456789qwertyuiopasdfghjklñzxcvbnmQWERTYUIOPASDFGHJKLÑZXCVBNM";
                _ima4.setClickable(false);
                _Alpha.setText("You selected: Alphanumeric Alphabet");
                break;
            case R.id.ima5:
                _Alphabet+="!·$%&/()=?¿Ç^*¨\";:_|@#¬'¡}[]{`+´-.,ºª0123456789";
                _ima5.setClickable(false);
                _Alpha.setText("You selected: Alphabet with numbers and all symbols");
                break;
            case R.id.ima6:
                _Alphabet+="QWERTYUIOPASDFGHJKLÑZXCVBNM";
                _ima6.setClickable(false);
                _Alpha.setText("You selected: Uppercase Alphabet");
                break;
            case R.id.ima7:
                _Alphabet+="10";
                _ima7.setClickable(false);
                _Alpha.setText("You selected: Binary Alphabet");
                break;
            case R.id.ima8:
                _Alphabet+="qwertyuiopasdfghjklñzxcvbnm";
                _ima8.setClickable(false);
                _Alpha.setText("You selected: Lowercase Alphabet");
                break;
            case R.id.imaBoton:
                _Alpha.setText("You selected: "+_Alphabet);
                _Screen=new Intent(this, GameWCreator.class);
                _Screen.putExtra("name",name);
                _Screen.putExtra("gamename",gamename);
                _Screen.putExtra("alfabeto",_Alphabet);
                startActivity(_Screen);
                finish();
                break;
            case R.id._TVAlphabet:
                Toast.makeText(getApplicationContext(),"You cleared the screen",Toast.LENGTH_SHORT);
                _Alphabet="";
                _ima1.setClickable(true);
                _ima2.setClickable(true);
                _ima3.setClickable(true);
                _ima4.setClickable(true);
                _ima5.setClickable(true);
                _ima6.setClickable(true);
                _ima7.setClickable(true);
                _ima8.setClickable(true);
                _Alpha.setText("Selected Alphabet");
                break;
        }
    }

    /**
     * metodo para indicar que hacer cuando se aprete el boton <back>
     */
    @Override
    public void onBackPressed(){
        finish();
    }
}
