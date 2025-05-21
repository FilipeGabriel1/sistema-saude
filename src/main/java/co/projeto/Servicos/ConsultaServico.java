package co.projeto.Servicos;

import java.util.ArrayList;

import co.projeto.Entidades.Consulta;
import co.projeto.Repositorio.RepositorioConsulta;

public class ConsultaServico {
    private RepositorioConsulta repositorioConsulta;

    public ConsultaServico(RepositorioConsulta repositorioConsulta) {
        this.repositorioConsulta = repositorioConsulta;
    }

    public void addConsulta(Consulta consulta) {
        this.repositorioConsulta.addConsulta(consulta);
    }

    public void removerConsulta(Consulta consulta) {
        this.repositorioConsulta.removerConsulta(consulta);
    }

    public void editarConsulta(Consulta consultaEditado) {
        this.repositorioConsulta.editarConsulta(consultaEditado);
    }

    public ArrayList<Consulta> listarConsultas() {
        return this.repositorioConsulta.listarConsultas();
    }

    public Consulta buscarConsultaPorId(int idConsulta) {
        return this.repositorioConsulta.buscarConsultaPorId(idConsulta);
    }
    

}
