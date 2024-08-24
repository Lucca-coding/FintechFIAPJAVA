public class Orcamento {
    private String categoria;
    private double limiteGasto;
    private double gastoAtual;

    public Orcamento(String categoria, double limiteGasto) {
        this.categoria = categoria;
        this.limiteGasto = limiteGasto;
        this.gastoAtual = 0.0;
    }

    public void atualizarGasto(double valor) {
        this.gastoAtual += valor;
    }

    public boolean verificarSeEstourouOrcamento() {
        return this.gastoAtual > this.limiteGasto;
    }

    // Getters e Setters
}