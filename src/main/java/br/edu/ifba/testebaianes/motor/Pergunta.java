/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifba.testebaianes.motor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import br.edu.ifba.testebaianes.util.Conversor;
/**
 * @author kelvin
 * @author lucas
 * @author vitor
 */
public class Pergunta implements Serializable{
	private String pergunta = null;
	private List<String> respostas = new ArrayList<String>();
	private int correta = -1;
	
	public Pergunta (String pergunta) {
		setPergunta(pergunta);
	}
	
	public void setPergunta (String pergunta) {
		this.pergunta = pergunta;
	}
	
	public void setRespostas (String respostaA, String respostaB, String respostaC) {
		this.respostas.add(respostaA);
		this.respostas.add(respostaB);
		this.respostas.add(respostaC);
	}
	
	public void setCorreta (int valor) {
		if (valor == 0 || valor == 1 || valor == 2) this.correta = valor;
		else System.err.println("Argumento \"" + valor + "\" inv�lido! Corrija isso a�...");
	}
	
	public void setCorreta (char arg) {
		int valor = Conversor.convertaCharToInt(arg);
		if (valor == 0 || valor == 1 || valor == 2) this.correta = valor;
		else System.err.println("Argumento \"" + arg + "\" inv�lido! Corrija isso a�...");
	}

	public String getPergunta() {
		return pergunta;
	}

	public List<String> getRespostas() {
		return respostas;
	}

	public char getCorreta() {
		return Conversor.convertaIntToChar(correta);
	}
        
        public boolean verificarResposta(int ponteiro){
            if(ponteiro==correta){
                return true;
            }
            return false;
        }
}
