package co.projeto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import co.projeto.Entidades.Consulta;
import co.projeto.Entidades.Exame;
import co.projeto.Entidades.Medico;
import co.projeto.Entidades.Paciente;
import co.projeto.Repositorio.RepositorioConsulta;
import co.projeto.Repositorio.RepositorioExame;
import co.projeto.Repositorio.RepositorioMedico;
import co.projeto.Repositorio.RepositorioPaciente;
import co.projeto.Servicos.ConsultaServico;

public class Main {
     public static void main(String[] args) {
        RepositorioPaciente repositorioPaciente = new RepositorioPaciente();

      
      
         Paciente pacienteParaExcluir = repositorioPaciente.buscarPacientePorId(2);
        if (pacienteParaExcluir != null) {
            repositorioPaciente.removerPaciente(pacienteParaExcluir);
            System.out.println("Paciente removido com sucesso! Id: ");
        } else {
            System.out.println("Paciente não encontrado para o id: ");
        }
        
    }
}
