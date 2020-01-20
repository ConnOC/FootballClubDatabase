import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class FootballApp
{
	private static Scanner input = new Scanner(System.in);
	private static InputStreamReader textInput = new InputStreamReader(System.in);
	private static BufferedReader reader = new BufferedReader(textInput);
	private static int centralPlayerID = 1001;
	private static int centralTeamID = 105;

	private static ArrayList<Team> allTeams = new ArrayList<Team>();
	private static ArrayList<Player> allPlayers = new ArrayList<Player>();
	private static ArrayList<Exception> bugReport = new ArrayList<Exception>();
	
	public static void main(String[] args)
	{
		prePopulate();
		mainMenu();
	}
	public static void prePopulate()
	{
		Team t1 = new Team(101, "Arsenal");
		Team t2 = new Team(102, "Liverpool");
		Team t3 = new Team(103, "Man united");
		Team t4 = new Team(104, "Man city");
		Player p1 = new Player(2001, "jim Smith", "Striker", 20, t1);
		Player p2 = new Player(2002, "Joe walsh", "midfielder" 22, t2);		
		
		allTeams.add(t1);
		allTeams.add(t2);
		allTeams.add(t3);
		allTeams.add(t4);
		allPlayers.add(p1);
		allPlayers.add(p2);
	}
	
	public static void viewTeams()
	{
		for(Team t: allTeams)
		{
			System.out.println(t.getTeamID() + "\t" + t.getTeamName());
		}
	}
	
	public static void createTeam() throws Exception
	{
		Team t = new Team(); //Creates an empty Team Object
		t.setTeamID(centralTeamID);
		centralTeamID++;
		System.out.println("Enter team name");
		t.setTeamName(reader.readLine());
		System.out.println(t.getTeamName() + " has been sucessfully created");
		allTeams.add(t);
	}
	
	public static void teamMenu()
	{
		System.out.println("Press 1 to Create a team");
		System.out.println("Press 2 to view All teams");
		System.out.println("press 3 to edit a team");
		System.out.println("Press 4 to delete a team");
		System.out.println("press 5 to return to main menu");
	
		String choice = input.next();
		
		switch(choice)
		{
			case"1":
			{
				try {
				createTeam();
				}
				catch(Exception e)
				{
					bugReport.add(e);
					System.out.println("Error logged");
				}
				break;
			}
			case"2":
			{
				viewTeams();
				break;
			}
			case"5":
			{
				mainMenu();
				break;
			}
		
		
		}
	
		teamMenu();
	}
	
	
	public static void mainMenu()
	{
		System.out.println("press 1 for player menu");
		System.out.println("press 2 for team menu");
		System.out.println("press x to exit");
		String choice = input.next();
		switch(choice)
		{
			case "1":
			{
				System.out.println("loading player menu");
				playerMenu();
				break;
			}
			
			case "2":
			{
			System.out.println("loading team menu");
			teamMenu();
			break;
			}
		
			case "x":
			{
		
			}
		
		
		
		}
				
		
		
		mainMenu();
	}

	public static void createPlayer() throws Exception
	{
		Player p = new Player();
		p.setId(centralPlayerID);
		centralPlayerID++;
		System.out.println("enter player name");
		p.setName(reader.readLine());
		System.out.println("enter age");
		p.setAge(input.nextInt());
		System.out.println("enter position");
		p.setPosition(reader.readLine());
		System.out.println("choose player club by ID number");
		viewTeams();
		int clubID = input.nextInt();
		
		for(Team t: allTeams)
		{
			if(clubID==t.getTeamID())
			{
				p.setClub(t); //adds chosen club to player
				t.addPlayer(p); // adds player to the club
				System.out.println(p.getName()+" has signed for "+t.getTeamName());
			}
		}
		allPlayers.add(p);
	}
	
	
	public static void playerMenu()
	{
		System.out.println("press 1 to create a player");
		System.out.println("press 2 view all players");
		System.out.println("press 3 to edit a player ");
		System.out.println("preddd 4 to delete a player");
		System.out.println("press 5 to print players by club");
		System.out.println("press 6 to return to main menu");

		String choice = input.next();
		
		switch(choice)
		{
		case"1":
		{
			try
			{
			createPlayer();
			}
			catch(Exception e)
			{
				bugReport.add(e);
				System.out.println("error logged");
			}
			break;
		}
		case "2":
		{
			viewPlayers();
			break;
		}
		case "3":
		{
			try
			{
			editPlayer();
			}
			catch(Exception e)
			{
				bugReport.add(e);
				System.out.println("error logged");
			}
			break;
			
			
			}
		case"4":
		{
			deletePlayer();
			break;
		}
		case"5":
		{
			printPlayersByClub();
			break;
		}
		
		case "6":
		{
			mainMenu();
			break;
		}
		
		
		
		}
		
		playerMenu();
	}


	private static void editPlayer() throws Exception
	{
		viewPlayers();
		System.out.println("choose ID number of player to edit");
		int chosenPlayer = input.nextInt();
		
		for(Player p: allPlayers)
		{
			if(chosenPlayer == p.getId())
			{
				System.out.println("enter new name for "+p.getName());
				p.setName(reader.readLine());
				System.out.println("enter new age for "+p.getAge());
				p.setAge(input.nextInt());
				System.out.println("enter new position to replace "+p.getPosiiton());
				p.setPosition(reader.readLine());
			}
		}
		
	}
	private static void deletePlayer() {
		viewPlayers();
		System.out.println("choose ID number of player to delete");
		int chosenPlayer = input.nextInt();
		
		for(Player p: allPlayers)
		{
			if(chosenPlayer==p.getId())
			{
				allPlayers.remove(p);
				for(Team t: allTeams)
				{
					if(p.getClub().equals(t))
					{
						p.setClub(null);
						t.removePlayer(p);
						playerMenu();
					}
				}
			}
		}
	}
	private static void printPlayersByClub() 
	{
		viewTeams();
		System.out.println("Enter club by ID number");
		int chosenClub = input.nextInt();
		
		for(Team t: allTeams)
		{
			if(chosenClub==t.getTeamID())
			{
				t.printSquad();
			}
		}
		
	}
	public static void viewPlayers()
	{
		for(Player p: allPlayers)
		{
			p.printDetails();
		}
	}

	








}
