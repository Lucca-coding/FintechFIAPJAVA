public class Categoria {
    private String nome;

    public Categoria(String nome) {
        this.nome = nome;
    }

    // Getters e setters para o atributo nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Métodos para exibir categorias e obter categorias por nome
    public static void exibirCategorias() {
        // Implementação para exibir categorias disponíveis
    }

    public static Categoria obterCategoriaPadrao() {
        // Implementação para retornar a categoria padrão
        return new Categoria("Padrão");
    }

    public static Categoria obterCategoriaPorNome(String nome) {
        // Implementação para buscar e retornar a categoria pelo nome
        // Se não encontrada, retorna null
        return null; // Substituir com a lógica real
    }
}
