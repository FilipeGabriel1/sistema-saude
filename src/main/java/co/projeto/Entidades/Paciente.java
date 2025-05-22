package co.projeto.Entidades;

public class Paciente  extends Pessoa {

    private int id;

        public Paciente( int id, String nome, String cpf, String telefone, String email, String senha) {
        super(nome, cpf, telefone, email, senha);

        this.id = id;

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
public String toString() {
    return "Paciente{" +
            "id=" + id +
            ", nome='" + nome + '\'' +
            ", cpf='" + cpf + '\'' +
            ", telefone='" + telefone + '\'' +
            ", email='" + email + '\'' +
            ", senha='" + senha + '\'' +
            '}';
}


}
