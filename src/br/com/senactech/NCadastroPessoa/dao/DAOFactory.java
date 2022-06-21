/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senactech.NCadastroPessoa.dao;

/**
 *
 * @author 666
 */
public class DAOFactory {
    
    private static PessoaDAO pDAO = new PessoaDAO();
    
    public static PessoaDAO getPessoaDAO() {
        return pDAO;
    }
}
