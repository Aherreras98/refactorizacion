package com.adrian;

/**
 * Clase que representa un cajero automático con operaciones básicas.
 * @author Adrián Herrera
 * @version 2.0
 * @since 18/03/2025
 * @see java.util.Scanner
 */
public class Cajero {
    public double saldo;
    double totalIngresos;
    double totalRetiros;
    int numIngresos;
    int numRetiros;

    /**
     * Constructor por defecto que inicializa los atributos del cajero.
     * @author Adrián Herrera
     * @version 2.0
     * @since 18/03/2025
     */
    public Cajero() {
        this.saldo = 0.0;
        this.totalIngresos = 0.0;
        this.totalRetiros = 0.0;
        this.numIngresos = 0;
        this.numRetiros = 0;
    }

    public void metodoInutil() {}

    /**
     * Controla el flujo principal del programa, mostrando el menú y gestionando las opciones seleccionadas.
     * @throws java.util.InputMismatchException Si se ingresa un valor no numérico en las opciones del menú.
     * @author Adrián Herrera
     * @version 2.0
     * @since 18/03/2025
     * @see java.util.Scanner
     */
    public void run() {
        boolean salir = false;
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        while (!salir) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    consultarSaldo();
                    break;
                case 2:
                    depositarDinero(scanner);
                    break;
                case 3:
                    retirarDinero(scanner);
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
                    break;
            }
        }

        mostrarResumen();
    }

    public void mostrarMenu() {
        System.out.println("Cajero Automático:");
        System.out.println("1. Consultar saldo");
        System.out.println("2. Depositar dinero");
        System.out.println("3. Retirar dinero");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public void consultarSaldo() {
        System.out.println("Su saldo actual es: " + saldo + " euros");
    }

    /**
     * Permite depositar una cantidad válida de dinero de la cuenta.
     * @param scanner Objeto para leer la entrada del usuario.
     * @throws java.util.InputMismatchException Si la cantidad ingreasada no es un número válido.
     * @author Adrián Herrera
     * @version 2.0
     * @since 18/03/2025
     */
    public void depositarDinero(java.util.Scanner scanner) {
        System.out.print("Ingrese la cantidad de dinero a depositar: ");
        double monto = scanner.nextDouble();
        scanner.nextLine();

        if (monto > 0) {
            saldo += monto;
            totalIngresos += monto;
            numIngresos++;
            System.out.println("Depósito realizado exitosamente. Saldo actual: " + saldo + " euros");
        } else {
            System.out.println("La cantidad ingresada no es válida.");
        }
    }

    /**
     * Permite retirar una cantidad válida de dinero de la cuenta, verificando fondos suficientes.
     * @param scanner Objeto para leer la entrada del usuario.
     * @throws java.util.InputMismatchException Si la cantidad ingreasada no es un número válido.
     * @author Adrián Herrera
     * @version 2.0
     * @since 18/03/2025
     */
    public void retirarDinero(java.util.Scanner scanner) {
        System.out.print("Ingrese la cantidad de dinero a retirar: ");
        double monto = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea

        if (monto > 0 && saldo >= monto) {
            saldo -= monto;
            totalRetiros += monto;
            numRetiros++;
            System.out.println("Retiro realizado exitosamente. Saldo actual: " + saldo + " euros");
        } else {
            System.out.println("No hay saldo suficiente.");
        }
    }

    public void mostrarResumen() {
        System.out.println("\nResumen de Uso del Cajero:");
        System.out.println("Total de ingresos: " + totalIngresos + " euros");
        System.out.println("Total de retiros: " + totalRetiros + " euros");
        System.out.println("Número de ingresos: " + numIngresos);
        System.out.println("Número de retiros: " + numRetiros);
        System.out.println("Saldo final: " + saldo + " euros");
    }

    /**
     * Método de ejecución del programa.
     * @param args Argumentos de línea de comandos (no utilizados en este programa).
     * @author Adrián Herrera
     * @version 2.0
     * @since 18/03/2025
     */
    public static void main(String[] args) {
        Cajero cajero = new Cajero();
        cajero.run();
    }
}