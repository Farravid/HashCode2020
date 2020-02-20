import java.util.*;
import java.io.*;

public class Library{

	private int id;
	private ArrayList<Book> libros;
	private int time;
	private int librosDia;
	private int librosToScan;

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

	public int registro(int diaActual, int diasTotales){
		librosToScan = diasTotales - (time+diaActual);
		librosToScan = librosToScan * librosDia;
		return time+diaActual;
	}


}