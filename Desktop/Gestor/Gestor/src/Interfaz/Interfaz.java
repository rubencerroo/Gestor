package Interfaz;
import dominio.*;
import Interfaz.*;
import app.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

 
import java.util.Scanner;

public class Interfaz {

    public static void mostrarMenu() {
        System.out.println("Seleccione una opción:");
        System.out.println("1. Listar clientes");
        System.out.println("2. Consultar cliente");
        System.out.println("3. Agregar cliente");
        System.out.println("4. Modificar cliente");
        System.out.println("5. Eliminar cliente");
        System.out.println("0. Salir");
    }

    public static int obtenerOpcion() {
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();
        return opcion;
    }

    public static String obtenerDni() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el DNI del cliente:");
        String dni = scanner.nextLine();
        return dni;
    }

    public static String[] obtenerDatosCliente() {
        Scanner scanner = new Scanner(System.in);
        String[] datosCliente = new String[2];
        System.out.println("Ingrese el nombre del cliente:");
        datosCliente[0] = scanner.nextLine();
        System.out.println("Ingrese el apellido del cliente:");
        datosCliente[1] = scanner.nextLine();
        return datosCliente;
    }
    public static void borrarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    

}
