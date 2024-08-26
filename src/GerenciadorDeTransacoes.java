import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeTransacoes {
    private List<Transacao> transacoes;
    private double saldo;

    public GerenciadorDeTransacoes() {
        this.transacoes = new ArrayList<>();
        this.saldo = 0.0;
    }

    public void adicionarTransacao(double valor, String tipo, String descricao, Categoria categoria) {
        Transacao novaTransacao = new Transacao(valor, tipo, descricao, categoria);
        transacoes.add(novaTransacao);
        if (tipo.equalsIgnoreCase("Recebimento")) {
            saldo += valor;
        } else if (tipo.equalsIgnoreCase("Gasto")) {
            saldo -= valor;
        }
        System.out.println("Transação adicionada com sucesso: " + novaTransacao);
    }

    public void exibirTransacoes() {
        System.out.println("Histórico de Transações:");
        for (Transacao transacao : transacoes) {
            System.out.println(transacao);
        }
        System.out.println("Saldo atual: R$" + saldo);
    }

    public double getSaldo() {
        return saldo;
    }
}
