package DAO;

import model.Usuario;

public class DaoUsuario<E> extends DaoGeral<Usuario> {
	public void removerUsuario(Usuario usuario) throws Exception {
		getEntityManager().getTransaction().begin();
		String sqlDeletaTel = "delete from telefone where usuario_cod =" + usuario.getCod();
		getEntityManager().createNativeQuery(sqlDeletaTel).executeUpdate();
		getEntityManager().getTransaction().commit();
		//HERANÇA aplicada
		super.delatarID(usuario);
	}
}
