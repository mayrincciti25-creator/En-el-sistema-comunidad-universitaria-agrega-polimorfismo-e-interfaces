package org.example.modelo;

public class Profesor extends PersonaUT implements Ensenador, Evaluador {

    private int numEmpleado;
    private int edad;
    private String puesto;
    private String cedulaProfesional;

    public Profesor() {
    }

    public Profesor(int numEmpleado, String nombre, String curp, int edad, String puesto, String cedulaProfesional) {
        super(nombre, curp);
        this.numEmpleado = numEmpleado;
        this.edad = edad;
        this.puesto = puesto;
        this.cedulaProfesional = cedulaProfesional;
    }

    public int getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(int numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getCedulaProfesional() {
        return cedulaProfesional;
    }

    public void setCedulaProfesional(String cedulaProfesional) {
        this.cedulaProfesional = cedulaProfesional;
    }

    @Override
    public String mostrarTipoPersona() {
        return "Profesor";
    }

    @Override
    public String ensenar() {
        return "El profesor está enseñando.";
    }

    @Override
    public String evaluar() {
        return "El profesor está evaluando.";
    }

    @Override
    public String toString() {

        return mostrarTipoPersona() + "\n" +
                "Número de empleado: " + numEmpleado + "\n" +
                "Nombre: " + getNombre() + "\n" +
                "CURP: " + getCurp() + "\n" +
                "Edad: " + edad + "\n" +
                "Puesto: " + puesto + "\n" +
                "Cédula profesional: " + cedulaProfesional;

    }

}