

public class Sudoko {
	int[][] board=new int[9][9];
	public void calculatesudoko(int row,int colume){
		if(row==8&&colume>=9){
			for(int i=0;i<9;i++){
				for(int j=0;j<9;j++){
					System.out.print(board[i][j]);
					System.out.print("|");
				}
				System.out.println("");
			}
			return;
		}
		if(colume==9){
			row++;
			colume=0;
		}
		if(board[row][colume]!=0){
			calculatesudoko(row,colume+1);
		}
		if(board[row][colume]==0){
			for(int i=1;i<10;i++){
				if(judge(row,colume,i)){
					board[row][colume]=i;
					calculatesudoko(row,colume+1);
	                board[row][colume]=0;
				}
			}
		}
		
		
	}
	public void setboard(int[][] board){
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				this.board[i][j]=board[i][j];
			}
		}
	}
	public boolean judge(int x,int y,int value){
        for(int p = 0; p<9; p++)
        {
            if(value == board[x][p])
            {
                return false;
            }
            if(value == board[p][y])
            {
                return false;
            }
            if(value == board[3*(x/3)+p%3][3*(y/3)+p/3])
            {
                return false;
            }
        }
        return true;
	}
	public static void main(String[] args){
        int ma1[][] = {
                {8,0,0,0,0,0,0,0,0},
                {0,0,3,6,0,0,0,0,0},
                {0,7,0,0,9,0,2,0,0},
                {0,5,0,0,0,7,0,0,0},
                {0,0,0,0,4,5,7,0,0},
                {0,0,0,1,0,0,0,3,0},
                {0,0,1,0,0,0,0,6,8},
                {0,0,8,5,0,0,0,1,0},
                {0,9,0,0,0,0,4,0,0}};
		Sudoko test=new Sudoko();
		test.setboard(ma1);
		test.calculatesudoko(0,0);
	}
}
