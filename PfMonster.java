package finalProject;

public class PfMonster {
	private String name;
	private String traits; //String[] traits; TODO fix monsters.add in ShortestPath.getListofMonsters, and the CTOR in this class.
	private String creatureFamily; //String[] creatureFamily[]; 
	
	/**Ctor
	 * 
	 * @param name String name of the monster
	 * @param traits String array of different monster traits
	 * @param creatureFamily String array of different monster creature families.
	 */
	public PfMonster(String name, String traits, String creatureFamily) {
		this.name = name;
		this.traits = traits;
		this.creatureFamily = creatureFamily;
	}
}
