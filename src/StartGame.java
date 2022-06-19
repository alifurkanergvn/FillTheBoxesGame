public class StartGame {
	
	//tablo sýfýrlama
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
		//Oyun baþlangýç noktalarý
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
				
			//Sol üst gidiþ
			if((x-2>=0 && y-2>=0) && gamePositions[y-2][x-2] == 0  ) {
				x-=2;
				y-=2;
			}
			//Yukarý gidiþ
			else if (y-3>=0 && gamePositions[y-3][x]==0 ) {
				y-=3;
			}
			//Sað üst gidiþ
			else if ((x+2<=9 && y-2>=0) && gamePositions[y-2][x+2]==0 ) {
				x+=2;
				y-=2;
			}
			//Saða gidiþ
			else if (x+3<=9  && gamePositions[y][x+3]==0 ) {
				x+=3;
			}
			//Sað alt gidiþ
			else if (x+2<=9 && y+2<=9 && gamePositions[y+2][x+2]==0) {
				x+=2;
				y+=2;
				 	
			}
			//Aþaðý gidiþ
			else if ( y+3<=9  && gamePositions[y+3][x]==0) {
				y+=3;
			}
			//Sol aþaðý gidiþ
			else if ( x-2>=0 && y+2<=9 && gamePositions[y+2][x-2]==0 ) {
				x-=2;
				y+=2;		
			}
			//Sola gidiþ
			else if ( x-3>=0 && gamePositions[y][x-3]==0  ) {
				x-=3;
			}
			//Gidilecek kare kalmayýnca
			else {
				showBoxes(gamePositions,countNumber);
				break;
			}
			++countNumber;
			gamePositions[y][x]=countNumber;
				
		}		
	}
		
	//Consolda arraylerin gösterimi
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
		System.out.println("En yüksek sayý:"+countNumber );
		System.out.println("\n\n");
		
	}
	

}
