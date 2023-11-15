package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Entities.Medico;
import Entities.Especialidade;
public class MedicoDAO {
    private Connection conn;
    public MedicoDAO(Connection conn){
        this.conn = conn;
    }
    public void cadastrarMedico(Medico medico) throws SQLException {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("INSERT INTO medico (crm, nome_completo, endereco, telefone, codigo_especialidade) VALUES (?, ?, ?, ?, ?)");
            st.setString(1, medico.getCrm());
            st.setString(2, medico.getNomeCompleto());
            st.setString(3, medico.getEndereco());
            st.setString(4, medico.getTelefone());
            st.setInt(5, medico.getEspecialidade().getCodigoEspecialidade());

            st.executeUpdate();

            System.out.println("Médico cadastrado com sucesso.");
        } finally {
            BancoDados.finalizarStatement(st);
            BancoDados.desconectar();
        }
    }

    public List<Medico> listarMedicos() throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT * FROM medico");
            rs = st.executeQuery();

            List<Medico> listaMedicos = new ArrayList<>();

            while (rs.next()) {
                Medico medico = new Medico(null,null,null,null,null);
                medico.setCrm(rs.getString("crm"));
                medico.setNomeCompleto(rs.getString("nome_completo"));
                medico.setEndereco(rs.getString("endereco"));
                medico.setTelefone(rs.getString("telefone"));

                EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO(conn);
                Especialidade especialidade = especialidadeDAO.buscarPorCodigo(rs.getInt("codigo_especialidade"));

                medico.setEspecialidade(especialidade);

                listaMedicos.add(medico);
            }

            return listaMedicos;
        } finally {
            BancoDados.finalizarStatement(st);
            BancoDados.finalizarResultSet(rs);
            BancoDados.desconectar();
        }
    }
    public Medico buscarPorCrm(String crm) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT * FROM medico WHERE crm = ?");
            st.setString(1, crm);

            rs = st.executeQuery();

            if (rs.next()) {
                Medico medico = new Medico(null,null,null,null,null);
                medico.setCrm(rs.getString("crm"));
                medico.setNomeCompleto(rs.getString("nome_completo"));
                medico.setEndereco(rs.getString("endereco"));
                medico.setTelefone(rs.getString("telefone"));

                EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO(conn);
                Especialidade especialidade = especialidadeDAO.buscarPorCodigo(rs.getInt("codigo_especialidade"));
                medico.setEspecialidade(especialidade);

                return medico;
            }

            return null;

        } finally {
            BancoDados.finalizarStatement(st);
            BancoDados.finalizarResultSet(rs);
            BancoDados.desconectar();
        }
    }

    public void atualizarMedico(Medico medico) throws SQLException {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("UPDATE medico SET nome_completo = ?, endereco = ?, telefone = ?, codigo_especialidade = ? WHERE crm = ?");
            st.setString(1, medico.getNomeCompleto());
            st.setString(2, medico.getEndereco());
            st.setString(3, medico.getTelefone());
            st.setInt(4, medico.getEspecialidade().getCodigoEspecialidade());
            st.setString(5, medico.getCrm());

            st.executeUpdate();

            System.out.println("Médico atualizado com sucesso.");

        } finally {
            BancoDados.finalizarStatement(st);
            BancoDados.desconectar();
        }
    }

    public void excluirMedico(String crm) throws SQLException {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("DELETE FROM medico WHERE crm = ?");
            st.setString(1, crm);

            int linhasAfetadas = st.executeUpdate();

            if (linhasAfetadas == 0) {
                System.out.println("Médico não encontrado ou não pôde ser excluído.");
            } else {
                System.out.println("Médico excluído com sucesso.");
            }

        } finally {
            BancoDados.finalizarStatement(st);
            BancoDados.desconectar();
        }
    }

}
