/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifba.testebaianes.util;

/**
 * @author kelvin
 * @author lucas
 * @author vitor
 */
public class Conversor {
	
	public static int convertaCharToInt (char arg) {
		char entrada = Character.toLowerCase(arg);
		
		switch (entrada) {
			case 'a':
				return (int) 0;
			case 'b':
				return (int) 1;
			case 'c':
				return (int) 2;
			default:
				System.err.println("Argumento \"" + arg + "\" invalido! Corrija isso ai...");
				System.exit(0);
		}
		
		return -1; //eu coloquei isso aqui pq o eclipse tava reclamando, ta ok????
	}
	
	public static char convertaIntToChar (int arg) {
		switch (arg) {
		case 0:
			return (char) 'a';
		case 1:
			return (char) 'b';
		case 2:
			return (char) 'c';
		default:
			System.err.println("Argumento \"" + arg + "\" invalido! Corrija isso ai...");
			System.exit(0);
		}
	
		return 'E'; //de Erro...
	}

}
