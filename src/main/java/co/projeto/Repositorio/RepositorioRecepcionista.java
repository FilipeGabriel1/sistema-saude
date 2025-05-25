package co.projeto.Repositorio;



import co.projeto.Conexao;

import co.projeto.Entidades.Recepcionista;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import co.projeto.Interfaces.InterfaceRecepcionista;

public class RepositorioRecepcionista implements InterfaceRecepcionista{
    private ArrayList<Recepcionista> recepcionistaList;

    public RepositorioRecepcionista() {
        this.recepcionistaList = new ArrayList<>();
    }

    public void addRecepcionista(Recepcionista recepcionista) {
        
           var sql = "insert into recepcionista (cpf, email, id, nome, senha, telefone, turno ) values (?, ?, ? , ?, ?, ?, ?)";

      try (var conexão = Conexao.obterConexao();
             var stmt = conexão.prepareStatement(sql)) {

        stmt.setString(1, recepcionista.getCpf());
        stmt.setString(2, recepcionista.getEmail());
        stmt.setInt(3, recepcionista.getId());
        stmt.setString(4, recepcionista.getNome());
        stmt.setString(5, recepcionista.getSenha());
        stmt.setString(6, recepcionista.getTelefone());
        stmt.setString(7, recepcionista.getTurno());
        stmt.executeUpdate();

        } catch (SQLException e) {
           throw new RuntimeException(e);
        }
       
        this.recepcionistaList.add(recepcionista);
    }

    public void removerRecepcionista(Recepcionista recepcionista) {

        
           var sql = "delete from recepcionista where id = ?";
        
        try (var conexão = Conexao.obterConexao();
             var stmt = conexão.prepareStatement(sql)) {

    
       stmt.setInt(1, recepcionista.getId());
        stmt.executeUpdate();

        } catch (SQLException e) {
           throw new RuntimeException(e);
        }

        
        this.recepcionistaList.remove(recepcionista);
    }

    public void editarRecepcionista(Recepcionista recepcionistaEditado) {

        
           var sql = "update recepcionista set cpf = ?, email = ?, nome = ?, senha = ?, telefone = ?, turno = ? where id = ?";

             try (var conexão = Conexao.obterConexao();
             var stmt = conexão.prepareStatement(sql)) {

      
            stmt.setString(1, recepcionistaEditado.getCpf());
            stmt.setString(2, recepcionistaEditado.getEmail());   
            stmt.setString(3, recepcionistaEditado.getNome());
            stmt.setString(4, recepcionistaEditado.getSenha());
            stmt.setString(5, recepcionistaEditado.getTelefone());
            stmt.setString(6, recepcionistaEditado.getTurno());
            stmt.setInt(7, recepcionistaEditado.getId());                
            stmt.executeUpdate();


        } catch (SQLException e) {
           throw new RuntimeException(e);
        }
      
    }
    public ArrayList<Recepcionista> listarRecepcionistas() {
        ArrayList<Recepcionista> lista = new ArrayList<>();
        var sql = "SELECT * FROM recepcionista";

        try (var conexão = Conexao.obterConexao();
             var stmt = conexão.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Recepcionista recepcionista = new Recepcionista(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("telefone"),
                    rs.getString("email"),
                    rs.getString("senha"),
                    rs.getString("turno")
                );
                lista.add(recepcionista);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;
    }

    public Recepcionista buscarRecepcionistaPorId(int idRecepcionista) {

           Recepcionista recepcionista = null;

         var sql = "Select * from recepcionista where id = ?";

           try (var conexão = Conexao.obterConexao();
             var stmt = conexão.prepareStatement(sql)) {

                stmt.setInt(1, idRecepcionista);

        try(ResultSet rs = stmt.executeQuery()){
            while (rs.next()) {

                recepcionista = new Recepcionista(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf"), rs.getString("telefone"), rs.getString("email"), rs.getString("senha"), rs.getString("turno")
                );
                recepcionistaList.add(recepcionista);

 
            }
        }

        } catch (SQLException e) {
           throw new RuntimeException(e);
        }

        return recepcionista;
    }
    public Recepcionista buscarRecepcionistaPorIdESenha(int id, String senha) {
        Recepcionista recepcionista = null;
        var sql = "SELECT * FROM recepcionista WHERE id = ? AND senha = ?";
        try (var conexao = Conexao.obterConexao();
             var stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setString(2, senha);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    recepcionista = new Recepcionista(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getString("turno")
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return recepcionista;
    }
       
    }

