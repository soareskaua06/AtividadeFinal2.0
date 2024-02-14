/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.UsuarioModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Aluno(a) TDS Noite
 */
public class UsuarioBancoDados {
        public void inserirUsuarioDB(UsuarioModel novoUsuario) {

        String sql = "INSERT INTO cliente (nome, cpf, email, endereco, dataNascimento) values (?, ?, ?, ?, ?)";
        PreparedStatement stmt = null;
        Connection connection = null;

        try {
            connection = new ConexaoDB().getConnection();
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, novoUsuario.getNome());
            stmt.setString(2, novoUsuario.getCpf());
            stmt.setString(3, novoUsuario.getEmail());
            stmt.setString(4, novoUsuario.getEndereco());
            stmt.setString(5, novoUsuario.getDataNascimento());
            
            stmt.execute();
            System.out.println("Registro realizado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao realizar regitro!");
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (Exception e) {
                System.out.println("Erro ao finalizar steatment!");
                e.printStackTrace();
            }

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                System.out.println("Erro ao finalizar conexao com o banco de dados!");
                e.printStackTrace();
            }
        }
    }

    
    public ArrayList<UsuarioModel> listarTodosUsuarios(){
    
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        
        UsuarioModel usuario = null;
        ArrayList<UsuarioModel> listaUsuarios = null;
        
        String sql = "SELECT * FROM ROOT.CLIENTE";
        
        try {
            conn = new ConexaoDB().getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs != null) {
                listaUsuarios = new ArrayList<>();
                while (rs.next()) {
                    usuario = new UsuarioModel();
                    usuario.setCodigo(rs.getInt("codigo"));
                    usuario.setNome(rs.getString("nome"));
                    usuario.setCpf(rs.getString("cpf"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setDataNascimento(rs.getString("dataNascimento"));
                    usuario.setEndereco(rs.getString("endereco"));
                    listaUsuarios.add(usuario);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao realizar regitro!");
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (Exception e) {
                System.out.println("Erro ao finalizar steatment!");
                e.printStackTrace();
            }

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                System.out.println("Erro ao finalizar conexao com o banco de dados!");
                e.printStackTrace();
            }
        }
        System.out.println("Lista" + listaUsuarios);
        return listaUsuarios;
    }
    
    public ArrayList<UsuarioModel> buscarUsuario(String nome){
    
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        
        UsuarioModel usuario = null;
        ArrayList<UsuarioModel> listaUsuarios = null;
        
        String sql = "SELECT * FROM ROOT.USUARIO WHERE nome LIKE '%" + 
                nome + "%' ORDER BY nome";
        
        try {
            conn = new ConexaoDB().getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs != null) {
                listaUsuarios = new ArrayList<>();
                while (rs.next()) {
                    usuario = new UsuarioModel();
                    usuario.setCodigo(rs.getInt("codigo"));
                    usuario.setNome(rs.getString("nome"));
                    usuario.setCpf(rs.getString("cpf"));
                    usuario.setEmail(rs.getString("email"));                    
                    usuario.setEndereco(rs.getString("endereco"));                    
                    usuario.setDataNascimento(rs.getString("dataNascimento"));                
                    listaUsuarios.add(usuario);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao selecionar contatos!");
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (Exception e) {
                System.out.println("Erro ao finalizar steatment!");
                e.printStackTrace();
            }

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                System.out.println("Erro ao finalizar conexao com o banco de dados!");
                e.printStackTrace();
            }
        }
        return listaUsuarios;
    }
    
    
    public void alterarUsuarioDB(UsuarioModel usuarioAjuste){

        Connection conn = null;
        PreparedStatement stmt = null;
        
        String sql = "UPDATE ROOT.USUARIO SET nome=?, cpf=?, email=?, endereco=?, dataNascimento=? WHERE codigo=?";
        
        try {
            conn = new ConexaoDB().getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, UsuarioAjuste.getNome());
            stmt.setString(2, UsuarioAjuste.getCpf());
            stmt.setString(3, UsuarioAjuste.getEmail());
            stmt.setString(4, UsuarioAjuste.getEndereco());
            stmt.setString(5, UsuarioAjuste.getDataNascimento());
            stmt.setInt(6, UsuarioAjuste.getCodgio());
            stmt.execute();
            System.out.println("Alteração do registro realizada com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao realizar a alteração no registro!");
            e.printStackTrace();
        }finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (Exception e) {
                System.out.println("Erro ao finalizar steatment!");
                e.printStackTrace();
            }

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                System.out.println("Erro ao finalizar conexao com o banco de dados!");
                e.printStackTrace();
            }
        }
    }
    
    public void excluirContatoBD(int id){
    
        Connection conn = null;
        PreparedStatement stmt = null;
        
        String sql = "DELETE FROM ROOT.CONTATOS where id=?";
        
        try {
            conn = new ConexaoDB().getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            System.out.println("Exlusão realizada com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao realizar a exclusão do registro.");
        }finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (Exception e) {
                System.out.println("Erro ao finalizar steatment!");
                e.printStackTrace();
            }

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                System.out.println("Erro ao finalizar conexao com o banco de dados!");
                e.printStackTrace();
            }
        }
        
    }
}
