package co.projeto.Servicos;

import java.util.ArrayList;

import co.projeto.Entidades.Exame;
import co.projeto.Repositorio.RepositorioExame;

public class ExameServico {

    private RepositorioExame repositorioExame;

    public ExameServico() {
        this.repositorioExame = new RepositorioExame();
    }

    public void addExame(Exame exame) {
        this.repositorioExame.addExame(exame);
    }

    public void removerExame(Exame exame) {
        this.repositorioExame.removerExame(exame);
    }

    public void editarExame(Exame exameEditado) {
        this.repositorioExame.editarExame(exameEditado);
    }

    public ArrayList<Exame> listarExames() {
        return this.repositorioExame.listarExames();
    }

    public Exame buscarExamePorId(int idConsulta) {
        return this.repositorioExame.buscarExamePorId(idConsulta);
    }
}
