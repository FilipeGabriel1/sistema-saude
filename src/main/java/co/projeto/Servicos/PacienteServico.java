package co.projeto.Servicos;

import java.util.ArrayList;

import co.projeto.Entidades.Paciente;
import co.projeto.Repositorio.RepositorioPaciente;

public class PacienteServico {
    
    private RepositorioPaciente repositorioPaciente;

    public PacienteServico() {
        this.repositorioPaciente = new RepositorioPaciente();
    }

    public void addPaciente(Paciente paciente) {
        this.repositorioPaciente.addPaciente(paciente);
    }

    public void removerPaciente(Paciente paciente) {
        this.repositorioPaciente.removerPaciente(paciente);
    }

    public void editarPaciente(Paciente pacienteEditado) {
        this.repositorioPaciente.editarPaciente(pacienteEditado);
    }

    public ArrayList<Paciente> listarPacientes() {
        return this.repositorioPaciente.listarPacientes();
    }

    public Paciente buscarPacientePorId(int idPaciente) {
        return this.repositorioPaciente.buscarPacientePorId(idPaciente);
    }


}
