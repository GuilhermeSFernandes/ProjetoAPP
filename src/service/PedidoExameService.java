package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import Entities.PedidoExame;
import DAO.PedidoExameDAO;

public class PedidoExameService {

    private PedidoExameDAO pedidoExameDAO;

    public PedidoExameService(Connection conn) {
        this.pedidoExameDAO = new PedidoExameDAO(conn);
    }

    public void cadastrarPedidoExame(PedidoExame pedidoExame) {
        try {
            pedidoExameDAO.cadastrarPedidoExame(pedidoExame);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<PedidoExame> listarPedidosExames() {
        try {
            return pedidoExameDAO.listarPedidosExames();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public PedidoExame buscarPorId(int idPedidoExame) {
        try {
            return pedidoExameDAO.buscarPorId(idPedidoExame);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void atualizarPedidoExame(PedidoExame pedidoExame) {
        try {
            pedidoExameDAO.atualizarPedidoExame(pedidoExame);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirPedidoExame(int idPedidoExame) {
        try {
            pedidoExameDAO.excluirPedidoExame(idPedidoExame);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
