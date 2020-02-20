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

			// for(int i=0; i<scores.size(); i++){
			// 	System.out.println(libros.get(i).getId() + " , " + libros.get(i).getScore());
			// }

			//Esta mierda lee el fichero
			int librosEnBiblioteca = 0;
			Library libreriaAux = new Library(0, 0, 0);
			while(linea != null) {
				linea = lectura.readLine();
				if(linea != null) {
					arrayAux = linea.split(" ");
					if(numLinea % 2 != 0){
						librosEnBiblioteca = Integer.parseInt(arrayAux[0]);
						libreriaAux = new Library(idLibreria, Integer.parseInt(arrayAux[1]), Integer.parseInt(arrayAux[2]));
						librerias.add(libreriaAux);
					}else{
						for(int i=0; i<arrayAux.length; i++){
							libreriaAux.insertBook(libros.get(Integer.parseInt(arrayAux[i])));
						}
					}
					idLibreria++;
					numLinea++;
				}
			}
			for(int i=0; i<librerias.size(); i++){
				System.out.println("Libreria " + i);
				for(int j=0; j<librerias.get(i).getLibros().size(); j++){
					System.out.println("\t" + "Libro " + j + " : " + librerias.get(i).getLibros().get(j).getId() + " , " + librerias.get(i).getLibros().get(j).getScore());
				}
			}
			//Esta otra mierda escribe
			/*while(empieza >= 0) {
				for(int i = empieza; i < 4; i++) {
					if(jugadores[i] != null) {
						fichaAux = jugadores[i].juega(tablero);
						if(fichaAux != null)
							escritura.write(jugadores[i].getNombre() + " juega " + fichaAux.toString() + "\n");
						else {
							escritura.write(jugadores[i].getNombre() + " juega null" + "\n");
							escritura.write(jugadores[i].getNombre() + " roba " + jugadores[i].roba(saco) + "\n");
						}
					}
				}
				empieza = 0;
			}*/
			int score=0;
			for (int=i;i<librerias.size();i++ ) {
				ArrayList<Book> librosL= librerias.get(i).getLibros();
				int librosmax=librerias.get(i).getLibrosToScan();

				for(int j=0;j<librosmax;j++){
					if(librosL.get(j).getEscaneado()==false){
						librosL.get(j).setEscaneado();
						score=score+librosL.get(j).getScore();
					}
				}
			}
		}


		//Escritura
		escritura.write(descripcion.get(1));

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
