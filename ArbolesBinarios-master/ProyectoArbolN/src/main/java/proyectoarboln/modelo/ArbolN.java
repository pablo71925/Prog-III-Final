/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoarboln.modelo;

import java.io.Serializable;
import proyectoarboln.exception.ArbolNException;

/**
 *
 * @author John
 */
public class ArbolN implements Serializable {
  private NodoN raiz;

    public NodoN getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoN raiz) {
        this.raiz = raiz;
    }
  

public void adicionarNodo(Empleado dato, String identificacionPadre, NodoN ayudante)
        throws ArbolNException
{
    //si hay datos
    ///Revisar si el empleado ya existe
    //encontrar al papa
    //si el papa existe lo adiciono
    if(raiz==null)
    {
        raiz = new NodoN(dato);
    }
    else
    {
        //buscar empleado
    if(buscarNodo(dato.getIdentificacion(),raiz)==null)
    {
        //encontrar el padre
        NodoN padreEncontrado = buscarNodo(identificacionPadre, raiz);
        if(padreEncontrado!=null)
        {
        // encontro al padre
            padreEncontrado.getHijos().add(new NodoN(dato));
        }
        else
        {
        throw new ArbolNException("ojo el padre con identificaion"+identificacionPadre
        +"no existe");
        }
    }
    else
      {
        throw new ArbolNException("Ojo el empleado con identificacion"+dato.getIdentificacion()
              +"ya existe");
      }
    }
  }
    


public NodoN buscarNodo(String identificacion, NodoN ayudante)
{
    if(ayudante.getDato().getIdentificacion()==identificacion)
    {
    return ayudante;
    }
    else 
    {
    //recorrer los hijos
        for(NodoN hijo: ayudante.getHijos())
        {
        NodoN nodoEncontrado= buscarNodo(identificacion, hijo);
        if(nodoEncontrado!=null)
        {
            return nodoEncontrado;
        }
        }
    }
return null;
}

    
    

}
