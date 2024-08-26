import java.util.ArrayList;
import java.util.List;

public class Transacao {
    private double valor;
    private String tipo;  // "Recebimento" ou "Gasto"
    private String descricao;
    private Categoria categoria;
    private static List<Transacao> transacoes = new ArrayList<>();
    private static double saldo = 0.0;

    public Transacao(double valor, String tipo, String descricao, Categoria categoria) {
        this.valor = valor;
        this.tipo = tipo;
        this.descricao = descricao;

        if (categoria == null) {
            this.categoria = Categoria.obterCategoriaPadrao();
        } else {
            this.categoria = categoria;
        }

        transacoes.add(this);
        if (tipo.equalsIgnoreCase("Recebimento")) {
            saldo += valor;
        } else if (tipo.equalsIgnoreCase("Gasto")) {
            saldo -= valor;
        }
    }

    public double getValor() {
        return valor;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public static double getSaldo() {
        return saldo;
    }

    public static void exibirTransacoes() {
        System.out.println("Histórico de Transações:");
        for (Transacao transacao : transacoes) {
            System.out.println(transacao);
        }
        System.out.println("Saldo atual: R$" + saldo);
    }

    @Override
    public String toString() {
        return tipo + ": " + descricao + " | Valor: R$" + valor + " | Categoria: " + categoria;
    }
}
