package br.com.igormicael.jv.controllers;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean
public class JogoVelhaController implements Serializable{

	private static final long serialVersionUID = -4979149346475263674L;
	
	private String jogadorO;
	private String jogadorX;
	
	private String jogadorAtual;
	
	private String mensagem ;
	
	private String jogadas [];
	
	private Boolean jogoGanho = false;
	
	public JogoVelhaController() {
	}

	public void iniciarJogo() {
		jogadas = new String [9];
		jogadorAtual = jogadorO;
		atualizarMensagem();
	}

	private void atualizarMensagem() {
		if(jogoGanho)
			mensagem = "O jogador " + jogadorAtual + " ganhou!";
		else
			mensagem = "É a vez do "+ jogadorAtual + " jogar" ;
			
	}

	public void jogar(int posicao) {
		String jogada = "";
		if(jogadorAtual != null) {
			if(jogadorAtual.equalsIgnoreCase(jogadorO)) {
				jogada = "O";
			}
			
			if(jogadorAtual.equalsIgnoreCase(jogadorX)) {
				jogada = "X";
			}
			
			jogadas[posicao] = jogada;
			
			verificarVencedor();
			
			if(!jogoGanho) {
				jogadorAtual = trocarJogador();
				atualizarMensagem();
			}
		}
	}
	
	public void verificarVencedor() {
		String jogada = "";
		
		if(jogadorAtual.equalsIgnoreCase(jogadorO)) {
			jogada = "O";
		}
		if(jogadorAtual.equalsIgnoreCase(jogadorX)) {
			jogada = "X";
		}
		
		// 0,1,2
		verificarCombinacoes(jogada,jogadas[0], jogadas[1], jogadas[2] );
		// 0,3,6
		verificarCombinacoes(jogada,jogadas[0], jogadas[3], jogadas[6] );
		// 0,4,8
		verificarCombinacoes(jogada,jogadas[0], jogadas[4], jogadas[8] );
		// 1,4,7
		verificarCombinacoes(jogada,jogadas[1], jogadas[4], jogadas[7] );
		// 2,5,8
		verificarCombinacoes(jogada,jogadas[2], jogadas[5], jogadas[8] );
		// 2,4,6
		verificarCombinacoes(jogada,jogadas[2], jogadas[4], jogadas[6] );
		// 3,4,5
		verificarCombinacoes(jogada,jogadas[3], jogadas[4], jogadas[5] );
		// 6,7,8
		verificarCombinacoes(jogada,jogadas[6], jogadas[7], jogadas[8] );
		
		atualizarMensagem();
		
	}
	
	public void verificarCombinacoes(String jogada,String _1, String _2, String _3) {
		if(jogoGanho == false &&
			jogada.equals(_1) &&
			jogada.equals(_2) &&
			jogada.equals(_3) ) {
			jogoGanho = true;
		}
	}
	
	public String trocarJogador() {
		if(jogadorAtual != null) {
			if(jogadorAtual.equalsIgnoreCase(jogadorO)) {
				return jogadorX;
			}
			if(jogadorAtual.equalsIgnoreCase(jogadorX)) {
				return jogadorO;
			}
		}
		return null;
	}
	
	//  
	
	public Boolean isCelulaDesabilitada(int posicao) {
		if(jogoGanho != null && jogoGanho) {
			return true;
		}else {
			if(jogadas != null && jogadas[posicao] != null) {
				return true;
			}
		}
		return false;
	}

	public String getJogadorO() {
		return jogadorO;
	}

	public void setJogadorO(String jogadorO) {
		this.jogadorO = jogadorO;
	}

	public String getJogadorX() {
		return jogadorX;
	}

	public void setJogadorX(String jogadorX) {
		this.jogadorX = jogadorX;
	}

	public String getJogadorAtual() {
		return jogadorAtual;
	}

	public String[] getJogadas() {
		return jogadas;
	}

	public String getMensagem() {
		return mensagem;
	}
	
}