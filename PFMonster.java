package monsters;

public class PFMonster implements Comparable<PFMonster>{
	private String name;
	private String[] traits;
//	private String[] family;
	
	/**
	 * constructs an object off of name and a list of traits
	 * 
	 * @param name
	 * @param traits
	 */
	public PFMonster(String name, String[] traits) {
		this.name = name;
		this.traits = traits;
	}
	
	/**
	 * returns the name from the object
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * returns an array of traits from the object
	 * 
	 * @return traits[]
	 */
	public String[] getTraits() {
		return traits;
	}
	
	/**
	 * TODO
	 * 
	 * @return family
	 */
//	public String[] getFamily() {
//		return family;
//	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(this.name + ": ");
		for(int i = 0; i < this.traits.length; i++) {
			sb.append(this.traits[i]);
			sb.append(" ");
		}
		
		return sb.toString();
	}

	@Override
	public int compareTo(PFMonster o) {
		return this.name.compareTo(o.name);
	}
}
