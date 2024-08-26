import java.util.ArrayList;
import java.util.List;

public class Categoria {
    private String nome;
    private static List<Categoria> categorias = new ArrayList<>();
    private static Categoria categoriaPadrao = new Categoria("Padrão");

    public Categoria(String nome) {
        this.nome = nome;
        categorias.add(this);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static Categoria obterCategoriaPorNome(String nome) {
        for (Categoria categoria : categorias) {
            if (categoria.getNome().equalsIgnoreCase(nome)) {
                return categoria;
            }
        }
        System.out.println("Categoria não encontrada.");
        return null;
    }

    public static Categoria obterCategoriaPadrao() {
        return categoriaPadrao;
    }

    public static void exibirCategorias() {
        System.out.println("Categorias disponíveis:");
        for (Categoria categoria : categorias) {
            System.out.println("- " + categoria.getNome());
        }
    }

    @Override
    public String toString() {
        return nome;
    }
}