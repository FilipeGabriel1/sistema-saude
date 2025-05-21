package co.projeto.Repositorio;

import java.util.ArrayList;


import co.projeto.Interfaces.InterfaceExame;
import co.projeto.Entidades.Exame;

public class RepositorioExame implements InterfaceExame {
    private ArrayList<Exame> exameList;

    public RepositorioExame() {
        this.exameList = new ArrayList<>();
    }

    public void addExame(Exame exame) {
        this.exameList.add(exame);
    }

    public void removerExame(Exame exame) {
        this.exameList.remove(exame);
    }

    public void editarExame(Exame exameEditado) {
        Exame exameAntigo = buscarExamePorId(exameEditado.getId());     
        if (exameAntigo != null) {
            int index = exameList.indexOf(exameAntigo);
            exameList.set(index, exameEditado);
        }
    }
    public ArrayList<Exame> listarExames() {
        return exameList;
    }

    public Exame buscarExamePorId(int idExame) {
        for (Exame exame : exameList) {
            if (exame.getId() == idExame) {
                return exame;
            }
        }
        return null;
    }
}
