package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import Entities.Medico;
import DAO.MedicoDAO;

public class MedicoService {

    private MedicoDAO medicoDAO;

    public MedicoService(Connection conn) {
        this.medicoDAO = new MedicoDAO(conn);
    }

    public void cadastrarMedico(Medico medico) {
        try {
            medicoDAO.cadastrarMedico(medico);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Medico> listarMedicos() {
        try {
            return medicoDAO.listarMedicos();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Medico buscarPorCrm(String crm) {
        try {
            return medicoDAO.buscarPorCrm(crm);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void atualizarMedico(Medico medico) {
        try {
            medicoDAO.atualizarMedico(medico);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirMedico(String crm) {
        try {
            medicoDAO.excluirMedico(crm);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
