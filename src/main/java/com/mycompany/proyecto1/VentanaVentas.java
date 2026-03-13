
package com.mycompany.proyecto1;

import javax.swing.*; 
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class VentanaVentas extends JDialog{
 
    //aqui esta la clase ventana que sera una ventana secundaria 
    private JTextField txtCodigo;
    
    //campo dende el usuario escribira la cantidad a vender 
    private JTextField txtCantidad;
    
    //constructo de la ventana 
    public VentanaVentas(){
        
        initComponents();
    }
    
    private void initComponents(){
        
    }
    //Metodo que registra las ventas 
    private void registrarVenta(){
        //leemos el codigo del producto 
        String codigo = txtCodigo.getText();
        
        //leemos la cantidad que el usuario quiere comprar 
        int cantidad = Integer.parseInt(txtCantidad.getText());
        
        //recorremos todos los productos del inventario 
        for(int i =0; i<Inventario.totalProductos; i++){
            
            //verificamos si el codigo coincide 
            if(Inventario.productos[i].codigo.equals(codigo)){
                
                //guardamos el producto encontrado 
                Producto p = Inventario.productos[i];
                
                //verificamos si hay producto en stock
                if(p.stock < cantidad){
                    
                    //si no hay sufuciente stock mostramos mensaje 
                    JOptionPane.showMessageDialog(this, "Stock no encontrado");
                    return;
                    
                }
                
                //retamos la cantidad vendida de stock 
                p.stock = p.stock - cantidad;
                
                // calculamos el total de la venta 
                double total= p.stock * cantidad;
                
                //obtenemos fecha y hora actual 
                LocalDateTime ahora = LocalDateTime.now();
                
                // formato de fecha 
                DateTimeFormatter formato= DateTimeFormatter.ofPattern("dd/MM/yy HH:MM:SS");
                
                String fecha = ahora.format(formato);
                
                //guardamos la venta en archivo 
                guardarVentanaArchivo(codigo, cantidad, total, fecha);
                
                //Mostramos confirmacion
                JOptionPane.showInternalMessageDialog(this, "Venta registrada correctamente");
                return;
             
            }
        }
        
        // si no se encuentra el producto 
        JOptionPane.showMessageDialog(this, "Producto no encontrado");
    
    }
    
    // metodo para guardar la ventana en un archivo de texto 
    private void guardarVentanaArchivo(String codigo, int cantidad, double total, String fecha){
        
        try{
            //abrimos el archivo venta.txt en modo escritura 
            FileWriter archivo = new FileWriter("ventanas.txt" , true);
            
            //escribimos los datos de la venta 
            archivo.write(codigo + "," + cantidad + "," +total+ "," + fecha + "\n" );
            
            // cerramos el archivo
            archivo.close();
        }catch(IOException e){
            //si ocurre error al escribir el archivo
            JOptionPane.showInternalMessageDialog(this, "Error al guardar la venta");
        }
        
    }
}
