package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Entities.Especialidade;
public class EspecialidadeDAO {
    private Connection conn;
    public EspecialidadeDAO (Connection conn){
        this.conn = conn;
    }
    public void cadastrarEspecialidade(Especialidade especialidade) throws SQLException {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("INSERT INTO especialidade (codigo, nome) VALUES (?, ?)");
            st.setInt(1, especialidade.getCodigoEspecialidade());
            st.setString(2, especialidade.getNomeEspecialidade());

            st.executeUpdate();

            System.out.println("Especialidade cadastrada com sucesso.");
        } finally {
            BancoDados.finalizarStatement(st);
            BancoDados.desconectar();
        }
    }

    public List<Especialidade> listarEspecialidades() throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT * FROM especialidade");
            rs = st.executeQuery();

            List<Especialidade> listaEspecialidades = new ArrayList<>();

            while (rs.next()) {
                Especialidade especialidade = new Especialidade(0, 0, null);
                especialidade.setCodigoEspecialidade(Integer.parseInt(String.valueOf(rs.getInt("codigo"))));
                especialidade.setNomeEspecialidade(rs.getString("nome"));

                listaEspecialidades.add(especialidade);
            }

            return listaEspecialidades;
        } finally {
            BancoDados.finalizarStatement(st);
            BancoDados.finalizarResultSet(rs);
            BancoDados.desconectar();
        }
    }
    public Especialidade buscarPorCodigo(int codigoEspecialidade) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT * FROM especialidade WHERE codigo = ?");
            st.setInt(1, codigoEspecialidade);

            rs = st.executeQuery();

            if (rs.next()) {
                Especialidade especialidade = new Especialidade(0, 0, null);
                especialidade.setCodigoEspecialidade(Integer.parseInt(String.valueOf(rs.getInt("codigo"))));
                especialidade.setNomeEspecialidade(rs.getString("nome"));

                return especialidade;
            }

            return null;
        } finally {
            BancoDados.finalizarStatement(st);
            BancoDados.finalizarResultSet(rs);
            BancoDados.desconectar();
        }
    }

}
