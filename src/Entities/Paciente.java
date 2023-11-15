package Entities;
import java.sql.Date;
public class Paciente {
    private int idPaciente;
    private String nome;
    private String foto;
    private Date dataNascimento;
    private String sexo;
    private String endereco;
    private String telefone;
    private String formaPagamento;

    public Paciente(String nome, String foto, Date dataNascimento, String sexo, String endereco, String telefone, String formaPagamento) {
        this.nome = nome;
        this.foto = foto;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.endereco = endereco;
        this.telefone = telefone;
        this.formaPagamento = formaPagamento;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public String getFoto() {
        return foto;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public String getNome() {
        return nome;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
    @Override
    public String toString() {
        return "Paciente{" +
                "idPaciente=" + idPaciente +
                ", nome='" + nome + '\'' +
                ", foto='" + foto + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", sexo='" + sexo + '\'' +
                ", endereco='" + endereco + '\'' +
                ", telefone='" + telefone + '\'' +
                ", formaPagamento='" + formaPagamento + '\'' +
                '}';
    }

}
