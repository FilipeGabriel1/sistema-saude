package co.projeto;

import co.projeto.Entidades.Consulta;
import co.projeto.Repositorio.RepositorioConsulta;
import co.projeto.Servicos.ConsultaServico;

public class Main {
    public static void main(String[] args) {
       
        // Aqui você pode adicionar chamadas para os métodos do ConsultaServico

        RepositorioConsulta repositorioConsulta = new RepositorioConsulta();
        ConsultaServico consultaServico = new ConsultaServico(repositorioConsulta);




        Consulta consulta = new Consulta(0, null, null, null);
        consultaServico.addConsulta(consulta);
       System.out.println(consultaServico.listarConsultas());

       System.out.println("------------------");


       System.out.println(repositorioConsulta.listarConsultas());

       repositorioConsulta.addConsulta(consulta);

         System.out.println(repositorioConsulta.listarConsultas());
    }
}