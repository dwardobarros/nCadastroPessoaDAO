/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senactech.NCadastroPessoa.conexao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 *
 * @author 666
 */
public class Conexao {
     //Cria constante com endereço do BD e Schema
    private static String url = "jdbc:mysql://localhost:3306/devn211";
    //Cria uma constante com o user DB
    private static String user = "root";
    //Cria uma constante comsenha do BD
    private static String pass = "";
    
    public static Connection getConexao() throws SQLException{
        //Inicia conexao nula, ainda não estabelecida
        Connection c = null;
        
        //Tentar estabelecer a conexão
        try {
            c = DriverManager.getConnection(url, user, pass);
            //Caso haja alguma falha entra no catch
        } catch (SQLException e) {
            throw new SQLException("Erro ao conectar Banco de Dados!\n" + e.getMessage());
        }
        return c;
    }
    
}
