/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleados.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pablo
 */
public class NodoN {
    
    int cantidadH;
    String dato;
    ArrayList <NodoN> hijos;
     ;
    
  public NodoN (String dato){
  this.dato = dato;    
  this.hijos= new ArrayList<NodoN>();
  this.cantidadH=0;
      
  }  


  
  
    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public int getHijos() {
        return cantidadH;
    }
    
    public NodoN retornaNodo(){
     return this;   
    }
    
      public void aumentarHijo(NodoN nodo){
     hijos.add(nodo);
     cantidadH=hijos.size();
 } 
   
       public void verInfo(){
       System.out.println("Empleado: "+ dato);   
   }
   

   
}
