package agenda;

import java.util.Objects;

public class Contato {
	private String nome;
	private String sobrenome;
	private String telefone;
	private boolean favorito;

	public Contato(String nome, String sobrenome, String telefone) {
		if (nome == null || sobrenome == null) {
			throw new NullPointerException();
		}
		if (nome.equals("") || sobrenome.equals("")) {
			throw new IllegalArgumentException();
		}

		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
		this.favorito = false;
	}

	public void favoritar(){
		this.favorito = true;
	}

	public void desfavoritar(){
		this.favorito = false;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		return Objects.equals(nome, other.nome) && Objects.equals(sobrenome, other.sobrenome);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, sobrenome);
	}

	public String toString() {
		return (this.favorito ? "❤️ " : "") + this.nome + " " + this.sobrenome
				+ "\n" + this.telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}