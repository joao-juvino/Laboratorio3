package agenda;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100
 * contatos.
 * 
 * @author nazareno
 *
 */
public class Agenda {

	private static final int TAMANHO_AGENDA = 100;
	private static final int TAMANHO_FAVORITOS = 10;
	private Contato[] contatos;
	private Contato[] favoritos;

	/**
	 * Cria uma agenda.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
		this.favoritos = new Contato[TAMANHO_FAVORITOS];
	}

	/**
	 * Acessa a lista de contatos mantida.
	 * 
	 * @return O array de contatos.
	 */
	public Contato[] getContatos() {
		return this.contatos;
	}

	/**
	 * Acessa os dados de um contato específico.
	 * 
	 * @param posicao Posição do contato na agenda.
	 * @return Dados do contato. Null se não há contato na posição.
	 */
	public Contato getContato(int posicao) {
		return contatos[posicao];
	}

	public boolean verificaContato(String nome, String sobrenome) {
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] == null)
				continue;
			if (contatos[i].getNome().equals(nome) && contatos[i].getSobrenome().equals(sobrenome))
				return true;
		}
		return false;
	}

	private boolean verificaFavorito(String nome, String sobrenome) {
		for (int i = 0; i < this.favoritos.length; i++) {
			if (this.favoritos[i] != null) {
				if (this.favoritos[i].getNome().equals(nome) && this.favoritos[i].getSobrenome().equals(sobrenome)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean existeContato(int posicao) {
		if (contatos[posicao - 1] == null)
			return false;
		return true;
	}

	public String exibeContato(int posicao) {
		return contatos[posicao - 1].toString();
	}

	public String listaContatos() {
		String saida = "\n";

		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				saida += (i + 1) + " - " + contatos[i].getNome() + " " + contatos[i].getSobrenome() + "\n";
			}
		}

		return saida;
	}

	private int getPosicaoFavorito(String nome, String sobrenome) {
		for (int i = 0; i < this.favoritos.length; i++) {
			if (this.favoritos[i] != null) {
				if (this.favoritos[i].getNome().equals(nome) && this.favoritos[i].getSobrenome().equals(sobrenome)) {
					return i + 1;
				}
			}
		}
		return -1;
	}

	public void adicionaFavorito(int posicaoContato, int posicaoFavorito) {
		if (contatos[posicaoContato - 1] != null) {
			if (this.favoritos[posicaoFavorito - 1] != null)
				this.favoritos[posicaoFavorito - 1].desfavoritar();

			String nome = this.contatos[posicaoContato - 1].getNome();
			String sobrenome = this.contatos[posicaoContato - 1].getSobrenome();
			if (this.verificaFavorito(nome, sobrenome)){
				int index = this.getPosicaoFavorito(nome, sobrenome);
				this.removeFavorito(index);
			}

			favoritos[posicaoFavorito - 1] = contatos[posicaoContato - 1];
			contatos[posicaoContato - 1].favoritar();
		}
	}

	public String listaFavoritos() {
		String saida = "\n";

		for (int i = 0; i < this.favoritos.length; i++) {
			if (this.favoritos[i] != null) {
				saida += (i + 1) + " - " + this.favoritos[i].getNome() + " " + this.favoritos[i].getSobrenome() + "\n";
			}
		}

		return saida;
	}

	public void removeFavorito(int posicao) {
		this.favoritos[posicao - 1].desfavoritar();
		this.favoritos[posicao - 1] = null;
	}

	/**
	 * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe
	 * sobrescreve o anterior.
	 * 
	 * @param posicao   Posição do contato.
	 * @param nome      Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone  Telefone do contato.
	 */
	public void cadastraContato(int posicao, String nome, String sobrenome, String telefone) {

		this.contatos[posicao - 1] = new Contato(nome, sobrenome, telefone);
	}
}