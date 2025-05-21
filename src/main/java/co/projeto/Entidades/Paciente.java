package co.projeto.Entidades;

public class Paciente  extends Pessoa {

    private int id;

        public Paciente(int pessoa_id, String nome, String cpf, String telefone, String email, String senha) {
        super(pessoa_id, nome, cpf, telefone, email, senha);

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


}
