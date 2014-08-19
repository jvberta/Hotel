package com.hotelcalifornia.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class criacaoELeituraDeArquivos {
	
	public final static void escreveArquivo(String file,String conteudo) throws IOException{
		
			FileWriter arq = new FileWriter(file);
			PrintWriter gravaArq = new PrintWriter(arq);
			gravaArq.write(conteudo);
			arq.close();
	}
	
	public final static String leArquivo(String file) throws IOException{
		FileReader arq = new FileReader(file);
		BufferedReader buff = new BufferedReader(arq);
		
		String retorno = buff.readLine();
		arq.close();
		return retorno;
		
	}
	

}
