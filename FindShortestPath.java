package finalProject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.SymbolGraph;

public class FindShortestPath {
	private String filepath;
	
	/**Ctor. Should create a graph of the array of monsters I think?
	 * 
	 * Why is this a constructor again? And why do we pass an array
	 * of monsters into this, rather than just passing the filepath in?
	 * I think this class just reads a CSV and converts it into a graph.
	 * 
	 * @param monsters array of type monster
	 */
	FindShortestPath(String filepath) {//PfMonster monsters[]) { //why were we passing in an array of monsters again?
		this.filepath = filepath;
	}
	
	/**
	 * 
	 */
	public void printAdjacencyList() {
		
		SymbolGraph sg = new SymbolGraph(filepath, ","); //make a new symbol graph
		Graph g = new Graph(sg.graph()); //make a graph which is a copy of the symbol graph
		
		
//		Broadly, what comes next isn't supposed to work like this, and should be done through the gui, but I'm just doing this temporarily.
//		Before going much further with this implementation, I'd like to get the GUI component of the project more functional.
		////////////////////////////////////////////////////////////
        System.out.println("Enter a source monster: ");
		String source = StdIn.readLine().toUpperCase();
		if (sg.contains(source)) {
		System.out.println("source: " + source);
		System.out.println("The following destinations can be reached from " + source + ".\n");
		} else {
			throw new IllegalArgumentException("The source " + source + " could not be found");
		}
		
		BreadthFirstPaths bfs = new BreadthFirstPaths(g, sg.indexOf(source));
		
		for (int i = 0; i < g.V(); i++) {
			System.out.print(sg.nameOf(i) + ": ");
			for (Integer el : bfs.pathTo(i)) {
				System.out.print(sg.nameOf(el) + " ");
			}
			System.out.println();
		}	
		
		///////////////////////////////////////////////////////
		
		
		
		
		
		
		
		
//		This code prints all source vertices, and where those vertices can go to. 
//		The goal of this project is to print a single source vertex and print the shortest path to a single destination.
//		In between these two goals, I believe a good stepping stone is to print the shortest path to every destination, from a single source. 
//		This stepping stone is very similar to the RouteFinder in CE - SymbolTable.
//		for (int i = 0; i < g.V(); i++) {//while (StdIn.hasNextLine()) {
//            String source = sg.nameOf(i);
//            System.out.println(source);
//            if (sg.contains(source)) {
//                int s = sg.indexOf(source);
//                for (int v : g.adj(s)) {
//                    StdOut.println("   " + sg.nameOf(v));
//                }
//            }
//            else {
//                StdOut.println("input not contain '" + source + "'");
//            }
//        }
		
		
	}
	
	
	
//	I don't think this code is ever used, but I spent a lot of time writing it and as such I don't yet have the heart to delete it. 
	/**Reads in a list of Monsters from the filepath attribute set by the Ctor,
	 * and creates a List of PfMonster from the csv file. 
	 * 
	 * Notably, the UML diagram uses an array of monsters rather than a List
	 * of monsters. This code is similar to another project I did, where I
	 * ultimately regretted using an array instead of a list/arraylist. 
	 * This class CAN return an array if that's what we want, but it doesn't
	 * do that currently.
	 * 
	 * @param filepath String representation of relative path to monsters.csv location.
	 * @return List of monsters.
	 */
	private List<PfMonster> getListOfMonsters() {
		
		List<PfMonster> monstersList = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(filepath))) { //make a buffered reader to read in the contents of the csv file.
			String line;
			while ((line = br.readLine()) != null) {
				String[] tokens = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
				monstersList.add(new PfMonster(tokens[0], tokens[1], tokens[2])); //TODO change tokens[1 + 2] to take in arrays of strings.  
			}
		} catch (FileNotFoundException e) {
			System.out.println("The file was not found.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("A problem occurred reading in the list of Monsters.");
			e.printStackTrace();
		}
		return monstersList;
	}
	
//	bfs
}
