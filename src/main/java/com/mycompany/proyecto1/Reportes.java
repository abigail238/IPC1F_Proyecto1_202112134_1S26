
package com.mycompany.proyecto1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Reportes {
    
    //Este es un metodo que genera el reporte de stock en HTML
    public static void generarReportesSrock(){
        try{
            //obtenemos la fecha y hora actual del sistema 
            LocalDateTime ahora= LocalDateTime.now();
            
            //creamos el formato que pide el proyecto 
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd_MM_yyy_HH_mm_ss");
            
            // convertimos la decha actual al formato 
            String fecha= ahora.format(formato);
            
            //creamos el nombre del archivo HTML
            String nombreArchivo = fecha + "_Stock.html";
            
            //creamos el archivo para escribir el reporte 
            FileWriter archivo = new FileWriter(nombreArchivo);
            
            //aqui vamos a escribir la estructura basica del HTML
            archivo.write("<html>");
            archivo.write("<head>");
            archivo.write("<title> Reporte de stock</title>");
            archivo.write("<head>");
            archivo.write("<body>");
            
            //titulo del reporte 
            archivo.write("<h1> Reporte de Inventario</h1>");
            
            //creamos una tabla HTML 
            archivo.write("<table border ='1'>");
            
            //Encabezado de la tabla 
            archivo.write("<tr>");
            archivo.write("<th>Codigo<th>");
            archivo.write("<th>Nombre<th>");
            archivo.write("<th>Categoria<th>");
            archivo.write("<th>Precio<th>");
            archivo.write("<th>Stock<th>");
            archivo.write("</tr>");
            
            
            //recorremos todos los prodcutos almacenados en el inventario 
            for(int i =0; i<Inventario.totalProductos; i++){
                
                //guardamos el producto actual 
                Producto p = Inventario.productos[i];
                
                //creamos un fila para cada producto 
                archivo.write("<tr>");
                archivo.write("<td>" + p.codigo + "</td>");
                archivo.write("<td>" + p.nombre + "</td>");
                archivo.write("<td>" + p.categoria + "</td>");
                archivo.write("<td>" + p.precio + "</td>");
                archivo.write("<td>" + p.stock + "</td>");
                 archivo.write("</tr>");
            }
            
            //cerranos la tabla 
             archivo.write("</table>");
             
             //cerramos el body 
              archivo.write("</body>");
              
              //cerramos el HTML 
               archivo.write("</html>");
               
               //cerramos el archivo para guardar los cambios 
               archivo.close();
        }catch(IOException  e){
            
            //si ocurre un error al crear el archivo 
            System.out.println("Error al generar el reporte");
        
        }
    }
    public static void generarReporteVenta (){
        
        try{
        
            
        LocalDateTime ahora = LocalDateTime.now();

         DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss");

        String fecha = ahora.format(formato);

        String nombreArchivo= fecha + "_venta.html";
        
        FileWriter archivo = new FileWriter(nombreArchivo);
        
        archivo.write("<html>");
        archivo.write("<head>");
        archivo.write("<title>Reporte de ventas</title>");
        archivo.write("</head>");
        archivo.write("<body>");
        archivo.write("<h1> Reporte de venta</h1>");
        
        //tabla html 
        archivo.write("<tabla border ='1'>");
        
        archivo.write("<tr>");
        archivo.write("<th>Codigo</th>");
        archivo.write("<th>Cantidad</th>");
        archivo.write("<th>Total</th>");
        archivo.write("<th>Fecha</th>");
        archivo.write("</tr>");
        
        //abrimos el archivo ventas.txt para leer las ventas 
            BufferedReader lector= new BufferedReader(new FileReader("ventas.txt"));
            
            String linea;
            
            //leemos cada linea del archivo ventras.txt
            while((linea = lector.readLine()) != null){
                
                //separamos los datos usando la coma 
                String [] datos = linea.split(",");
                
                //creamos una fila de la tabla html
                archivo.write("<tr>");
                archivo.write("<td>" + datos[0] + "</td>");
                archivo.write("<td>" + datos[1] + "</td>");
                archivo.write("<td>" + datos[2] + "</td>");
                archivo.write("<td>" + datos[3] + "</td>");
                archivo.write("</tr>");
                
                
            }
            lector.close();
            
            //cerramos la tabla html 
            archivo.write("</table>");
            
            archivo.write("</body>");
            
            archivo.write("</html>");
            
            archivo.close();
        }catch(IOException e){
            
        }
            System.out.println("Erros al generar el reporte de ventas");
        }
            
}
