package ui;

import java.util.Scanner;

public class Guacamaya {

    public static Scanner reader;
    public static double[] precios;
    public static int[] unidades;

    public static void main(String[] args) {

        inicializarGlobales();
        menu();
    }

    /**
     * Descripcion: Este metodo se encarga de iniciar las variables globales
     * pre: El Scanner reader debe estar declarado
     * pos: l Scanner reader queda inicializado
    */
    public static void inicializarGlobales() {

        reader = new Scanner(System.in);

    }

    /**
     * Descripcion: Este metodo se encarga de desplegar el menu al usuario y mostrar los mensajes de resultado para cada funcionalidad
     * pre: El Scanner reader debe estar inicializado
     * pre: El arreglo precios debe estar inicializado
    */
    public static void menu() {

        System.out.println("Bienvenido a Guacamaya!");

        establecerCantidadVendida();

        boolean salir = false;

        do {

            System.out.println("\nMenu Principal:");
            System.out.println("1. Solicitar precios ($) y cantidades de cada referencia de producto vendida en el dia");
            System.out.println("2. Calcular la cantidad total de unidades vendidas en el dia");
            System.out.println("3. Calcular el precio promedio de las referencias de producto vendidas en el dia");
            System.out.println("4. Calcular las ventas totales (dinero recaudado) durante el dia");
            System.out.println("5. Consultar el numero de referencias de productos que en el dia han superado un limite minimo de ventas");
            System.out.println("6. Salir");
            System.out.println("\nDigite la opcion a ejecutar");
            int opcion = reader.nextInt();

            switch (opcion) {
                case 1:
                    solicitarDatos();
                    break;
                case 2:
                    System.out.println("\nLa cantidad total de unidades vendidas en el dia fue de: "+calcularTotalUnidadesVendidas());
                    break;
                case 3:
                    System.out.println("\nEl precio promedio de las referencias de producto vendidas en el dia fue de: "+calcularPrecioPromedio());
                    break;
                case 4:
                    System.out.println("\nLas ventas totales (dinero recaudado) durante el dia fueron: "+calcularVentasTotales());
                    break;
                case 5:
                    System.out.println("\nDigite el limite minimo de ventas a analizar");
                    double limite = reader.nextDouble();
                    System.out.println("\nDe las "+precios.length+" referencias vendidas en el dia, "+consultarReferenciasSobreLimite(limite)+" superaron el limite minimo de ventas de "+limite);
                    break;
                case 6:
                    System.out.println("\nGracias por usar nuestros servicios!");
                    salir = true;
                    reader.close();
                    break;

                default:
                    break;
            }

        } while (!salir);

    }

    /**
     * Descripcion: Este metodo se encarga de preguntar al usuario el numero de referencias de producto diferentes 
     * vendidas en el dia e inicializa con ese valor los arreglos encargados de almacenar precios y cantidades
     * pre: El Scanner reader debe estar inicializado
     * pre: Los arreglos precios y unidades deben estar declarados
     * pos: Los arreglos precios y unidades quedan inicializados
     */
    public static void establecerCantidadVendida() {

        System.out.println("\nDigite el numero de referencias de producto diferentes vendidas en el dia ");
        int referencias = reader.nextInt();

        precios = new double[referencias];
        unidades = new int[referencias];

    }

    public static void solicitarDatos(){

        for (int i = 0; i < precios.length; i++) {
            System.out.println("Referencia " + (i + 1) + ":");
            System.out.print("Ingrese el precio del producto: ");
            precios[i] = reader.nextDouble();
            System.out.print("Ingrese la cantidad vendida: ");
            unidades[i] = reader.nextInt();
        }

    }
      /**
     * Descripcion: Este metodo calcula la cantidad total de unidades vendidas en el dia
     * pre: El arreglo unidades debe estar inicializado con valores válidos
     * pos: Retorna la suma de todas las unidades vendidas
     * @return la cantidad total de unidades vendidas
     */

    public static int calcularTotalUnidadesVendidas(){
        int totalUnidades = 0;

        for (int unidades : unidades) {
            totalUnidades += unidades;
        }

        return totalUnidades;
    }
     /**
     * Descripcion: Este metodo calcula el precio promedio de las referencias de producto vendidas en el dia
     * pre: El arreglo precios debe estar inicializado con valores válidos
     * pos: Retorna el promedio de los precios de todas las referencias
     * @return el precio promedio de las referencias de producto vendidas
     */

    public static double calcularPrecioPromedio(){
        double sumaPrecios = 0;

        for (double precio : precios) {
            sumaPrecios += precio;
        }

        return sumaPrecios / precios.length;
       

    }
     /**
     * Descripcion: Este metodo calcula las ventas totales (dinero recaudado) durante el dia
     * pre: Los arreglos precios y unidades deben estar inicializados con valores válidos
     * pos: Retorna la suma del producto de precio por cantidad de cada referencia
     * @return el total de dinero recaudado durante el dia
     */

    public static double calcularVentasTotales(){
        double totalVentas = 0;

        for (int i = 0; i < precios.length; i++) {
            totalVentas += precios[i] * unidades[i];
        }

        return totalVentas;
    }
    /**
     * Descripcion: Este metodo consulta el numero de referencias de productos que en el dia han superado un limite minimo de ventas
     * pre: Los arreglos precios y unidades deben estar inicializados con valores válidos
     * pre: El parametro limite debe ser un valor positivo
     * pos: Retorna el número de referencias que superan el limite mínimo de ventas
     * @param limite el valor minimo de ventas a analizar
     * @return el numero de referencias que superan el limite
     */


    public static int consultarReferenciasSobreLimite(double limite){

        int contador = 0;

        for (int i = 0; i < precios.length; i++) {
            if (precios[i] * unidades[i] > limite) {
                contador++;
            }
        }

        return contador;
    }



}


