package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import Entities.PedidoExame;

public class PedidoExameDAOTeste {

    public static void main(String[] args) {

        try {
            // Testar cada um dos métodos da classe PedidoExameDAO
            cadastrarPedidoExameTeste();
            buscarPorIdTeste();
            atualizarPedidoExameTeste();
            excluirPedidoExameTeste();
            listarPedidosExamesTeste();

        } catch (SQLException | IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public static void cadastrarPedidoExameTeste() throws SQLException, IOException, ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        PedidoExame pedidoExame = new PedidoExame(0,0,null,null,null,0);
        pedidoExame.setExame(1); // Código do exame
        pedidoExame.setPaciente("Nome do Paciente");
        pedidoExame.setMedico("CRM123"); // CRM do médico
        pedidoExame.setDataRealizacao(new java.sql.Date(sdf.parse("01/01/2023").getTime()));
        pedidoExame.setValorPago(150.0);

        Connection conn = BancoDados.conectar();
        new PedidoExameDAO(conn).cadastrarPedidoExame(pedidoExame);

        System.out.println("Pedido de Exame cadastrado com sucesso.");
    }

    public static void buscarPorIdTeste() throws SQLException, IOException {

        int idPedidoExame = 1;

        Connection conn = BancoDados.conectar();
        PedidoExame pedidoExame = new PedidoExameDAO(conn).buscarPorId(idPedidoExame);

        if (pedidoExame != null) {
            System.out.println("Pedido de Exame encontrado:");
            System.out.println("ID: " + pedidoExame.getIdPedidoExame());
            System.out.println("Exame: " + pedidoExame.getExame());
            System.out.println("Paciente: " + pedidoExame.getPaciente());
            System.out.println("Médico: " + pedidoExame.getMedico());
            System.out.println("Data de Realização: " + pedidoExame.getDataRealizacao());
            System.out.println("Valor Pago: " + pedidoExame.getValorPago());
        } else {
            System.out.println("Pedido de Exame não encontrado.");
        }
    }

    public static void atualizarPedidoExameTeste() throws SQLException, IOException, ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        PedidoExame pedidoExame = new PedidoExame(0,0,null,null,null,0);
        pedidoExame.setIdPedidoExame(1);
        pedidoExame.setExame(2); // Novo código do exame
        pedidoExame.setPaciente("Novo Nome do Paciente");
        pedidoExame.setMedico("CRM456"); // Novo CRM do médico
        pedidoExame.setDataRealizacao(new java.sql.Date(sdf.parse("02/02/2023").getTime()));
        pedidoExame.setValorPago(200.0);

        Connection conn = BancoDados.conectar();
        new PedidoExameDAO(conn).atualizarPedidoExame(pedidoExame);

        System.out.println("Pedido de Exame atualizado com sucesso.");
    }

    public static void excluirPedidoExameTeste() throws SQLException, IOException {

        int idPedidoExame = 1;

        Connection conn = BancoDados.conectar();
        new PedidoExameDAO(conn).excluirPedidoExame(idPedidoExame);

        System.out.println("Pedido de Exame excluído com sucesso.");
    }

    public static void listarPedidosExamesTeste() throws SQLException, IOException {

        Connection conn = BancoDados.conectar();
        List<PedidoExame> listaPedidosExames = new PedidoExameDAO(conn).listarPedidosExames();

        System.out.println("Lista de Pedidos de Exames:");
        for (PedidoExame pedidoExame : listaPedidosExames) {
            System.out.println("ID: " + pedidoExame.getIdPedidoExame());
            System.out.println("Exame: " + pedidoExame.getExame());
            System.out.println("Paciente: " + pedidoExame.getPaciente());
            System.out.println("Médico: " + pedidoExame.getMedico());
            System.out.println("Data de Realização: " + pedidoExame.getDataRealizacao());
            System.out.println("Valor Pago: " + pedidoExame.getValorPago());
            System.out.println("-------------");
        }
    }
}
