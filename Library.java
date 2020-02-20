import java.util.*;
import java.io.*;

public class Library{

	private int id;
	private ArrayList<Book> libros;
	private int time;
	private int librosDia;
	private int librosToScan;
	private boolean registrada;

	public Library(int id, int time, int librosDia){
		libros = new ArrayList<Book>();
		if(id<0){
			this.id = -1;
		}else{
			this.id = id;
		}
		if(time<0){
			this.time = -1;
		}else{
			this.time = time;
		}
		if(librosDia<0){
			this.librosDia = -1;
		}else{
			this.librosDia = librosDia;
		}
		registrada = false;
	}

	public int getId(){
		return id;
	}
	public void setId(int id){
		if(id<0){
			this.id = -1;
		}else{
			this.id = id;
		}
	}
	public ArrayList<Book> getLibros(){
		return libros;
	}
	public void insertBook(Book bookecito){
		if(bookecito!=null){
			libros.add(bookecito);
		}
	}
	public int getTime(){
		return time;
	}
	public void setTime(int time){
		if(time<0){
			this.time = -1;
		}else{
			this.time = time;
		}
	}
	public int getlibrosDia(){
		return librosDia;
	}

	public int getLibrosToScan(){
		return librosToScan;
	}

	public boolean getRegistrada(){
		return registrada;
	}

	public int registro(int diaActual, int diasTotales){
		System.out.println("Time vale: "+time);
		System.out.println("Dia actual: "+diaActual);
		System.out.println("Dias totales: "+diasTotales);
		librosToScan = diasTotales - (time+diaActual-1);
		System.out.println("Aqui que valgo"+ librosToScan);
		librosToScan = librosToScan * librosDia;
		System.out.println("Libros to Scan: "+librosToScan);
		if(librosToScan>libros.size()){
			librosToScan = libros.size();
		}

		System.out.println("Final libros to Scan es: "+librosToScan);
		registrada = true;
		System.out.println("Devuelvo esto: "+time+diaActual);
		return time+diaActual;
	}


}