package sae.graph;
//by maxime
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import sae.dungeon.*;

public class Node {
	
	//attribut 
	private String name;
	private Set<Node> neighbors;
	private Coord coord;
	
	//constructeur (pensé au HashSet)
	public Node(String name, Coord coord) {
        this.name = name;
        this.coord = coord;
        this.neighbors = new HashSet<>(); //WARNING Hashset
    }
	
	
	///// GESTION DES VOISIN /////
	public Set<Node> neighbors(){
		return neighbors;
	}
	
	public void addNeighbors(Node noeud) {
		neighbors.add(noeud);
	}
	///// FIN GESTION VOISIN /////

	
	///// AUTO-GENERATION /////
	@Override
	public String toString() {
		return "Node [name=" + name 
				+ ", nbNeighbors=" + neighbors.size()
				+ ", coord=" + coord 
				+ "]"; 
	}

	public String getName() {
		return name;
	}

	public Coord getCoord() {
		return coord;
	}
	///// FIN AUTO-GEN /////
	
	
	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if(!(object instanceof Node )) {
			return false;
		}// vérifie que l'objet est un Node
		Node node = (Node) object;//cast d'acces
		return Objects.equals(name, node.name)
				&& Objects.equals(coord, node.coord);//vérifie que les infos des noeuds sont égal
	}

	
	//Fonction volé sur le site "Stack Overflow"
	@Override
	public int hashCode() {
    	return Objects.hash(name, coord);
	}
	
	
}
