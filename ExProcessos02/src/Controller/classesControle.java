package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class classesControle {
 
	public classesControle(){
		super();
	}
	
	public String pegarOS() {
		String os = System.getProperty("os.name");
		return os;
	}
	
	public void MostrarProcessos(String os) {
		Process p;
		if(os.contains("Windows 10")) {
		  try {
			p = Runtime.getRuntime().exec("tasklist");
			InputStream fluxo = p.getInputStream(); 
		    InputStreamReader leitor = new InputStreamReader(fluxo);
		    BufferedReader buffer = new BufferedReader(leitor);
		    String linha = buffer.readLine();
		    int x =  0;
		    while(x <= 0) {
		    	 System.out.println(linha);
		    	 linha = buffer.readLine();
		    	 if(linha == null) {
		    		 break;
		    	 }
		    }
		} catch (IOException e) {

			e.printStackTrace();
		}
		 
	 }else if(os.contains("Linux")) {
		 try {
				p = Runtime.getRuntime().exec("top");
				InputStream fluxo = p.getInputStream(); 
			    InputStreamReader leitor = new InputStreamReader(fluxo);
			    BufferedReader buffer = new BufferedReader(leitor);
			    String linha = buffer.readLine();
			    int x =  0;
			    while(x <= 0) {
			    	 System.out.println(linha);
			    	 linha = buffer.readLine();
			    	 if(linha == null) {
			    		 break;
			    	 }
			    }
			} catch (IOException e) {

				e.printStackTrace();
			}
	 }
   }
	
  public void MatarProcessosPID(String os,String PID) {
	  Runtime comando = Runtime.getRuntime();
	  if(os.contains("Windows 10")) {
	    try {
			Process proc = comando.exec("TASKKILL / PID "+PID);
		} catch (IOException e) {
			e.printStackTrace();
		}
	  }else if(os.contains("Linux")){
		  try {
				Process proc = comando.exec("pkill -9 "+PID);
			} catch (IOException e) {
				e.printStackTrace();
			}
	  }
  }	
  
  public void MatarProcessoNome(String os,String nome) {
	  Runtime comando = Runtime.getRuntime();
	  if(os.contains("Windows 10")) {
	    try {
			Process proc = comando.exec("TASKKILL/IM "+nome);
		} catch (IOException e) {
			e.printStackTrace();
		}
	  }else if(os.contains("Linux")){
		  try {
				Process proc = comando.exec("pkill -f "+nome);
			} catch (IOException e) {
				e.printStackTrace();
			}
	  }
  }	
}
