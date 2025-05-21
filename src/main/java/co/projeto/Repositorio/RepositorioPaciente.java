package co.projeto.Repositorio;

import java.util.ArrayList;

import co.projeto.Entidades.Paciente;
import co.projeto.Interfaces.InterfacePaciente;

public class RepositorioPaciente implements InterfacePaciente {

    private ArrayList<Paciente> pacienteList;

    public RepositorioPaciente() {
        this.pacienteList = new ArrayList<>();
    }

    public void addPaciente(Paciente paciente) {
        this.pacienteList.add(paciente);
    }

    public void removerPaciente(Paciente paciente) {
        this.pacienteList.remove(paciente);
    }

    public void editarPaciente(Paciente pacienteEditado) {
        Paciente pacienteAntigo = buscarPacientePorId(pacienteEditado.getId());
        if (pacienteAntigo != null) {
            int index = pacienteList.indexOf(pacienteAntigo);
            pacienteList.set(index, pacienteEditado);
        }
    }

    public ArrayList<Paciente> listarPacientes() {
        return pacienteList;
    }

    public Paciente buscarPacientePorId(int id) {
        for (Paciente paciente : pacienteList) {
            if (paciente.getId() == id) {
                return paciente;
            }
        }
        return null;
    }

    public Paciente buscarPacientePorCpf(String cpf) {
        for (Paciente paciente : pacienteList) {
            if (paciente.getCpf().equals(cpf)) {
                return paciente;
            }
        }
        return null;
    }
    

}
