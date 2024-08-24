import java.util.ArrayList;
import java.util.List;

public class Login {
    private String email;
    private String senha;

    public Login(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public boolean autenticarUsuario(String email, String senha) {
        return this.email.equals(email) && this.senha.equals(senha);
    }

    public void exibirMensagemErro() {
        System.out.println("Erro: Email ou senha incorretos!");
    }

    public void redirecionarParaTelaPrincipal() {
        System.out.println("Login bem-sucedido! Redirecionando para a tela principal...");
    }
}
