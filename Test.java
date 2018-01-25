import java.util.Random;

enum Suite { HEART, SPADE, DIAMOND, CLUB; }

class Deck {
	Cards c[][] = new Cards[13][4];
	
	Deck() {
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 4; j++) {
				c[i][j] = new Cards();
				c[i][j].setNumber(i+1);
				
				if 		( j == 0 )
					c[i][j].setSuite(Suite.HEART);
				
				else if ( j == 1 )
					c[i][j].setSuite(Suite.CLUB);
				
				else if ( j == 2 )
					c[i][j].setSuite(Suite.SPADE);
				
				else if ( j == 3 )
					c[i][j].setSuite(Suite.DIAMOND);
			}
			
		}
	}
	
	void printDeck() {
		for (int i = 0 ; i < 13; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.println(c[i][j].toString());
			}
		}
	}
	void shuffleDeck() {
		System.out.println("\n\nShuffling the deck!");
		Random r = new Random();
		
		for (int i = 0; i < 1000; i++) {
			int a = r.nextInt(13);
			int b = r.nextInt(4);
			int x = r.nextInt(13);
			int y = r.nextInt(4);
			
			Cards temp1 = c[a][b];
			c[a][b] = c[x][y];
			c[x][y] = temp1;
		}
	}
}

class Cards {
	private int number;
	private Suite s;
	
	Cards() {
		this.number = 0;
		this.s = null;
	}
	
	void setNumber(int number) {
		this.number = number;
	}
	void setSuite(Suite s) {
		this.s = s;
	}
	int getNumber() {
		return this.number;
	}
	Suite getSuite() {
		return this.s;
	}
	
	@Override
	public String toString() {
		String o = "Number: " + getNumber() + " and suite: " + getSuite();
		return o;
	}
}
public class Test {
	public static void main(String[] args) {
		Deck d = new Deck();
		d.printDeck();
		
		d.shuffleDeck();
		d.printDeck();
	}
}
