package DAO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import Entities.Medico;
import Entities.Especialidade;

public class MedicoDAOTeste {
    public static void main(String[] args) {
        // Criando uma instância de Especialidade para associar ao médico
        Especialidade cardiologia = new Especialidade(1, 0, "Cardiologista");

        // Criando uma instância de Médico
        Medico medico = new Medico(null, null, null, null, null);
        medico.setCrm("12345");
        medico.setNomeCompleto("Dr. João Silva");
        medico.setEndereco("Rua Principal, 123");
        medico.setTelefone("123456789");
        medico.setEspecialidade(cardiologia);

        // Exibindo informações do médico usando o método toString
        System.out.println("Informações do Médico:");
        System.out.println(medico);
    }
}
