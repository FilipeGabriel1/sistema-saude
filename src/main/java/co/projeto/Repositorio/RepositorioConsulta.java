package co.projeto.Repositorio;


import java.sql.SQLException;
import java.util.ArrayList;


import co.projeto.Interfaces.InterfaceConsulta;
import co.projeto.Conexao;
import co.projeto.Entidades.Consulta;



public class RepositorioConsulta implements InterfaceConsulta {
    private ArrayList<Consulta> consultaList;

    public RepositorioConsulta() {
        this.consultaList = new ArrayList<>();
    }

    public void addConsulta(Consulta consulta) {

        var sql = "insert into consulta (data_consulta, id, medico_id, paciente_id) values (?, ?, ? , ?)";

        try (var conexão = Conexao.obterConexao();
             var stmt = conexão.prepareStatement(sql)) {

            stmt.setTimestamp(1, java.sql.Timestamp.valueOf(consulta.getDataConsulta()));
            stmt.setInt(2, consulta.getId());
            stmt.setInt(3, consulta.getMedico().getId());
            stmt.setInt(4, consulta.getPaciente().getId());

            stmt.executeUpdate();

            consultaList.add(consulta);

        } catch (SQLException e) {
            
            throw new RuntimeException(e);
        }

    }

    public void removerConsulta(Consulta consulta) {
        this.consultaList.remove(consulta);
    }

    public void editarConsulta(Consulta consultaEditado) {
        Consulta consultaAntiga = buscarConsultaPorId(consultaEditado.getId());
        if (consultaAntiga !=null) {
            int index = consultaList.indexOf(consultaAntiga);
            consultaList.set(index, consultaEditado);
            
        }
        }
    
    public ArrayList<Consulta> listarConsultas() {
        return consultaList;

        var sql = "select * from consulta";

        }

    public Consulta buscarConsultaPorId(int idConsulta) {
        for (Consulta consulta : consultaList) {
            if (consulta.getId() == idConsulta) {
                return consulta;
            }
        }
        return null;
    }
}
