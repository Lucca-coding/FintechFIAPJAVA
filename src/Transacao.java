public class Transacao {
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

    public static void exibirTransacao(Transacao transacao) {
        System.out.println("Tipo: " + transacao.getTipo());
        System.out.println("Valor: " + transacao.getValor());
        System.out.println("Descrição: " + transacao.getDescricao());
        System.out.println("Categoria: " + transacao.getCategoria().getNome());
        System.out.println("-----------------------");
    }
}
