package sae.graph;
//by maxime
import java.util.HashSet;
import java.util.Set;

public class Graph {
	
	//il faut géré le fait que sur l'UML, un graph est composé de plusieur Node
	//private List<Node> nodes; 
	private Set<Node> nodes;//remplace List, aparament similaire en évitant les doublon automatiquement.
	
	//constructeur graph
	public Graph() {
		this.nodes = new HashSet<>();
	}
	
	//ajout d'un noeud a la liste de neud
	public void addNode(Node node) {
		nodes.add(node);
	}
	
	//ajout d'un chemin entre deux noeud (pensé au sécurité)
	public void addEdge(Node n1, Node n2) {
		if (!nodes.contains(n1)) {
	    addNode(n1);
		}
		if (!nodes.contains(n2)) {
		    addNode(n2);
		}
		n1.addNeighbors(n2);
		n2.addNeighbors(n1);
	}

	@Override//auto généré
	public String toString() {
		return "Graph []";
	}
	
	//FIXME fabrique un getnode ! //c'est bon !
	public Set<Node> getNodes() {
		return nodes;
	}
}
