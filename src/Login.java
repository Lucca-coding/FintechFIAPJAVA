public class Login {
    private String email;
    private String senha;
    private boolean loggedIn;

    public Login(String email, String senha) {
        this.email = email;
        this.senha = senha;
        this.loggedIn = false;
    }

    public boolean autenticarUsuario(String email, String senha) {
        if (this.email.equals(email) && this.senha.equals(senha)) {
            this.loggedIn = true;
            return true;
        }
        return false;
    }

    public void exibirMensagemErro() {
        System.out.println("Erro: Email ou senha incorretos!");
    }

    public void redirecionarParaTelaPrincipal() {
        System.out.println("Login bem-sucedido! Redirecionando para a tela principal...");
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    // Getters and setters for email and senha, if needed
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
