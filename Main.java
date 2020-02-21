import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		String linea = new String();
		FileReader ficheroLectura = null;
		FileWriter ficheroEscritura = null;
		BufferedReader lectura = null;
		BufferedWriter escritura = null;

		try {
			ficheroLectura = new FileReader(args[0]);
			ficheroEscritura = new FileWriter(args[1]);
			lectura = new BufferedReader(ficheroLectura);
			escritura = new BufferedWriter(ficheroEscritura);
			ArrayList<Integer> descripcion = new ArrayList<>();
			ArrayList<Integer> scores = new ArrayList<>();
			ArrayList<Book> libros = new ArrayList<>();
			ArrayList<Library> librerias = new ArrayList<>();
			Book libroAux;
			int numLinea = 3, idLibreria = 0;
			linea = lectura.readLine();
			String [] arrayAux = linea.split(" ");
			for(int i=0; i<arrayAux.length; i++){
				descripcion.add(Integer.parseInt(arrayAux[i]));
			}
			linea = lectura.readLine();
			arrayAux = linea.split(" ");
			for(int i=0; i<arrayAux.length; i++){
				scores.add(Integer.parseInt(arrayAux[i]));
			}
			for(int i=0; i<scores.size(); i++){
				libroAux = new Book(i, scores.get(i));
				libros.add(libroAux);
			}

			//Esta mierda lee el fichero
			int librosEnBiblioteca = 0;
			Library libreriaAux = new Library(0, 0, 0);
			while(linea != null) {
				linea = lectura.readLine();
				if(linea != null && !linea.equals(" ")) {
					arrayAux = linea.split(" ");
					System.out.println(numLinea + " , " + arrayAux.length + " , " + arrayAux[0]);
					if(numLinea % 2 != 0 && arrayAux.length == 3){
						//librosEnBiblioteca = Integer.parseInt(arrayAux[0]);
						libreriaAux = new Library(idLibreria, Integer.parseInt(arrayAux[1]), Integer.parseInt(arrayAux[2]));
						librerias.add(libreriaAux);
						idLibreria++;
					}else if(numLinea % 2 == 0 && arrayAux.length > 0){
						for(int i=0; i<arrayAux.length; i++){
							libreriaAux.insertBook(libros.get(Integer.parseInt(arrayAux[i])));
						}
					}
					numLinea++;
				}
			}
			// Esto muestra la info de las librerías y los libros dentro de cada librería
			// for(int i=0; i<librerias.size(); i++){
			// 	System.out.println("Libreria " + i);
			// 	for(int j=0; j<librerias.get(i).getLibros().size(); j++){
			// 		System.out.println("\t" + "Libro " + j + " : " + librerias.get(i).getLibros().get(j).getId() + " , " + librerias.get(i).getLibros().get(j).getScore());
			// 	}
			// }



			int diaActual = 0;
			int contador = 0;
			while(diaActual< descripcion.get(2) && contador<librerias.size()){
				if((descripcion.get(2) - diaActual) >= librerias.get(contador).getTime()){
					diaActual = librerias.get(contador).registro(diaActual,descripcion.get(2));
				}
				contador++;
			}

			int score=0;
			for(int i=0; i<librerias.size();i++){
				if(librerias.get(i).getRegistrada()){
					ArrayList<Book> librosL= librerias.get(i).getLibros();
					int librosmax=librerias.get(i).getLibrosToScan();
					System.out.println(librerias.get(i).getLibrosToScan());
					for(int j=0;j<librosmax;j++){
						if(librosL.get(j).getEscaneado()==false){
							librosL.get(j).setEscaneo();
							score=score+librosL.get(j).getScore();
						}
					}
				}
			}
			System.out.println(score);
			// while(diaActual < descripcion.get(2)){
			// 	for (int i= 0;i<librerias.size();i++ ) {
			// 		ArrayList<Book> librosL= librerias.get(i).getLibros();
			// 		int librosmax=librerias.get(i).getLibrosToScan();
			// 		for(int j=0;j<librosmax;j++){
			// 			if(librosL.get(j).getEscaneado()==false){
			// 				librosL.get(j).setEscaneo();
			// 				score=score+librosL.get(j).getScore();
			// 			}
			// 		}
			// 	}
			// } 
			
			//Escritura
		escritura.write(descripcion.get(1).toString()+"\n");
		// String idLibreriass = 0, librosCapaces=0;
		for(int i=0;i<librerias.size();i++){
			// idLibreriass = libre
			escritura.write(Integer.toString(librerias.get(i).getId())+" "+Integer.toString(librerias.get(i).getLibrosToScan())+"\n");
			for(int j=0;j<librerias.get(i).getLibrosToScan();j++){
				//raquel
				escritura.write(Integer.toString(librerias.get(i).getLibros().get(j).getId())+" ");
			}
			escritura.write("\n");
		}
		}

		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(escritura != null)
					escritura.close();
				if(lectura != null)
					lectura.close();
				if(ficheroLectura != null)
					ficheroLectura.close();
				if(ficheroEscritura != null)
					ficheroEscritura.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
