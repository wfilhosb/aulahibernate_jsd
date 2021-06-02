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

	// Hashcode utilizado em COLLECTIONS, arraylists, cria um código para agrupar objetos semelhantes
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (cod ^ (cod >>> 32));
		return result;
	}

	//verifica se a lista já contem o objeto
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (cod != other.cod)
			return false;
		return true;
	}

}
