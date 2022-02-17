//package com.howtodoinjava.examples;
 package wordfinder;
 
//import java.util.*;
import java.util.Arrays;
import java.util.List;

public class Soundex 
        
{
    
  
    public static String getGode(String s) 
    {
        s =" " + s;
        char[] x = s.toUpperCase().toCharArray();
          x = Arrays.copyOf(x, x.length + 2);

         // 12345678
         // ^    ^
 
        for (int i = 0; i < x.length -1; i++) {
      
            if (String.valueOf(x[i]).equals(String.valueOf(x[i+1])))
            {x[i] = ' ';}
            else {
            
            switch (x[i]) {
            case 'T':
            case 'D': {
                String tio = String.valueOf(x[i]) +  String.valueOf(x[i+1]) + String.valueOf(x[i+2]);
                if (tio.equals("TIO")){
                    x[i] = '6';
                    break;
                }
                else {
                
                x[i] = '1';
                break;
                }
            }
 
            case 'N': {
                String mn = String.valueOf(x[i-1]) + String.valueOf(x[i]);
           
                if (mn.equals("3N")) {
                x[i] = ' ';
                break;
                }
                else {
                x[i] = '2';
                break;
                }
            }
            
            case 'M': {
                x[i] = '3';
                break;
            }
 
            case 'R': {
                x[i] = '4';
                break;
            }
 
            case 'L': {
                x[i] = '5';
                break;
            }
 
            case 'S':
            case 'C':
            case 'G':{
                String sh = String.valueOf(x[i]) + String.valueOf(x[i+1]);   
                String sio = String.valueOf(x[i]) + String.valueOf(x[i+1])+ String.valueOf(x[i+2]); 
                if (
                  //Shhhhhhh sound
                sh.equals("SH") || sh.equals("CH") || sh.equals("GE") || sio.equals("SIO") || sio.equals("CIA"))
       
                {x[i] = '6';
                break;}
                
                //Snake hissing sound
             
                else if ( sh.equals("CQ")  || x[i]=='S' ||  sh.equals("CE") || sh.equals("CI"))
                {x[i] = 'O';
                break;
                }
                else if (sh.equals("CK") ||sh.equals("GH") || sh.equals("GN"))
                {
                x[i] = ' ';
                break;
                }
                              
                else {x[i] = '7';
                break;}
                // Que sound
      

                
            }
            case 'J':{
                x[i] = '6';
                break;
            }
            case 'K':
            case 'Q':{
                String kn = String.valueOf(x[i]) + String.valueOf(x[i+1]);   
                if (kn.equals("KN"))
                {
                    x[i] = ' ';
                break;
                }
                else {
                x[i] = '7';
                break;
                }
            }
            case 'F':
            case 'V':{
                x[i] = '8';
                break;
            }
            case 'B':
            case 'P': {
                String mb = String.valueOf(x[i-1] + String.valueOf(x[i]));
                String ph = String.valueOf(x[i]) + String.valueOf(x[i+1]);
                if (mb.equals("3B") && ph != "") {
                x[i] = ' ';
                break;
                }
                else if (ph.equals("BT") || ph.equals("PT") || ph.equals("PN") ||ph.equals("PS")) {
                 x[i] = ' ';
                break;
                }
                else if (ph.equals("PH")) {
                  x[i] = '8';
                break;   
                }  
                else {
                x[i] = '9';
                break;
                        }
            }
            
            case 'Z':
            case 'X':    
                x[i] = 'O';
                break;
                
            default: {
                x[i] = ' ';
                break;
            }
            }
        }
        }
 

        String output = "";
         
            for (int i = 0; i < x.length; i++){
                output += x[i];
        }
 output = output.replaceAll("\\s+", "");
return output;
    }
}