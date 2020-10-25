/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifba.testebaianes.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import br.edu.ifba.testebaianes.motor.Pergunta;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author kelvin
 * @author lucas
 * @author vitor
 */
public class ImportadorDeJson {
	
	public static ArrayList<Pergunta> jsonParaArray (File lugarOndeEuVouAbrirOJson) {
		
		JSONParser jsonParser = new JSONParser();
		JSONArray listaPerguntas = null;
		ArrayList<Pergunta> minhasPerguntas = new ArrayList<Pergunta>();
		
		try (FileReader leitor = new FileReader(lugarOndeEuVouAbrirOJson))
        {
            //Read JSON file
            Object obj = jsonParser.parse(leitor);
 
            listaPerguntas = (JSONArray) obj;
              
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
		
		for (Object o : listaPerguntas) {
			JSONObject umaPergunta = (JSONObject) o;
			Pergunta p = new Pergunta((String) umaPergunta.get("pergunta"));
			//System.out.println((String) umaPergunta.get("pergunta"));
			p.setRespostas(
					(String) umaPergunta.get("a"),
					(String) umaPergunta.get("b"),
					(String) umaPergunta.get("c")
			);
			//System.out.println((String) umaPergunta.get("correta"));
			String charTemp = (String) umaPergunta.get("correta");
			p.setCorreta(charTemp.charAt(0));
			
			minhasPerguntas.add(p);
		}
		
		return minhasPerguntas;
    }

}
