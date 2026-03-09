
package com.mycompany.proyecto1;



public class VentanaAgregar {
    
    public ventanaAgregar(){
        initComponents();
        
    }
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {
    
    
    String codigo = txtCodigo.getText();
String nombre = txtNombre.getText();
String categoria = txtCategoria.getText();
double precio = Double.parseDouble(txtPrecio.getText());
int cantidad = Integer.parseInt(txtCantidad.getText());
    

Producto nuevo = new Producto(codigo, nombre, categoria, precio, cantidad);

Inventario.productos[Inventario.totalProductos] = nuevo;
Inventario.totalProductos++;   
         
  javax.swing.JOptionPane.showMessageDialog(this, "Producto agregado correctamente");
    }
}
        
        
        
    

