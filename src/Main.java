import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Criando um usuário com email e senha
        Login usuario = new Login("joao@example.com", "senha123");

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("=== Menu de Login ===");
            System.out.println("1. Fazer Login");
            System.out.println("2. Sair");
            System.out.print("Escolha uma opção: ");

            // Verifica se a entrada é um número
            if (scanner.hasNextInt()) {
                int opcao = scanner.nextInt();
                scanner.nextLine();  // Consumir a nova linha

                switch (opcao) {
                    case 1:
                        System.out.print("Digite seu email: ");
                        String email = scanner.nextLine();
                        System.out.print("Digite sua senha: ");
                        String senha = scanner.nextLine();

                        Login Login = new Login(email, senha);

                        if (Login.autenticarUsuario(Login)) {
                            Login.redirecionarParaTelaPrincipal();
                        } else {
                            Login.exibirMensagemErro();
                        }
                        break;
                    case 2:
                        System.out.println("Saindo...");
                        continuar = false;
                        break;
                    default:
                        System.out.println("Erro: Selecione uma das opções acima.");
                        break;
                }
            } else {
                // Caso o usuário digite algo que não seja um número
                System.out.println("Erro: Selecione uma das opções acima.");
                scanner.nextLine();  // Consumir a entrada inválida
            }

            // Voltar ao menu após a tentativa de login, se o usuário não escolheu sair
            if (continuar) {
                System.out.println("\nPressione Enter para voltar ao menu inicial...");
                scanner.nextLine();
            }
        }

        scanner.close();
    }
}