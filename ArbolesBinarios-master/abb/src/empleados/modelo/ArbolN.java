/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleados.modelo;

/**
 *
 * @author Pablo
 */
public class ArbolN {
    private NodoN Raiz;
    
 public ArbolN(){
     
 }   
    
 public NodoN insertRaiz(String dato){
 Raiz= new NodoN(dato);
 return Raiz;
     
 }   
public void insertar (NodoN nodo,String dato, String padre){
 NodoN nuevo = new NodoN (dato);
 
 if (nodo.getDato().equals(padre)){
   nodo.aumentarHijo(nuevo);
 }
 else{
 for(int i=0; i<nodo.getHijos(); i++){
     if(nodo.hijos.get(i).getDato().equals(padre)){
      nodo.hijos.get(i).aumentarHijo(nuevo);
     }
     
     else {
         insertar(nodo.hijos.get(i), dato, padre);
     }
 }    
 }
    
}  

public void recorrer(NodoN raiz){
raiz.verInfo();
for(int i=0; i<raiz.getHijos(); i++){
 recorrer(raiz.hijos.get(i));   
}
}




public boolean buscar(NodoN raiz, String buscar, boolean encontrado){
if(raiz.getDato().equals(buscar)){
 encontrado=true;   
}    
for(int i=0; i<raiz.getHijos();i++){
encontrado=buscar(raiz.hijos.get(i),buscar,encontrado);    
}    
return encontrado;
}



}


