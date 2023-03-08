package app;
import dominio.*;
import Interfaz.*;
import app.*;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;




public class Main {
    public static void main(String[] args) {
        Gestor gestor = new Gestor();
        Interfaz interfaz = new Interfaz();
        boolean salir = false;
        Scanner scanner=new Scanner(System.in);

        while (!salir) {
            System.out.println("*********** Menú de opciones ***********");
            System.out.println("1. Agregar cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Consultar cliente");
            System.out.println("4. Modificar cliente");
            System.out.println("5. Eliminar cliente");
            System.out.println("6. Salir");
            System.out.println("****************************************");

            int opcion = interfaz.obtenerOpcion();
            Interfaz.borrarPantalla();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre del cliente:");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese el apellido del cliente:");
                    String apellido = scanner.nextLine();
                    System.out.println("Ingrese el DNI del cliente:");
                    String dni = scanner.nextLine();
                    gestor.agregarCliente(nombre, apellido, dni);
                    System.out.println("Cliente agregado exitosamente.");
                    break;
                case 2:
                    System.out.println("Lista de clientes:");
                    gestor.listarClientes();
                    break;
                case 3:
                    System.out.println("Ingrese el DNI del cliente a consultar:");
                    dni = scanner.nextLine();
                    gestor.consultarCliente(dni);
                    break;
                case 4:
                    System.out.println("Ingrese el DNI del cliente a modificar:");
                    dni = scanner.nextLine();
                    System.out.println("Ingrese el nuevo nombre del cliente:");
                    nombre = scanner.nextLine();
                    System.out.println("Ingrese el nuevo apellido del cliente:");
                    apellido = scanner.nextLine();
                    gestor.modificarCliente(dni, nombre, apellido);
                    System.out.println("Cliente modificado exitosamente.");
                    break;
                case 5:
                    System.out.println("Ingrese el DNI del cliente a eliminar:");
                    dni = scanner.nextLine();
                    gestor.eliminarCliente(dni);
                    System.out.println("Cliente eliminado exitosamente.");
                    break;
                case 6:
                    salir = true;
                    
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intente nuevamente.");
                    break;
            }
        }
        
        System.out.println("Saliendo...");
        
        gestor.cerrar();
    }
} 



