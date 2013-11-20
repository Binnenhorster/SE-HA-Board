
public class Board {
	String[][] field;
	
	public Board(){
		field = new String[3][3];
		for(int i = 0; i < field.length; i++){
			for (int j = 0;j < field[i].length;j++){
				field[i][j] = "Empty";
			}
		}
	}
	
	public void setMark(String mark, int x, int y){
		if(x > 2 || y > 2){
			throw new InvalidPositionException("Ihre angegebene Position ist auﬂerhalb des Feldes");
		}else if (!(mark.equalsIgnoreCase("X") || mark.equalsIgnoreCase("O"))){
			throw new InvalidPositionException("Nur X oder O erlaubt");
		}else{
			field[x][y] = mark;
		}
	}
	
	public boolean hasWinner(){
		return (testFor("X") || testFor("O"));
	}
	
	public boolean testFor(String mark){
		boolean result = false;
		//Teste Spalten
		for (int i = 0; i < 2;i++){
			if (field[i][0].equalsIgnoreCase(mark) && field[i][1].equalsIgnoreCase(mark) && field[i][2].equalsIgnoreCase(mark)){
				result = true;
			}
		}
		//Teste Zeilen
		for (int i = 0; i < 2;i++){
			if (field[0][i].equalsIgnoreCase(mark) && field[1][i].equalsIgnoreCase(mark) && field[2][i].equalsIgnoreCase(mark)){
				result = true;
			}
		}
		//Teste Diagonalen
		
			if (field[0][0].equalsIgnoreCase(mark) && field[1][1].equalsIgnoreCase(mark) && field[2][2].equalsIgnoreCase(mark)){
				result = true;
			}
		for (int i = 0;i<2;i++){
			if (field[2][0].equalsIgnoreCase(mark) && field[1][1].equalsIgnoreCase(mark) && field[0][2].equalsIgnoreCase(mark)){
				result = true;
			}
		}
		return result;
	}
}
