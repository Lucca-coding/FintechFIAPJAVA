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

    // Getters e setters para acessar os atributos
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
