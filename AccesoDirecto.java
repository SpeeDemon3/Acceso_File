package repasoM03.ejemploPackage.tema6;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class AccesoDirecto {

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
		File archivo = new File(rutaCarpeta + sep + "ejemploAccesoDirecto.txt");
		archivo.createNewFile(); // Creo el nuevo archivo en blanco
		
		// Invoco y guardo las frases que introduzca el usuario con el metodo pideFrases()
		ArrayList<String> frases =  Funciones.pideFrases();
		
		// Creo un objeto RandomAccessFile para poder leer y escribir sobre el archivo, indicandolo en el segundo parametro
		RandomAccessFile raf = new RandomAccessFile(archivo, "rw");
		// Escribo sobre el archivo en blanco
		raf.writeBytes(frases.get(0) + salto);
		raf.writeBytes(frases.get(1) + salto);
		raf.writeBytes(frases.get(2));
		
		raf.seek(0); // Situo el puntero al inicio 
		
		while(raf.getFilePointer() < raf.length()) {
			System.out.println(raf.readLine());
		}
		 
		raf.close(); // Cierro la conexion con el fichero
	}

}
