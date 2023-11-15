package Entities;

public class Exame {
    private int codigoExame;
    private String nomeExame;
    private double valor;
    private String orientacoes;

    public Exame(int codigoExame, String nomeExame, double valor, String orientacoes) {
        this.codigoExame = codigoExame;
        this.nomeExame = nomeExame;
        this.valor = valor;
        this.orientacoes = orientacoes;
    }

    public int getCodigoExame() {
        return codigoExame;
    }

    public void setCodigoExame(int codigoExame) {
        this.codigoExame = codigoExame;
    }

    public String getNomeExame() {
        return nomeExame;
    }

    public void setNomeExame(String nomeExame) {
        this.nomeExame = nomeExame;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getOrientacoes() {
        return orientacoes;
    }

    public void setOrientacoes(String orientacoes) {
        this.orientacoes = orientacoes;
    }
    @Override
    public String toString() {
        return "Exame{" +
                "codigoExame=" + codigoExame +
                ", nomeExame='" + nomeExame + '\'' +
                ", valor=" + valor +
                ", orientacoes='" + orientacoes + '\'' +
                '}';
    }
}
