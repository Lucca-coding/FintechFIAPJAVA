import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login usuario = null;
        Perfil perfil = null;
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
                            System.out.print("Digite seu email: ");
                            String email = scanner.nextLine();
                            System.out.print("Digite sua senha: ");
                            String senha = scanner.nextLine();
                            usuario = new Login(email, senha);
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
                            Categoria categoriaRecebimento;

                            if (nomeCategoriaRecebimento.isEmpty()) {
                                categoriaRecebimento = Categoria.obterCategoriaPadrao();
                            } else {
                                categoriaRecebimento = Categoria.obterCategoriaPorNome(nomeCategoriaRecebimento);
                            }

                            if (categoriaRecebimento == null) {
                                categoriaRecebimento = Categoria.obterCategoriaPadrao();
                            }

                            new Transacao(valorRecebimento, "Recebimento", descricaoRecebimento, categoriaRecebimento);
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
                            Categoria categoriaGasto;

                            if (nomeCategoriaGasto.isEmpty()) {
                                categoriaGasto = Categoria.obterCategoriaPadrao();
                            } else {
                                categoriaGasto = Categoria.obterCategoriaPorNome(nomeCategoriaGasto);
                            }

                            if (categoriaGasto == null) {
                                categoriaGasto = Categoria.obterCategoriaPadrao();
                            }

                            new Transacao(valorGasto, "Gasto", descricaoGasto, categoriaGasto);
                            System.out.println("Gasto adicionado com sucesso!");
                            break;
                        case 4: // Exibir Transações
                            // Chame o método que exibe transações aqui
                            break;
                        case 5: // Criar Objetivo Financeiro
                            System.out.print("Digite o nome do objetivo financeiro: ");
                            String nomeObjetivo = scanner.nextLine();
                            System.out.print("Digite o valor a atingir: ");
                            double valorAtingir = scanner.nextDouble();
                            scanner.nextLine(); // Consumir a nova linha

                            ObjetivoFinanceiro objetivo = new ObjetivoFinanceiro(nomeObjetivo, valorAtingir);
                            System.out.println("Objetivo financeiro criado com sucesso!");
                            // Adicione o objetivo ao gerenciador ou lista de objetivos
                            break;
                        case 6: // Transferir para Objetivo
                            // Implemente a lógica para transferir dinheiro para o objetivo financeiro
                            break;
                        case 7: // Exibir Objetivos Financeiros
                            // Chame o método que exibe objetivos financeiros aqui
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

            // Voltar ao menu após as operações, se o usuário não escolheu sair
            if (continuar) {
                System.out.println("\nPressione Enter para continuar...");
                scanner.nextLine();
            }
        }

        scanner.close();
    }
}
