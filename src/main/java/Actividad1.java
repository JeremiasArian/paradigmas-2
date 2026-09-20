/*Una librería necesita un programa que le permita gestionar sus ventas
de sus respectivos productos.
De cada producto se registran las siguientes características:
• Código de Barras
• Nombre del producto
• Descripción
• Precio
Desarrollar una aplicación Orientada a Objetos que permita:
1) Recuperar bajo demanda la recaudación total de la librería.
2) Mostrar el subtotal de la venta.
3) Controlar la carga de datos.*/

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Actividad1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Libro> listaDeLibros = new ArrayList<>();

        System.out.println("Cargar información de libros vendidos");
        while(true) {
            Libro libro = new Libro();
            System.out.println("Ingrese el codigo de barras:");
            int i = sc.nextInt();
            if(i==0) break;
            libro.setCodigo(sc.nextInt());
            System.out.println("Ingrese el nombre del libro:");
            libro.setNombre(sc.nextLine());
            System.out.println("Ingrese la descripcion del libro:");
            libro.setDescripcion(sc.nextLine());
            System.out.println("Ingrese el precio del libro:");
            libro.setPrecio(sc.nextInt());
            listaDeLibros.add(libro);
            System.out.println("Libro agregado con exito");
        }
    }
}
