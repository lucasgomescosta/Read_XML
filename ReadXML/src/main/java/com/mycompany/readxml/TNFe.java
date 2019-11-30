/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.readxml;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;



/**
 *
 * @author lucas.costa
 */
public class TNFe {
    
     private static int somenteDigitos(String palavra) {
            String digitos = "";
            char[] letras  = palavra.toCharArray();
            for (char letra : letras) {
                if(Character.isDigit(letra)) {
                    digitos += letra;
                }
            }
            return Integer.parseInt(digitos);
    }
    
    public static void main(String[] args) throws NumberFormatException {
          
    
          Long t;
          String s = "Valor aproximado dos tributos R$ 634,51 (26,75%) Fonte IBPT";
          System.out.println(Long.parseLong(s));
       
//        String dateTimeString  = "2010-03-01T00:00:00-08:00";
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
//        Date date = df.parse(dateTimeString);
//        DateFormat d = new SimpleDateFormat("dd/MM/yyyy");
//        String di = d.format(date);
//        System.out.println(date);
//        
//          
//        String formato = "dd/MM/yyyy";
//        SimpleDateFormat formatter = new SimpleDateFormat(formato);
//        System.out.println("A data formatada é: "+ formatter.format(date));   
            

    }
       
    
}
