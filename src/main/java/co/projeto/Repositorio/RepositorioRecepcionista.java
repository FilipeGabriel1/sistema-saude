package co.projeto.Repositorio;



import co.projeto.Entidades.Recepcionista;
import java.util.ArrayList;
import co.projeto.Interfaces.InterfaceRecepcionista;

public class RepositorioRecepcionista implements InterfaceRecepcionista{
    private ArrayList<Recepcionista> recepcionistaList;

    public RepositorioRecepcionista() {
        this.recepcionistaList = new ArrayList<>();
    }

    public void addRecepcionista(Recepcionista recepcionista) {
        this.recepcionistaList.add(recepcionista);
    }

    public void removerRecepcionista(Recepcionista recepcionista) {
        this.recepcionistaList.remove(recepcionista);
    }

    public void editarRecepcionista(Recepcionista recepcionistaEditado) {
        Recepcionista recepcionistaAntigo = buscarRecepcionistaPorId(recepcionistaEditado.getId());
        if (recepcionistaAntigo != null) {
            int index = recepcionistaList.indexOf(recepcionistaAntigo);
            recepcionistaList.set(index, recepcionistaEditado);
        }
    }
    public ArrayList<Recepcionista> listarRecepcionistas() {
        return recepcionistaList;
    }

    public Recepcionista buscarRecepcionistaPorId(int idRecepcionista) {
        for (Recepcionista recepcionista : recepcionistaList) {
            if (recepcionista.getId() == idRecepcionista) {
                return recepcionista;
            }
        }
        return null;
    }
}
