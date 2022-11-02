package agenda;

import java.util.Arrays;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;

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
	private Contato[] favorito;

	/**
	 * Cria uma agenda.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
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

	public boolean existeContato(int posicao) {
		if (contatos[posicao - 1] == null)
			return false;
		return true;
	}

	public String exibeContato(int posicao) {
		return contatos[posicao].toString();
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