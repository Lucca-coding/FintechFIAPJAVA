public class ObjetivoFinanceiro {
    private String nome;
    private double valorAtingir;
    private double valorAtual;

    public ObjetivoFinanceiro(String nome, double valorAtingir) {
        this.nome = nome;
        this.valorAtingir = valorAtingir;
        this.valorAtual = 0;
    }

    public String getNome() {
        return nome;
    }

    public double getValorAtingir() {
        return valorAtingir;
    }

    public double getValorAtual() {
        return valorAtual;
    }

    public void adicionarValor(double valor) {
        this.valorAtual += valor;
    }

    public static void exibirObjetivo(ObjetivoFinanceiro objetivo) {
        System.out.println("Nome: " + objetivo.getNome());
        System.out.println("Valor a Atingir: " + objetivo.getValorAtingir());
        System.out.println("Valor Atual: " + objetivo.getValorAtual());
        System.out.println("-----------------------");
    }
}
