package co.projeto.Repositorio;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import co.projeto.Interfaces.InterfaceConsulta;
import co.projeto.Conexao;
import co.projeto.Entidades.Consulta;
import co.projeto.Entidades.Exame;



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
            stmt.setInt(3, consulta.getMedico().getCrm());
            stmt.setInt(4, consulta.getPaciente().getId());
            stmt.executeUpdate();

            consultaList.add(consulta);

        } catch (SQLException e) {
            
            throw new RuntimeException(e);
        }

    }

    public void removerConsulta(Consulta consulta) {

           var sql = "delete from consulta where id = ?";
        
        try (var conexão = Conexao.obterConexao();
             var stmt = conexão.prepareStatement(sql)) {

    
       stmt.setInt(1, consulta.getId());
        stmt.executeUpdate();

        } catch (SQLException e) {
           throw new RuntimeException(e);
        }
        
      
        this.consultaList.remove(consulta);
    }

    public void editarConsulta(Consulta consultaEditado) {

          var sql = "update consulta set data_consulta = ?, medico_id = ?, paciente_id = ? where id = ?";

           try (var conexão = Conexao.obterConexao();
             var stmt = conexão.prepareStatement(sql)) {

        stmt.setTimestamp(1, java.sql.Timestamp.valueOf(consultaEditado.getDataConsulta()));
        stmt.setInt(2, consultaEditado.getMedico().getCrm());
        stmt.setInt(3, consultaEditado.getPaciente().getId());
        stmt.setInt(4, consultaEditado.getId());
        stmt.executeUpdate();

        } catch (SQLException e) {
           throw new RuntimeException(e);
        }
         

        }
    
    public ArrayList<Consulta> listarConsultas() {
        

          var sql = "Select * from consulta";

            try (var conexão = Conexao.obterConexao();
             var stmt = conexão.prepareStatement(sql)) {

        try(ResultSet rs = stmt.executeQuery()){
            while (rs.next()) {
                int pacienteId = rs.getInt("paciente_id");
                int medicoId = rs.getInt("medico_id");

               Consulta consulta = new Consulta(rs.getInt("id"), pacienteId, medicoId,rs.
                );

                consultaList.add(consulta);
                
            }
        }

        } catch (SQLException e) {
           throw new RuntimeException(e);
        }

        return consultaList;

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
