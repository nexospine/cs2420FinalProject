package monsters;

import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.algs4.ST;

/**
 * Creates a symbol table for ordering PFMonster objects for
 * finding elements based on variable input.
 * 
 * @author Aiden M
 */
public class Search {
	private ST<String, PFMonster> monstersST = new ST<>();
	
	/**
	 * Creates a symbol table based off the data from the monsters array.
	 * all data must be unique and not case sensitive.
	 * 
	 * @param monsters
	 */
	public Search(PFMonster[] monsters) {
		for(PFMonster s : monsters) {
			monstersST.put(s.getName().toLowerCase(), s);
		}
	}
	
	/**
	 * Takes input and uses ST.ceiling and ST.floor to find a list of objects 
	 * that best match the given input.
	 * 
	 * @param userSearch
	 * @return array of PFMonsters[]
	 */
	public PFMonster[] range(String userSearch) {
		userSearch = userSearch.toLowerCase();
		String current = monstersST.ceiling(userSearch);
		String last = monstersST.floor(userSearch + "z");
		
		List<PFMonster> results = new ArrayList<>();
		results.add(monstersST.get(current));
		
		if(current.compareTo(last) > 0) {
			return results.toArray(new PFMonster[results.size()]);
		}
		
		while(!current.equals(last)) {
			current = monstersST.ceiling(current + "a");
			results.add(monstersST.get(current));
			
		}
		return results.toArray(new PFMonster[results.size()]);
		
	}
}
