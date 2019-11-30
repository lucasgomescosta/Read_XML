/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.readxml;

import java.io.File;  
import java.io.IOException;  
import java.util.Iterator;  
import java.util.List;  
import java.util.logging.Level;  
import java.util.logging.Logger;  
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import org.jdom2.Attribute;  
import org.jdom2.Document;  
import org.jdom2.Element;  
import org.jdom2.JDOMException;  
import org.jdom2.input.SAXBuilder;  

/**
 *
 * @author lucas.costa
 */

public class ReadXML {
    //classe modelo que tem os getters e seters 
    private Nfepasm nfepasm = new Nfepasm();

    public static void main (String[] args)  {  
        ReadXML lexml = new ReadXML();  
        lexml.lerarq();  
    }  
    
     private void lerarq() {  
        //Aqui você informa o nome do arquivo XML.  
        File f = new File("F:\\xml\\xmlRetorno_Thu-Oct-31-16-58-59-BOT-2019.xml");    

        //Criamos uma classe SAXBuilder que vai processar o XML  
        SAXBuilder sb = new SAXBuilder();  
  
        //Este documento agora possui toda a estrutura do arquivo.  
        Document d;  
        try {  
            d = sb.build(f);  

            //Recuperamos o elemento root  
            Element nfe = d.getRootElement();  
            //Recuperamos os atributos filhos (Attributes)  
            List atributes = nfe.getAttributes();  
            Iterator i_atr = atributes.iterator();  
  
            //Iteramos com os atributos filhos  
            while (i_atr.hasNext()) {  
                Attribute atrib = (Attribute) i_atr.next();  
                System.out.println("\nattribute de ("+nfe.getName()+"):"+ atrib.getName()+" - valor: "+atrib.getValue());  
            }  
            //Recuperamos os elementos filhos (children)  
            List elements = nfe.getChildren();  
            Iterator i = elements.iterator();  
  
        //Iteramos com os elementos filhos, e filhos do dos filhos  
            while (i.hasNext()) {  
                Element element = (Element) i.next();  
                System.out.println("element:"+ element.getName());  
                trataElement(element);  
            }
            
            //aqui vai ser chamada a classe Dao para salvar no banco de dados
            NfeDao nfedao = new NfeDao();
            nfedao.salvar(nfepasm); 
  
        } catch (JDOMException ex) {  
            Logger.getLogger(ReadXML.class.getName()).log(Level.SEVERE, null, ex);  
        }  
        catch (IOException ex) {  
            Logger.getLogger(ReadXML.class.getName()).log(Level.SEVERE, null, ex);  
        }  
  
  
    }  
  
