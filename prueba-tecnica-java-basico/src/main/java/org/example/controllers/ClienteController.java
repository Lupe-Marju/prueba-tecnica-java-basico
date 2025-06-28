package org.example.controllers;

import org.example.entities.Cliente;
import org.example.entities.Sexo;
import org.example.persistence.ClienteJPA;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class ClienteController {

    ClienteJPA clienteJPA = new ClienteJPA();
    Scanner scanner = new Scanner(System.in);

    public void agregarCliente() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        try {
            if (nombre.isBlank()) {
                throw new NullPointerException("Nombre es un requerimiento");
            }
            if (31 < nombre.length()) {
                throw new IllegalArgumentException("Nombre demasiado largo");
            }
        } catch (NullPointerException | IllegalArgumentException npe) {
            System.out.println("Error: " + npe.getMessage());
            return;
        }

        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        try {
            if (apellido.isBlank()) {
                throw new NullPointerException("Apellido es un requerimiento");
            }
            if (31 < apellido.length()) {
                throw new IllegalArgumentException("Apellido demasiado largo");
            }
        } catch (NullPointerException | IllegalArgumentException npe) {
            System.out.println("Error: " + npe.getMessage());
            return;
        }

        System.out.print("Fecha de nacimiento (yyyy-mm-dd): ");
        LocalDate fechaNacimiento;
        try {
            fechaNacimiento = LocalDate.parse(scanner.nextLine());
        } catch (DateTimeParseException npe) {
            System.out.println("Error: la fecha está en formato incorrecto");
            return;
        }

        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();
        try {
            if (telefono.isBlank()) {
                throw new NullPointerException("Telefono es un requerimiento");
            }
            if (10 < telefono.length()) {
                throw new IllegalArgumentException("Telefono demasiado largo");
            }
        } catch (NullPointerException | IllegalArgumentException npe) {
            System.out.println("Error: " + npe.getMessage());
            return;
        }

        System.out.print("Indica tu sexo (M,F,O): ");
        Sexo sexo;
        try {
            sexo = Sexo.valueOf(scanner.nextLine().toUpperCase());
        } catch (IllegalArgumentException npe) {
            System.out.println("Error: Sexo no valido. Utilizar una de las opciones");
            return;
        }

        System.out.print("Correo electrónico: ");
        String correoElectronico = scanner.nextLine();
        try {
            if (correoElectronico.isBlank()) {
                throw new NullPointerException("Correo electrónico es un requerimiento");
            }
            if (41 < correoElectronico.length()) {
                throw new IllegalArgumentException("Correo electrónico demasiado largo");
            }
        } catch (NullPointerException | IllegalArgumentException npe) {
            System.out.println("Error: " + npe.getMessage());
            return;
        }

        System.out.print("Ciudad: ");
        String ciudad = scanner.nextLine();
        try {
            if (ciudad.isBlank()) {
                throw new NullPointerException("Ciudad es un requerimiento");
            }
            if (31 < ciudad.length()) {
                throw new IllegalArgumentException("Ciudad demasiado largo");
            }
        } catch (NullPointerException | IllegalArgumentException npe) {
            System.out.println("Error: " + npe.getMessage());
            return;
        }

        Cliente cliente = new Cliente(nombre, apellido, sexo, ciudad, fechaNacimiento, telefono, correoElectronico);

        clienteJPA.agregar(cliente);
        System.out.println("Cliente agregado correctamente");

    }

    public void listarClientes() {
        List<Cliente> clientes = clienteJPA.listar();
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes");
        } else {
            System.out.println("Clientes: ");
            for (Cliente cliente1 : clientes) {
                System.out.println(cliente1);
            }
        }
    }

    public void listarClientesXCiudad(String ciudad) {
        List<Cliente> clientes = clienteJPA.listar();
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes");
        } else {
            System.out.println("Clientes: ");
            for (Cliente cliente2 : clientes) {
                if (cliente2.getCiudad().equalsIgnoreCase(ciudad)) {
                    System.out.println(cliente2);
                }
            }
        }
    }

    public void actualizarCliente(Long id) throws DateTimeParseException {
        Cliente cliente = clienteJPA.buscar(id);
        if (cliente == null) {
            System.out.println("Cliente no encontrado");
            return;
        }
        System.out.println("Complete los datos que quiere actualizar, sino dejarlos en blanco.");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        if (!nombre.isBlank()) {
            try {
                if (31 < nombre.length()) {
                    throw new IllegalArgumentException("Nombre demasiado largo");
                }
            } catch (IllegalArgumentException npe) {
                System.out.println("Error: " + npe.getMessage());
                return;
            }
                cliente.setNombre(nombre);
        }

        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        if (!apellido.isBlank()) {
            try {
            if (31 < apellido.length()) {
                throw new IllegalArgumentException("Apellido demasiado largo");
            }
        } catch (IllegalArgumentException npe){
            System.out.println("Error: " + npe.getMessage());
            return;
        }
            cliente.setApellidos(apellido);
        }

        System.out.print("Fecha de nacimiento (yyyy-mm-dd): ");
        String fecha = scanner.nextLine();
        if (!fecha.isBlank()) {
            LocalDate fechaNacimiento;
            try {
                fechaNacimiento = LocalDate.parse(fecha);
            } catch (DateTimeParseException npe) {
                System.out.println("Error: la fecha está en formato incorrecto");
                return;
            }
            cliente.setFechaNacimiento(fechaNacimiento);
        }

        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();
        if (!telefono.isBlank()) {
            try {
                if (10 < telefono.length()) {
                    throw new IllegalArgumentException("Telefono demasiado largo");
                }
            } catch (IllegalArgumentException npe){
                System.out.println("Error: " + npe.getMessage());
                return;
            }
            cliente.setTelefono(telefono);
        }

        System.out.print("Indica tu sexo (M,F,O): ");
        String sexo = scanner.nextLine().toUpperCase();
        if (!sexo.isBlank()) {
            Sexo sexoF;
            try {
                sexoF = Sexo.valueOf(sexo.toUpperCase());
            } catch (IllegalArgumentException npe) {
                System.out.println("Error: Sexo no valido. Utilizar una de las opciones");
                return;
            }
            cliente.setSexo(sexoF);
        }

        System.out.print("Correo electrónico: ");
        String correoElectronico = scanner.nextLine();
        if (!correoElectronico.isBlank()) {
            try {
                if (41 < correoElectronico.length()) {
                    throw new IllegalArgumentException("Correo electrónico demasiado largo");
                }
            } catch (IllegalArgumentException npe){
                System.out.println("Error: " + npe.getMessage());
                return;
            }
            cliente.setCiudad(correoElectronico);
        }

        System.out.print("Ciudad: ");
        String ciudad = scanner.nextLine();
        if (!ciudad.isBlank()) {
            try {
                if (30 < ciudad.length()) {
                    throw new IllegalArgumentException("Ciudad demasiado largo");
                }
            } catch (IllegalArgumentException npe){
                System.out.println("Error: " + npe.getMessage());
                return;
            }
            cliente.setCiudad(ciudad);
        }

        clienteJPA.actualizar(cliente);
        System.out.println("Cliente actualizado correctamente");
    }


    public boolean eliminarCliente(Long id) {
        return clienteJPA.eliminar(id);
    }


}
