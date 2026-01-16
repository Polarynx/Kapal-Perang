
public class Location 
{
	private int column;
	private int row;
	
	/**
	 * @param c - x position
	 * @param r - y position
	 */
	public Location(int c, int r) 
	{
		column = c;
		row = r;
	}
	public int getRow() 
	{
		return row;
	}
	public int getColumn() 
	{
		return column;
	}
	public int[] asArray()
	{
		return new int[] {row, column};
	}
	public boolean equals(Location o) {return(row == o.getRow() && column == o.getColumn());}
//	public boolean checkArray(String[][] ar) { if()
}
