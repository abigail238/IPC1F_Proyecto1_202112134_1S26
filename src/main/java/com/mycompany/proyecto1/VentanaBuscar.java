
package com.mycompany.proyecto1;

import javax.swing.*; //Esta libreira se usa para componentes graficos como Jdialog. JTextField y JOptionPane
public class VentanaBuscar extends JDialog{
    
    //la clase se extiende JDialog para que sea una ventana secundaria
    private JTextField txtCodigo;
    
    public VentanaBuscar(){ // constructor de la ventana, se ejecuta cuando se crea la ventana 
        // sirve para construir la infterfaz grafica 
        initComponents();
    }
    
   
    // método de la interfaz 
    private void initComponents(){
    }
    
    //este metodo contiene logica para buscar el producto 
    private void buscarProducto(){
        //aqui obetenemos el texto que el usuario escribirio en el campo de txtcodigo
        String codigo = txtCodigo.getText();
        
        // este ciclo recorre todos los productos guardados 
        for(int i=0; i< Inventario.totalProductos; i ++){
             if (Inventario.productos[i].codigo.equals(codigo)){ //aqui vamos a verififcar si el codigo del producto actual es igual al codigo que el usuario ingreso 
                 
                 //si encontramos el producto, lo guardamos en una variable 
                 Producto p =Inventario.productos[i];
                 
                 //creamos un texto con toda la informacion del producto para mostrarlos a el usuario 
                 String info= "Codigo: " + p.codigo + "Nombre: " + p.nombre + "Categoria: " +p.categoria + "Precio: " + p.precio + " Stock: " + p.stock;
                 
                 
                 //mostramos la informacion del producto en un ventana 
                 JOptionPane.showMessageDialog(this, info);
                 
                 
                 // detien el metodo por que ya encontramos el producto 
                 return;
             }
        }
        // si el ciclo termina y no se encontro el producto 
        //mostramos un mensaje indicando que no exite
        JOptionPane.showMessageDialog(this, "Producto no encontrado");
    }
}
