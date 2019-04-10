/**
 * 
 */
package bfsdfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author vijyant
 *
 * @since Mar 18, 2019
 *
 */
public class Graphs {
	public static class Node{
		private int id;
		List<Node> adacent = new LinkedList<>();
		public Node(int id) {
			this.id = id;
		}
	}

	private Map<Integer, Node> nodeLookup = new HashMap<>();
	
	private Node getNode(int id) {
		return nodeLookup.get(id);
	}
	
	public void addEdge(int source, int destination) {
		Node s = getNode(source);
		Node d = getNode(destination);
		s.adacent.add(d);
	}
	
	public boolean hasPathDFS(int source , int destination) {
		Node s = getNode(source);
		Node d = getNode(destination);
		Set<Integer> visited = new HashSet<>();
		return hasPathDFS(s,d, visited);
	}
	
	public boolean hasPathDFS(Node source, Node destination, Set<Integer> visited) {
		if(visited.contains(source.id)) {
			return false;
		}
		visited.add(source.id);
		if(source == destination) {
			return true;
		}
		for(Node child : source.adacent) {
			if(hasPathDFS(child, destination, visited)) {
				return true;
			}
		}
		return false;
	}
	
	
	public boolean hasPathBFS(Node source , Node destination) {
		LinkedList<Node> nextToVisit = new LinkedList<>();
		Set<Integer> visited = new HashSet<>();
		nextToVisit.add(source);
		while(!nextToVisit.isEmpty()) {
			Node node = nextToVisit.remove();
			if(node == destination) {
				return true;
			}
			if(visited.contains(node.id)) {
				continue;
			}
			visited.add(node.id);
			for(Node child : node.adacent) {
				nextToVisit.add(child);
			}
		}
		return false;
	}
}
