public class Financeiro {
    protected Transacao transacaoAtual;

    public void adicionarTransacao(Transacao transacao) {
        this.transacaoAtual = transacao;
        System.out.println("Transação adicionada com sucesso!");
    }

    public void exibirTransacoes() {
        if (transacaoAtual == null) {
            System.out.println("Nenhuma transação registrada.");
        } else {
            System.out.println("=== Transação ===");
            transacaoAtual.exibirTransacao();
        }
    }
}
