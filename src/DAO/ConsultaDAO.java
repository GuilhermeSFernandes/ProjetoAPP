package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.List;
import Entities.Consulta;

public class ConsultaDAO {
        private Connection conn;

        public ConsultaDAO (Connection conn){
            this.conn = conn;
        }
    public void agendarConsulta(String nomePaciente, String nomeMedico, Timestamp horarioConsulta) throws SQLException {

        PreparedStatement st = null;

        try {

            int pacienteID = buscarPacienteIDPorNome(nomePaciente);
            String crmMedico = buscarMedicoCRMPorNome(nomeMedico);

            st = conn.prepareStatement("INSERT INTO consulta (paciente_id, crm_medico, horario_consulta) VALUES (?, ?, ?)");

            st.setInt(1, pacienteID);
            st.setString(2, crmMedico);
            st.setTimestamp(3, horarioConsulta);

            st.executeUpdate();

        } finally {

            BancoDados.finalizarStatement(st);
            BancoDados.desconectar();
        }
    }

    // Método auxiliar para buscar o ID do paciente com base no nome
    public int buscarPacienteIDPorNome(String nomePaciente) throws SQLException {
        int pacienteID = -1; // Valor padrão se não encontrar
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT id_paciente FROM paciente WHERE nome = ?");
            st.setString(1, nomePaciente);
            rs = st.executeQuery();

            if (rs.next()) {
                pacienteID = rs.getInt("id_paciente");
            }

        } finally {
            BancoDados.finalizarStatement(st);
            BancoDados.finalizarResultSet(rs);
        }

        return pacienteID;
    }


    public String buscarMedicoCRMPorNome(String nomeMedico) throws SQLException {
        String crmMedico = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT crm FROM medico WHERE nome_completo = ?");
            st.setString(1, nomeMedico);
            rs = st.executeQuery();

            if (rs.next()) {
                crmMedico = rs.getString("crm");
            }

        } finally {
            BancoDados.finalizarStatement(st);
            BancoDados.finalizarResultSet(rs);
        }

        return crmMedico;
    }

    public List<Consulta> buscarPorMedico(String crmMedico) throws SQLException {

        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT * FROM consulta WHERE crm_medico = ?");
            st.setString(1, crmMedico);

            rs = st.executeQuery();

            List<Consulta> listaConsultas = new ArrayList<>();

            while (rs.next()) {
                Consulta consulta = new Consulta(0,null,null,null);
                consulta.setIdConsulta(rs.getInt("id_consulta"));
                consulta.setPaciente(rs.getInt("paciente_id"));
                consulta.setMedico(rs.getString("crm_medico"));
                consulta.setHorarioConsulta(rs.getTimestamp("horario_consulta"));

                listaConsultas.add(consulta);
            }

            return listaConsultas;

        } finally {
            BancoDados.finalizarStatement(st);
            BancoDados.finalizarResultSet(rs);
        }
    }
    public List<Consulta> buscarPorHorario(Timestamp horarioConsulta) throws SQLException {

        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT * FROM consulta WHERE horario_consulta = ?");
            st.setTimestamp(1, horarioConsulta);

            rs = st.executeQuery();

            List<Consulta> listaConsultas = new ArrayList<>();

            while (rs.next()) {
                Consulta consulta = new Consulta(0,null,null,null);
                consulta.setIdConsulta(rs.getInt("id_consulta"));
                consulta.setPaciente(rs.getInt("paciente_id"));
                consulta.setMedico(rs.getString("crm_medico"));
                consulta.setHorarioConsulta(rs.getTimestamp("horario_consulta"));

                listaConsultas.add(consulta);
            }

            return listaConsultas;

        } finally {
            BancoDados.finalizarStatement(st);
            BancoDados.finalizarResultSet(rs);
            BancoDados.desconectar();
        }
    }
    public void excluirConsulta(int idConsulta) throws SQLException {

        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("DELETE FROM consulta WHERE id_consulta = ?");
            st.setInt(1, idConsulta);

            int linhasAfetadas = st.executeUpdate();

            if (linhasAfetadas == 0) {
                System.out.println("Consulta não encontrada ou não pôde ser excluída.");
            } else {
                System.out.println("Consulta excluída com sucesso.");
            }

        } finally {
            BancoDados.finalizarStatement(st);
            BancoDados.desconectar(); // Adicione esta linha
        }
        }
    public void atualizarConsulta(int idConsulta, Timestamp novoHorarioConsulta) throws SQLException {

        PreparedStatement st = null;

        try {
            // Verifique se a consulta com o ID fornecido existe antes de tentar atualizar
            if (consultaExiste(idConsulta)) {
                st = conn.prepareStatement("UPDATE consulta SET horario_consulta = ? WHERE id_consulta = ?");
                st.setTimestamp(1, novoHorarioConsulta);
                st.setInt(2, idConsulta);

                st.executeUpdate();

                System.out.println("Consulta atualizada com sucesso.");
            } else {
                System.out.println("Consulta não encontrada. Nenhuma atualização realizada.");
            }

        } finally {
            BancoDados.finalizarStatement(st);
            BancoDados.desconectar();
        }
    }

    public boolean consultaExiste(int idConsulta) throws SQLException {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("SELECT id_consulta FROM consulta WHERE id_consulta = ?");
            st.setInt(1, idConsulta);

            return st.executeQuery().next();
        } finally {
            BancoDados.finalizarStatement(st);
        }
    }
}
