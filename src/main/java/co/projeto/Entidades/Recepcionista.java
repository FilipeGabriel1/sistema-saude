package co.projeto.Entidades;


    public class Recepcionista extends Pessoa {

    private int id;
    private String turno;

    public Recepcionista(int pessoa_id, String nome, String cpf, String telefone, String email, String senha, String turno) {
        super(pessoa_id, nome, cpf, telefone, email, senha);
        this.turno = turno;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTurno() {
        return turno;
    }
    public void setTurno(String turno) {
        this.turno = turno;
    }


}