    private void trataElement(Element element) {  
  
            //Recuperamos os atributos filhos (Attributes)  
            List atributes = element.getAttributes();  
            Iterator i_atr = atributes.iterator();  
  
            //Iteramos com os atributos filhos  
            while (i_atr.hasNext()) {  
                Attribute atrib = (Attribute) i_atr.next();  
                //pego cada campo e seto em seu respectivo em seu respectivo set
               switch (element.getName()) {
                case "infNFe":
                    if(atrib.getName().equals("Id")){
                        //cada campo eu seto 
                        nfepasm.setNfedanf(atrib.getValue().substring(3, atrib.getValue().length()));
                        System.out.println(atrib.getName()+" com valor: "+atrib.getValue().substring(3, atrib.getValue().length()));
                    } else if(atrib.getName().equals("versao")){
                        System.out.println(atrib.getName()+" com valor: "+atrib.getValue());
                    }
                    break;
                case "retProc":
                    if(atrib.getName().equals("NSUAN")){
                        System.out.println(atrib.getName()+" com valor: "+atrib.getValue());
                    } else if(atrib.getName().equals("NSU")){
                        System.out.println(atrib.getName()+" com valor: "+atrib.getValue());
                    }
                    break;
                }
//                System.out.println("\nattribute de ("+element.getName()+"):"+ atrib.getName()+" - valor: "+atrib.getValue());  
            }  
        //Recuperamos os elementos filhos (children)  
        List elements = element.getChildren();  
        Iterator it = elements.iterator();  
  
        //Iteramos com os elementos filhos, e filhos do dos filhos  
        while (it.hasNext()) {  
            Element el = (Element) it.next();  //mexer aqui
            switch(element.getName()) {
                case "ide":
                    if(el.getName().equals("nNF")){
                        System.out.println(el.getName()+" com valor: "+el.getValue());
                    } else if(el.getName().equals("serie")){
                        System.out.println(el.getName()+" com valor: "+el.getValue());
                    } else if(el.getName().equals("dhEmi")){
                        System.out.println(el.getName()+" com valor: "+el.getValue());
                    } else if(el.getName().equals("mod")) {
                        System.out.println(el.getName()+" com valor: "+el.getValue());
                    } else if(el.getName().equals("tpNF")) {
                        System.out.println(el.getName()+" com valor: "+el.getValue());
                    } else if(el.getName().equals("natOp")) {
                        System.out.println(el.getName()+" com valor: "+el.getValue());
                    } else if(el.getName().equals("tpEmis")) {
                        System.out.println(el.getName()+" com valor: "+el.getValue());
                    } else if(el.getName().equals("finNFe")) {
                        System.out.println(el.getName()+" com valor: "+el.getValue());
                    } else if(el.getName().equals("idDest")) {
                        System.out.println(el.getName()+" com valor: "+el.getValue());
                    } else if(el.getName().equals("indFinal")) {
                        System.out.println(el.getName()+" com valor: "+el.getValue());
                    } 
                    break;
                case "emit":
                    if(el.getName().equals("xNome")){
                        System.out.println(el.getName()+" com valor: "+el.getValue());
                    } else if(el.getName().equals("CNPJ")) {
                        System.out.println(el.getName()+" com valor: "+el.getValue());                        
                    } 
                    break;
                case "enderEmit":     
                     if(el.getName().equals("xLgr")){
                        System.out.println(el.getName()+" com valor: "+el.getValue());                                                   
                     } else if(el.getName().equals("xBairro")){
                        System.out.println(el.getName()+" com valor: "+el.getValue());                                                   
                     } else if(el.getName().equals("nro")){
                        System.out.println(el.getName()+" com valor: "+el.getValue());                                                   
                     } else if(el.getName().equals("xMun")){
                        System.out.println(el.getName()+" com valor: "+el.getValue());                                                   
                     } else if(el.getName().equals("cMun")){
                        System.out.println(el.getName()+" com valor: "+el.getValue());                                                   
                     } else if(el.getName().equals("UF")){
                        System.out.println(el.getName()+" com valor: "+el.getValue());                                                   
                     } 
                    
                    break;
                case "dest": 
                    if(el.getName().equals("IE")){
                       System.out.println(el.getName()+" com valor: "+el.getValue());                                                   
                    } else if(el.getName().equals("xNome")){
                       System.out.println(el.getName()+" com valor: "+el.getValue());                                                   
                    } else if(el.getName().equals("indIEDest")){
                       System.out.println(el.getName()+" com valor: "+el.getValue());                                                   
                    } else if(el.getName().equals("CNPJ")){
                       System.out.println(el.getName()+" com valor: "+el.getValue());                                                   
                    }
                    break;
                case "enderDest":
                    if(el.getName().equals("xLgr")){
                       System.out.println(el.getName()+" com valor: "+el.getValue());                                                   
                    } else if(el.getName().equals("xBairro")){
                       System.out.println(el.getName()+" com valor: "+el.getValue());                                                   
                    } else if(el.getName().equals("nro")){
                       System.out.println(el.getName()+" com valor: "+el.getValue());                                                   
                    } else if(el.getName().equals("xMun")){
                       System.out.println(el.getName()+" com valor: "+el.getValue());                                                   
                    } else if(el.getName().equals("cMun")){
                       System.out.println(el.getName()+" com valor: "+el.getValue());                                                   
                    } else if(el.getName().equals("UF")){
                       System.out.println(el.getName()+" com valor: "+el.getValue());                                                   
                    }
                    
                    break;
                case "ICMSTot": 
                    if(el.getName().equals("vBC")){
                       System.out.println(el.getName()+" com valor: "+el.getValue());                                                   
                    } else if(el.getName().equals("vICMS")){
                       System.out.println(el.getName()+" com valor: "+el.getValue());                                                   
                    } else if(el.getName().equals("vBCST")){
                       System.out.println(el.getName()+" com valor: "+el.getValue());                                                   
                    } else if(el.getName().equals("vST")){
                       System.out.println(el.getName()+" com valor: "+el.getValue());                                                   
                    } else if(el.getName().equals("vProd")){
                       System.out.println(el.getName()+" com valor: "+el.getValue());                                                   
                    } else if(el.getName().equals("vFrete")){
                       System.out.println(el.getName()+" com valor: "+el.getValue());                                                   
                    } else if(el.getName().equals("vSeg")){
                       System.out.println(el.getName()+" com valor: "+el.getValue());                                                   
                    } else if(el.getName().equals("vOutro")){
                       System.out.println(el.getName()+" com valor: "+el.getValue());                                                   
                    } else if(el.getName().equals("vIPI")){
                       System.out.println(el.getName()+" com valor: "+el.getValue());                                                   
                    } else if(el.getName().equals("vNF")){
                       System.out.println(el.getName()+" com valor: "+el.getValue());                                                   
                    } else if(el.getName().equals("vDesc")){
                       System.out.println(el.getName()+" com valor: "+el.getValue());                                                   
                    } else if(el.getName().equals("vICMSDeson")){
                       System.out.println(el.getName()+" com valor: "+el.getValue());                                                   
                    } else if(el.getName().equals("vFCPUFDest")){
                       System.out.println(el.getName()+" com valor: "+el.getValue());                                                   
                    } else if(el.getName().equals("vICMSUFDest")){
                       System.out.println(el.getName()+" com valor: "+el.getValue());                                                   
                    } else if(el.getName().equals("vICMSUFRemet")){
                       System.out.println(el.getName()+" com valor: "+el.getValue());                                                   
                    } else if(el.getName().equals("vFCPUFDest")){
                       System.out.println(el.getName()+" com valor: "+el.getValue());                                                   
                    }
                    
                    break;
                case "vol":
                    if(el.getName().equals("pesoB")){
                       System.out.println(el.getName()+" com valor: "+el.getValue());                                                   
                    }
                    
                    break;
                case "transp": 
                    if(el.getName().equals("modFrete")){
                       System.out.println(el.getName()+" com valor: "+el.getValue());                                                   
                    }
                    break;
                case "infAdic":
                    if(el.getName().equals("infCpl")){
                        
                        System.out.println(el.getName()+" com valor: "+somenteDigitos(el.getValue()));
                    }
                    
                    break;
                case "prod":
                    if(el.getName().equals("CFOP")){
                        System.out.println(el.getName()+" com valor: "+el.getValue());
                    }
                    break;

            }
     //       System.out.println("element("+element.getName()+"):"+ el.getName()+" - Valor: "+el.getText());  
                    

            trataElement(el);  
        }  
    }
    
    private int somenteDigitos(String palavra) {
    String digitos = "";
    char[] letras  = palavra.toCharArray();
    for (char letra : letras) {
        if(Character.isDigit(letra)) {
            digitos += letra;
        }
    }
    return Integer.parseInt(digitos);
} 
    

}
