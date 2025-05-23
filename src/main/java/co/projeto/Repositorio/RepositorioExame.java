package co.projeto.Repositorio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import co.projeto.Interfaces.InterfaceExame;
import co.projeto.Conexao;
import co.projeto.Entidades.Exame;
import java.time.LocalDate;

public class RepositorioExame implements InterfaceExame {
    private ArrayList<Exame> exameList;

    public RepositorioExame() {
        this.exameList = new ArrayList<>();
            }
        
    

    public void addExame(Exame exame) {

           var sql = "insert into exame (data_exame, id, resultado, tipo_exame) values (?, ?, ? , ?)";

            try (var conexão = Conexao.obterConexao();
             var stmt = conexão.prepareStatement(sql)) {

            stmt.setDate(1, java.sql.Date.valueOf(exame.getDataExame()));
            stmt.setInt(2,exame.getId());
            stmt.setString(3, exame.getResultado());
            stmt.setString(4, exame.getTipoExame());

            stmt.executeUpdate();

            exameList.add(exame);

        } catch (SQLException e) {
            
            throw new RuntimeException(e);
        }

        this.exameList.add(exame);
    }

    public void removerExame(Exame exame) {

         var sql = "delete from exame where id = ?";
        
        try (var conexão = Conexao.obterConexao();
             var stmt = conexão.prepareStatement(sql)) {

    
       stmt.setInt(1, exame.getId());
        stmt.executeUpdate();

        } catch (SQLException e) {
           throw new RuntimeException(e);
        }
        
        this.exameList.remove(exame);
    }

    public void editarExame(Exame exameEditado) {

        var sql = "update exame set data_exame = ?, resultado = ?, tipo_exame = ? where id = ?";

           try (var conexão = Conexao.obterConexao();
             var stmt = conexão.prepareStatement(sql)) {

        stmt.setDate(1, java.sql.Date.valueOf(exameEditado.getDataExame()));
        stmt.setString(2, exameEditado.getResultado());
        stmt.setString(3, exameEditado.getTipoExame());
        stmt.setInt(4, exameEditado.getId());
        stmt.executeUpdate();

        } catch (SQLException e) {
           throw new RuntimeException(e);
        }
         

    }

      
    public ArrayList<Exame> listarExames() {
        ArrayList<Exame> exames = new ArrayList<>();
        String sql = "SELECT * FROM exame";

        try (var conexao = Conexao.obterConexao();
             var stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String tipoExame = rs.getString("tipo_exame");
                LocalDate dataExame = rs.getDate("data_exame").toLocalDate();
                String resultado = rs.getString("resultado");

                Exame exame = new Exame(id, tipoExame, dataExame, resultado);
                exames.add(exame);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return exames;
    }

     

    public Exame buscarExamePorId(int idExame) {
        Exame exame = null;

         var sql = "Select * from exame where id = ?";

           try (var conexão = Conexao.obterConexao();
             var stmt = conexão.prepareStatement(sql)) {

                stmt.setInt(1, idExame);

        try(ResultSet rs = stmt.executeQuery()){
            while (rs.next()) {
              exame = new Exame(
                rs.getInt("id"),
                rs.getString("resultado"),
                rs.getDate("data_exame").toLocalDate(),
                rs.getString("tipo_exame")
              );

                exameList.add(exame);


              
                
            }
        }

        } catch (SQLException e) {
           throw new RuntimeException(e);
        }

        return exame;
    }


}