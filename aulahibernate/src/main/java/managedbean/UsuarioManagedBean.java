package managedbean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Usuario;
import DAO.DaoGeral;

@ViewScoped
@ManagedBean(name = "usuarioManagedBean")
public class UsuarioManagedBean {
	private Usuario usuarioPessoa = new Usuario();
	private DaoGeral daoGeral = new DaoGeral();
	private List<Usuario> list = new ArrayList<Usuario>();

	public Usuario getUsuarioPessoa() {
		return usuarioPessoa;
	}

	public void setUsuarioPessoa(Usuario usuarioPessoa) {
		this.usuarioPessoa = usuarioPessoa;
	}

	public String salvar() {
		daoGeral.salvar(usuarioPessoa);
		return "";
	}

	public String novo() {
		usuarioPessoa = new Usuario();
		return "";
	}

	public String deletarID() {
		daoGeral.delatarID(usuarioPessoa);
		usuarioPessoa = new Usuario();
		return "";
	}

	public List<Usuario> getList() {
		return daoGeral.listar(Usuario.class);
	}
}