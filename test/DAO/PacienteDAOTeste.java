package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import Entities.Paciente;
import DAO.PacienteDAO;

public class PacienteDAOTeste {

    public static void cadastrarPacienteTeste() throws SQLException, IOException, ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Paciente paciente = new Paciente(0,null,null,null,null,null,null,null);
        paciente.setIdPaciente(1);
        paciente.setNome("João Silva");
        paciente.setSexo("M");
        paciente.setDataNascimento(new java.sql.Date(sdf.parse("15/03/1985").getTime()));
        paciente.setEndereco("Rua B, 456");
        paciente.setTelefone("987654321");
        paciente.setFormaPagamento("Plano de Saúde");

        Connection conn = BancoDados.conectar();
        new PacienteDAO(conn).cadastrarPaciente(paciente);

        System.out.println("Cadastro de paciente efetuado com sucesso.");
    }

    public static void buscarTodosPacientesTeste() throws SQLException, IOException {
        Connection conn = BancoDados.conectar();
        PacienteDAO pacienteDAO = new PacienteDAO(conn);
        List<Paciente> listaPacientes = pacienteDAO.buscarTodos();

        for (Paciente paciente : listaPacientes) {
            System.out.println(paciente.getIdPaciente() + " - " + paciente.getNome() + " - " + paciente.getSexo() + " - "
                    + paciente.getDataNascimento() + " - " + paciente.getEndereco() + " - " + paciente.getTelefone()
                    + " - " + paciente.getFormaPagamento());
        }
    }

    public static void buscarPorCodigoTeste() throws SQLException, IOException {

        int codigo = 2;

        Connection conn = BancoDados.conectar();
        Paciente paciente = new PacienteDAO(conn).buscarPorId(codigo);

        if (paciente != null) {
            System.out.println(paciente.getIdPaciente() + " - " + paciente.getNome() + " - " + paciente.getSexo() + " - "
                    + paciente.getDataNascimento() + " - " + paciente.getEndereco() + " - " + paciente.getTelefone()
                    + " - " + paciente.getFormaPagamento());
        } else {
            System.out.println("Paciente não encontrado com o código " + codigo);
        }
    }

    public static void atualizarPacienteTeste() throws SQLException, IOException, ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Paciente paciente = new Paciente(0,null,null,null,null,null,null,null);
        paciente.setIdPaciente(3);
        paciente.setNome("Maria Oliveira");
        paciente.setSexo("Feminino");
        paciente.setDataNascimento(new java.sql.Date(sdf.parse("20/09/1990").getTime()));
        paciente.setEndereco("Rua C, 789");
        paciente.setTelefone("123456789");
        paciente.setFormaPagamento("Dinheiro");

        Connection conn = BancoDados.conectar();
        new PacienteDAO(conn).atualizarPaciente(paciente);

        System.out.println("Dados do paciente atualizados com sucesso.");
    }

    public static void excluirPacienteTeste() throws SQLException, IOException {

        int codigo = 4;
        Connection conn = BancoDados.conectar();
        PacienteDAO pacienteDAO = new PacienteDAO(conn);
        int linhasManipuladas = pacienteDAO.excluirPaciente(codigo);

        if (linhasManipuladas > 0) {
            System.out.println("Paciente excluído com sucesso.");
        } else {
            System.out.println("Nenhum paciente encontrado com o código " + codigo);
        }
    }

    public static void main(String[] args) {

        try {
            // Testar cada um dos métodos
            PacienteDAOTeste.cadastrarPacienteTeste();
            PacienteDAOTeste.buscarTodosPacientesTeste();
            PacienteDAOTeste.buscarPorCodigoTeste();
            PacienteDAOTeste.atualizarPacienteTeste();
            PacienteDAOTeste.excluirPacienteTeste();
        } catch (SQLException | IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
