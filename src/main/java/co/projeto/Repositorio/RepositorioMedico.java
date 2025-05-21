package co.projeto.Repositorio;

import java.util.ArrayList;

import co.projeto.Entidades.Medico;
import co.projeto.Interfaces.InterfaceMedico;

public class RepositorioMedico implements InterfaceMedico {
    private ArrayList<Medico> medicoList;

    public RepositorioMedico() {
        this.medicoList = new ArrayList<>();
    }

    public void addMedico(Medico medico) {
        this.medicoList.add(medico);
    }

    public void removerMedico(Medico medico) {
        this.medicoList.remove(medico);
    }

    public void editarMedico(Medico medicoEditado) {
        Medico medicoAntigo = buscarMedicoPorId(medicoEditado.getId());
        if (medicoAntigo != null) {
            int index = medicoList.indexOf(medicoAntigo);
            medicoList.set(index, medicoEditado);
        }
    }

    public ArrayList<Medico> listarMedicos() {
        return medicoList;
    }

    public Medico buscarMedicoPorId(int id) {
        for (Medico medico : medicoList) {
            if (medico.getId() == id) {
                return medico;
            }
        }
        return null;
    }

    public Medico buscarMedicoPorCpf(String cpf) {
        for (Medico medico : medicoList) {
            if (medico.getCpf().equals(cpf)) {
                return medico;
            }
        }
        return null;
    }
}