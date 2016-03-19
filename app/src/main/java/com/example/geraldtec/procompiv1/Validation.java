package com.example.geraldtec.procompiv1;

/**
 * Created by GeraldF on 15/03/2016.
 */
public class Validation {
    public static Boolean validar(String entrada){
        byte parentesis = 0;
        String []expRegulares;

        CharSequence caracter;
        CharSequence caracterSig;
        CharSequence caracterAnt;
        expRegulares = new String[20];
        expRegulares[0]="+";
        while(!(entrada.equals(""))){
            caracter = entrada.subSequence(0, 1);
            // Validamos el siguiente valor de la cadena
            if(entrada.length()>1){
                caracterSig = entrada.subSequence(1, 2);
            }
            else{
                caracterSig="";
            }
            //---------------------------------------------------
            //Validamos las posibilidades de los parentÃ©sis
            if(caracter.equals("(")){
                parentesis++;
                for(int i=0;i<20;i++){
                    if(caracterSig.equals(expRegulares[i])){
                        return false;
                    }
                }
            }
            else if(caracter.equals(")")){
                parentesis--;
            }
            //-----------------------------------------------------
            // Se realizan las validaciones correspondientes a las expresiones regulares contenidas en el vector expRegulares.
            for(int i=0; i<20;i++){
                if(caracter.equals(expRegulares[i])){
                    if(caracterSig.equals(expRegulares[i]) | caracterSig.equals("*") | caracterSig.equals(")") | entrada.length()==1){
                        return false;
                    }
                }
            }

            entrada= entrada.substring(1); // partimos la entrada
        }
        //------------------------------------------------------------
        //Se valida la cantidad de parentÃ©sis
        if(parentesis==0){
            return true;
        }
        return false;
    }
}


