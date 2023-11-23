package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import Entities.Especialidade;

public class EspecialidadeDAOTeste {

    public static void main(String[] args) {
        try (Connection conn = BancoDados.conectar()) {
            testarEspecialidadeDAO(conn);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void testarEspecialidadeDAO(Connection conn) {
        try {
            // Cadastrar Especialidade
            EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO(conn);
            Especialidade novaEspecialidade = new Especialidade(1, 0, "Dermatologia");
            especialidadeDAO.cadastrarEspecialidade(novaEspecialidade);

            // Listar Especialidades
            List<Especialidade> listaEspecialidades = especialidadeDAO.listarEspecialidades();
            assert !listaEspecialidades.isEmpty() : "A lista de especialidades não deve estar vazia";

            // Buscar Especialidade por Código
            int codigoBuscar = 1;
            Especialidade especialidadeBuscada = especialidadeDAO.buscarPorCodigo(codigoBuscar);
            assert especialidadeBuscada != null : "Especialidade não encontrada por código " + codigoBuscar;

            // Atualizar Especialidade
            Especialidade especialidadeAtualizada = new Especialidade(1, 0, "Cardiologia");
            especialidadeDAO.atualizarEspecialidade(especialidadeAtualizada);

            // Listar Especialidades após atualização
            listaEspecialidades = especialidadeDAO.listarEspecialidades();
            assert listaEspecialidades.stream().anyMatch(e -> e.getNomeEspecialidade().equals("Cardiologia")) : "Especialidade não atualizada corretamente";

            // Excluir Especialidade
            especialidadeDAO.excluirEspecialidade(1);

            // Listar Especialidades após exclusão
            listaEspecialidades = especialidadeDAO.listarEspecialidades();
            assert listaEspecialidades.stream().noneMatch(e -> e.getCodigoEspecialidade() == 1) : "Especialidade não excluída corretamente";

            System.out.println("Testes concluídos com sucesso.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
