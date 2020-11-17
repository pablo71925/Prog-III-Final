/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoarboln;

import javax.swing.JOptionPane;
import proyectoarboln.exception.ArbolNException;
import proyectoarboln.modelo.ArbolN;
import proyectoarboln.modelo.Ciudad;
import proyectoarboln.modelo.Empleado;

/**
 *
 * @author John
 */
public class PruebaArbolN {
    public static void main(String[] args) {
        ArbolN arbol = new ArbolN();
        Ciudad mzls= new Ciudad(1,"manizales");
        Ciudad per= new Ciudad(1,"pereira");
        
        Empleado carloaiza= new Empleado("carlos","loaiza",mzls,6000000,(byte)50,"75147236");
         Empleado esteban= new Empleado("esteba","alzate rios",per,4000000,(byte)20,"85147236");
        Empleado hoover= new Empleado("hoover","colorado",mzls,8000000,(byte)40,"12345687");
         Empleado karen= new Empleado("karen","ortegon",mzls,2000000,(byte)26,"22345687");
        try {
            arbol.adicionarNodo(carloaiza, "", arbol.getRaiz());
             arbol.adicionarNodo(esteban,carloaiza.getIdentificacion(), arbol.getRaiz());
             arbol.adicionarNodo(hoover,esteban.getIdentificacion(), arbol.getRaiz());
             arbol.adicionarNodo(karen,esteban.getIdentificacion(), arbol.getRaiz());
             
            System.out.println("Adicionado = ");
        } catch (ArbolNException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
       
    }
    
}
