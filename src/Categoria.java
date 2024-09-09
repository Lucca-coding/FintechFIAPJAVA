public class Categoria {
    private String nome;

    // Construtor
    public Categoria(String nome) {
        this.nome = nome;
    }

    // Getter para o nome da categoria
    public String getNome() {
        return nome;
    }

    // Metodo estático para exibir categorias (exemplo)
    public static void exibirCategorias() {
        System.out.println("1. Alimentação");
        System.out.println("2. Transporte");
        System.out.println("3. Lazer");
        System.out.println("4. Outros");
    }

    // Metodo estático para obter a categoria por nome (exemplo)
    public static Categoria obterCategoriaPorNome(String nome) {
        switch (nome.toLowerCase()) {
            case "alimentação":
                return new Categoria("Alimentação");
            case "transporte":
                return new Categoria("Transporte");
            case "lazer":
                return new Categoria("Lazer");
            default:
                return null; // Ou retorna uma categoria padrão
        }
    }

    // Metodo estático para obter a categoria padrão (exemplo)
    public static Categoria obterCategoriaPadrao() {
        return new Categoria("Outros");
    }
}
