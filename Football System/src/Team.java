import java.util.ArrayList;

public class Team 
{

	private int teamID;
	private String teamName;
	private ArrayList<Player> teamSquad = new ArrayList<Player>();
	
	public Team()
	{
		
	}
	public Team(int teamID, String teamName)
	{
		this.teamID = teamID;
		this.teamName = teamName;		
	}
	
	public void addPlayer(Player p)
	{
		//add methods adds to the array list
		teamSquad.add(p);
		System.out.println(p.getName() + "has been added to the squad");
	}
	
	public void removePlayer(Player p)
	{
		// remove method removes
		teamSquad.remove(p);
		System.out.println(p.getName() + "has beeen removed from the squad");
	}
	
	public void printSquad()
	{
	/*
	 * we use a different kind of for loops working with
	 * Arraylists
	 * 1. we define a local variable i.e. Player p
	 * 2. Separated by a colon , we name the arraylist
	 * the for loops will then proceed to load in the contents of hte ArrayLists
	 * into the local variable and execute the code inside of the block
	 * each object is moved into the variable one by one until there are no more
	 * objects left at this point
	 */
	System.out.println(teamName + "squad list");
	System.out.println("******************************");
	for(Player p: teamSquad)
	{
		p.printDetails();
	}
	System.out.println("********************************");
	
	}
	
	public int getTeamID() {
		return teamID;
	}
	public void setTeamID(int teamID) {
		this.teamID = teamID;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public ArrayList<Player> getTeamSquad() {
		return teamSquad;
	}
	public void setTeamSquad(ArrayList<Player> teamSquad) {
		this.teamSquad = teamSquad;
	}
	
	
}
