package org.example.vista;

import org.example.dao.AlumnoDAO;
import org.example.dao.ProfesorDAO;
import org.example.modelo.Alumno;
import org.example.modelo.PersonaUT;
import org.example.modelo.Profesor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Menu {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    AlumnoDAO alumnoDAO = new AlumnoDAO();
    ProfesorDAO profesorDAO = new ProfesorDAO();

    private void registrarAlumno() {
        try {
            Alumno alumno = new Alumno();

            System.out.println("Número de expediente:");
            alumno.setNumExpediente(Integer.parseInt(br.readLine()));

            System.out.println("Nombre:");
            alumno.setNombre(br.readLine());

            System.out.println("CURP:");
            alumno.setCurp(br.readLine());

            System.out.println("Edad:");
            alumno.setEdad(Integer.parseInt(br.readLine()));

            System.out.println("Carrera:");
            alumno.setCarrera(br.readLine());

            System.out.println("Cuatrimestre:");
            alumno.setCuatrimestres(Integer.parseInt(br.readLine()));

            alumnoDAO.nuevoAlumno(alumno);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void listarAlumnos() {
        ArrayList<Alumno> alumnos = alumnoDAO.extraerAlumnos();

        System.out.println("\n--- ALUMNOS ---");

        for (Alumno alumno : alumnos) {
            System.out.println(alumno);
        }
    }

    private void buscarAlumno() {
        try {

            System.out.println("Número de expediente:");
            int numero = Integer.parseInt(br.readLine());

            Alumno alumno = alumnoDAO.buscarAlumno(numero);

            if (alumno != null) {
                System.out.println(alumno);
            } else {
                System.out.println("Alumno no encontrado");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void modificarAlumno() {
        try {

            Alumno alumno = new Alumno();

            System.out.println("Número de expediente:");
            alumno.setNumExpediente(Integer.parseInt(br.readLine()));

            System.out.println("Nuevo nombre:");
            alumno.setNombre(br.readLine());

            System.out.println("Nueva CURP:");
            alumno.setCurp(br.readLine());

            System.out.println("Nueva edad:");
            alumno.setEdad(Integer.parseInt(br.readLine()));

            System.out.println("Nueva carrera:");
            alumno.setCarrera(br.readLine());

            System.out.println("Nuevo cuatrimestre:");
            alumno.setCuatrimestres(Integer.parseInt(br.readLine()));

            alumnoDAO.actualizarAlumno(alumno);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void eliminarAlumno() {
        try {

            Alumno alumno = new Alumno();

            System.out.println("Número de expediente:");
            alumno.setNumExpediente(Integer.parseInt(br.readLine()));

            alumnoDAO.eliminarAlumno(alumno);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    private void registrarProfesor() {
        try {
            Profesor profesor = new Profesor();

            System.out.println("Número de empleado:");
            profesor.setNumEmpleado(Integer.parseInt(br.readLine()));

            System.out.println("Nombre:");
            profesor.setNombre(br.readLine());

            System.out.println("CURP:");
            profesor.setCurp(br.readLine());

            System.out.println("Edad:");
            profesor.setEdad(Integer.parseInt(br.readLine()));

            System.out.println("Puesto:");
            profesor.setPuesto(br.readLine());

            System.out.println("Cédula profesional:");
            profesor.setCedulaProfesional(br.readLine());

            profesorDAO.nuevoProfesor(profesor);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void listarProfesores() {

        ArrayList<Profesor> profesores = profesorDAO.extraerProfesores();

        System.out.println("\n--- PROFESORES ---");

        for (Profesor profesor : profesores) {
            System.out.println(profesor);
        }
    }

    private void buscarProfesor() {

        try {

            System.out.println("Número de empleado:");
            int numero = Integer.parseInt(br.readLine());

            Profesor profesor = profesorDAO.buscarProfesor(numero);

            if (profesor != null) {
                System.out.println(profesor);
            } else {
                System.out.println("Profesor no encontrado");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void modificarProfesor() {

        try {

            Profesor profesor = new Profesor();

            System.out.println("Número de empleado:");
            profesor.setNumEmpleado(Integer.parseInt(br.readLine()));

            System.out.println("Nuevo nombre:");
            profesor.setNombre(br.readLine());

            System.out.println("Nueva CURP:");
            profesor.setCurp(br.readLine());

            System.out.println("Nueva edad:");
            profesor.setEdad(Integer.parseInt(br.readLine()));

            System.out.println("Nuevo puesto:");
            profesor.setPuesto(br.readLine());

            System.out.println("Nueva cédula profesional:");
            profesor.setCedulaProfesional(br.readLine());

            profesorDAO.actualizarProfesor(profesor);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void eliminarProfesor() {

        try {

            Profesor profesor = new Profesor();

            System.out.println("Número de empleado:");
            profesor.setNumEmpleado(Integer.parseInt(br.readLine()));

            profesorDAO.eliminarProfesor(profesor);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void mostrarComunidadUniversitaria() {

        ArrayList<PersonaUT> comunidad = new ArrayList<>();

        comunidad.addAll(alumnoDAO.extraerAlumnos());
        comunidad.addAll(profesorDAO.extraerProfesores());

        System.out.println("\n--- COMUNIDAD UNIVERSITARIA ---");

        for (PersonaUT persona : comunidad) {
            System.out.println(persona);
            System.out.println();
        }
    }public void menu() {

        int opcion;

        do {

            try {

                System.out.println("\n===== UNIVERSIDAD =====");
                System.out.println("1. Registrar alumno");
                System.out.println("2. Listar alumnos");
                System.out.println("3. Buscar alumno");
                System.out.println("4. Modificar alumno");
                System.out.println("5. Eliminar alumno");
                System.out.println("6. Registrar profesor");
                System.out.println("7. Listar profesores");
                System.out.println("8. Buscar profesor");
                System.out.println("9. Modificar profesor");
                System.out.println("10. Eliminar profesor");
                System.out.println("11. Mostrar comunidad universitaria");
                System.out.println("12. Salir");
                System.out.print("Seleccione una opción: ");

                opcion = Integer.parseInt(br.readLine());

                switch (opcion) {

                    case 1:
                        registrarAlumno();
                        break;

                    case 2:
                        listarAlumnos();
                        break;

                    case 3:
                        buscarAlumno();
                        break;

                    case 4:
                        modificarAlumno();
                        break;

                    case 5:
                        eliminarAlumno();
                        break;

                    case 6:
                        registrarProfesor();
                        break;

                    case 7:
                        listarProfesores();
                        break;

                    case 8:
                        buscarProfesor();
                        break;

                    case 9:
                        modificarProfesor();
                        break;

                    case 10:
                        eliminarProfesor();
                        break;

                    case 11:
                        mostrarComunidadUniversitaria();
                        break;

                    case 12:
                        System.out.println("Programa finalizado");
                        break;

                    default:
                        System.out.println("Opción incorrecta");
                }

            } catch (Exception e) {

                System.out.println("Error: " + e.getMessage());
                opcion = 0;

            }

        } while (opcion != 12);

    }
}