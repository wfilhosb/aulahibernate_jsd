package model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cod;
	private String nome;
	private String senha;
	private String sobrenome;

	// aqui se usa o mappedBy apontando para o objeto que foi referenciado na classe
	// TELEFONE
	// não estava funcionando por causa da letra maiúscula, não fazemos a referencia
	// a classe
	// e sim ao objeto que se chama usuario, para cada usuario criado, mapeamos um
	// objeto
	@OneToMany(mappedBy = "usuario")
	private List<Telefone> TelUsuario;

	public List<Telefone> getTelUsuario() {
		return TelUsuario;
	}

	public void setTelUsuario(List<Telefone> telUsuario) {
		TelUsuario = telUsuario;
	}

	public long getCod() {
		return cod;
	}

	public void setCod(long cod) {
		this.cod = cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	@Override
	public String toString() {
		return "Usuario [cod=" + cod + ", nome=" + nome + ", senha=" + senha + ", sobrenome=" + sobrenome + "]";
	}
}
