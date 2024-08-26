import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeCategorias {
    private List<Categoria> categorias;

    public GerenciadorDeCategorias() {
        this.categorias = new ArrayList<>();
    }

    public void adicionarCategoria(String nome) {
        Categoria novaCategoria = new Categoria(nome);
        categorias.add(novaCategoria);
        System.out.println("Categoria '" + nome + "' adicionada com sucesso!");
    }

    public Categoria obterCategoriaPorNome(String nome) {
        for (Categoria categoria : categorias) {
            if (categoria.getNome().equalsIgnoreCase(nome)) {
                return categoria;
            }
        }
        System.out.println("Categoria não encontrada.");
        return null;
    }

    public void exibirCategorias() {
        System.out.println("Categorias disponíveis:");
        for (Categoria categoria : categorias) {
            System.out.println("- " + categoria.getNome());
        }
    }
}
