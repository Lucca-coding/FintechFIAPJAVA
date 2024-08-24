import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeObjetivos {
    private List<ObjetivoFinanceiro> objetivos;

    public GerenciadorDeObjetivos() {
        this.objetivos = new ArrayList<>();
    }

    public void criarObjetivo(String nome, double valorMeta) {
        ObjetivoFinanceiro objetivo = new ObjetivoFinanceiro(nome, valorMeta);
        objetivos.add(objetivo);
        System.out.println("Objetivo '" + nome + "' criado com meta de " + valorMeta + ".");
    }

    public void transferirParaObjetivo(String nomeObjetivo, double valor, GerenciadorDeTransacoes gerenciadorDeTransacoes) {
        if (gerenciadorDeTransacoes.getSaldo() >= valor) {
            for (ObjetivoFinanceiro objetivo : objetivos) {
                if (objetivo.getNome().equalsIgnoreCase(nomeObjetivo)) {
                    objetivo.adicionarValor(valor);
                    gerenciadorDeTransacoes.atualizarSaldo(-valor);  // Reduz o saldo da conta
                    System.out.println("Transferido " + valor + " para o objetivo '" + nomeObjetivo + "'.");
                    return;
                }
            }
            System.out.println("Objetivo não encontrado.");
        } else {
            System.out.println("Saldo insuficiente para realizar a transferência.");
        }
    }

    public void exibirObjetivos() {
        if (objetivos.isEmpty()) {
            System.out.println("Nenhum objetivo financeiro registrado.");
        } else {
            System.out.println("=== Seus Objetivos Financeiros ===");
            for (ObjetivoFinanceiro objetivo : objetivos) {
                System.out.println(objetivo);
            }
        }
    }
}