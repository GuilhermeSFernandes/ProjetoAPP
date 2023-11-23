package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import Entities.Medico;
import Entities.Especialidade;
public class MedicoDAOTeste {

    public static void main(String[] args) {
        try {
            // Obtém uma conexão com o banco de dados
            Connection conn = BancoDados.conectar();

            // Cria um objeto DAO passando a conexão
            MedicoDAO medicoDAO = new MedicoDAO(conn);

            // Testa o método de cadastrar médico
            Medico novoMedico = new Medico("CRM123", "Dr. João", "Rua A, 123", "123456789", new Especialidade(1, 0, "Cardiologista"));
            medicoDAO.cadastrarMedico(novoMedico);

            // Testa o método de listar médicos
            List<Medico> listaMedicos = medicoDAO.listarMedicos();
            System.out.println("Lista de Médicos:");
            for (Medico medico : listaMedicos) {
                System.out.println(medico);
            }

            // Testa o método de buscar médico por CRM
            String crmBuscar = "CRM123";
            Medico medicoBuscado = medicoDAO.buscarPorCrm(crmBuscar);
            if (medicoBuscado != null) {
                System.out.println("Médico encontrado por CRM " + crmBuscar + ": " + medicoBuscado);
            } else {
                System.out.println("Médico não encontrado por CRM " + crmBuscar);
            }

            // Testa o método de atualizar médico
            Medico medicoAtualizado = new Medico("CRM123", "Dr. João Atualizado", "Rua B, 456", "987654321", new Especialidade(2, 0, "Pediatra"));
            medicoDAO.atualizarMedico(medicoAtualizado);

            // Testa o método de listar médicos novamente após a atualização
            listaMedicos = medicoDAO.listarMedicos();
            System.out.println("Lista de Médicos após atualização:");
            for (Medico medico : listaMedicos) {
                System.out.println(medico);
            }

            // Testa o método de excluir médico
            medicoDAO.excluirMedico("CRM123");

            // Testa o método de listar médicos novamente após a exclusão
            listaMedicos = medicoDAO.listarMedicos();
            System.out.println("Lista de Médicos após exclusão:");
            for (Medico medico : listaMedicos) {
                System.out.println(medico);
            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
