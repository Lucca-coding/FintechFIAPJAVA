import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login usuario = null;
        Perfil perfil = null;
        Transacao transacao = null;
        ObjetivoFinanceiro objetivo = null;
        boolean continuar = true;

        while (continuar) {
            if (usuario == null || !usuario.isLoggedIn()) {
                // Menu Inicial: Registro, Login, Sair
                System.out.println("=== Menu Inicial ===");
                System.out.println("1. Registrar");
                System.out.println("2. Fazer Login");
                System.out.println("3. Sair");
                System.out.print("Escolha uma opção: ");

                if (scanner.hasNextInt()) {
                    int opcao = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha

                    switch (opcao) {
                        case 1: // Registrar
                            System.out.print("Digite seu nome completo: ");
                            String nome = scanner.nextLine();
                            System.out.print("Digite sua data de nascimento (dd/mm/aaaa): ");
                            String dataNascimento = scanner.nextLine();
                            System.out.print("Digite seu telefone: ");
                            String telefone = scanner.nextLine();
                            System.out.print("Digite seu email: ");
                            String email = scanner.nextLine();
                            System.out.print("Digite sua senha: ");
                            String senha = scanner.nextLine();

                            usuario = new Login(email, senha);
                            perfil = new Perfil(nome, dataNascimento, telefone, email);
                            System.out.println("Usuário registrado com sucesso!");
                            break;
                        case 2: // Fazer Login
                            if (usuario == null) {
                                System.out.println("Erro: Nenhum usuário registrado.");
                                break;
                            }
                            System.out.print("Digite seu email: ");
                            String emailLogin = scanner.nextLine();
                            System.out.print("Digite sua senha: ");
                            String senhaLogin = scanner.nextLine();
                            if (usuario.autenticarUsuario(emailLogin, senhaLogin)) {
                                System.out.println("Login bem-sucedido!");
                                usuario.redirecionarParaTelaPrincipal();
                            } else {
                                usuario.exibirMensagemErro();
                            }
                            break;
                        case 3: // Sair
                            System.out.println("Saindo...");
                            continuar = false;
                            break;
                        default:
                            System.out.println("Erro: Selecione uma das opções acima.");
                            break;
                    }
                } else {
                    System.out.println("Erro: Selecione uma das opções acima.");
                    scanner.nextLine(); // Consumir a entrada inválida
                }
            } else {
                // Menu Principal: Exibir Perfil, Adicionar Recebimento, etc.
                System.out.println("=== Menu Principal ===");
                System.out.println("1. Exibir Perfil");
                System.out.println("2. Adicionar Recebimento");
                System.out.println("3. Adicionar Gasto");
                System.out.println("4. Exibir Transações");
                System.out.println("5. Criar Objetivo Financeiro");
                System.out.println("6. Transferir para Objetivo");
                System.out.println("7. Exibir Objetivos Financeiros");
                System.out.println("8. Sair");
                System.out.print("Escolha uma opção: ");

                if (scanner.hasNextInt()) {
                    int opcao = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha

                    switch (opcao) {
                        case 1: // Exibir Perfil
                            if (perfil == null) {
                                System.out.println("Perfil não configurado.");
                            } else {
                                System.out.println("Perfil:");
                                System.out.println("Nome: " + perfil.getNomeCompleto());
                                System.out.println("Data de Nascimento: " + perfil.getDataNascimento());
                                System.out.println("Telefone: " + perfil.getTelefone());
                                System.out.println("Email: " + perfil.getEmail());
                            }
                            break;
                        case 2: // Adicionar Recebimento
                            System.out.print("Digite o valor do recebimento: ");
                            double valorRecebimento = scanner.nextDouble();
                            scanner.nextLine(); // Consumir a nova linha
                            System.out.print("Digite a descrição do recebimento: ");
                            String descricaoRecebimento = scanner.nextLine();

                            // Seleção de Categoria
                            Categoria.exibirCategorias();
                            System.out.print("Escolha a categoria ou pressione Enter para usar a categoria padrão: ");
                            String nomeCategoriaRecebimento = scanner.nextLine();
                            Categoria categoriaRecebimento = Categoria.obterCategoriaPorNome(nomeCategoriaRecebimento);

                            if (categoriaRecebimento == null) {
                                categoriaRecebimento = Categoria.obterCategoriaPadrao();
                            }

                            transacao = new Transacao(valorRecebimento, "Recebimento", descricaoRecebimento, categoriaRecebimento);
                            System.out.println("Recebimento adicionado com sucesso!");
                            break;
                        case 3: // Adicionar Gasto
                            System.out.print("Digite o valor do gasto: ");
                            double valorGasto = scanner.nextDouble();
                            scanner.nextLine(); // Consumir a nova linha
                            System.out.print("Digite a descrição do gasto: ");
                            String descricaoGasto = scanner.nextLine();

                            // Seleção de Categoria
                            Categoria.exibirCategorias();
                            System.out.print("Escolha a categoria ou pressione Enter para usar a categoria padrão: ");
                            String nomeCategoriaGasto = scanner.nextLine();
                            Categoria categoriaGasto = Categoria.obterCategoriaPorNome(nomeCategoriaGasto);

                            if (categoriaGasto == null) {
                                categoriaGasto = Categoria.obterCategoriaPadrao();
                            }

                            transacao = new Transacao(valorGasto, "Gasto", descricaoGasto, categoriaGasto);
                            System.out.println("Gasto adicionado com sucesso!");
                            break;
                        case 4: // Exibir Transações
                            if (transacao == null) {
                                System.out.println("Nenhuma transação registrada.");
                            } else {
                                System.out.println("=== Transações ===");
                                Transacao.exibirTransacao(transacao);
                            }
                            break;
                        case 5: // Criar Objetivo Financeiro
                            System.out.print("Digite o nome do objetivo financeiro: ");
                            String nomeObjetivo = scanner.nextLine();
                            System.out.print("Digite o valor a atingir: ");
                            double valorAtingir = scanner.nextDouble();
                            scanner.nextLine(); // Consumir a nova linha

                            objetivo = new ObjetivoFinanceiro(nomeObjetivo, valorAtingir);
                            System.out.println("Objetivo financeiro criado com sucesso!");
                            break;
                        case 6: // Transferir para Objetivo
                            if (objetivo == null) {
                                System.out.println("Nenhum objetivo financeiro registrado.");
                                break;
                            }

                            System.out.print("Digite o valor a ser transferido: ");
                            double valorTransferir = scanner.nextDouble();
                            scanner.nextLine(); // Consumir a nova linha

                            objetivo.adicionarValor(valorTransferir);
                            System.out.println("Valor transferido com sucesso!");
                            break;
                        case 7: // Exibir Objetivos Financeiros
                            if (objetivo == null) {
                                System.out.println("Nenhum objetivo financeiro registrado.");
                            } else {
                                System.out.println("=== Objetivo Financeiro ===");
                                ObjetivoFinanceiro.exibirObjetivo(objetivo);
                            }
                            break;
                        case 8: // Sair
                            System.out.println("Saindo...");
                            continuar = false;
                            break;
                        default:
                            System.out.println("Erro: Selecione uma das opções acima.");
                            break;
                    }
                } else {
                    System.out.println("Erro: Selecione uma das opções acima.");
                    scanner.nextLine(); // Consumir a entrada inválida
                }
            }
        }
        scanner.close();
    }
}
