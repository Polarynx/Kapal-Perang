import java.util.Scanner;
import java.lang.Boolean;
public class Game {
	private String[][] board = new String[10][10];
	private String[][] botBoard = new String[10][10];
	private boolean won;
	private final int numShipsLeft = 6;
	
	public Game()
	{
			System.out.println("WELCOME TO BATTLESHIP!");
			Scanner scan = new Scanner(System.in);
			for(int i = 0; i<numShipsLeft; i++)
			{
				String ship="";
				switch(i) {
				case 0: {ship = "Battleship";break;}
				case 1: {ship = "Destroyer";break;}
				case 2: {ship = "Destroyer";break;}
				case 3: {ship = "Submarine";break;}
				case 4: {ship = "Submarine";break;}
				case 5: {ship = "Submarine";break;}
				default:{break;}
				}
				Location loc;
				do {
					// bot
					loc = new Location((int)(Math.random()*board[0].length), (int)(Math.random()*board.length));
				} while (!placeShip(ship, loc, (int)((Math.random()*4)+1), true));
				Location thumbsUp;
				int dir;
				Boolean cont = null;
				do {
					// human
					System.out.println(((cont != null)?"The ship cannot fit inside the battlefield! ":"")+"Please input an inital location for the "+ship+"\nThe first int is the horizantal distance from the left, and the second int is the vertical distance from the top.");
					thumbsUp = new Location(scan.nextInt(),scan.nextInt());
					System.out.println("Please input the direction for the battleship\n1 - Up, 2 - Right, 3 - Down, 4 - Left");
					dir = scan.nextInt();
					cont = !placeShip(ship, thumbsUp, dir, false);
					getBoard(true);
				} while (cont); 
		}
			battle();
	}
	
	
	public void battle() 
	{
		Scanner scan = new Scanner(System.in);
		boolean jorge = false;
		while(!jorge) 
		{
			System.out.println("Type the location you want to shoot at \nfirst number is the row, the second number is the column");
			takeShot(new Location(scan.nextInt(),scan.nextInt()),true);
			takeShot(new Location((int)(Math.random()*10),(int)(Math.random()*10)),false);
			System.out.println("Your Board:");
			getBoard(true);
			jorge = checkIfWin();
		}
//		FileWriter ok = new FileWriter("");
		System.out.println("YOU " + (won?"ARE VICTORIOUS IN BATTLE!":"LOST AGAINST THE MACHINES..."));
//		PrintWriter hi = new PrintWriter(new FileWriter("line.dat"));
//		hi.println("YOU " + (won?"ARE VICTORIOUS IN BATTLE!":"LOST AGAINST THE MACHINES..."));
//		hi.close();
//		Scanner file = new Scanner(new File("line.dat"));

	}
	/**
	 * @param direction - 1: up, 2: right, 3: down, 4: left
	 * @param bot - true if bot, false if not
	 * @return - is ship placed?
	 */
	public boolean placeShip(String name, Location ok, int direction, boolean bot)
	{
		int shipLength;
		switch(name) { // find ship length based on name
		case "Battleship": {shipLength = 4; break;}
		case "Destroyer": {shipLength = 3; break;}
		case "Submarine": {shipLength = 2; break;}
		default: {return false;}
		}
		Location[] xd = new Location[shipLength];
		String[][] boardee;
		int col = ok.getColumn();
		int row = ok.getRow();
		if(bot) {boardee=botBoard;}else {boardee=board;}
		for (int i = 0; i < shipLength; i++)
		{	
			if((row<boardee.length&& col<boardee[0].length && row>=0 && col>=0)&&boardee[row][col]==null) {
			if(direction==3) {xd[i]=new Location(col, row); row++;}
			if(direction==2) {xd[i]=new Location(col, row); col++;}
			if(direction==1) {xd[i]=new Location(col, row); row--;}
			if(direction==4) {xd[i]=new Location(col, row); col--;}}else {return false;}
		}
		
		for (int i = 0; i < shipLength; i++) {boardee[xd[i].getRow()][xd[i].getColumn()]=name;}
		
		return true;
	}
	public void getBoard() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Do you want to see the player board or bot board?\n Return true for player board and false for bot board.");
		boolean player = scan.nextBoolean();
		if(player) {
			for(String[] jakob: board) {
				for(String nithin: jakob) {
					if(nithin != null && !nithin.contains("-hit")) {System.out.print("- ");}else if(nithin != null && nithin.contains("-hit")){System.out.print("X ");}else {System.out.print("O ");}
				}
				System.out.println("");
			}
		} else {
			for(String[] jakob: botBoard) {
				for(String nithin: jakob) {
					if(nithin != null && !nithin.contains("-hit")) {System.out.print("- ");}else if(nithin != null && nithin.contains("-hit")){System.out.print("X ");} else {System.out.print("O ");}
				}
				System.out.println("");
			}
		}
	}
	public void takeShot(Location l,boolean bot)
	{
		String[][] boarde;
		String ifPlayer = !bot?"bot":"player";
		if(bot) {boarde=botBoard;}else {boarde=board;}
		if(boarde[l.getRow()][l.getColumn()]!=null && !boarde[l.getRow()][l.getColumn()].contains("-hit")) {
			System.out.println("The " + ifPlayer + " has struck a " + boarde[l.getRow()][l.getColumn()] + "!");
			boarde[l.getRow()][l.getColumn()]+="-hit";
		} else if(boarde[l.getRow()][l.getColumn()] != null && boarde[l.getRow()][l.getColumn()].contains("-hit")) 
		{
			System.out.println("The " + ifPlayer + " has already struck this ship.");
		}else 
		{
			System.out.println("The " + ifPlayer + " has missed.");
		}
	}
	public boolean checkIfWin()
	{
		boolean won1 = true;
		boolean won2 = true;
			for(String[] jakob: botBoard) {
				for(String nithin: jakob) {
					if(nithin != null && !nithin.contains("-hit")) {won1=false;}
				}
			}
			for(String[] jakob: board) {
				for(String nithin: jakob) {
					if(nithin != null && !nithin.contains("-hit")) {won2=false;}
				}
			}
		if(won1) {won=true;} if(won2) {won=false;}
		if(won1||won2) {return true;}else {return false;}
	}
	public void getBoard(boolean sean) {
		if(sean) {
			for(String[] jakob: board) {
				for(String nithin: jakob) {
					if(nithin != null) {System.out.print("- ");}else {System.out.print("O ");}
				}
				System.out.println("");
			}
		} else {
			for(String[] jakob: botBoard) {
				for(String nithin: jakob) {
					if(nithin != null) {System.out.print("- ");}else if(nithin.contains("-hit")){System.out.print("X ");} else {System.out.print("O ");
				}
				System.out.println("");
			}
		}}
	}
	public String getter() {
		return (won?"ARE VICTORIOUS IN BATTLE!":"LOST AGAINST THE MACHINES...");
	}
}
