package Entities;
import java.sql.Date;
public class PedidoExame {
    private int idPedidoExame;
    private int exame; // Relacionamento com Exame
    private String paciente; // Relacionamento com Paciente
    private String medico; // Relacionamento com Medico
    private Date dataRealizacao;
    private double valorPago;

    public PedidoExame(int idPedidoExame, int exame, String paciente, String medico, Date dataRealizacao, double valorPago) {
        this.idPedidoExame = idPedidoExame;
        this.exame = exame;
        this.paciente = paciente;
        this.medico = medico;
        this.dataRealizacao = dataRealizacao;
        this.valorPago = valorPago;
    }

    public int getIdPedidoExame() {
        return idPedidoExame;
    }

    public void setIdPedidoExame(int idPedidoExame) {
        this.idPedidoExame = idPedidoExame;
    }

    public int getExame() {
        return exame;
    }

    public void setExame(int exame) {
        this.exame = exame;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public Date getDataRealizacao() {
        return dataRealizacao;
    }

    public void setDataRealizacao(Date dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }
    @Override
    public String toString() {
        return "PedidoExame{" +
                "idPedidoExame=" + idPedidoExame +
                ", exame=" + exame +
                ", paciente='" + paciente + '\'' +
                ", medico='" + medico + '\'' +
                ", dataRealizacao=" + dataRealizacao +
                ", valorPago=" + valorPago +
                '}';
    }
}
