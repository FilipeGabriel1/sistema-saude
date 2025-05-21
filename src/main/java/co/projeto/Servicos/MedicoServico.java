package co.projeto.Servicos;

import java.util.ArrayList;

import co.projeto.Entidades.Medico;
import co.projeto.Repositorio.RepositorioMedico;

public class MedicoServico {

    private RepositorioMedico repositorioMedico;

    public MedicoServico() {
        this.repositorioMedico = new RepositorioMedico();
    }

    public void addMedico(Medico medico) {
        this.repositorioMedico.addMedico(medico);
    }

    public void removerMedico(Medico medico) {
        this.repositorioMedico.removerMedico(medico);
    }

    public void editarMedico(Medico medicoEditado) {
        this.repositorioMedico.editarMedico(medicoEditado);
    }

    public ArrayList<Medico> listarMedicos() {
        return this.repositorioMedico.listarMedicos();
    }

    public Medico buscarMedicoPorId(int idMedico) {
        return this.repositorioMedico.buscarMedicoPorId(idMedico);
    }

}
