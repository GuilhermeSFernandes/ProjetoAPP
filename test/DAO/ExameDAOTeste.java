package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import Entities.Exame;

public class ExameDAOTeste {

    public static void main(String[] args) {
        try {
            // Obtém uma conexão com o banco de dados
            Connection conn = BancoDados.conectar();

            // Cria um objeto DAO passando a conexão
            ExameDAO exameDAO = new ExameDAO(conn);

            // Testa o método de cadastrar exame
            Exame novoExame = new Exame(1, "Exame de Sangue", 150.0, "Jejum de 12 horas");
            exameDAO.cadastrarExame(novoExame);

            // Testa o método de listar exames
            List<Exame> listaExames = exameDAO.listarExames();
            System.out.println("Lista de Exames:");
            for (Exame exame : listaExames) {
                System.out.println(exame);
            }

            // Testa o método de buscar exame por ID
            int idExameBuscar = 1; // substitua pelo ID correto do exame
            Exame exameBuscado = exameDAO.buscarPorId(idExameBuscar);
            if (exameBuscado != null) {
                System.out.println("Exame encontrado por ID " + idExameBuscar + ": " + exameBuscado);
            } else {
                System.out.println("Exame não encontrado por ID " + idExameBuscar);
            }

            // Testa o método de atualizar exame
            Exame exameAtualizado = new Exame(1, "Exame de Sangue Atualizado", 180.0, "Jejum de 8 horas");
            exameDAO.atualizarExame(exameAtualizado);

            // Testa o método de listar exames novamente após a atualização
            listaExames = exameDAO.listarExames();
            System.out.println("Lista de Exames após atualização:");
            for (Exame exame : listaExames) {
                System.out.println(exame);
            }

            // Testa o método de excluir exame
            exameDAO.excluirExame(1);

            // Testa o método de listar exames novamente após a exclusão
            listaExames = exameDAO.listarExames();
            System.out.println("Lista de Exames após exclusão:");
            for (Exame exame : listaExames) {
                System.out.println(exame);
            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
