import java.util.ArrayList;
import java.util.List;

public class Login {
    private String email;
    private String senha;
    private List<Transacao> transacoes;

    public Login(String email, String senha) {
        this.email = email;
        this.senha = senha;
        this.transacoes = new ArrayList<>();
    }

    public boolean autenticarUsuario(String email, String senha) {
        return this.email.equals(email) && this.senha.equals(senha);
    }

    public void exibirMensagemErro() {
        System.out.println("Erro: Email ou senha incorretos!");
    }

    public void redirecionarParaTelaPrincipal() {
        System.out.println("Login bem-sucedido! Redirecionando para a tela principal...");
    }

    public void adicionarTransacao(double valor, String tipo, String descricao) {
        Transacao transacao = new Transacao(valor, tipo, descricao);
        transacoes.add(transacao);
        System.out.println("Transação adicionada com sucesso!");
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
    }
}
