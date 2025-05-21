package co.projeto.Entidades;

public class Medico  extends Pessoa {

   
    private String especialidade;
    private int id;

   
    public Medico(int pessoa_id, String nome, String cpf, String telefone, String email, String senha, String especialidade) {
        super(pessoa_id , nome, cpf, telefone, email, senha);
        this.especialidade = especialidade;
    }
    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

}
