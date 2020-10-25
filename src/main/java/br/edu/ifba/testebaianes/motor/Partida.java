/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifba.testebaianes.motor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author kelvin
 * @author lucas
 * @author vitor
 */
public class Partida implements Serializable{
	private long duracao;
	private String jogador;
	private int pontos = 0;
	private ArrayList<Pergunta> perguntasDaPartida;
        private int limite;
	private int contador = 0;
	private boolean partidaFinalizada = false;
        private boolean opponentEnded = false;
	
	public Partida(long tempo, ArrayList<Pergunta> perguntas) {
		setInicioPartida(tempo);
		setPerguntas(perguntas);
	}
        
        public Partida(ArrayList<Pergunta> perguntas) {
		setPerguntas(perguntas);
	}
        
        public Partida(){}
	
	public void setJogador (String s) {
		this.jogador = s;
	}
	
	public String getJogador () {
		return jogador;
	}
	
	public void setInicioPartida (long tempo) {
		this.duracao = tempo;
	}
	
	public void setPerguntas (ArrayList<Pergunta> perguntas) {
		perguntasDaPartida = perguntas;
                limite = perguntasDaPartida.size();
	}

        public long getDuracao() {
            return duracao;
        }
        
        
	
	/*private void getNext () {
		
		// Retorna a pergunta como um System.out.println(); diretamente no console mais pr�ximo.
		 
		Scanner scanner = new Scanner(System.in);
		System.out.println(perguntasDaPartida.get(contador).getPergunta());
		System.out.println(" ");
		System.out.println("A) " + perguntasDaPartida.get(contador).getRespostas().get(0));
		System.out.println("B) " + perguntasDaPartida.get(contador).getRespostas().get(1));
		System.out.println("C) " + perguntasDaPartida.get(contador).getRespostas().get(2));
		System.out.println("Digite sua resposta:");
		char respostaUsuario = Character.toLowerCase(scanner.next().charAt(0));
		if (perguntasDaPartida.get(contador).getCorreta() == respostaUsuario) pontos++;
		scanner.close();
		contador++;
	}*/
        public ArrayList<Pergunta> getDados(){
            return this.perguntasDaPartida;
        }
        
        public Pergunta getNext(){
            int aux = contador;
            contador++;
            if(aux>=limite){
                return null;
            }
            return perguntasDaPartida.get(aux);
        }
        
        public String getNextPergunta(){
            return perguntasDaPartida.get(contador).getPergunta();
        }
        
        public List<String> getRespostas(){
            List<String> respostas = perguntasDaPartida.get(contador).getRespostas();
            contador++;
            return respostas;
        }
	
	public boolean isLastPergunta() {
		/**
		 * Retorna se � a �ltima pergunta.
		 * Bom para usar como condicional de um loop para passar as perguntas.
		 */
		return (perguntasDaPartida.size() == contador);
	}
	
	public void setFimPartida (long tempoFinal) {
		duracao = tempoFinal - duracao;
		partidaFinalizada = true;
	}
	
	public int getPontos() {
		return pontos;
	}
        
        public void addPontos(){
            pontos++;
        }
	
	public long getTempo() {
		return duracao;
	}
	
	public boolean isPartidaFinalizada () {
		return partidaFinalizada;
	}

        public boolean isOpponentEnded() {
            return opponentEnded;
        }

        public void setOpponentEnded(boolean opponentEnded) {
            this.opponentEnded = opponentEnded;
        }
}
