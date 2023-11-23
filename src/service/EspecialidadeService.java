package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import Entities.Especialidade;
import DAO.EspecialidadeDAO;

public class EspecialidadeService {

    private EspecialidadeDAO especialidadeDAO;

    public EspecialidadeService(Connection conn) {
        this.especialidadeDAO = new EspecialidadeDAO(conn);
    }

    public void cadastrarEspecialidade(Especialidade especialidade) {
        try {
            especialidadeDAO.cadastrarEspecialidade(especialidade);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Especialidade> listarEspecialidades() {
        try {
            return especialidadeDAO.listarEspecialidades();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Especialidade buscarPorCodigo(int codigoEspecialidade) {
        try {
            return especialidadeDAO.buscarPorCodigo(codigoEspecialidade);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
