package co.projeto.Interfaces;

import java.util.ArrayList;

import co.projeto.Entidades.Exame;

public interface InterfaceExame {
    void addExame(Exame exame);

    void removerExame(Exame exame);

    void editarExame(Exame exameEditado);

    ArrayList<Exame> listarExames();

    Exame buscarExamePorId(int idExame);
}