package co.projeto.Entidades;

import java.time.LocalDate;

public class Exame {

       private int id;
    private String tipoExame;
    private LocalDate dataExame;
    private String resultado;

    public Exame(int id, String tipoExame, LocalDate dataExame, String resultado) {
        this.id = id;
        this.tipoExame = tipoExame;
        this.dataExame = dataExame;
        this.resultado = resultado;
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

}
