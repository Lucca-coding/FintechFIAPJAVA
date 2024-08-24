public class ObjetivoFinanceiro {
    private String nome;
    private double valorMeta;
    private double valorAtual;

    public ObjetivoFinanceiro(String nome, double valorMeta) {
        this.nome = nome;
        this.valorMeta = valorMeta;
        this.valorAtual = 0.0;  // Inicialmente, o valor alocado ao objetivo é 0
    }

    public void adicionarValor(double valor) {
        if (valor > 0) {
            this.valorAtual += valor;
            System.out.println("Valor de " + valor + " adicionado ao objetivo '" + nome + "'.");
        }
    }

    public double getValorMeta() {
        return valorMeta;
    }

    public double getValorAtual() {
        return valorAtual;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Objetivo: " + nome + " | Meta: " + valorMeta + " | Alocado: " + valorAtual;
    }
}