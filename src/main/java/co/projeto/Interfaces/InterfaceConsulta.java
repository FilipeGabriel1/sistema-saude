package co.projeto.Interfaces;

import java.util.ArrayList;

import co.projeto.Entidades.Consulta;

public interface InterfaceConsulta 
{
    void addConsulta(Consulta consulta);

    void removerConsulta(Consulta consulta);

    void editarConsulta(Consulta consultaEditado);

    ArrayList<Consulta> listarConsultas();

    Consulta buscarConsultaPorId(int idConsulta);

}