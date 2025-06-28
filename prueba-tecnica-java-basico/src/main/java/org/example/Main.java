package org.example;

import org.example.controllers.ClienteController;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClienteController controller = new ClienteController();
        int opcion;

        System.out.println("--- Bienvenido al gestor de clientes ---");

        while (true) {
            System.out.println("-----------------------");
            System.out.println("---MENÚ DEL GESTOR ---");
            System.out.println("Elija la opción que quiere realizar");
            System.out.println("-----------------------");
            System.out.println("1. Cargar un nuevo cliente");
            System.out.println("2. Listar todos los clientes");
            System.out.println("3. Actualizar un cliente");
            System.out.println("4. Eliminar un cliente");
            System.out.println("5. Buscar los clientes de una ciudad");
            System.out.println("6. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1://Cargar un nuevo cliente
                    controller.agregarCliente();
                    break;

                case 2: //Listar clientes
                    controller.listarClientes();
                    break;

                case 3: //Actualizar un cliente
                    System.out.print("ID del cliente a actualizar: ");
                    controller.actualizarCliente(scanner.nextLong());
                    break;

                case 4: //Eliminar un cliente
                    System.out.print("ID del cliente a eliminar: ");
                    System.out.println(controller.eliminarCliente(scanner.nextLong()) ? "Cliente eliminado." : "Cliente no encontrado.");
                    break;

                case 5:  //Buscar clientes por ciudad
                    System.out.print("Ciudad para buscar los clientes: ");
                    controller.listarClientesXCiudad(scanner.nextLine());
                    System.out.println("No hay más clientes en esa ciudad");
                    break;

                case 6: //Salir
                    System.out.println("Muchas gracias por utilizar el gestor");
                    System.out.println("----- ADIOS -----");
                    return;

                default: //Otro numero que no sea un opción
                    System.out.println("No ha introducido una opción válida. Por favor vuelva a intentar");
                    break;
            }
        }
    }
}