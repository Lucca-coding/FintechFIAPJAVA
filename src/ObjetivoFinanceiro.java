public class ObjetivoFinanceiro extends Financeiro {
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
            valorAtual += valor;
            if (valorAtual > valorAtingir) {
                valorAtual = valorAtingir; // Limitar o valor ao objetivo
            }
            System.out.println("Valor transferido com sucesso!");
        } else {
            System.out.println("Valor inválido para transferência.");
        }
    }

    public void exibirObjetivo() {
        System.out.println("=== Objetivo Financeiro ===");
        System.out.println("Nome: " + nome);
        System.out.println("Valor a Atingir: " + valorAtingir);
        System.out.println("Valor Atual: " + valorAtual);
        System.out.println("Progresso: " + (valorAtual / valorAtingir * 100) + "%");
    }
}
