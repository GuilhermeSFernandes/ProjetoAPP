package DAO;
import Entities.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class PacienteDAO {
    private Connection conn;

    public PacienteDAO(Connection conn){
        this.conn = conn;
    }
    public void cadastrarPaciente(Paciente paciente) throws SQLException {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("INSERT INTO paciente (nome, foto, data_nascimento, sexo, endereco, telefone, forma_pagamento) VALUES (?, ?, ?, ?, ?, ?, ?)");
            st.setString(1, paciente.getNome());
            st.setString(2, paciente.getFoto());
            st.setDate(3, paciente.getDataNascimento());
            st.setString(4, paciente.getSexo());
            st.setString(5, paciente.getEndereco());
            st.setString(6, paciente.getTelefone());
            st.setString(7, paciente.getFormaPagamento());

            st.executeUpdate();

            System.out.println("Paciente cadastrado com sucesso.");
        } finally {
            BancoDados.finalizarStatement(st);
            BancoDados.desconectar();
        }
    }

    public Paciente buscarPorId(int idPaciente) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT * FROM paciente WHERE id_paciente = ?");
            st.setInt(1, idPaciente);

            rs = st.executeQuery();

            if (rs.next()) {
                Paciente paciente = new Paciente(null, null, null, null, null, null, null);
                paciente.setIdPaciente(rs.getInt("id_paciente"));
                paciente.setNome(rs.getString("nome"));
                paciente.setFoto(rs.getString("foto"));
                paciente.setDataNascimento(rs.getDate("data_nascimento"));
                paciente.setSexo(rs.getString("sexo"));
                paciente.setEndereco(rs.getString("endereco"));
                paciente.setTelefone(rs.getString("telefone"));
                paciente.setFormaPagamento(rs.getString("forma_pagamento"));

                return paciente;
            }

            return null;

        } finally {
            BancoDados.finalizarStatement(st);
            BancoDados.finalizarResultSet(rs);
            BancoDados.desconectar();
        }
    }

    public void atualizarPaciente(Paciente paciente) throws SQLException {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("UPDATE paciente SET nome = ?, foto = ?, data_nascimento = ?, sexo = ?, endereco = ?, telefone = ?, forma_pagamento = ? WHERE id_paciente = ?");
            st.setString(1, paciente.getNome());
            st.setString(2, paciente.getFoto());
            st.setDate(3, paciente.getDataNascimento());
            st.setString(4, paciente.getSexo());
            st.setString(5, paciente.getEndereco());
            st.setString(6, paciente.getTelefone());
            st.setString(7, paciente.getFormaPagamento());
            st.setInt(8, paciente.getIdPaciente());

            st.executeUpdate();

            System.out.println("Paciente atualizado com sucesso.");

        } finally {
            BancoDados.finalizarStatement(st);
            BancoDados.desconectar();
        }
    }

    public void excluirPaciente(int idPaciente) throws SQLException {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("DELETE FROM paciente WHERE id_paciente = ?");
            st.setInt(1, idPaciente);

            int linhasAfetadas = st.executeUpdate();

            if (linhasAfetadas == 0) {
                System.out.println("Paciente não encontrado ou não pôde ser excluído.");
            } else {
                System.out.println("Paciente excluído com sucesso.");
            }

        } finally {
            BancoDados.finalizarStatement(st);
            BancoDados.desconectar();
        }
    }
    public List<Paciente> listarPacientes() throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT * FROM paciente");
            rs = st.executeQuery();

            List<Paciente> listaPacientes = new ArrayList<>();

            while (rs.next()) {
                Paciente paciente = new Paciente(null,null,null,null,null,null,null);
                paciente.setIdPaciente(rs.getInt("id_paciente"));
                paciente.setNome(rs.getString("nome"));
                paciente.setFoto(rs.getString("foto"));
                paciente.setDataNascimento(rs.getDate("data_nascimento"));
                paciente.setSexo(rs.getString("sexo"));
                paciente.setEndereco(rs.getString("endereco"));
                paciente.setTelefone(rs.getString("telefone"));
                paciente.setFormaPagamento(rs.getString("forma_pagamento"));

                listaPacientes.add(paciente);
            }

            return listaPacientes;

        } finally {
            BancoDados.finalizarStatement(st);
            BancoDados.finalizarResultSet(rs);
            BancoDados.desconectar();
        }
    }

}
