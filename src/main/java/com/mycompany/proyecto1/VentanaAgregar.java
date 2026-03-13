
package com.mycompany.proyecto1;
import javax.swing.*;


public class VentanaAgregar extends JDialog {
    
        // campos de texto de fomrulario 
    private JTextField txtCodigo;
     private JTextField txtNombre;
      private JTextField txtPrecio;
       private JTextField txtCantidad;
        private JComboBox<String> comboCategoria;

   public VentanaAgregar(){
       initComponents();
          
   }
   
    // método de la interfaz 
    private void initComponents(){
        

    }
    
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        guardarProducto();
    }   
   private void guardarProducto(){
      if(txtCodigo.getText().isEmpty() || 
          txtNombre.getText().isEmpty() ||
              txtPrecio.getText().isEmpty() ||
              txtCantidad.getText().isEmpty()){
          
          JOptionPane.showMessageDialog(this, "Todos los campos deben llenarse");
        return;
      }
              
          
  
        String codigo = txtCodigo.getText();
       String nombre= txtNombre.getText();
       String categoria =  comboCategoria.getSelectedItem().toString();
       double precio = Double.parseDouble(txtPrecio.getText());
       int cantidad = Integer.parseInt(txtCantidad.getText());
       
       if(precio <= 0 || cantidad <=0){
          JOptionPane.showMessageDialog(this, "Precio y cantidad deben ser mayor a 0");
           return;
       }
       for(int i =0; i< Inventario.totalProductos; i++){
           
           if(Inventario.productos[i].codigo.equals(codigo)){
               JOptionPane.showMessageDialog(this, "El codigo ya existe");
               return;
           }
       }
       
       
       //se va a crear un nuevo producto 
            Producto nuevo = new Producto(codigo, nombre, categoria, precio, cantidad);
       
       //aqui lo vamos a guardar en inventario
       Inventario.productos[Inventario.totalProductos]= nuevo;
      Inventario.totalProductos++;
       
       JOptionPane.showMessageDialog(this, "Producto agregado correctamente");
       
       
       
   }
}
        
        
        
    

