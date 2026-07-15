package org.example.modelo;

public class Alumno extends PersonaUT implements Ensenable, Evaluable {

    private int numExpediente;
    private int edad;
    private String carrera;
    private int cuatrimestres;

    public Alumno() {
    }

    public Alumno(int numExpediente, String nombre, String curp, int edad, String carrera, int cuatrimestres) {
        super(nombre, curp);
        this.numExpediente = numExpediente;
        this.edad = edad;
        this.carrera = carrera;
        this.cuatrimestres = cuatrimestres;
    }

    public int getNumExpediente() {
        return numExpediente;
    }

    public void setNumExpediente(int numExpediente) {
        this.numExpediente = numExpediente;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getCuatrimestres() {
        return cuatrimestres;
    }

    public void setCuatrimestres(int cuatrimestres) {
        this.cuatrimestres = cuatrimestres;
    }

    @Override
    public String mostrarTipoPersona() {
        return "Alumno";
    }

    @Override
    public String aprender() {
        return "El alumno está aprendiendo.";
    }

    @Override
    public String recibirEvaluacion() {
        return "El alumno recibió una evaluación.";
    }

    @Override
    public String toString() {
        return mostrarTipoPersona() + "\n" +
                "Número de expediente: " + numExpediente + "\n" +
                "Nombre: " + getNombre() + "\n" +
                "CURP: " + getCurp() + "\n" +
                "Edad: " + edad + "\n" +
                "Carrera: " + carrera + "\n" +
                "Cuatrimestres: " + cuatrimestres;
    }

}