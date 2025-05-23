package co.projeto.Entidades;

import java.time.LocalDate;

public class Exame {

       private int id;
    private String tipoExame;
    private LocalDate dataExame;
    private String resultado;

   public Exame(int id, String resultado, java.time.LocalDate dataExame, String tipoExame) {
    this.id = id;
    this.dataExame = dataExame;
    this.resultado = resultado;
    this.tipoExame = tipoExame;
}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoExame() {
        return tipoExame;
    }

    public void setTipoExame(String tipoExame) {
        this.tipoExame = tipoExame;
    }

    public LocalDate getDataExame() {
        return dataExame;
    }

    public void setDataExame(LocalDate dataExame) {
        this.dataExame = dataExame;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    @Override
public String toString() {
    return "Exame{" +
            "id=" + id +
            ", dataExame=" + dataExame +
            ", resultado='" + resultado + '\'' +
            ", tipoExame='" + tipoExame + '\'' +
            '}';
}

}
