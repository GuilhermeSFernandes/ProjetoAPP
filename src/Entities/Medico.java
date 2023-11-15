package Entities;
import java.sql.Date;
public class Medico {
        private String crm;
        private String nomeCompleto;
        private String endereco;
        private String telefone;
        private Especialidade especialidade; // Relacionamento com Especialidade

    public Medico(String crm, String nomeCompleto, String endereco, String telefone, Especialidade especialidade) {
        this.crm = crm;
        this.nomeCompleto = nomeCompleto;
        this.endereco = endereco;
        this.telefone = telefone;
        this.especialidade = especialidade;
    }

    public String getCrm() {
        return crm;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }
    @Override
    public String toString() {
        return "Médico{" +
                "CRM='" + crm + '\'' +
                ", Nome='" + nomeCompleto + '\'' +
                ", Endereço='" + endereco + '\'' +
                ", Telefone='" + telefone + '\'' +
                ", Especialidade=" + especialidade +
                '}';
    }
}
