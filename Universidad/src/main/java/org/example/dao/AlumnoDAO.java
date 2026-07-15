package org.example.dao;

import org.example.modelo.Alumno;

import java.sql.*;
import java.util.ArrayList;

public class AlumnoDAO {

    public void nuevoAlumno(Alumno alumno) {

        try {

            Connection con = Conexion.conectar();

            String sql = "INSERT INTO alumno VALUES(?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, alumno.getNumExpediente());
            ps.setString(2, alumno.getNombre());
            ps.setString(3, alumno.getCurp());
            ps.setInt(4, alumno.getEdad());
            ps.setString(5, alumno.getCarrera());
            ps.setInt(6, alumno.getCuatrimestres());

            ps.executeUpdate();

            System.out.println("Alumno registrado correctamente");

        } catch (Exception e) {

            System.out.println("Error al registrar alumno");

        }

    }

    public ArrayList<Alumno> extraerAlumnos() {

        ArrayList<Alumno> alumnos = new ArrayList<>();

        try {

            Connection con = Conexion.conectar();

            String sql = "SELECT * FROM alumno";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Alumno alumno = new Alumno();

                alumno.setNumExpediente(rs.getInt("numExpediente"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setCurp(rs.getString("curp"));
                alumno.setEdad(rs.getInt("edad"));
                alumno.setCarrera(rs.getString("carrera"));
                alumno.setCuatrimestres(rs.getInt("cuatrimestres"));

                alumnos.add(alumno);

            }

        } catch (Exception e) {

            System.out.println("Error al listar alumnos");

        }

        return alumnos;

    }

    public Alumno buscarAlumno(int numExpediente) {

        Alumno alumno = null;

        try {

            Connection con = Conexion.conectar();

            String sql = "SELECT * FROM alumno WHERE numExpediente=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, numExpediente);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                alumno = new Alumno();

                alumno.setNumExpediente(rs.getInt("numExpediente"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setCurp(rs.getString("curp"));
                alumno.setEdad(rs.getInt("edad"));
                alumno.setCarrera(rs.getString("carrera"));
                alumno.setCuatrimestres(rs.getInt("cuatrimestres"));

            }

        } catch (Exception e) {

            System.out.println("Error al buscar alumno");

        }

        return alumno;

    }

    public void actualizarAlumno(Alumno alumno) {

        try {

            Connection con = Conexion.conectar();

            String sql = "UPDATE alumno SET nombre=?, curp=?, edad=?, carrera=?, cuatrimestres=? WHERE numExpediente=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getCurp());
            ps.setInt(3, alumno.getEdad());
            ps.setString(4, alumno.getCarrera());
            ps.setInt(5, alumno.getCuatrimestres());
            ps.setInt(6, alumno.getNumExpediente());

            ps.executeUpdate();

            System.out.println("Alumno actualizado");

        } catch (Exception e) {

            System.out.println("Error al actualizar alumno");

        }

    }

    public void eliminarAlumno(Alumno alumno) {

        try {

            Connection con = Conexion.conectar();

            String sql = "DELETE FROM alumno WHERE numExpediente=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, alumno.getNumExpediente());

            ps.executeUpdate();

            System.out.println("Alumno eliminado");

        } catch (Exception e) {

            System.out.println("Error al eliminar alumno");

        }

    }

}