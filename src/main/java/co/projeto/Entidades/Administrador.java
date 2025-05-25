package co.projeto.Entidades;

public class Administrador extends Pessoa {

    private int id;

    public Administrador(int id, String nome, String cpf, String telefone, String email, String senha) {
        super(nome, cpf, telefone, email, senha);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    



}
