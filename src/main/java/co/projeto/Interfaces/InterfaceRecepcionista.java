package co.projeto.Interfaces;

import java.util.List;

import co.projeto.Entidades.Recepcionista;

public interface InterfaceRecepcionista {
    void addRecepcionista(Recepcionista recepcionista);

    void removerRecepcionista(Recepcionista recepcionista);

    void editarRecepcionista(Recepcionista recepcionistaEditado);

    List<Recepcionista> listarRecepcionistas();

    Recepcionista buscarRecepcionistaPorId(int idRecepcionista);
}