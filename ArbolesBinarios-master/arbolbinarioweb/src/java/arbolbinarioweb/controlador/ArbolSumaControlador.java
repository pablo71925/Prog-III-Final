/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolbinarioweb.controlador;

import arbolbinario.modeloespecial.Nodo;
import arbolbinario.modeloespecial.ArbolBinario;
import arbolbinario.modelo.excepciones.ArbolBinarioException;
import arbolbinario.modeloespecial.Dato;
import arbolbinarioweb.controlador.util.JsfUtil;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import org.primefaces.model.diagram.Connection;
import org.primefaces.model.diagram.DefaultDiagramModel;
import org.primefaces.model.diagram.Element;
import org.primefaces.model.diagram.connector.StraightConnector;
import org.primefaces.model.diagram.endpoint.DotEndPoint;
import org.primefaces.model.diagram.endpoint.EndPointAnchor;

/**
 *
 * @author Pablo
 */
@Named(value = "ArbolSumaControlador")
@SessionScoped
public class ArbolSumaControlador implements Serializable {

    /**
     * Creates a new instance of ArbolSumaControlador
     */
    
    private int numero;
    private ArbolBinario arbol;
    private DefaultDiagramModel model;
    
    @PostConstruct
    private void inicializar(){
        arbol = new ArbolBinario();
        
    }
    
    

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public ArbolBinario getArbol() {
        return arbol;
    }

    public void setArbol(ArbolBinario arbol) {
        this.arbol = arbol;
    }

    public DefaultDiagramModel getModel() {
        return model;
    }

    public void setModel(DefaultDiagramModel model) {
        this.model = model;
    }
    
    
    
    public ArbolSumaControlador() {
        
        
        
        
    }
  
    public void adicionarNodo()
    {
        try {
            arbol.adicionarNodo(new Dato(numero), arbol.getRaiz());
            pintarArbol();
        } catch (ArbolBinarioException ex) {
            JsfUtil.addErrorMessage(ex.getMessage());
        }
    }
    public void pintarArbol() {

        model = new DefaultDiagramModel();
        model.setMaxConnections(-1);
        model.setConnectionsDetachable(false);
        StraightConnector connector = new StraightConnector();
        connector.setPaintStyle("{strokeStyle:'#404a4e', lineWidth:6}");
        connector.setHoverPaintStyle("{strokeStyle:'#20282b'}");
        model.setDefaultConnector(connector);
        pintarArbol(arbol.getRaiz(), model, null, 50, 0);

    }  

    private void pintarArbol(Nodo reco, DefaultDiagramModel model, Element padre, int x, int y) {

        if (reco != null) {
            Element elementHijo = new Element(reco.getDato().getSuma() +"-"+reco.getDato().getNumero());
            elementHijo.setId(String.valueOf(reco.getDato().getNumero()));

            elementHijo.setX(String.valueOf(x) + "em");
            elementHijo.setY(String.valueOf(y) + "em");

            if (padre != null) {
                elementHijo.addEndPoint(new DotEndPoint(EndPointAnchor.TOP));
                DotEndPoint conectorPadre = new DotEndPoint(EndPointAnchor.BOTTOM);
                padre.addEndPoint(conectorPadre);
                model.connect(new Connection(conectorPadre, elementHijo.getEndPoints().get(0)));

            }

            model.addElement(elementHijo);

            pintarArbol(reco.getIzquierda(), model, elementHijo, x - 10, y + 5);
            pintarArbol(reco.getDerecha(), model, elementHijo, x + 10, y + 5);
        }
    }
    
    public void onClickRight() {
        String id = FacesContext.getCurrentInstance().getExternalContext()
                .getRequestParameterMap().get("elementId");
        System.out.println(id.replaceAll("frmArbolSuma:diagrama-",""));
        //Short.valueOf(id.replaceAll("frmMotociclista:diagrama-", ""));
    }
public void LLenarArbolSumas(arbolbinario.modelo.ArbolBinario abb){
    arbol=new ArbolBinario();
    recorrerAbbPreOrden(abb.getRaiz());
    pintarArbol();
    
}
    
public void recorrerAbbPreOrden(arbolbinario.modelo.Nodo temp){
   if(temp != null){
    try{
        arbol.adicionarNodo(new Dato (temp.getDato()), arbol.getRaiz());
        recorrerAbbPreOrden(temp.getIzquierda());
        recorrerAbbPreOrden(temp.getDerecha());
        
    }
    catch (ArbolBinarioException ex){
      JsfUtil.addErrorMessage(ex.getMessage());  
    }
   }
    
}
    
    
}
