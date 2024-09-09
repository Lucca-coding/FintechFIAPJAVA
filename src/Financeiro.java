import java.util.ArrayList;
import java.util.List;

public class Financeiro {
    private List<Transacao> transacoes = new ArrayList<>();

    public void adicionarTransacao(Transacao transacao) {
        transacoes.add(transacao);
    }

    public void exibirTransacoes() {
        for (Transacao t : transacoes) {
            System.out.println(t);
        }
    }
}
