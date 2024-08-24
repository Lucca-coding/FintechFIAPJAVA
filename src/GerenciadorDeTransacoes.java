import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeTransacoes {
    private List<Transacao> transacoes;
    private double saldo;

    public GerenciadorDeTransacoes() {
        this.transacoes = new ArrayList<>();
        this.saldo = 0.0;  // Saldo inicial da conta
    }

    public void adicionarTransacao(double valor, String tipo, String descricao) {
        Transacao transacao = new Transacao(valor, tipo, descricao);
        transacoes.add(transacao);

        if (tipo.equalsIgnoreCase("Recebimento")) {
            saldo += valor;  // Atualiza o saldo com o valor do recebimento
        } else if (tipo.equalsIgnoreCase("Gasto")) {
            saldo -= valor;  // Atualiza o saldo subtraindo o valor do gasto
        }

        System.out.println(tipo + " de " + valor + " adicionado(a) com sucesso.");
    }

    public void exibirTransacoes() {
        if (transacoes.isEmpty()) {
            System.out.println("Nenhuma transação registrada.");
        } else {
            System.out.println("=== Suas Transações ===");
            for (Transacao transacao : transacoes) {
                System.out.println(transacao);
            }
        }
        exibirSaldo();
    }

    public void exibirSaldo() {
        System.out.println("=== Saldo Atual: " + saldo + " ===");
    }
}
