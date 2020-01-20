
public class Player
{
private int id;
private String name;
private String position;
private int age;
private Team club;

public Player()
{
	//null constructor
}

public Player(int id, String name, String position, int age, Team club)
{
	this.id = id;
	this.name = name;		
	this.position = position;
	this.age = age;


}
public void printDetails()
{
	System.out.println("ID:\t" + id);
	System.out.println("Name:\t" + name);
	System.out.println("Age:\t" + age);
	System.out.println("Position:\t" + position);
	if(club.equals(null))
	{
		System.out.println("club unattached");
	}
	else
	{
		System.out.println("club is "+ club.getTeamName());
	}
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPosiiton() {
	return position;
}
public void setPosition(String position) {
	this.position = position;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public Team getClub() {
	return club;
}
public void setClub(Team club) {
	this.club = club;
}



}
