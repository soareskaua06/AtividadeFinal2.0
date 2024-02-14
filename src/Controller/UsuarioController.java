
package Controller;

import Model.UsuarioModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Aluno(a) TDS Noite
 */
public class UsuarioController {
        public void cadastrarUsuario(String nome, String cpf, String email, String endereco, String dataNascimento) {
        if ((nome != null && nome.length() > 0) && (cpf != null && cpf.length() > 0)
                && (email != null && email.length() > 0) && (endereco != null && endereco.length() > 0) 
                && (dataNascimento != null && dataNascimento.length() > 0)) {
            
            UsuarioController novoUsuario = new UsuarioController(nome, cpf, email, endereco, dataNascimento);
            novoUsuario.cadastrarUsuario(novoUsuario);
        } else {
            JOptionPane.showMessageDialog(null, "Preencha os campos corretamente");
        }
    }    
        public ArrayList<UsuarioModel> listarUsuarioController(){
            UsuarioController usuario = new UsuarioController();
            return usuario.listarUsuarioController();
         }
}
