import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Login usuario = null;
        GerenciadorDeTransacoes gerenciadorDeTransacoes = new GerenciadorDeTransacoes();
        GerenciadorDeObjetivos gerenciadorDeObjetivos = new GerenciadorDeObjetivos();
        boolean loggedIn = false;
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("=== Menu de Login ===");
            System.out.println("1. Registrar");
            System.out.println("2. Fazer Login");
            System.out.println("3. Adicionar Recebimento");
            System.out.println("4. Adicionar Gasto");
            System.out.println("5. Exibir Transações");
            System.out.println("6. Criar Objetivo Financeiro");
            System.out.println("7. Transferir para Objetivo");
            System.out.println("8. Exibir Objetivos Financeiros");
            System.out.println("9. Sair");
            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                int opcao = scanner.nextInt();
                scanner.nextLine();  // Consumir a nova linha

                switch (opcao) {
                    case 1:
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
                            System.out.print("Digite seu email: ");
                            String email = scanner.nextLine();
                            System.out.print("Digite sua senha: ");
                            String senha = scanner.nextLine();

                            if (usuario.autenticarUsuario(email, senha)) {
                                usuario.redirecionarParaTelaPrincipal();
                                loggedIn = true;
                            } else {
                                usuario.exibirMensagemErro();
                            }
                        }
                        break;
                    case 3:
                        if (loggedIn) {
                            System.out.print("Digite o valor do recebimento: ");
                            double valorRecebimento = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.print("Digite a descrição do recebimento: ");
                            String descricaoRecebimento = scanner.nextLine();
                            gerenciadorDeTransacoes.adicionarTransacao(valorRecebimento, "Recebimento", descricaoRecebimento);
                        } else {
                            System.out.println("Você precisa estar logado para adicionar uma transação.");
                        }
                        break;
                    case 4:
                        if (loggedIn) {
                            System.out.print("Digite o valor do gasto: ");
                            double valorGasto = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.print("Digite a descrição do gasto: ");
                            String descricaoGasto = scanner.nextLine();
                            gerenciadorDeTransacoes.adicionarTransacao(valorGasto, "Gasto", descricaoGasto);
                        } else {
                            System.out.println("Você precisa estar logado para adicionar uma transação.");
                        }
                        break;
                    case 5:
                        if (loggedIn) {
                            gerenciadorDeTransacoes.exibirTransacoes();
                        } else {
                            System.out.println("Você precisa estar logado para visualizar suas transações.");
                        }
                        break;
                    case 6:
                        if (loggedIn) {
                            System.out.print("Digite o nome do objetivo: ");
                            String nomeObjetivo = scanner.nextLine();
                            System.out.print("Digite o valor da meta: ");
                            double valorMeta = scanner.nextDouble();
                            scanner.nextLine();
                            gerenciadorDeObjetivos.criarObjetivo(nomeObjetivo, valorMeta);
                        } else {
                            System.out.println("Você precisa estar logado para criar um objetivo financeiro.");
                        }
                        break;
                    case 7:
                        if (loggedIn) {
                            System.out.print("Digite o nome do objetivo: ");
                            String nomeObjetivo = scanner.nextLine();
                            System.out.print("Digite o valor a transferir: ");
                            double valorTransferencia = scanner.nextDouble();
                            scanner.nextLine();
                            gerenciadorDeObjetivos.transferirParaObjetivo(nomeObjetivo, valorTransferencia, gerenciadorDeTransacoes);
                        } else {
                            System.out.println("Você precisa estar logado para transferir dinheiro para um objetivo.");
                        }
                        break;
                    case 8:
                        if (loggedIn) {
                            gerenciadorDeObjetivos.exibirObjetivos();
                        } else {
                            System.out.println("Você precisa estar logado para visualizar seus objetivos financeiros.");
                        }
                        break;
                    case 9:
                        System.out.println("Saindo...");
                        continuar = false;
                        break;
                    default:
                        System.out.println("Erro: Selecione uma das opções acima.");
                        break;
                }
            } else {
                System.out.println("Erro: Selecione uma das opções acima.");
                scanner.nextLine();  // Consumir a entrada inválida
            }

            if (continuar) {
                System.out.println("\nPressione Enter para voltar ao menu inicial...");
                scanner.nextLine();
            }
        }

        scanner.close();
    }
}
