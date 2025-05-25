package co.projeto.Entidades;

public class Medico  extends Pessoa {

   
    private String especialidade;
    private int crm;

   
    public Medico(int crm , String nome, String cpf, String telefone, String email, String senha, String especialidade) {
        super( nome, cpf, telefone, email, senha);
        this.especialidade = especialidade;
        this.crm = crm;
    }
    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    public int getCrm() {
        return crm;
    }
    public void setCrm(int crm) {
        this.crm = crm;
    }
@Override
public String toString() {
    return "---------------------------" +
           "\nCRM: " + crm +
           "\nNome: " + nome +
           "\nCPF: " + cpf +
           "\nTelefone: " + telefone +
           "\nEmail: " + email +
           "\nSenha: " + senha +
           "\nEspecialidade: " + especialidade +
           "\n---------------------------";
}
    

}


