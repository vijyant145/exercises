package test;

import java.util.ArrayList;
import java.util.List;

public class Node {
	
	public List<Integer> keys;
	public List<Node> children;
	
	
	public Node() {
		this.keys = new ArrayList<>();
		this.children = new ArrayList<>();
	}

}
