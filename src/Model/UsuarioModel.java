/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.UsuarioBancoDados;

/**
 *
 * @author Aluno(a) TDS Noite
 */
public class UsuarioModel {
    private int codigo;
    private String nome;
    private String cpf;
    private String email;
    private String endereco;
    private String dataNascimento;

    public UsuarioModel() {
    }

    public UsuarioModel(String nome, String cpf, String email, String endereco, String dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    public void cadastrarUsuario(UsuarioModel novoUsuario){
    UsuarioBancoDados novoRegistro = new UsuarioBancoDados();
    novoRegistro.inserirUsuarioDB(novoUsuario);
    }
}
