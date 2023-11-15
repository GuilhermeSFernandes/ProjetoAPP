package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class BancoDadosTeste {

    public static void main(String[] args) {

        try (Connection conn = BancoDados.conectar()) {
            System.out.println("Conexão estabelecida.");
        } catch (SQLException | IOException e) {
            System.err.println("Erro ao estabelecer a conexão: " + e.getMessage());
        }

        System.out.println("Conexão finalizada.");
    }
}
