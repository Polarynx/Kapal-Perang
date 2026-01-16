import java.io.*;
import java.util.Scanner;
public class Battlemain {

	public static void main(String[] args) {
//		 TODO Auto-generated method stub
		Game gg = new Game();
		String high="";
		try{
			Scanner scan = new Scanner(new File("line.dat"));
			while(scan.hasNext())
			{
			   high+=( scan.nextLine()+"\n");
			}
		}catch(FileNotFoundException e) {
			System.out.println("FAILURE");
		}
		PrintWriter hi;
		try{
			hi = new PrintWriter(new FileWriter("line.dat"));
	  	    hi.println(high + "YOU " + gg.getter());
	    	hi.close();
		}catch(IOException e) {
			System.out.println("FAILURE");
		}	
		}

}
