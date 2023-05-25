package repasoM03.ejemploPackage.tema6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AccesoSecuencial {

	public static void main(String[] args) throws IOException {
		// Ruta absoluta hasta el proyecto
		String rutaAbs = System.getProperty("user.dir");
		// Separador que utiliza el sistema operativo donde se ejecute
		String sep = File.separator;
		// Salto de linea que utiliza el sistema operativo donde se ejecute
		String salto = System.getProperty("line.separator");
		// Ruta completa hasta la carpeta
		String rutaCarpeta = rutaAbs + sep + "carpeta";
		
		// Asigno a un variable File la ruta hasta la carpeta donde contendra el archivo
		File carpeta = new File(rutaCarpeta);
		
		if (!carpeta.exists()) { // Si la carpeta no existe
			carpeta.mkdir(); // Se creara con el metodo mkdir
			System.out.println("Carpeta creada.\n"
					+ "" + carpeta.getParent()); // Muestro la ruta relativa de la carpeta
		}
		
		// Creo el archivo dentro de la carpeta creada
		File archivo = new File(rutaCarpeta + sep + "ejemploAccesoSecuencial.txt");
		archivo.createNewFile(); // Creo el nuevo archivo en blanco
		
		// Invoco y guardo las frases que introduzca el usuario con el metodo pideFrases()
		ArrayList<String> frases =  Funciones.pideFrases();
		
		FileWriter fw = new FileWriter(archivo);
		
		BufferedWriter bw = new BufferedWriter(fw);
		// Escribo dentro del archivo
		bw.write(frases.get(0) + salto);
		bw.write(frases.get(1) + salto);
		bw.write(frases.get(2) + salto);
		// Vacio el buffer
		bw.flush();
		// Cierro la conexion con el archivo
		bw.close();
		
		FileReader fr = new FileReader(archivo);
		
		BufferedReader br = new BufferedReader(fr);
		
		
		for(String linea = br.readLine(); linea != null; linea = br.readLine()) {
			System.out.println(linea);
		}
		
		br.close();
		
	}

}
