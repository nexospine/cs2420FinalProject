package monsters;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.algs4.StdIn;

public class GUI {

	public static void main(String[] args) {
		PFMonster[] monsters = getMonsters("src/monsters/resources/pfMonsters.csv");
		
		Search monsterSearch = new Search(monsters);
		PFMonster[] userMonsters;
		
		System.out.print("Enter a monster name/partial name: ");
		while(StdIn.hasNextLine()) {
			String input = StdIn.readLine();
			if(input != "") {
				userMonsters = monsterSearch.range(input);
				if(userMonsters != null) {
					for(int i = 0; i < userMonsters.length; i++) {
						System.out.println(userMonsters[i].toString());
					}
				}
			}
			else
				System.out.println("Please enter a valid name");
		}
	}
	
	/**
	 * Reads from the given csv file to create a list of elements in the form of an array
	 * 
	 * @param fileName
	 * @return array of all elements from csv
	 */
	private static PFMonster[] getMonsters(String fileName) {
		List<PFMonster> list = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
			br.readLine(); // remove header
			String line;
			while((line = br.readLine()) != null) {
				String[] tokens = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
				String[] trait = tokens[1].replace("\"", "").split(",");
				list.add(new PFMonster(tokens[0], trait));
			}
		} catch (IOException e) {
			System.out.println("a problem occured reading the csv");
			e.printStackTrace();
		}

		return list.toArray(new PFMonster[list.size()]);
	}

}
