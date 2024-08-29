package C14270824;

import java.util.*;

public class LibretaDeNotas {
    public static void main(String[] args) {



        Map<String, Double> libreta = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese la cantidad de alumnos: ");
        int alumnos = sc.nextInt();

        for (int i = 0; i < alumnos; i++) {
            System.out.println("Ingrese el nombre del alumno: ");
            String nombre = sc.next();
            System.out.println("Ingrese la cantidad de notas para " + nombre + ": ");
            int cantidadNotas = sc.nextInt();

            List<Integer> notas = new ArrayList<>();
            for (int j = 0; j < cantidadNotas; j++) {
                int nota;
                do {
                    System.out.println("Ingrese la nota " + (j + 1) + " para el alumno " + nombre + " (entre 0 y 10): ");
                    nota = sc.nextInt();
                    if (nota < 0 || nota > 10) {
                        System.out.println("Nota inválida. Debe estar entre 0 y 10.");
                    }
                } while (nota < 0 || nota > 10); // Repetir hasta que la nota sea válida
                notas.add(nota);
            }
            System.out.println("Nota máxima de " + nombre + ": " + Collections.max(notas));
            System.out.println("Nota mínima de " + nombre + ": " + Collections.min(notas));

            // Calcular promedio
            double suma = 0;
            for (int nota : notas) {
                suma += nota;
            }
            double promedio = suma / cantidadNotas;
            libreta.put(nombre, promedio); // Guardar el promedio en el mapa
        }

        // Menú de opciones
        int opcion = 0;
        do {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Mostrar promedio de notas de un estudiante");
            System.out.println("2. Mostrar si la nota es aprobatoria");
            System.out.println("3. Verificar si la nota está por encima del promedio del curso");
            System.out.println("4. Salir");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1: // Mostrar promedio de notas de un estudiante
                    System.out.println("Ingrese el nombre del estudiante:");
                    String nombre = sc.next();
                    if (libreta.containsKey(nombre)) {
                        System.out.println("Promedio de " + nombre + ": " + libreta.get(nombre));
                    } else {
                        System.out.println("Estudiante no encontrado.");
                    }
                    break;

                case 2: // Mostrar si la nota es aprobatoria
                    System.out.println("Ingrese el nombre del estudiante:");
                    nombre = sc.next();
                    if (libreta.containsKey(nombre)) {
                        double promedio = libreta.get(nombre);
                        String resultado = (promedio >= 5) ? "Aprobatoria" : "No aprobatoria";
                        System.out.println("La nota es: " + resultado);
                    } else {
                        System.out.println("Estudiante no encontrado.");
                    }
                    break;

                case 3: // Verificar si la nota está por encima del promedio del curso
                    double sumaPromedios = 0;
                    for (double promedio : libreta.values()) {
                        sumaPromedios += promedio;
                    }
                    double promedioCurso = sumaPromedios / libreta.size();
                    System.out.println("Promedio del curso: " + promedioCurso);

                    System.out.println("Ingrese el nombre del estudiante:");
                    nombre = sc.next();
                    if (libreta.containsKey(nombre)) {
                        double promedio = libreta.get(nombre);
                        if (promedio > promedioCurso) {
                            System.out.println("La nota de " + nombre + " está por encima del promedio del curso.");
                        } else {
                            System.out.println("La nota de " + nombre + " no está por encima del promedio del curso.");
                        }
                    } else {
                        System.out.println("Estudiante no encontrado.");
                    }
                    break;

                case 4: // Salir
                    System.out.println("Saliendo del programa.");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, seleccione nuevamente.");
                    break;
            }
        } while (opcion != 4);

        sc.close();
    }
}
