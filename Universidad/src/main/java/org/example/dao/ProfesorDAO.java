package org.example.dao;

import org.example.modelo.Profesor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProfesorDAO {

    public void nuevoProfesor(Profesor profesor) {

        try {

            Connection con = Conexion.conectar();

            String sql = "INSERT INTO profesor VALUES(?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, profesor.getNumEmpleado());
            ps.setString(2, profesor.getNombre());
            ps.setString(3, profesor.getCurp());
            ps.setInt(4, profesor.getEdad());
            ps.setString(5, profesor.getPuesto());
            ps.setString(6, profesor.getCedulaProfesional());

            ps.executeUpdate();

            System.out.println("Profesor registrado correctamente");

        } catch (Exception e) {

            System.out.println("Error al registrar profesor");

        }

    }

    public ArrayList<Profesor> extraerProfesores() {

        ArrayList<Profesor> profesores = new ArrayList<>();

        try {

            Connection con = Conexion.conectar();

            String sql = "SELECT * FROM profesor";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Profesor profesor = new Profesor();

                profesor.setNumEmpleado(rs.getInt("numEmpleado"));
                profesor.setNombre(rs.getString("nombre"));
                profesor.setCurp(rs.getString("curp"));
                profesor.setEdad(rs.getInt("edad"));
                profesor.setPuesto(rs.getString("puesto"));
                profesor.setCedulaProfesional(rs.getString("cedulaProfesional"));

                profesores.add(profesor);

            }

        } catch (Exception e) {

            System.out.println("Error al listar profesores");

        }

        return profesores;

    }

    public Profesor buscarProfesor(int numEmpleado) {

        Profesor profesor = null;

        try {

            Connection con = Conexion.conectar();

            String sql = "SELECT * FROM profesor WHERE numEmpleado=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, numEmpleado);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                profesor = new Profesor();

                profesor.setNumEmpleado(rs.getInt("numEmpleado"));
                profesor.setNombre(rs.getString("nombre"));
                profesor.setCurp(rs.getString("curp"));
                profesor.setEdad(rs.getInt("edad"));
                profesor.setPuesto(rs.getString("puesto"));
                profesor.setCedulaProfesional(rs.getString("cedulaProfesional"));

            }

        } catch (Exception e) {

            System.out.println("Error al buscar profesor");

        }

        return profesor;

    }

    public void actualizarProfesor(Profesor profesor) {

        try {

            Connection con = Conexion.conectar();

            String sql = "UPDATE profesor SET nombre=?, curp=?, edad=?, puesto=?, cedulaProfesional=? WHERE numEmpleado=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, profesor.getNombre());
            ps.setString(2, profesor.getCurp());
            ps.setInt(3, profesor.getEdad());
            ps.setString(4, profesor.getPuesto());
            ps.setString(5, profesor.getCedulaProfesional());
            ps.setInt(6, profesor.getNumEmpleado());

            ps.executeUpdate();

            System.out.println("Profesor actualizado");

        } catch (Exception e) {

            System.out.println("Error al actualizar profesor");

        }

    }

    public void eliminarProfesor(Profesor profesor) {

        try {

            Connection con = Conexion.conectar();

            String sql = "DELETE FROM profesor WHERE numEmpleado=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, profesor.getNumEmpleado());

            ps.executeUpdate();

            System.out.println("Profesor eliminado");

        } catch (Exception e) {

            System.out.println("Error al eliminar profesor");

        }

    }

}