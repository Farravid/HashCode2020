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
			//Esta mierda lee el fichero
			while(linea != null) {
				linea = lectura.readLine();
				if(linea != null) {
					System.out.println(linea);
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
