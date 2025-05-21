package co.projeto.Interfaces;

import java.util.List;

import co.projeto.Entidades.Paciente;

public interface InterfacePaciente {

    void addPaciente(Paciente paciente);

    void removerPaciente(Paciente paciente);

    void editarPaciente(Paciente pacienteEditado);

    List<Paciente> listarPacientes();

    Paciente buscarPacientePorId(int id);
   



}
