package graph;

import java.util.HashSet;
import java.util.Set;

import sae.dungeon.Coord;

public class Node {
	
	private String name;
	private Set<Node> neighbors;
	private Coord coord;
	
	public Node(String name, Coord coord) {
        this.name = name;
        this.coord = coord;
        this.neighbors = new HashSet<>();
    }
	
	public Set<Node> neighbors(){
		return neighbors;
	}
	
	public void addNeighbourg(Node noeud) {
		
	}

	@Override
	public String toString() {
		return "Node [name=" + name + ", neighbors=" + neighbors + ", coord=" + coord + "]";
		//auto génération
	}

	public String getName() {
		return name;
	}

	public Coord getCoord() {
		return coord;
	}
	
	public boolean equals(Object objet) {
		return false;
		
	}
	
}
