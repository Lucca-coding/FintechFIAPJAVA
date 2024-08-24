public class Conta {
    private String nomeConta;
    private double saldo;
    private String tipoConta;
    private String banco;

    public Conta(String nomeConta, double saldo, String tipoConta, String banco) {
        this.nomeConta = nomeConta;
        this.saldo = saldo;
        this.tipoConta = tipoConta;
        this.banco = banco;
    }

    public void adicionarConta() {
        // Implementar a adição de uma nova conta
    }

    public void atualizarSaldo(double valor) {
        this.saldo += valor;
    }

    public double consultarSaldo() {
        return this.saldo;
    }
}