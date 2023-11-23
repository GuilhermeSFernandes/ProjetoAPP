package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import Entities.Paciente;
import DAO.PacienteDAO;

public class PacienteService {

    private PacienteDAO pacienteDAO;

    public PacienteService(Connection conn) {
        this.pacienteDAO = new PacienteDAO(conn);
    }

    public void cadastrarPaciente(Paciente paciente) {
        try {
            pacienteDAO.cadastrarPaciente(paciente);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Paciente> listarPacientes() {
        try {
            return pacienteDAO.listarPacientes();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Paciente buscarPorId(int idPaciente) {
        try {
            return pacienteDAO.buscarPorId(idPaciente);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void atualizarPaciente(Paciente paciente) {
        try {
            pacienteDAO.atualizarPaciente(paciente);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirPaciente(int idPaciente) {
        try {
            pacienteDAO.excluirPaciente(idPaciente);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
