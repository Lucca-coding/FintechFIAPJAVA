public class ObjetivoFinanceiro {
    private String nome;
    private double valorAtingir;
    private double valorAtual;

    public ObjetivoFinanceiro(String nome, double valorAtingir) {
        this.nome = nome;
        this.valorAtingir = valorAtingir;
        this.valorAtual = 0.0;
    }

    public void adicionarValor(double valor) {
        if (valor > 0) {
            this.valorAtual += valor;
        }
    }

    // Getters e setters para os atributos
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorAtingir() {
        return valorAtingir;
    }

    public void setValorAtingir(double valorAtingir) {
        this.valorAtingir = valorAtingir;
    }

    public double getValorAtual() {
        return valorAtual;
    }
}
