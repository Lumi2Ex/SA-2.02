package sae.graph;
//by maxime
import java.util.ArrayList;
import java.util.List;

public class GraphSoluce {
	
	private List<Node> soluce; 
	

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
