package Question8_8;

public class Question {
	static int columnForRow[] = new int [8];
	static boolean check(int row) {
		for (int i = 0; i < row; i++) {
			int diff = Math.abs(columnForRow[i] - columnForRow[row]);
		    if (diff == 0 || diff == row - i) return false;
		}
		return true;
	}

	static void printBoard() {
		System.out.println("-----------------");
		for(int i = 0; i < 8; i++){
			System.out.print("|");
			for(int j = 0; j < 8; j++){
			    if (columnForRow[i] == j) System.out.print("Q|");
			    else System.out.print(" |");
			}
			System.out.println("\n-----------------");
		}
		System.out.println("");
	}

	static void PlaceQueen(int row){
		if (row == 8) {
		    printBoard();
		    return; 
		}
		for (int i = 0; i < 8; i++) {
		    columnForRow[row]=i;
		    if(check(row)){
				PlaceQueen(row+1);
		    }
		}
	}
	   
	public static void main(String[] args) {
		PlaceQueen(0);
	}

}
