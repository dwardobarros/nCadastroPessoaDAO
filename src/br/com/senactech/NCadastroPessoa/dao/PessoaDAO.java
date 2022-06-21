/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senactech.NCadastroPessoa.dao;

import br.com.senactech.NCadastroPessoa.conexao.Conexao;
import br.com.senactech.NCadastroPessoa.model.Pessoa;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author 666
 */
public class PessoaDAO {
    
    public void cadastrarPessoa(Pessoa pVO) throws SQLException{
        //Buscar conexao do BD
        Connection con = Conexao.getConexao();
        //Cria espaço de trabalho SQL, é a área no Java onde vamos executar  os scripts SQL
        Statement stat = con.createStatement();
        
        try {
       String sql;
                sql = "insert into pessoas values"
               + "null, '"
               + pVO.getNomePessoa() + "', " 
               + pVO.getCpf() + "', " 
               + pVO.getEndereco() + "', " 
               + pVO.getTelefone() + "', "
               +pVO.getIdade() + ", "
               +pVO.isStatus() + ";";
       
       stat.execute(sql);
       
        } catch (SQLException e) {

        throw new SQLException("Erro ao inserir Pessoa! \n" + e.getMessage()) ;
        
         } finally {
            con.close();
            stat.close();
    }
        
    }
    
    public ArrayList<Pessoa> listarPessoas() throws SQLException {
        
         //Buscar conexao do BD
        Connection con = Conexao.getConexao();
        //Cria espaço de trabalho SQL, é a área no Java onde vamos executar  os scripts SQL
        Statement stat = con.createStatement();
        
        try {
            String sql;
            sql = "select * from pessoa";
            ResultSet rs = stat.executeQuery(sql);
            ArrayList<Pessoa> pessoas = new ArrayList<>();
            while(rs.next()){
                Pessoa p = new Pessoa();
                //Lado do java |x| lado do BD
                p.setIdPessoa(rs.getInt("idPessoa"));
                p.setNomePessoa(rs.getString("nomePessoa"));
                p.setCpf(rs.getString("cpf"));
                p.setEndereco(rs.getString("endereco"));
                p.setTelefone(rs.getString("telefone"));
                p.setIdade(rs.getInt("idade"));
                p.setStatus(rs.getBoolean("status"));
                //popula o arraylist
                pessoas.add(p);   
            }
            //retorna arrayList
            return pessoas;
            
        } catch (SQLException e) {
            throw new SQLException("Erro ao listar Pessoas! \n" + e.getMessage());
            
        } finally {
            con.close();
            stat.close();
       

        }
    }
    
    public boolean verCPF(String cpf) throws SQLException{
         //Buscar conexao do BD
        Connection con = Conexao.getConexao();
        //Cria espaço de trabalho SQL, é a área no Java onde vamos executar  os scripts SQL
        Statement stat = con.createStatement();
        
        boolean verCPF = false;
        
        try {
            String sql;
            sql = "select cpf from pessoa where cpf = " + cpf;
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                verCPF = rs.wasNull();
            }
    } catch (SQLException e) {
            throw new SQLException("CPF Inexistente! \n" + e.getMessage());
           } finally {
            con.close();
            stat.close();
       
        }
        return verCPF;
    }
    
    public Pessoa getByDoc(String cpf) throws SQLException{
        //Buscar conexao do BD
        Connection con = Conexao.getConexao();
        //Cria espaço de trabalho SQL, é a área no Java onde vamos executar  os scripts SQL
        Statement stat = con.createStatement();
        
        Pessoa p = new Pessoa();
        
        try {
            String sql;
            sql = "select * from pessoa where cpf =" + cpf;
            ResultSet rs = stat.executeQuery(sql);
                while(rs.next()) {
                    //lado do java |x| lado do banco
                p.setIdPessoa(rs.getInt("idPessoa"));
                p.setNomePessoa(rs.getString("nomePessoa"));
                p.setCpf(rs.getString("cpf"));
                p.setEndereco(rs.getString("endereco"));
                p.setTelefone(rs.getString("telefone"));
                p.setIdade(rs.getInt("idade"));
                p.setStatus(rs.getBoolean("status"));
                }
        } catch (SQLException e) {
                throw new SQLException("Pessoa inexistente! \n" + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }
        return p;
    }
    
    public void deletarPessoa(int id) throws SQLException {
        //Buscar conexao do BD
        Connection con = Conexao.getConexao();
        //Cria espaço de trabalho SQL, é a área no Java onde vamos executar  os scripts SQL
        Statement stat = con.createStatement();
        
        try {
            String sql;
            sql = "delete from pessoa where idPessoa = " + id;
            stat.execute(sql);
        } catch (SQLException e) {
            throw new SQLException("Impossível deletar usuário! \n" + e.getMessage());
        } finally {
            con.close();
            stat.close();
        }
    }
    
    public void atualizarPessoa(Pessoa pVO) throws SQLException{
        //Buscar conexao do BD
        Connection con = Conexao.getConexao();
        //Cria espaço de trabalho SQL, é a área no Java onde vamos executar  os scripts SQL
        Statement stat = con.createStatement();
        
        try {
            String sql;
            sql = "update pessoa set "
                    + "nomePessoa = '" + pVO.getNomePessoa() +  "', "
                    + "endereco = '" + pVO.getEndereco() +  "', "
                    + "idade = " + pVO.getIdade() +  ", "
                    + "telefone = '" + pVO.getTelefone() +  "', "
                    + "status = " + pVO.isStatus() +  " "
                    + "where idPessoa = " + pVO.getIdPessoa();
            stat.executeUpdate(sql);
        } catch (SQLException e) {
            throw new SQLException("Impossível atualizar usuário! \n" + e.getMessage());
        } finally {
            con.close();
            stat.close();
     }
    }
    
}
