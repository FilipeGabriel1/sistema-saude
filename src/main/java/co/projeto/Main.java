package co.projeto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import co.projeto.Entidades.Consulta;
import co.projeto.Entidades.Exame;
import co.projeto.Entidades.Medico;
import co.projeto.Entidades.Paciente;
import co.projeto.Entidades.Recepcionista;
import co.projeto.Repositorio.RepositorioConsulta;
import co.projeto.Repositorio.RepositorioExame;
import co.projeto.Repositorio.RepositorioMedico;
import co.projeto.Repositorio.RepositorioPaciente;
import co.projeto.Repositorio.RepositorioRecepcionista;
import co.projeto.Servicos.ConsultaServico;

public class Main {
     public static void main(String[] args) {
      
  RepositorioRecepcionista repositorioRecepcionista = new RepositorioRecepcionista();

        // Adicionar recepcionista
        Recepcionista recepcionista = new Recepcionista(
            2,                      // id
            "Jose Joao",            // nome
            "12345678900",          // cpf
            "11999999999",          // telefone
            "ana@email.com",        // email
            "senha123",             // senha
            "Manhã"                 // turno
        );
        
  System.out.println("Lista de recepcionistas:");
        for (Recepcionista r : repositorioRecepcionista.listarRecepcionistas()) {
            System.out.println(r);
        }
     
         int idBusca = 1;
        Recepcionista encontrada = repositorioRecepcionista.buscarRecepcionistaPorId(idBusca);
        if (encontrada != null) {
            System.out.println("Recepcionista encontrada: " + encontrada);
        } else {
            System.out.println("Recepcionista não encontrada para o id: " + idBusca);
        }

         Recepcionista recepcionistaEditada = new Recepcionista(
            1,                      // id (mesmo id)
            "Ana Souza",            // nome
            "12345678900",          // cpf
            "11888888888",          // novo telefone
            "ana@email.com",        // email
            "novaSenha456",         // nova senha
            "Tarde"                 // novo turno
        );
        repositorioRecepcionista.editarRecepcionista(recepcionistaEditada);
        System.out.println("Recepcionista editada!");

        repositorioRecepcionista.removerRecepcionista(recepcionistaEditada);
        System.out.println("Recepcionista removida!");
    }
}
