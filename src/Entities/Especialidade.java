package Entities;

public class Especialidade {
        private int idEspecialidade;
        private int codigoEspecialidade;
        private String nomeEspecialidade;

    public Especialidade(int idEspecialidade, int codigoEspecialidade, String nomeEspecialidade) {
        this.idEspecialidade = idEspecialidade;
        this.codigoEspecialidade = codigoEspecialidade;
        this.nomeEspecialidade = nomeEspecialidade;
    }

    public int getIdEspecialidade() {
        return idEspecialidade;
    }

    public int getCodigoEspecialidade() {
        return codigoEspecialidade;
    }

    public String getNomeEspecialidade() {
        return nomeEspecialidade;
    }
    public void setIdEspecialidade(int idEspecialidade) {
        this.idEspecialidade = idEspecialidade;
    }

    public void setCodigoEspecialidade(int codigoEspecialidade) {
        this.codigoEspecialidade = codigoEspecialidade;
    }

    public void setNomeEspecialidade(String nomeEspecialidade) {
        this.nomeEspecialidade = nomeEspecialidade;
    }
    @Override
    public String toString() {
        return "Especialidade{" +
                "codigoEspecialidade=" + codigoEspecialidade +
                ", nomeEspecialidade='" + nomeEspecialidade + '\'' +
                '}';
    }
}

