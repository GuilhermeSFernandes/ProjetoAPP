package service;
import DAO.ConsultaDAO;
import Entities.Consulta;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class ConsultaService {
    private ConsultaDAO consultaDAO;

    public ConsultaService(Connection conn) {
        this.consultaDAO = new ConsultaDAO(conn);
    }

    public void agendarConsulta(String nomePaciente, String nomeMedico, Timestamp horarioConsulta) throws SQLException {
        consultaDAO.agendarConsulta(nomePaciente, nomeMedico, horarioConsulta);
    }

    public List<Consulta> buscarPorMedico(String crmMedico) throws SQLException {
        return consultaDAO.buscarPorMedico(crmMedico);
    }

    public List<Consulta> buscarPorHorario(Timestamp horarioConsulta) throws SQLException {
        return consultaDAO.buscarPorHorario(horarioConsulta);
    }

    public void excluirConsulta(int idConsulta) throws SQLException {
        consultaDAO.excluirConsulta(idConsulta);
    }

    public void atualizarConsulta(int idConsulta, Timestamp novoHorarioConsulta) throws SQLException {
        consultaDAO.atualizarConsulta(idConsulta, novoHorarioConsulta);
    }

    public boolean consultaExiste(int idConsulta) throws SQLException {
        return consultaDAO.consultaExiste(idConsulta);
    }
}