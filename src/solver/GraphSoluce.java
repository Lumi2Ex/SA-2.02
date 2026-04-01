package solver;

import java.util.List;

import graph.Node;

public class GraphSoluce {
	
	private List<Node> soluce; 
	
	public GraphSoluce() {
	
	}
	
	public void add(Node node) {
		soluce.add(node);
	}
	
	public List<Node> getSoluce() {
		return soluce;
	}
}
