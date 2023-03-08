package dominio;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import dominio.*;
import Interfaz.*;
import app.*;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter; 
import java.io.IOException;
import java.util.ArrayList;




public class Clientes {
    private ArrayList<Cliente> clientes;

    public Clientes() {
        clientes = new ArrayList<Cliente>();
    }

    public void agregarCliente(String nombre, String apellido, String dni) {
        Cliente cliente = new Cliente(nombre, apellido, dni);
        clientes.add(cliente);
        guardarClientes();

    }

    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            for (int i = 0; i < clientes.size(); i++) {
                System.out.println(clientes.get(i).toString());
            }
        }
    }

    public Cliente consultarCliente(String dni) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getDni().equals(dni)) {
                return clientes.get(i);
            }
        }
        return null;
    }

    public void modificarCliente(String dni, String nombre, String apellido) {
        Cliente cliente = consultarCliente(dni);
        if (cliente != null) {
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            guardarClientes();
        } else {
            System.out.println("No se encontró el cliente con DNI " + dni);
        }
    }

    public void eliminarCliente(String dni) {
        Cliente cliente = consultarCliente(dni);
        if (cliente != null) {
            clientes.remove(cliente);
            guardarClientes();
        } else {
            System.out.println("No se encontró el cliente con DNI " + dni);
        }
    }

    public void guardarClientes() {
        try {
            FileWriter fileWriter = new FileWriter("clientes.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
    
            for (Cliente cliente : clientes) {
                bufferedWriter.write(cliente.getNombre() + ";" + cliente.getApellido() + ";" + cliente.getDni() + "\n");
            }
    
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error al guardar los clientes: " + e.getMessage());
        }
    }
    public void cargarClientes() {
        try {
            FileReader fileReader = new FileReader("clientes.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
    
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                String[] datos = linea.split(";");
                String nombre = datos[0];
                String apellido = datos[1];
                String dni = datos[2];
                Cliente cliente = new Cliente(nombre, apellido, dni);
                clientes.add(cliente);
            }
    
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            System.out.println("Error al cargar los clientes: " + e.getMessage());
        }
    
    }
        
    
}
