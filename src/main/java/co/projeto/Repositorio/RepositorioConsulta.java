package co.projeto.Repositorio;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;


import co.projeto.Interfaces.InterfaceConsulta;
import co.projeto.Conexao;
import co.projeto.Entidades.Consulta;
import co.projeto.Entidades.Medico;
import co.projeto.Entidades.Paciente;



public class RepositorioConsulta implements InterfaceConsulta {
    private ArrayList<Consulta> consultaList;
    private RepositorioPaciente repositorioPaciente;
    private RepositorioMedico repositorioMedico;

    public RepositorioConsulta() {
        this.consultaList = new ArrayList<>();
        this.repositorioPaciente = new RepositorioPaciente();
        this.repositorioMedico = new RepositorioMedico();
    }

    public void addConsulta(Consulta consulta) {

        var sql = "insert into consulta (data_consulta, id, medico_id, paciente_id) values (?, ?, ? , ?)";

        try (var conexão = Conexao.obterConexao();
             var stmt = conexão.prepareStatement(sql)) {

            stmt.setTimestamp(1, java.sql.Timestamp.valueOf(consulta.getDataConsulta().atStartOfDay()));
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

        stmt.setTimestamp(1, java.sql.Timestamp.valueOf(consultaEditado.getDataConsulta().atStartOfDay()));
        stmt.setInt(2, consultaEditado.getMedico().getCrm());
        stmt.setInt(3, consultaEditado.getPaciente().getId());
        stmt.setInt(4, consultaEditado.getId());
        stmt.executeUpdate();

        } catch (SQLException e) {
           throw new RuntimeException(e);
        }
         

        }
    
    public ArrayList<Consulta> listarConsultas() {
        ArrayList<Consulta> consultas = new ArrayList<>();
        String sql = "SELECT * FROM consulta";

        RepositorioPaciente repositorioPaciente = new RepositorioPaciente();
        RepositorioMedico repositorioMedico = new RepositorioMedico();

        try (var conexao = Conexao.obterConexao();
             var stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                int pacienteId = rs.getInt("paciente_id");
                int medicoCrm = rs.getInt("medico_id");
                LocalDate dataConsulta = rs.getDate("data_consulta").toLocalDate();

                Paciente paciente = repositorioPaciente.buscarPacientePorId(pacienteId);
                Medico medico = repositorioMedico.buscarMedicoPorCrm(medicoCrm);

                Consulta consulta = new Consulta(id, paciente, medico, dataConsulta);
                consultas.add(consulta);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return consultas;
    }

    public Consulta buscarConsultaPorId(int idConsulta) {

        Consulta consulta = null;

        var sql = "Select * from consulta where id = ?";

        try (var conexão = Conexao.obterConexao();
             var stmt = conexão.prepareStatement(sql)) {

            stmt.setInt(1, idConsulta);

            try(ResultSet rs = stmt.executeQuery()){
                if (rs.next()) {
                    int pacienteId = rs.getInt("paciente_id");
                    int medicoId = rs.getInt("medico_id");

                    Paciente paciente = repositorioPaciente.buscarPacientePorId(pacienteId);
                    Medico medico = repositorioMedico.buscarMedicoPorCrm(medicoId);

                    consulta = new Consulta(rs.getInt("id"), paciente, medico, rs.getTimestamp("data_consulta").toLocalDateTime().toLocalDate());
                    consultaList.add(consulta);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return consulta;
    }
}
