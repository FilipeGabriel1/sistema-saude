package co.projeto.Entidades;

import java.time.LocalDate;


public class Consulta {

    private int id;
    private Paciente paciente;
    private Medico medico;
    private LocalDate dataConsulta;

    public Consulta(int id, Paciente pacienteId, Medico medicoId, LocalDate dataConsulta) {
        this.id = id;
        this.paciente = pacienteId;
        this.medico = medicoId;
        this.dataConsulta = dataConsulta;
    
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    public Medico getMedico() {
        return medico;
    }
    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    public LocalDate getDataConsulta() {
        return dataConsulta;
    }
    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }


    @Override
public String toString() {
    return "Consulta{" +
            "id=" + id +
            ", paciente=" + paciente +
            ", medico=" + medico +
            ", dataConsulta=" + dataConsulta +
            '}';
}

}
