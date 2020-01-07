/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.readxml;

import java.io.File;  
import java.io.IOException;  
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
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
   
    public static void main (String[] args) throws ParseException  {  
        ReadXML lexml = new ReadXML();  
        lexml.lerarq();  
    }  
    
     private void lerarq() throws ParseException {  
        //Aqui você informa o nome do arquivo XML.  
        
        File arquivos[];
        File diretorio = new File("seu_diretorio");
        arquivos = diretorio.listFiles();

        for(int i1 = 0; i1 < arquivos.length; i1++){
            //Criamos uma classe SAXBuilder que vai processar o XML  
            SAXBuilder sb = new SAXBuilder();  
            System.out.println("cont: "+i1);
            //Este documento agora possui toda a estrutura do arquivo.  
            Document d;  
            try {  
                d = sb.build(arquivos[i1]);  

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

            } catch (JDOMException ex) {  
                Logger.getLogger(ReadXML.class.getName()).log(Level.SEVERE, null, ex);  
            }  
            catch (IOException ex) {  
                Logger.getLogger(ReadXML.class.getName()).log(Level.SEVERE, null, ex);  
            }  
            
            System.out.println("-----------------------------------------------------------");
        }
        //File f = new File("C:\\Users\\lucas.costa\\Videos\\Notas\\t.xml");    

       
  
  
    }  
  
    private String getDateTime() { 
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
        System.out.println(dateFormat);
	Date date = new Date(); 
	return dateFormat.format(date); 
    }
    
    private void trataElement(Element element) throws ParseException {  
  
            //Recuperamos os atributos filhos (Attributes)  
            List atributes = element.getAttributes();  
            Iterator i_atr = atributes.iterator();  
  
            //Iteramos com os atributos filhos  
            while (i_atr.hasNext()) {  
                Attribute atrib = (Attribute) i_atr.next();  
                
            /*   switch (element.getName()) {
                case "infNFe":
                    if(atrib.getName().equals("Id")){
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
                case "det":
                    if (atrib.getName().equals("nItem")) {
                         System.out.println(atrib.getName()+" com valor: "+atrib.getValue());
                    }
                    
                    break;   
                }*/
               /* Date d = new Date();
                Calendar c = Calendar.getInstance();
                String dStr = DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);  
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                Date date = df.parse(dStr);
                System.out.println("Data: "+date);
                String Hora = ""+c.get(Calendar.HOUR)+":"+c.get(Calendar.MINUTE)+":"+c.get(Calendar.SECOND);
                System.out.println("Hora: "+Hora);*/
                System.out.println("\nattribute de ("+element.getName()+"):"+ atrib.getName()+" - valor: "+atrib.getValue());  
               
            }  
        //Recuperamos os elementos filhos (children)  
        List elements = element.getChildren();  
        Iterator it = elements.iterator();  
  
        //Iteramos com os elementos filhos, e filhos do dos filhos  
        while (it.hasNext()) {  
            Element el = (Element) it.next();  //mexer aqui
           /* switch(element.getName()) {
                case "ide":
                    if(el.getName().equals("nNF")){
                        System.out.println(el.getName()+" com valor: "+el.getValue());
                    } else if(el.getName().equals("serie")){
                        System.out.println(el.getName()+" com valor: "+el.getValue());
                    } else if(el.getName().equals("dhEmi")){
                        String aux = el.getValue().substring(0, 10);
                        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                        Date date = df.parse(aux);
                        System.out.println(el.getName()+" com valor: "+date);
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
                 case "prod":
                    if (el.getName().equals("cProd")) {
                       System.out.println(el.getName()+" com valor: "+el.getValue());  
                    } else if (el.getName().equals("cEAN")) {
                       System.out.println(el.getName()+" com valor: "+el.getValue());  
                    } else if (el.getName().equals("xProd")) {
                       System.out.println(el.getName()+" com valor: "+el.getValue());  
                    } else if (el.getName().equals("NCM")) {
                       System.out.println(el.getName()+" com valor: "+el.getValue());  
                    } else if (el.getName().equals("CFOP")) {
                       System.out.println(el.getName()+" com valor: "+el.getValue());  
                    } else if (el.getName().equals("vProd")) {
                       System.out.println(el.getName()+" com valor: "+el.getValue());  
                    } else if (el.getName().equals("uTrib")) {
                       System.out.println(el.getName()+" com valor: "+el.getValue());  
                    } else if (el.getName().equals("qTrib")) {
                       System.out.println(el.getName()+" com valor: "+el.getValue());  
                    } else if(el.getName().equals("vDesc")){
                        System.out.println(el.getName()+" com valor: "+el.getValue());
                    }
                    
                    System.out.println("To aqui");       
                    break;
                 case "veicProd":
                     if (el.getName().equals("tpOp")) {
                       System.out.println(el.getName()+" com valor: "+el.getValue());  
                    } else if (el.getName().equals("chassi")) {
                       System.out.println(el.getName()+" com valor: "+el.getValue());  
                    } else if (el.getName().equals("pot")) {
                       System.out.println(el.getName()+" com valor: "+el.getValue());  
                    } else if (el.getName().equals("cilin")) {
                       System.out.println(el.getName()+" com valor: "+el.getValue());  
                    } else if (el.getName().equals("nSerie")) {
                       System.out.println(el.getName()+" com valor: "+el.getValue());  
                    } else if (el.getName().equals("tpComb")) {
                       System.out.println(el.getName()+" com valor: "+el.getValue());  
                    } else if (el.getName().equals("nMotor")) {
                       System.out.println(el.getName()+" com valor: "+el.getValue());  
                    } else if (el.getName().equals("anoMod")) {
                       System.out.println(el.getName()+" com valor: "+el.getValue());  
                    } else if (el.getName().equals("anoMod")) {
                       System.out.println(el.getName()+" com valor: "+el.getValue());  
                    } else if (el.getName().equals("anoFab")) {
                       System.out.println(el.getName()+" com valor: "+el.getValue());  
                    } else if (el.getName().equals("tpVeic")) {
                       System.out.println(el.getName()+" com valor: "+el.getValue());  
                    } else if (el.getName().equals("espVeic")) {
                       System.out.println(el.getName()+" com valor: "+el.getValue());  
                    } else if (el.getName().equals("condVeic")) {
                       System.out.println(el.getName()+" com valor: "+el.getValue());  
                    }
                     
                    break;
                    
                 case "med":
                    if (el.getName().equals("nLote")) {
                       System.out.println(el.getName()+" com valor: "+el.getValue());                                                   
                    } else if (el.getName().equals("qLote")) {
                       System.out.println(el.getName()+" com valor: "+el.getValue());                                                   
                    } else if (el.getName().equals("dFab")) {
                       System.out.println(el.getName()+" com valor: "+el.getValue());                                                   
                    } else if (el.getName().equals("dVal")) {
                       System.out.println(el.getName()+" com valor: "+el.getValue());                                                   
                    } else if (el.getName().equals("vPMC")) {
                       System.out.println(el.getName()+" com valor: "+el.getValue());                                                   
                    } 
                     
                    break;
                     
                case "ICMS00":
                    if (el.getName().equals("orig")) {
                       System.out.println(el.getName()+" com valor: "+el.getValue());                                                   
                    } else if (el.getName().equals("modBC")) {
                       System.out.println(el.getName()+" com valor: "+el.getValue());                                                   
                    } else if (el.getName().equals("vBC")) {
                       System.out.println(el.getName()+" com valor: "+el.getValue());  
                    } else if (el.getName().equals("pICMS")) {
                       System.out.println(el.getName()+" com valor: "+el.getValue());  
                    } else if (el.getName().equals("vICMS")) {
                       System.out.println(el.getName()+" com valor: "+el.getValue());                         
                    } 

                   break;
                case "ICMS40":
                    if(el.getName().equals("motDesICMS")){
                       System.out.println(el.getName()+" com valor: "+el.getValue());                                                   
                    }

                break;
            
                case "ICMS60":
                    if(el.getName().equals("vBCSTRet")){
                        System.out.println(el.getName()+" com valor: "+el.getValue());                                                   
                    } else if(el.getName().equals("vICMSSTRet")){
                        System.out.println(el.getName()+" com valor: "+el.getValue());                                                   
                    }

                break;
            
                case "ICMSSN102":
                    if(el.getName().equals("CSOSN")){
                        System.out.println(el.getName()+" com valor: "+el.getValue());                                                   
                    }

                break;

                 case "ICMSSN101":
                    if(el.getName().equals("pCredSN")){
                        System.out.println(el.getName()+" com valor: "+el.getValue());                                                   
                    } else if(el.getName().equals("vCredICMSSN")){
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
                        
                        System.out.println(el.getName()+" com valor: "+el.getValue());
                    }
                    
                    break;


            }*/
            System.out.println("element("+element.getName()+"):"+ el.getName()+" - Valor: "+el.getText());                
            trataElement(el);  
        }  
    }
    

    

}
