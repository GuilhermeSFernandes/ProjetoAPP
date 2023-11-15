package Entities;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class Consulta {
    private int idConsulta;
    private int paciente; // Relacionamento com Paciente
    private String medico; // Relacionamento com Medico
    private Timestamp horarioConsulta;

    public Consulta(int idConsulta, Paciente paciente, Medico medico, Timestamp horarioConsulta) {
        this.idConsulta = idConsulta;
        this.paciente = paciente.getIdPaciente();
        this.medico = String.valueOf(medico);
        this.horarioConsulta = horarioConsulta;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public int getPaciente() {
        return paciente;
    }

    public String getMedico() {
        return medico;
    }

    public Timestamp getHorarioConsulta() {
        return horarioConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public void setPaciente(int paciente) {
        this.paciente = paciente;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public void setHorarioConsulta(Timestamp horarioConsulta) {
        this.horarioConsulta = horarioConsulta;
    }
    @Override
    public String toString() {
        return "Consulta{" +
                "idConsulta=" + idConsulta +
                ", paciente=" + paciente +
                ", medico=" + medico +
                ", horarioConsulta=" + horarioConsulta +
                '}';
    }
}
