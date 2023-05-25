package repasoM03.ejemploPackage.tema6;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * @author speedemon -> Antonio Ruiz Benito
 *
 */
public class Funciones {

	/**
	 * Metodo para preguntar y guardar 3 frases introducidas por el usuario
	 * @return -> Frase introducidas por el usuario dentro de un ArrayList()
	 */
	public static ArrayList<String> pideFrases(){
		// Creo un array dinamico donde guardare las frases que introduzca el usuario
		ArrayList<String> frases = new ArrayList<String>();
		
		try {
			
			Scanner sc = new Scanner(System.in);
		
			// Pido la primera frase
			System.out.println("Introduce la primera frase.");
			// Guardo la primera frase 
			String frase1 = sc.nextLine();
			
			// Pido la segunda frase y la guardo
			System.out.println("Introduce la segunda frase.");
			String frase2 = sc.nextLine();
			
			System.out.println("Introduce la tercera frase.");
			String frase3 = sc.nextLine();
			
			sc.close();
			
			// Añado las frase al array dinamico
			frases.add(frase1);
			frases.add(frase2);
			frases.add(frase3);
			
		} catch(Exception e) {
			System.out.println("Ocurrio un error.");
		}
		
		return frases; // Retorno el array con las frases introducidas
	}
	
}
