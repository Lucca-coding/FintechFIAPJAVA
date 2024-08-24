import java.util.Date;

public class Transacao {
    private Date data;
    private double valor;
    private String tipo;  // "Recebimento" ou "Gasto"
    private String descricao;

    public Transacao(double valor, String tipo, String descricao) {
        this.data = new Date();
        this.valor = valor;
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
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

    @Override
    public String toString() {
        return "Data: " + data + ", Tipo: " + tipo + ", Valor: " + valor + ", Descrição: " + descricao;
    }
}
