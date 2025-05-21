package co.projeto.Interfaces;

import java.util.List;
import co.projeto.Entidades.Medico;

public interface InterfaceMedico {

    void addMedico(Medico medico);

    void removerMedico(Medico medico);

    void editarMedico(Medico medicoEditado);

    List<Medico> listarMedicos();

    Medico buscarMedicoPorId(int id);
    
}
