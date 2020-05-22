package br.senac.sp.model.beam;

import br.senac.sp.dao.usuarioDAO;
import br.senac.sp.model.Usuario;

/**
 *
 * @author rafae
 */
public class c_cadUser extends Usuario {

    public usuarioDAO dao = new usuarioDAO();

    /*public boolean cadUsuarios(String nome, String cpf, String filial, String perfil, String login, String senha, String senhaAdmin) {
        dao.setNome(nome);
        dao.setCpf(cpf);
        dao.setFilial(filial);
        dao.setFilial(perfil);
        dao.setLogin(login);
        dao.setSenha(senha);
        dao.setSenhaAdmin(senhaAdmin);
        dao.cadastrar(dao);
        if (!(dao.getNome().equals(null)
                && (dao.getCpf().equals(null)
                && (dao.getFilial().equals(null)
                && (dao.getPerfil().equals(null)
                && (dao.getLogin().equals(null)
                && (dao.getSenha().equals(null))
                && (dao.getSenhaAdmin().equals(null)))))))) {
            System.out.println(dao);
        }
        return true;
    }*/
}
