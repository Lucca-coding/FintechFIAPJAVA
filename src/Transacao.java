import java.util.Date;

public class Transacao {
    private String descricao;
    private double valor;
    private Date data;
    private String tipoTransacao;
    private Conta conta;

    public Transacao(String descricao, double valor, Date data, String tipoTransacao, Conta conta) {
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.tipoTransacao = tipoTransacao;
        this.conta = conta;
    }

    public void registrarTransacao() {
        // Implementar o registro da transação
        conta.atualizarSaldo(tipoTransacao.equals("Receita") ? valor : -valor);
    }

    // Métodos para listar transações, calcular total de receitas e despesas, etc.
}