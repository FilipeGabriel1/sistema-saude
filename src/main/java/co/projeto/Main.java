package co.projeto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import co.projeto.Entidades.Consulta;
import co.projeto.Entidades.Exame;
import co.projeto.Entidades.Medico;
import co.projeto.Entidades.Paciente;
import co.projeto.Repositorio.RepositorioConsulta;
import co.projeto.Repositorio.RepositorioExame;
import co.projeto.Servicos.ConsultaServico;

public class Main {
    public static void main(String[] args) {
       
 RepositorioExame repositorioExame = new RepositorioExame();

        int idBusca = 1; // Altere para o id que deseja buscar
        Exame exame = repositorioExame.buscarExamePorId(idBusca);

        if (exame != null) {
            System.out.println("Exame encontrado:");
            System.out.println(exame);
        } else {
            System.out.println("Exame não encontrado para o id: " + idBusca);
        }
          System.out.println("-------------------------------------");

           

        int idEditar = 1; // id do exame que deseja editar
        Exame exameExistente = repositorioExame.buscarExamePorId(idEditar);

        if (exameExistente != null) {
            // Crie um novo objeto Exame com os dados atualizados
           Exame exameEditado = new Exame(idEditar, LocalDate.now(), "Positivo", "ChurusBangus - Churusbingus");

            repositorioExame.editarExame(exameEditado);
            System.out.println("Exame editado com sucesso!");
        } else {
            System.out.println("Exame não encontrado para o id: " + idEditar);
        }

        System.out.println("-------------------------------------");

         int idRemover = 1; // id do exame que deseja remover
        Exame exameParaRemover = repositorioExame.buscarExamePorId(idRemover);

        if (exameParaRemover != null) {
            repositorioExame.removerExame(exameParaRemover);
            System.out.println("Exame removido com sucesso!");
        } else {
            System.out.println("Exame não encontrado para o id: " + idRemover);
        }
    }
}