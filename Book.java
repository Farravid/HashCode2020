import java.util.*;
import java.io.*;

public class Book{

	private int id;
	private int score;
	private boolean isEscaneado;

	public Book(int idBook, int scoreBook){
		if(idBook<0){
			id = -1;
		}else{
			id = idBook;
		}
		if(scoreBook<0){
			score = -1;
		}else{
			score = scoreBook;
		}
		isEscaneado = false;
	}


	public int getId(){
		return id;
	}
	public void setId(int idLibro){
		if(idLibro<0){
			id = -1;
		}else{
		id = idLibro;
		}
	}

	public int getScore(){
		return score;
	}

	public void setScore(int scoreLibro){
		if(scoreLibro<0){
			score = -1;
		}else{
			score = scoreLibro;
		}
	}

	public boolean getEscaneado(){
		return isEscaneado;
	}

	public void setEscaneo(){
		isEscaneado = true;
	}

}