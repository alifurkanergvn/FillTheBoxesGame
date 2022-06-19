public class StartGame {
	
	//tablo s�f�rlama
	public int [][] resetAllBox (int [][]array){
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				array[i][j]=0;
			}
		}
		return array;
	}
	
	
	public void gameStartPoint() {
		
		int [][] gamePositions = new int[10][10];
		//Oyun ba�lang�� noktalar�
		for(int y=0; y<=9; y++) {
			for(int x=0; x<=9; x++) {
				gamePositions = resetAllBox(gamePositions);
				fillBoxes(gamePositions,x,y);
				
			}
		}
		//fillBoxes(gamePositions, 0, 0);
	}
	
	public void fillBoxes(int [][]gamePositions, int x, int y) {
		
		int countNumber=1;
		gamePositions[y][x] =countNumber;
		//countNumber++;
		
		while (countNumber<=100) {
				
			//Sol �st gidi�
			if((x-2>=0 && y-2>=0) && gamePositions[y-2][x-2] == 0  ) {
				x-=2;
				y-=2;
			}
			//Yukar� gidi�
			else if (y-3>=0 && gamePositions[y-3][x]==0 ) {
				y-=3;
			}
			//Sa� �st gidi�
			else if ((x+2<=9 && y-2>=0) && gamePositions[y-2][x+2]==0 ) {
				x+=2;
				y-=2;
			}
			//Sa�a gidi�
			else if (x+3<=9  && gamePositions[y][x+3]==0 ) {
				x+=3;
			}
			//Sa� alt gidi�
			else if (x+2<=9 && y+2<=9 && gamePositions[y+2][x+2]==0) {
				x+=2;
				y+=2;
				 	
			}
			//A�a�� gidi�
			else if ( y+3<=9  && gamePositions[y+3][x]==0) {
				y+=3;
			}
			//Sol a�a�� gidi�
			else if ( x-2>=0 && y+2<=9 && gamePositions[y+2][x-2]==0 ) {
				x-=2;
				y+=2;		
			}
			//Sola gidi�
			else if ( x-3>=0 && gamePositions[y][x-3]==0  ) {
				x-=3;
			}
			//Gidilecek kare kalmay�nca
			else {
				showBoxes(gamePositions,countNumber);
				break;
			}
			++countNumber;
			gamePositions[y][x]=countNumber;
				
		}		
	}
		
	//Consolda arraylerin g�sterimi
	public void showBoxes (int [][] gamePositions,int countNumber) {
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				if(gamePositions[i][j] < 10) {
					System.out.print(gamePositions[i][j] + "   ");
				}
				else if(gamePositions[i][j] == 100){
					System.out.print(gamePositions[i][j] + " ");
				}
				else {
				System.out.print(gamePositions[i][j] + "  ");
				}
			}
			System.out.println();
			
		}
		System.out.println("En y�ksek say�:"+countNumber );
		System.out.println("\n\n");
		
	}
	

}
