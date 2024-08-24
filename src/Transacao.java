public class Transacao {
    private double valor;
    private String tipo;
    private String descricao;

    public Transacao(double valor, String tipo, String descricao) {
        this.valor = valor;
        this.tipo = tipo;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return tipo + ": " + valor + " - " + descricao;
    }
}
