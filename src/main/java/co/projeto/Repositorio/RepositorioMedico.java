package co.projeto.Repositorio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.projeto.Conexao;
import co.projeto.Entidades.Medico;
import co.projeto.Interfaces.InterfaceMedico;

public class RepositorioMedico implements InterfaceMedico {
    private ArrayList<Medico> medicoList;

    public RepositorioMedico() {
        this.medicoList = new ArrayList<>();
    }

    public void addMedico(Medico medico) {

         var sql = "insert into medico (cpf, crm, email, especialidade, nome, senha, telefone) values (?, ?, ? , ?, ?, ?, ?)";

      try (var conexão = Conexao.obterConexao();
             var stmt = conexão.prepareStatement(sql)) {

        stmt.setString(1, medico.getCpf());
        stmt.setInt(2, medico.getCrm());
        stmt.setString(3, medico.getEmail());
        stmt.setString(4, medico.getEspecialidade());
        stmt.setString(5, medico.getNome());
        stmt.setString(6, medico.getSenha());
        stmt.setString(7, medico.getTelefone());
        stmt.executeUpdate();

        } catch (SQLException e) {
           throw new RuntimeException(e);
        }
        this.medicoList.add(medico);
    }

    public void removerMedico(Medico medico) {

         var sql = "delete from medico where crm = ?";
        
        try (var conexão = Conexao.obterConexao();
             var stmt = conexão.prepareStatement(sql)) {

    
       stmt.setInt(1, medico.getCrm());
        stmt.executeUpdate();

        } catch (SQLException e) {
           throw new RuntimeException(e);
        }
        this.medicoList.remove(medico);
    }

    public void editarMedico(Medico medicoEditado) {

            var sql = "update medico set cpf = ?, email = ?, especialidade = ?, nome = ?, senha = ?, telefone = ? where crm = ?";

             try (var conexão = Conexao.obterConexao();
             var stmt = conexão.prepareStatement(sql)) {

        
        stmt.setString(1, medicoEditado.getCpf());
        stmt.setString(2, medicoEditado.getEmail());
        stmt.setString(3, medicoEditado.getEspecialidade());
        stmt.setString(4, medicoEditado.getNome());
        stmt.setString(5, medicoEditado.getSenha());
        stmt.setString(6, medicoEditado.getTelefone());
        stmt.setInt(7, medicoEditado.getCrm());
        stmt.executeUpdate();

        } catch (SQLException e) {
           throw new RuntimeException(e);
        }

     
    }

    public ArrayList<Medico> listarMedicos() {
        ArrayList<Medico> medicos = new ArrayList<>();
        String sql = "SELECT * FROM medico";

        try (var conexao = Conexao.obterConexao();
             var stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int crm = rs.getInt("crm");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");
                String senha = rs.getString("senha");
                String especialidade = rs.getString("especialidade");

                Medico medico = new Medico(crm, nome, cpf, telefone, email, senha, especialidade);
                medicos.add(medico);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return medicos;
    }



    public Medico buscarMedicoPorCrm(int crm) {

        Medico medico = null;

         var sql = "Select * from medico where crm = ?";

           try (var conexão = Conexao.obterConexao();
             var stmt = conexão.prepareStatement(sql)) {

                stmt.setInt(1, crm);

        try(ResultSet rs = stmt.executeQuery()){
            while (rs.next()) {
                medico = new Medico(rs.getInt("crm"), rs.getString("nome"), rs.getString("cpf"), rs.getString("telefone"), rs.getString("email"), rs.getString("senha"), rs.getString("especialidade")
                );
                medicoList.add(medico);
;


              
                
            }
        }

        } catch (SQLException e) {
           throw new RuntimeException(e);
        }

        return medico;
    }

    public Medico buscarMedicoPorCrmESenha(int crm, String senha) {
        Medico medico = null;
        try (var conexão = Conexao.obterConexao()) {
            String sql = "SELECT * FROM medico WHERE crm = ? AND senha = ?";
            var stmt = conexão.prepareStatement(sql);
            stmt.setInt(1, crm);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                medico = new Medico(
                    rs.getInt("crm"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("telefone"),
                    rs.getString("email"),
                    rs.getString("senha"),
                    rs.getString("especialidade")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return medico;
    }
}