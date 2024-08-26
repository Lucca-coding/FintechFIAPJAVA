public class Transacao {
    private double valor;
    private String tipo;  // "Recebimento" ou "Gasto"
    private String descricao;
    private Categoria categoria;

    public Transacao(double valor, String tipo, String descricao, Categoria categoria) {
        this.valor = valor;
        this.tipo = tipo;
        this.descricao = descricao;
        this.categoria = categoria;
    }

    public double getValor() {
        return valor;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return tipo + ": " + descricao + " | Valor: R$" + valor + " | Categoria: " + categoria;
    }
}
