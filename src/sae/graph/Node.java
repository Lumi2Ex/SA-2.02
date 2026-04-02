package sae.graph;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import sae.dungeon.*;

public class Node {
	
	private String name;
	private Set<Node> neighbors;
	private Coord coord;
	
	public Node(String name, Coord coord) {
        this.name = name;
        this.coord = coord;
        this.neighbors = new HashSet<>(); //WARNING Hashset
    }
	
	public Set<Node> neighbors(){
		return neighbors;
	}
	
	public void addNeighbors(Node noeud) {
		neighbors.add(noeud);
	}

	@Override
	public String toString() {
		return "Node [name=" + name 
				+ ", nbNeighbors=" + neighbors.size()
				+ ", coord=" + coord 
				+ "]"; 
		//auto génération
	}

	public String getName() {
		return name;
	}

	public Coord getCoord() {
		return coord;
	}
	
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

	
	//stack overflow recommande mais jsp a quoi sa sert donc ...
	@Override
	public int hashCode() {
    	return Objects.hash(name);
	}
	
	
}
