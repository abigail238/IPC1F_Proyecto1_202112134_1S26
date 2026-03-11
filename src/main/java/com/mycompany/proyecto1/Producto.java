/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;

/**
 *
 * @author Lorena
 */
public class Producto {
    // aqui vamos a crear la estructura de datos del inventario
    // aqui solo vamos a definir la estructura del producto 
    public String codigo;
    public String nombre;
    public String categoria;
    public double precio;
    public int stock;
    
    // aqui estamos haciendo el constructor para inicializar el producto facilmente 
    
    public Producto(String codigo, String nombre, String categoria, double precio,int stock ){
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
    }
    
}
