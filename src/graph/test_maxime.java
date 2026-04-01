package graph;

public class test_maxime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Coord c1 = new Coord(0, 0);
		Node n1 = new Node("n1", c1);
		
		Coord c2 = new Coord(1, 0);
		Node n2 = new Node("n1", c2);
		
		Coord c3 = new Coord(1, 1);
		Node n3 = new Node("n1", c3);
		
//		1-2
//		  |
//		  3
		
		n1.addNeighbors(n2);
		n2.addNeighbors(n3);
		
		System.out.println(n1.toString());
		
		Graph G1 = new Graph();
		
		G1.addNode(n1);
		G1.addNode(n2);
		G1.addNode(n3);
		G1.addEdge(n1, n2);
		G1.addEdge(n2, n3);
	}
	
}
