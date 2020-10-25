/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifba.testebaianes.motor;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import br.edu.ifba.testebaianes.util.ImportadorDeJson;

/**
 *
 * @author lucas
 */
public class Motor {
    private ArrayList<Pergunta> todasAsPerguntas = ImportadorDeJson.jsonParaArray(new File(".//src//files//dicionario.json"));
    private ArrayList<Partida> ultimasDuasPartidas = new ArrayList<Partida>();
    private Random r = new Random();
    private final int limite = todasAsPerguntas.size();
	
	
    public Motor () {
		
    }
		
	public Partida criarPartida (int numeroDePerguntas, String nomeDoJogador) {
		/**
		 * Partida sai daqui j� iniciada.
		 */
		ArrayList<Pergunta> perguntasSelecionadas = new ArrayList<Pergunta>();
		for (int i = 0 ; i < numeroDePerguntas ; i++) {
			perguntasSelecionadas.add(todasAsPerguntas.get(r.nextInt(limite)));
			if (i > 0) { //testa se houve pergunta repetida
				if (perguntasSelecionadas.get(i-1).equals(perguntasSelecionadas.get(i))) {
					perguntasSelecionadas.remove(i);
					perguntasSelecionadas.add(todasAsPerguntas.get(r.nextInt(limite)));
				}
			}
		}
		Partida p = new Partida(System.currentTimeMillis()/1000, perguntasSelecionadas);
		p.setJogador(nomeDoJogador);
		return p;
	}
	
	/*
	public void iniciarPartida (Partida p) {
		p.setInicioPartida(System.currentTimeMillis()/1000);
		//esse metodo acima e privado.
		//O metodo INICIARPARTIDA e um apendice.
	}
	*/
		
    public void finalizarPartida (Partida p) {
        p.setFimPartida(System.currentTimeMillis()/1000);
        if (ultimasDuasPartidas.size() == 2) ultimasDuasPartidas.remove(0); //se o tamanho for 2, remova o primeiro
        //o de cima poderia ser uma pilha, ne? Eu estive pensando nisso...
        if (p.isPartidaFinalizada()) ultimasDuasPartidas.add(p);
    }
		
    public String quemGanhou () {
	String resposta = "NADA";
	if (ultimasDuasPartidas.get(0).getPontos() > ultimasDuasPartidas.get(1).getPontos())
            resposta = ultimasDuasPartidas.get(0).getJogador();
	if (ultimasDuasPartidas.get(1).getPontos() > ultimasDuasPartidas.get(0).getPontos())
            resposta = ultimasDuasPartidas.get(1).getJogador();
	if (ultimasDuasPartidas.get(1).getPontos() == ultimasDuasPartidas.get(0).getPontos()) {
            if (ultimasDuasPartidas.get(0).getTempo() > ultimasDuasPartidas.get(1).getTempo())
		resposta = ultimasDuasPartidas.get(0).getJogador();
            if (ultimasDuasPartidas.get(1).getTempo() > ultimasDuasPartidas.get(0).getTempo())
		resposta = ultimasDuasPartidas.get(1).getJogador();
	}
		
    	return resposta;
    }
}
