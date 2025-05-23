package co.projeto.Repositorio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.projeto.Conexao;
import co.projeto.Entidades.Paciente;
import co.projeto.Interfaces.InterfacePaciente;

public class RepositorioPaciente implements InterfacePaciente {

    private ArrayList<Paciente> pacienteList;

    public RepositorioPaciente() {
        this.pacienteList = new ArrayList<>();
    }

    public void addPaciente(Paciente paciente) {

           var sql = "insert into paciente (cpf, email, id, nome, senha, telefone) values (?, ?, ? , ?, ?, ?)";

      try (var conexão = Conexao.obterConexao();
             var stmt = conexão.prepareStatement(sql)) {

        stmt.setString(1, paciente.getCpf());
        stmt.setString(2, paciente.getEmail());
        stmt.setInt(3, paciente.getId());
        stmt.setString(4, paciente.getNome());
        stmt.setString(5, paciente.getSenha());
        stmt.setString(6, paciente.getTelefone());
        stmt.executeUpdate();

        } catch (SQLException e) {
           throw new RuntimeException(e);
        }
        this.pacienteList.add(paciente);
    }
       
    

    public void removerPaciente(Paciente paciente) {

           var sql = "delete from paciente where id = ?";
        
        try (var conexão = Conexao.obterConexao();
             var stmt = conexão.prepareStatement(sql)) {

    
       stmt.setInt(1, paciente.getId());
        stmt.executeUpdate();

        } catch (SQLException e) {
           throw new RuntimeException(e);
        }

        this.pacienteList.remove(paciente);
    }

    public void editarPaciente(Paciente pacienteEditado) {

           var sql = "update paciente set cpf = ?, email = ?, nome = ?, senha = ?, telefone = ? where id = ?";

             try (var conexão = Conexao.obterConexao();
             var stmt = conexão.prepareStatement(sql)) {

        
      stmt.setString(1, pacienteEditado.getCpf());
      stmt.setString(2, pacienteEditado.getEmail());
      stmt.setString(3, pacienteEditado.getNome());
      stmt.setString(4, pacienteEditado.getSenha());
      stmt.setString(5, pacienteEditado.getTelefone());
      stmt.setInt(6, pacienteEditado.getId());
      stmt.executeUpdate();


        } catch (SQLException e) {
           throw new RuntimeException(e);
        }

    }

    public ArrayList<Paciente> listarPacientes() {
    ArrayList<Paciente> pacientes = new ArrayList<>();
    String sql = "SELECT * FROM paciente";

    try (var conexao = Conexao.obterConexao();
         var stmt = conexao.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            int id = rs.getInt("id");
            String nome = rs.getString("nome");
            String cpf = rs.getString("cpf");
            String telefone = rs.getString("telefone");
            String email = rs.getString("email");
            String senha = rs.getString("senha");

            Paciente paciente = new Paciente(id, nome, cpf, telefone, email, senha);
            pacientes.add(paciente);
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    return pacientes;
}

    public Paciente buscarPacientePorId(int id) {

          Paciente paciente = null;

         var sql = "Select * from paciente where id = ?";

           try (var conexão = Conexao.obterConexao();
             var stmt = conexão.prepareStatement(sql)) {

                stmt.setInt(1, id);

        try(ResultSet rs = stmt.executeQuery()){
            while (rs.next()) {

                paciente = new Paciente(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf"), rs.getString("telefone"), rs.getString("email"), rs.getString("senha"));
                pacienteList.add(paciente);
;


              
                
            }
        }

        } catch (SQLException e) {
           throw new RuntimeException(e);
        }

        return paciente;
    }
       

    

}
