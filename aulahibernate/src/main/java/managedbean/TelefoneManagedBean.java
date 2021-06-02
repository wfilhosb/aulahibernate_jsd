package managedbean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import DAO.DaoUsuario;
import model.Usuario;

@ManagedBean (name="telefoneManagedBean")
@ViewScoped
public class TelefoneManagedBean {
	private Usuario usuario = new Usuario();
	private DaoUsuario <Usuario> daoUsuario = new DaoUsuario<Usuario>();

	@PostConstruct
	public void init() {
	String codusu =FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("codigousuario");
	usuario = daoUsuario.pesquisar(Long.parseLong(codusu),Usuario.class);
	}
			
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
