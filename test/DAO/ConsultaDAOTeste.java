package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.io.IOException;
import java.util.List;
import Entities.Consulta;

public class ConsultaDAOTeste {

    public static void main(String[] args) {
        try {
            // Obtém uma conexão com o banco de dados
            Connection conn = BancoDados.conectar();

            // Cria um objeto DAO passando a conexão
            ConsultaDAO consultaDAO = new ConsultaDAO(conn);

            // Testa o método de agendar consulta
            Timestamp horarioConsulta = Timestamp.valueOf("2023-11-16 14:30:00");
            consultaDAO.agendarConsulta("NomePaciente", "NomeMedico", horarioConsulta);

            // Testa o método de buscar consultas por médico
            List<Consulta> consultasPorMedico = consultaDAO.buscarPorMedico("CRM_Medico");
            System.out.println("Consultas por Médico:");
            for (Consulta consulta : consultasPorMedico) {
                System.out.println(consulta);
            }

            // Testa o método de buscar consultas por horário
            List<Consulta> consultasPorHorario = consultaDAO.buscarPorHorario(horarioConsulta);
            System.out.println("Consultas por Horário:");
            for (Consulta consulta : consultasPorHorario) {
                System.out.println(consulta);
            }

            // Testa o método de excluir consulta
            consultaDAO.excluirConsulta(1);

            // Testa o método de atualizar consulta
            int idConsultaAtualizar = 2; // substitua pelo ID correto da consulta
            Timestamp novoHorarioConsulta = Timestamp.valueOf("2023-11-17 15:00:00");
            consultaDAO.atualizarConsulta(idConsultaAtualizar, novoHorarioConsulta);

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
