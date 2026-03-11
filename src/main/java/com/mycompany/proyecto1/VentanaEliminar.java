
package com.mycompany.proyecto1;

import javax.swing.*;

public class VentanaEliminar extends JDialog {
    
    // campo de texto servira para que el usuario escriba el codigo del producto a buscar
    private JTextField txtCodigo;
    
    //constructor de la ventana 
    //se ejecuta cuando se crea la ventana 
    public VentanaEliminar(){
        
        //Este metodo sirve para construir la interfaz graficas 
        initComponents ();
        
    }
    private void initComponents(){
        
    }
    //Este metodo contiene la logica para buscar un producto 
    //dentro del inventario 
    private void eliminarProducto(){
        
        //aqui obtenemos el texto que el usuario escribio en el campo txtCodigo
        String codigo = txtCodigo.getText();
        
        //Recorre todos los productos guardados en el inventario 
      
        for(int i=0; i<Inventario.totalProductos; i++){
            
            //si entramos un producto con el mismo codigo 
            if(Inventario.productos[i].codigo.equals(codigo)){
                
                
                // Mostramos una confirmacion al usuario antes de eliminar 
                int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar este producto?");
                
                // si el usuario presiona si
                if(confirmacion == JOptionPane.YES_OPTION){
                    // aqui vomemos los productos una posicion hacia atras
                    //para llenar el espacio del producto eliminado
                    for(int j = i; j < Inventario.totalProductos - 1; j++){
                        
                        //El producto siguientes ocupa la poscion actual 
                        Inventario.productos[i] = Inventario.productos [j+1];
                        
                    }
                    
                    //Reducimos el contador de productos 
                   Inventario.totalProductos--;
                   
                   //Mostramos mensaje de exito
                   JOptionPane.showConfirmDialog(this, "Producto eliminado");
                   
                   return;
                }
            }
            
        }
            //Si no encontramos el producto
            JOptionPane.showConfirmDialog(this, "Producto no encontrado");
    }
    
    
    
}
