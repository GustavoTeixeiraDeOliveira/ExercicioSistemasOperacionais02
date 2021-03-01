package View;

import javax.swing.JOptionPane;
import Controller.classesControle;
public class Main {
	public static void main(String[] args) {
		int op=0;
		classesControle cont = new classesControle();
		String os = cont.pegarOS();
		while(op!=9){
			 op=Integer.parseInt(JOptionPane.showInputDialog("\n1- Ver Processos  \n2- Matar Processos \n9-Finalizar"));

			 switch(op){
			   case 1:
				   cont.MostrarProcessos(os);
			   break;
			   
			  case 2:
				  int op2 = 0;
				  while(op2!=9){
						 op2=Integer.parseInt(JOptionPane.showInputDialog("\n1- Matar com PID  \n2- Matar com nome \n9-Finalizar"));

						 switch(op){
						   case 1:
							   String PID = JOptionPane.showInputDialog("Digite o  PID do processo a ser finalizado");
							   cont.MatarProcessosPID(os, PID);
						   break;
						   
						  case 2:
							  String nome = JOptionPane.showInputDialog("Digite o nome do processo a ser finalizado");
							  cont.MatarProcessoNome( os, nome);
							
						   break;
							
					    }
					  }
				  
				
			   break;
				
		    }
		  }
	
	}

}
