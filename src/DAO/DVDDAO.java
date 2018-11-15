/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.DVD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pedro Alcantara
 */
public class DVDDAO extends ExecuteSQL{
    public DVDDAO(Connection con) {
        super(con);
    }
    public List<DVD> ListarCodFilme(int cod){
     String sql = "select idfilme from dvd where iddvd = "+ cod + "";
     List<DVD> lista = new ArrayList<>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                   DVD a = new DVD();
                   a.setCod_filme(rs.getInt(1));
                   
                   lista.add(a);
                }
                return lista;
            }else{
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
     
    }
    public String Inserir_DVD(DVD a) {
        String sql = "insert into dvd values(0,?,?,?,?)";
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setInt(1, a.getCod_filme());
            ps.setDouble(2, a.getPreco());
            ps.setString(3, a.getData_compra());
            ps.setString(4, a.getSituacao());
            
            

            
            
            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso";
            }else {
                return "Erro ao inserir";
            }
            
            
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    
   
    public List<DVD> ListarDVD() {
        String sql = "select iddvd,idfilme,preco_compra,data_compra,situacao from dvd";
        List<DVD> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (ps != null) {
                while (rs.next()) {                    
                    DVD a = new DVD();
                    a.setCodigo(rs.getInt(1));
                    a.setCod_filme(rs.getInt(2));
                    a.setPreco(rs.getInt(3));
                    a.setData_compra(rs.getString(4));
                    a.setSituacao(rs.getString(5));
                    
                    lista.add(a);
                }
                
                return lista;
            }else {
                return null;
            }
            
        } catch (Exception e) {
            return null;
        }
    }
    
    
 
    public List<DVD> Pesquisar_Nome_DVD(String preco) {
        String sql = "select iddvd,idfilme,preco_compra,data_compra,situacao" + "from dvd where iddvd Like '"+ preco + "%'";
        List<DVD> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (ps != null) {
                while (rs.next()) {                    
                    DVD a = new DVD();
                    a.setCodigo(rs.getInt(1));
                    a.setCod_filme(rs.getInt(2));
                    a.setPreco(rs.getInt(3));
                    a.setData_compra(rs.getString(4));
                    a.setSituacao(rs.getString(5));
                    
                    lista.add(a);
                }
                
                return lista;
            }else {
                return null;
            }
            
        } catch (Exception e) {
            return null;
        }
        
    }
    
    
   
    public List<DVD> Pesquisar_Cod_DVD(int cod) {
        String sql = "select iddvd,idfilme,preco_compra,data_compra,situacao" + "from dvd where iddvd = '" + cod + "'";
        List<DVD> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (ps != null) {
                while (rs.next()) {                    
                    DVD a = new DVD();
                    a.setCodigo(rs.getInt(1));
                    a.setCod_filme(rs.getInt(2));
                    a.setPreco(rs.getInt(3));
                    a.setData_compra(rs.getString(4));
                    a.setSituacao(rs.getString(5));
                    
                    lista.add(a);
                }
                
                return lista;
            }else {
                return null;
            }
            
        } catch (Exception e) {
            return null;
        }
        
    }
    
    
  
    public boolean testar_DVD(int cod) {
        boolean Resultado = false;
        
        try {
            String sql = "select * from dvd where iddvd = " + cod + "";
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {                    
                    Resultado = true;
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        
        return Resultado;
    }
    
    
    
    
    public List<DVD> CapturarDVD(int cod) {
        String sql = "select * from dvd where iddvd =" + cod + " ";
        List<DVD> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {                    
                    DVD a = new DVD();
                    a.setCodigo(rs.getInt(1));
                    a.setCod_filme(rs.getInt(2));
                    a.setPreco(rs.getInt(3));
                    a.setData_compra(rs.getString(4));
                    a.setSituacao(rs.getString(5));

                    lista.add(a);
                }
                return lista;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    public boolean Testar_Situacao(int cod){
        boolean teste = false;
        try {
            String sql = "select iddvd from dvd where iddvd =" + cod +""
                    + "and situacao = 'Disponivel'";
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while(rs.next()){
                    teste = true;
                }
            }
        } catch (Exception e) {
        }
        return teste;
    }
    
    
   
    public String Alterar_DVD(DVD a) {
        String sql = "update dvd set idfilme = ?, preco_compra = ?, data_compra = ?, situacao = ? where iddvd = ?"; 
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, a.getCod_filme());
            ps.setDouble(2, a.getPreco());
            ps.setString(3, a.getData_compra());
            ps.setString(4, a.getSituacao());
            ps.setInt(5, a.getCodigo());
            
            if (ps.executeUpdate() > 0) {
                return "Atualizado com sucesso";
            } else {
                return "Erro ao atualizar";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public List<DVD> ListarComboDVD() {
        String sql = "select data_compra from dvd order by data_compra asc";
        List<DVD> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {                    
                    DVD a = new DVD();
                    a.setData_compra(rs.getString(1));
                    lista.add(a);
                }
                return lista;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<DVD> ConsultarCodigoDVD(String titulo) {
        String sql = "select iddvd from dvd where data_compra = '" + titulo + "'";
        List<DVD> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {                    
                    DVD a = new DVD();
                    a.setCodigo(rs.getInt(1));
                    lista.add(a);
                }
                return lista;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    public String Excluir_DVD(DVD a) {
        String sql = "delete from dvd where iddvd = ? and data_compra = ? ";
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, a.getCodigo());
            ps.setString(2, a.getData_compra());
            
            if (ps.executeUpdate() > 0) {
                return "Excluido com sucesso";
            } else {
                return "Erro ao excluir";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
