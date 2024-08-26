import java.util.ArrayList;
import java.util.List;

public class ObjetivoFinanceiro {
    private String nome;
    private double valorMeta;
    private double valorAtual;
    private static List<ObjetivoFinanceiro> objetivos = new ArrayList<>();

    public ObjetivoFinanceiro(String nome, double valorMeta) {
        this.nome = nome;
        this.valorMeta = valorMeta;
        this.valorAtual = 0;
        objetivos.add(this);
    }

    public String getNome() {
        return nome;
    }

    public double getValorMeta() {
        return valorMeta;
    }

    public double getValorAtual() {
        return valorAtual;
    }

    public void adicionarValor(double valor) {
        if (valor > 0) {
            valorAtual += valor;
            System.out.println("Valor de R$" + valor + " adicionado ao objetivo '" + nome + "'.");
        } else {
            System.out.println("Valor inválido para adicionar ao objetivo.");
        }
    }

    public static ObjetivoFinanceiro obterObjetivoPorNome(String nome) {
        for (ObjetivoFinanceiro objetivo : objetivos) {
            if (objetivo.getNome().equalsIgnoreCase(nome)) {
                return objetivo;
            }
        }
        System.out.println("Objetivo não encontrado.");
        return null;
    }

    public static void exibirObjetivos() {
        System.out.println("Objetivos financeiros:");
        for (ObjetivoFinanceiro objetivo : objetivos) {
            System.out.println("- " + objetivo.getNome() + " | Meta: R$" + objetivo.getValorMeta() + " | Atual: R$" + objetivo.getValorAtual());
        }
    }
}