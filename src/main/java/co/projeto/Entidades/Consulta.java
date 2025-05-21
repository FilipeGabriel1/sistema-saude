package co.projeto.Entidades;

import java.time.LocalDateTime;

public class Consulta {

    private int id;
    private Paciente paciente;
    private Medico medico;
    private LocalDateTime dataConsulta;

    public Consulta(int id, Paciente paciente, Medico medico, LocalDateTime dataConsulta) {
        this.id = id;
        this.paciente = paciente;
        this.medico = medico;
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
    public LocalDateTime getDataConsulta() {
        return dataConsulta;
    }
    public void setDataConsulta(LocalDateTime dataConsulta) {
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
