import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Login usuario = null;
        Perfil perfil = null;
        GerenciadorDeTransacoes gerenciadorDeTransacoes = new GerenciadorDeTransacoes();
        GerenciadorDeObjetivos gerenciadorDeObjetivos = new GerenciadorDeObjetivos();
        boolean loggedIn = false;
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            if (!loggedIn) {
                System.out.println("=== Menu de Login ===");
                System.out.println("1. Registrar");
                System.out.println("2. Fazer Login");
                System.out.println("3. Sair");
            } else {
                System.out.println("=== Menu Principal ===");
                System.out.println("1. Exibir Perfil");
                System.out.println("2. Adicionar Recebimento");
                System.out.println("3. Adicionar Gasto");
                System.out.println("4. Exibir Transações");
                System.out.println("5. Criar Objetivo Financeiro");
                System.out.println("6. Transferir para Objetivo");
                System.out.println("7. Exibir Objetivos Financeiros");
                System.out.println("8. Sair");
            }

            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                int opcao = scanner.nextInt();
                scanner.nextLine();  // Consumir a nova linha

                if (!loggedIn) {
                    switch (opcao) {
                        case 1:
                            System.out.print("Digite seu nome completo: ");
                            String nomeCompleto = scanner.nextLine();
                            System.out.print("Digite sua data de nascimento (dd/mm/aaaa): ");
                            String dataNascimento = scanner.nextLine();
                            System.out.print("Digite seu telefone: ");
                            String telefone = scanner.nextLine();
                            System.out.print("Digite seu email: ");
                            String email = scanner.nextLine();
                            System.out.print("Digite sua senha: ");
                            String senha = scanner.nextLine();

                            usuario = new Login(email, senha);
                            perfil = new Perfil(nomeCompleto, dataNascimento, telefone, email);
                            System.out.println("Usuário registrado com sucesso!");
                            break;
                        case 2:
                            if (usuario == null) {
                                System.out.println("Nenhum usuário registrado. Por favor, registre-se primeiro.");
                            } else {
                                System.out.print("Digite seu email: ");
                                String emailLogin = scanner.nextLine();
                                System.out.print("Digite sua senha: ");
                                String senhaLogin = scanner.nextLine();

                                if (usuario.autenticarUsuario(emailLogin, senhaLogin)) {
                                    usuario.redirecionarParaTelaPrincipal();
                                    loggedIn = true;
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
                    switch (opcao) {
                        case 1:
                            if (perfil != null) {
                                System.out.println(perfil);
                            } else {
                                System.out.println("Perfil não encontrado.");
                            }
                            break;
                        case 2:
                            System.out.print("Digite o valor do recebimento: ");
                            double valorRecebimento = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.print("Digite a descrição do recebimento: ");
                            String descricaoRecebimento = scanner.nextLine();
                            gerenciadorDeTransacoes.adicionarTransacao(valorRecebimento, "Recebimento", descricaoRecebimento);
                            break;
                        case 3:
                            System.out.print("Digite o valor do gasto: ");
                            double valorGasto = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.print("Digite a descrição do gasto: ");
                            String descricaoGasto = scanner.nextLine();
                            gerenciadorDeTransacoes.adicionarTransacao(valorGasto, "Gasto", descricaoGasto);
                            break;
                        case 4:
                            gerenciadorDeTransacoes.exibirTransacoes();
                            break;
                        case 5:
                            System.out.print("Digite o nome do objetivo: ");
                            String nomeObjetivo = scanner.nextLine();
                            System.out.print("Digite o valor da meta: ");
                            double valorMeta = scanner.nextDouble();
                            scanner.nextLine();
                            gerenciadorDeObjetivos.criarObjetivo(nomeObjetivo, valorMeta);
                            break;
                        case 6:
                            System.out.print("Digite o nome do objetivo: ");
                            nomeObjetivo = scanner.nextLine();
                            System.out.print("Digite o valor a transferir: ");
                            double valorTransferencia = scanner.nextDouble();
                            scanner.nextLine();
                            gerenciadorDeObjetivos.transferirParaObjetivo(nomeObjetivo, valorTransferencia, gerenciadorDeTransacoes);
                            break;
                        case 7:
                            gerenciadorDeObjetivos.exibirObjetivos();
                            break;
                        case 8:
                            System.out.println("Saindo...");
                            continuar = false;
                            break;
                        default:
                            System.out.println("Erro: Selecione uma das opções acima.");
                            break;
                    }
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
