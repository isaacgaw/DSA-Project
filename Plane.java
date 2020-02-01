
public class Plane 
{
//=------------------ Global variables ------------------------------------------
	public String name;
	public String dest;
	public String runway;

//=-------------------- Constructor --------------------------------------------
	public Plane (String name, String dest, String runway) 
	{
		// initializing the variables
		this.name = name;
		this. dest = dest;
		this.runway = runway;
	}

//=--------------------- Will Get the name -------------------------------------
	public String getName() 
	{
		return name;
	}

//=------------------------- Will get the Destination --------------------------
	public String getDest() 
	{
		return dest;
	}

//=------------------------------ Will get the runway --------------------------
	public String getRunway() 
	{
		return runway;
	}
//=------------------------------- Will set the Name -------------------------
	public void setName(String name) 
	{
		this.name = name;
	}

//=---------------------------- Will set the Destination -------------------
	public void setDest(String dest) 
	{
		this.dest = dest;
	}

//=-----------------------------  Will set the Runway -------------------
	public void setRunway(String runway) 
	{
		this.runway = runway;
	}
}
