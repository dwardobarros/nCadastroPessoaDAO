/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senactech.NCadastroPessoa.services;

/**
 *
 * @author 666
 */
public class ServicosFactory {
    
    private static PessoaServicos pessoaServicos = new PessoaServicos();
    
    public static PessoaServicos getPessoaServicos() {
        return pessoaServicos;
    }
}
