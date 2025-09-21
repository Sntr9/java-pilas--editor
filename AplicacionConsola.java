import java.util.Scanner;

public class AplicacionConsola {
    // Pila principal para las acciones realizadas (líneas de texto)
    private static Pila<String> pilaPrincipal = new Pila<>();
    // Pila secundaria para las acciones deshechas
    private static Pila<String> pilaDeshacer = new Pila<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1:
                        escribirTexto(scanner);
                        break;
                    case 2:
                        deshacerAccion();
                        break;
                    case 3:
                        rehacerAccion();
                        break;
                    case 4:
                        mostrarTextoActual();
                        break;
                    case 5:
                        System.out.println("Saliendo de la aplicación. ¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                opcion = 0; // Para continuar el bucle
            }
            System.out.println(); // Salto de línea para mejor visualización
        } while (opcion != 5);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("--- Menú de Opciones ---");
        System.out.println("1. Escribir texto");
        System.out.println("2. Deshacer última acción");
        System.out.println("3. Rehacer última acción");
        System.out.println("4. Mostrar texto actual");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void escribirTexto(Scanner scanner) {
        System.out.print("Escriba la línea de texto: ");
        String linea = scanner.nextLine();
        pilaPrincipal.push(linea);
        System.out.println("Texto agregado.");
    }

    private static void deshacerAccion() {
        if (!pilaPrincipal.isEmpty()) {
            String ultimaLinea = pilaPrincipal.pop();
            pilaDeshacer.push(ultimaLinea);
            System.out.println("Acción deshecha. Se borró: '" + ultimaLinea + "'");
        } else {
            System.out.println("No hay acciones para deshacer.");
        }
    }

    private static void rehacerAccion() {
        if (!pilaDeshacer.isEmpty()) {
            String lineaDeshecha = pilaDeshacer.pop();
            pilaPrincipal.push(lineaDeshecha);
            System.out.println("Acción rehecha. Se restauró: '" + lineaDeshecha + "'");
        } else {
            System.out.println("No hay acciones para rehacer.");
        }
    }

    private static void mostrarTextoActual() {
        if (!pilaPrincipal.isEmpty()) {
            System.out.println("Texto actual (última línea): '" + pilaPrincipal.peek() + "'");
        } else {
            System.out.println("El texto está vacío.");
        }
    }
}