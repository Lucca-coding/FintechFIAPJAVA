import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Login usuario = null;  // Inicialmente, não há usuário registrado
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("=== Menu de Login ===");
            System.out.println("1. Registrar");
            System.out.println("2. Fazer Login");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                int opcao = scanner.nextInt();
                scanner.nextLine();  // Consumir a nova linha

                switch (opcao) {
                    case 1:
                        // Registro do usuário
                        System.out.print("Digite seu email: ");
                        String novoEmail = scanner.nextLine();
                        System.out.print("Digite sua senha: ");
                        String novaSenha = scanner.nextLine();
                        usuario = new Login(novoEmail, novaSenha);
                        System.out.println("Usuário registrado com sucesso!");
                        break;
                    case 2:
                        if (usuario == null) {
                            System.out.println("Nenhum usuário registrado. Por favor, registre-se primeiro.");
                        } else {
                            // Processo de login
                            System.out.print("Digite seu email: ");
                            String email = scanner.nextLine();
                            System.out.print("Digite sua senha: ");
                            String senha = scanner.nextLine();

                            if (usuario.autenticarUsuario(email, senha)) {
                                usuario.redirecionarParaTelaPrincipal();
                            } else {
                                usuario.exibirMensagemErro();
                            }
                        }
                        break;
                    case 3:
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