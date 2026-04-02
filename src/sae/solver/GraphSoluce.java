package sae.solver;
import java.util.ArrayList;
import java.util.List;

import sae.graph.Node;

public class GraphSoluce {
	
	private List<Node> soluce; 
	
	// FIXME : remplir constructeur
	public GraphSoluce() {
		this.soluce = new ArrayList<>();
	}
	
	public void add(Node node) {
		this.soluce.add(node);
	}
	
	public List<Node> getSoluce() {
		return this.soluce;
	}
}
