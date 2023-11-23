package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import Entities.Exame;
import DAO.ExameDAO;

public class ExameService {

    private ExameDAO exameDAO;

    public ExameService(Connection conn) {
        this.exameDAO = new ExameDAO(conn);
    }

    public void cadastrarExame(Exame exame) {
        try {
            exameDAO.cadastrarExame(exame);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Exame buscarPorId(int idExame) {
        try {
            return exameDAO.buscarPorId(idExame);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void atualizarExame(Exame exame) {
        try {
            exameDAO.atualizarExame(exame);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirExame(int idExame) {
        try {
            exameDAO.excluirExame(idExame);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Exame> listarExames() {
        try {
            return exameDAO.listarExames();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
