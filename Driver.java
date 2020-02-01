import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Driver {
	// Global variable
	static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

	public static <T> void main(String[] args) throws IOException {
		int n = 0;
		// queue of planes that need to be re-entered
		ListArrayBased<Plane> reEnter = new ListArrayBased<>();
		// array of runways
		ListArrayBased<Runway> airport = new ListArrayBased<>();

		boolean bye = false;
		// =------------------------------adds to booth
		// queue--------------------------------------------------------------------------------
		System.out.println("Enter the number of runways for your airport: ");

		String number = stdin.readLine().trim();
		int num = Integer.parseInt(number);

		for (int i = 0; i < num; i++) {
			System.out.println("Name of number " + (i + 1) + " runway:");
			String name = stdin.readLine().trim();
			Runway na = new Runway(name);
			airport.add(i, na);
		}

		// =-----------------------------------start of menu
		// sequence------------------------------------------------------------------------------

		while (!bye) {
			printMenu();
			String input = stdin.readLine().trim();
			n = Integer.parseInt(input);
			System.out.println(n);
			switch (n) {
			// =-----------------------------this adds a persons name to name
			// queue-------------------------------------------------------------------
			case 1:
				boolean there = false;
				int index = 0;

				System.out.println("Welcome to the Airport Enter the plane information:");
				System.out.println("Name of the plane: ");
				String nam = stdin.readLine().trim();
				System.out.println(nam);
				System.out.println("Where is the plane headed: ");
				String d = stdin.readLine().trim();
				System.out.println(d);
				System.out.println("What is the name of the Runway: ");
				String r = stdin.readLine().trim();
				System.out.println(r);

				while (!there) {
					for (int x = 0; x < airport.size(); x++) {
						if (airport.get(x).getName().compareTo(r) == 0) {
							there = true;
							index = x;
						}
					}
					if (!there) {
						System.out.println("Enter a known runway: ");
						r = stdin.readLine().trim();
					}
				}

				// =-------------------------------------------------------------------------------
				Plane plane = new Plane(nam, d, r);
				airport.get(index).add(plane);

				System.out.println("\tThe plane has now been added! ");
				System.out.println("");

				break;
			// =--------------------------------------this will take first in
			// line and take a booth
			// away---------------------------------------------------------------------------------
			case 2:
				try {

				} catch (QueueException ex) {
					System.out.println("");
				}
				break;
			// =-------------------------------------------------this will
			// finish the booth
			// inspection------------------------------------------------------------------------
			case 3:
				System.out.println("Enter flight number:");
				String find = stdin.readLine().trim();
				index = 0;
				boolean found = false;
				Plane temp;

				if (reEnter.isEmpty()) {
					System.out.println("There are no planes waiting for clearance!");
					break;
				}
				while (!found) {
					for (int x = 0; x < reEnter.size(); x++) {
						if (find == reEnter.get(x).getName()) {
							index = x;
						}
					}
					if (!found) {
						System.out.println("Enter a known flight: ");
						find = stdin.readLine().trim();
					}
				}

				temp = reEnter.get(index);
				reEnter.remove(index);
				found = false;
				for (int x = 0; x < airport.size(); x++) {
					if (airport.get(x).getName().compareTo(temp.getRunway()) == 0) {
						airport.get(x).add(temp);
					}
				}

				if (!found) {
					// put in other fucking runway
				}

				break;
			// =-----------------------------------------Add runway
			case 4:
				boolean same = false;
				System.out.println("Enter the name of the new runway: ");
				String name = stdin.readLine().trim();

				while (!same)
					for (int x = 0; x < airport.size(); x++) {
						if (airport.get(x).getName().compareTo(name) == 0) {
							same = true;
							System.out.println("Runway " + name + " already exists, please choose another name.");
							System.out.println("Enter the name of the new runway:");
							name = stdin.readLine().trim();
							x = -1;
						}
					}

				Runway open = new Runway(name);
				airport.add(airport.size(), open);
				System.out.println("Runway " + name + " has opened.");

				break;
			// =--------------------------------------------remove runway
			case 5:
				if(airport.size() == 1) {
					System.out.println("Cannot close only runway!");
					break;
				}
				
				System.out.println("Enter runway: ");
				String removeR = stdin.readLine().trim();
				boolean search = true;
				index = 0;
				int INDEX = 0;

				while (search) {
					for (int x = 0; x < airport.size(); x++) {
						if (airport.get(x).getName().compareTo(removeR) == 0) {
							index = x;
							search = false;
						}
					}
					if (search) {
						System.out.println("No such runway!");
						System.out.println("Enter runway:");
						removeR = stdin.readLine().trim();
					}
				}

				if (airport.get(index).isEmpty()) {
					airport.remove(index);
				} else {
					for (int z = (airport.get(index).size() - 1); z >= 0; z--) {

						System.out.println("Enter new runway for plane " + airport.get(index).peek().getName() + ": ");
						String removeA = stdin.readLine().trim();

						same = true;
						while (same) {
							if (removeA.compareTo(removeR) == 0) {
								System.out.println("This is the runway that is closing!");
								System.out.println("Enter new runway for " + airport.get(index).peek().getName() + ": ");
								removeA = stdin.readLine().trim();
							}
							else {
								same = false;
							}
						}
						search = true;

						while (search) {
							for (int x = 0; x < airport.size(); x++) {
								if (airport.get(x).getName().compareTo(removeA) == 0) {
									INDEX = x;
									search = false;
								}
							}
							if (search) {
								System.out.println("No such runway!");
								System.out.println("Enter new runway for plane " + airport.get(index).peek() + ": ");
								removeA = stdin.readLine().trim();
							}
						}
						
						airport.get(INDEX).add(airport.get(index).peek());
						
						System.out.println("Flight " + airport.get(index).peek().getName() + " is now waiting for takeoff on runway " + removeA);
						airport.get(index).remove();
					}
					System.out.println("Runway " + removeR + " has been closed. \n");
					airport.remove(index);
				}

				break;
			// =-------------------------------displays what has been done
			// (inspecting
			// wise)--------------------------------------------------------------------------------------------------
			case 6:

				break;
			// =-----------------------------------------this Exits the menu
			// ----------------------------------------------------------------------
			case 7:
				break;
			case 8:
				break;
			case 9:
				System.out.println("Ending the program... Goodbye");
				break;
			default:
				System.out.println("");
			}
		}
	}

	/*
	 * this will have the menu done and ready to print
	 */
	public static void printMenu() {
		System.out.println("Select from the from the following menu: ");
		System.out.println("\t Option 1:  Plane enters the system.");
		System.out.println("\t Option 2:  Plane takes off.");
		System.out.println("\t Option 3:  Plane is allowed to re-enter a runway.");
		System.out.println("\t Option 4:  Runway opens.");
		System.out.println("\t Option 5:  Runway close.");
		System.out.println("\t Option 6:  Display info about planes waiting to take off.");
		System.out.println("\t Option 7:  Display info about planes waiting to be allowed to re-enter a runway.");
		System.out.println("\t Option 8:  Display number of planes who have taken off.");
		System.out.println("\t Option 9:  End the program.");
		System.out.println("Make your menu selection now: ");
	}

}
