public class Transacao extends Financeiro {
    private double valor;
    private String tipo;
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

    public void exibirTransacao() {
        System.out.println("Tipo: " + this.getTipo());
        System.out.println("Valor: " + this.getValor());
        System.out.println("Descrição: " + this.getDescricao());
        System.out.println("Categoria: " + this.getCategoria().getNome());
        System.out.println("-----------------------");
    }
}
