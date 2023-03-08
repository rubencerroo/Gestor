package dominio;
import dominio.*;
import Interfaz.*;
import app.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList; 


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Gestor {
    private Clientes clientes;

    public Gestor() {
        this.clientes = new Clientes();
        clientes.cargarClientes();
    }
    

    public void agregarCliente(String nombre, String apellido, String dni) {
        clientes.agregarCliente(nombre, apellido, dni);
    }

    public void listarClientes() {
        clientes.listarClientes();
    }

    public void consultarCliente(String dni) {
        Cliente cliente = clientes.consultarCliente(dni);
        if (cliente != null) {
            System.out.println(cliente.toString());
        } else {
            System.out.println("No se encontró el cliente con DNI " + dni);
        }
    }

    public void modificarCliente(String dni, String nombre, String apellido) {
        clientes.modificarCliente(dni, nombre, apellido);
    }

    public void eliminarCliente(String dni) {
        clientes.eliminarCliente(dni);
    }
    
    public void cerrar() {
        clientes.guardarClientes(); // Agrega esta línea para guardar los clientes en el archivo antes de cerrar la aplicación
    }
    
}

