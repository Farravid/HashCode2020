import java.util.*;
import java.io.*;

public class Book{

	private int id;
	private int score;

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

	public void setScore(scoreLibro){
		if(scoreLibro<0){
			score = -1;
		}else{
			score = scoreLibro;
		}
	}

}