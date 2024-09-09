public class Perfil extends Pessoa {
    private String email;

    public Perfil(String nomeCompleto, String dataNascimento, String telefone, String email) {
        super(nomeCompleto, dataNascimento, telefone);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
