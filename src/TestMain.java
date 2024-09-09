public class TestMain {
    public static void main(String[] args) {
        // Criando um objeto Perfil
        Perfil perfil = new Perfil("João Silva", "01/01/1990", "123456789", "joao@example.com");
        System.out.println("Perfil criado:");
        System.out.println("Nome: " + perfil.getNomeCompleto());
        System.out.println("Data de Nascimento: " + perfil.getDataNascimento());
        System.out.println("Telefone: " + perfil.getTelefone());
        System.out.println("Email: " + perfil.getEmail());

        // Criando um objeto ObjetivoFinanceiro
        ObjetivoFinanceiro objetivo = new ObjetivoFinanceiro("Viagem para Europa", 5000.00);
        System.out.println("\nObjetivo financeiro criado:");
        System.out.println("Nome do Objetivo: " + objetivo.getNome());
        System.out.println("Valor a Atingir: " + objetivo.getValorAtingir());

        // Adicionando valor ao objetivo financeiro
        objetivo.adicionarValor(1500.00);
        System.out.println("Valor atual do objetivo após adicionar R$ 1500: " + objetivo.getValorAtual());

        // Tente adicionar outro valor ao objetivo financeiro
        objetivo.adicionarValor(2000.00);
        System.out.println("Valor atual do objetivo após adicionar R$ 2000: " + objetivo.getValorAtual());
    }
}
