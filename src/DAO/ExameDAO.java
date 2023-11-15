package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Entities.Exame;
public class ExameDAO {
    private Connection conn;
    public ExameDAO (Connection conn){
        this.conn = conn;
    }
    public void cadastrarExame(Exame exame) throws SQLException {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("INSERT INTO exame (codigo_exame, nome, valor, orientacoes_realizacao) VALUES (?, ?, ?, ?)");
            st.setInt(1, exame.getCodigoExame());
            st.setString(2, exame.getNomeExame());
            st.setDouble(3, exame.getValor());
            st.setString(4, exame.getOrientacoes());

            st.executeUpdate();

            System.out.println("Exame cadastrado com sucesso.");
        } finally {
            BancoDados.finalizarStatement(st);
            BancoDados.desconectar();
        }
    }

    public Exame buscarPorId(int idExame) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT * FROM exame WHERE id_exame = ?");
            st.setInt(1, idExame);

            rs = st.executeQuery();

            if (rs.next()) {
                Exame exame = new Exame(0, null,0,null);
                exame.setCodigoExame(rs.getInt("id_exame"));
                exame.setNomeExame(rs.getString("nome"));
                exame.setValor(rs.getDouble("valor"));
                exame.setOrientacoes(rs.getString("orientacoes_realizacao"));

                return exame;
            }

            return null;

        } finally {
            BancoDados.finalizarStatement(st);
            BancoDados.finalizarResultSet(rs);
            BancoDados.desconectar();
        }
    }

    public void atualizarExame(Exame exame) throws SQLException {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("UPDATE exame SET codigo_exame = ?, nome = ?, valor = ?, orientacoes_realizacao = ? WHERE id_exame = ?");
            st.setInt(1, exame.getCodigoExame());
            st.setString(2, exame.getNomeExame());
            st.setDouble(3, exame.getValor());
            st.setString(4, exame.getOrientacoes());
            st.setInt(5, exame.getCodigoExame());

            st.executeUpdate();

            System.out.println("Exame atualizado com sucesso.");

        } finally {
            BancoDados.finalizarStatement(st);
            BancoDados.desconectar();
        }
    }

    public void excluirExame(int idExame) throws SQLException {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("DELETE FROM exame WHERE id_exame = ?");
            st.setInt(1, idExame);

            int linhasAfetadas = st.executeUpdate();

            if (linhasAfetadas == 0) {
                System.out.println("Exame não encontrado ou não pôde ser excluído.");
            } else {
                System.out.println("Exame excluído com sucesso.");
            }

        } finally {
            BancoDados.finalizarStatement(st);
            BancoDados.desconectar();
        }
    }
    public List<Exame> listarExames() throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT * FROM exame");
            rs = st.executeQuery();

            List<Exame> listaExames = new ArrayList<>();

            while (rs.next()) {
                Exame exame = new Exame(0,null,0,null);
                exame.setCodigoExame(rs.getInt("id_exame"));
                exame.setNomeExame(rs.getString("nome"));
                exame.setValor(rs.getDouble("valor"));
                exame.setOrientacoes(rs.getString("orientacoes_realizacao"));

                listaExames.add(exame);
            }

            return listaExames;

        } finally {
            BancoDados.finalizarStatement(st);
            BancoDados.finalizarResultSet(rs);
            BancoDados.desconectar();
        }
    }
}
