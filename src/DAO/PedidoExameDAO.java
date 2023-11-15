package DAO;
import Entities.PedidoExame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Entities.Medico;
import Entities.Paciente;

public class PedidoExameDAO {
    private Connection conn;

    public PedidoExameDAO(Connection conn){
        this.conn = conn;
    }
    public void cadastrarPedidoExame(PedidoExame pedidoExame) throws SQLException {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("INSERT INTO pedido_exame (codigo_exame, nome_paciente, crm_medico, data_realizacao, valor_pago) VALUES (?, ?, ?, ?, ?)");
            st.setInt(1, pedidoExame.getExame());
            st.setString(2, pedidoExame.getPaciente());
            st.setString(3, pedidoExame.getMedico());
            st.setDate(4, pedidoExame.getDataRealizacao());
            st.setDouble(5, pedidoExame.getValorPago());

            st.executeUpdate();

            System.out.println("Pedido de Exame cadastrado com sucesso.");
        } finally {
            BancoDados.finalizarStatement(st);
            BancoDados.desconectar();
        }
    }

    public PedidoExame buscarPorId(int idPedidoExame) throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT * FROM pedido_exame WHERE id_pedido_exame = ?");
            st.setInt(1, idPedidoExame);

            rs = st.executeQuery();

            if (rs.next()) {
                PedidoExame pedidoExame = new PedidoExame(0, 0, null, null, null, 0.0);
                pedidoExame.setIdPedidoExame(rs.getInt("id_pedido_exame"));
                pedidoExame.setExame(rs.getInt("codigo_exame"));
                pedidoExame.setPaciente(rs.getString("nome_paciente"));
                pedidoExame.setMedico(rs.getString("crm_medico"));
                pedidoExame.setDataRealizacao(rs.getDate("data_realizacao"));
                pedidoExame.setValorPago(rs.getDouble("valor_pago"));

                return pedidoExame;
            }

            return null;

        } finally {
            BancoDados.finalizarStatement(st);
            BancoDados.finalizarResultSet(rs);
            BancoDados.desconectar();
        }
    }

    public void atualizarPedidoExame(PedidoExame pedidoExame) throws SQLException {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("UPDATE pedido_exame SET codigo_exame = ?, nome_paciente = ?, crm_medico = ?, data_realizacao = ?, valor_pago = ? WHERE id_pedido_exame = ?");
            st.setInt(1, pedidoExame.getExame());
            st.setString(2, pedidoExame.getPaciente());
            st.setString(3, pedidoExame.getMedico());
            st.setDate(4, pedidoExame.getDataRealizacao());
            st.setDouble(5, pedidoExame.getValorPago());
            st.setInt(6, pedidoExame.getIdPedidoExame());

            st.executeUpdate();

            System.out.println("Pedido de Exame atualizado com sucesso.");

        } finally {
            BancoDados.finalizarStatement(st);
            BancoDados.desconectar();
        }
    }

    public void excluirPedidoExame(int idPedidoExame) throws SQLException {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement("DELETE FROM pedido_exame WHERE id_pedido_exame = ?");
            st.setInt(1, idPedidoExame);

            int linhasAfetadas = st.executeUpdate();

            if (linhasAfetadas == 0) {
                System.out.println("Pedido de Exame não encontrado ou não pôde ser excluído.");
            } else {
                System.out.println("Pedido de Exame excluído com sucesso.");
            }

        } finally {
            BancoDados.finalizarStatement(st);
            BancoDados.desconectar();
        }
    }
    public List<PedidoExame> listarPedidosExames() throws SQLException {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT * FROM pedido_exame");
            rs = st.executeQuery();

            List<PedidoExame> listaPedidosExames = new ArrayList<>();

            while (rs.next()) {
                PedidoExame pedidoExame = new PedidoExame(0, 0, null, null, null,0.0);
                pedidoExame.setIdPedidoExame(rs.getInt("id_pedido_exame"));
                pedidoExame.setExame(rs.getInt("codigo_exame"));
                pedidoExame.setPaciente(rs.getString("nome_paciente"));
                pedidoExame.setMedico(rs.getString("crm_medico"));
                pedidoExame.setDataRealizacao(rs.getDate("data_realizacao"));
                pedidoExame.setValorPago(rs.getDouble("valor_pago"));

                listaPedidosExames.add(pedidoExame);
            }

            return listaPedidosExames;

        } finally {
            BancoDados.finalizarStatement(st);
            BancoDados.finalizarResultSet(rs);
            BancoDados.desconectar();
        }
    }

    public List<PedidoExame> buscarTodos() throws SQLException {
        return listarPedidosExames();
    }

}
