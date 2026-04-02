package sae;

import sae.dungeon.*;
import sae.graph.Graph;
import sae.graph.Node;
import sae.transform.Dungeon2Graph;

public class test_maxime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
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
		//OK//
		
		Dungeon dungeon = new DungeonBuilder().createFirstDungeon();
		Dungeon2Graph mapping = new Dungeon2Graph(dungeon);

		System.out.println("Rooms : " + dungeon.getRooms().size());
		System.out.println("Nodes : " + mapping.getGraph().getNodes().size());
		//OK//
		
		Dungeon dungeon = new DungeonBuilder().createFirstDungeon();
		Dungeon2Graph mapping = new Dungeon2Graph(dungeon);

		System.out.println(mapping.mappedNode(dungeon.getRoomA()));
		System.out.println(mapping.mappedNode(dungeon.getRoomB()));
		//OK//
		
		Dungeon dungeon = new DungeonBuilder().createFirstDungeon();
		Dungeon2Graph mapping = new Dungeon2Graph(dungeon);

		for (Room room : dungeon.getRooms()) {
		    Node node = mapping.mappedNode(room);
		    int nbRooms = room.getNextRooms().size();
		    int nbNodes = node.neighbors().size();

		    System.out.println(room.getName() + " -> rooms voisins: " + nbRooms + ", nodes voisins: " + nbNodes);
		    }
		//OK//
		*/
		Dungeon dungeon = new DungeonBuilder().createFifthDungeon();
		Dungeon2Graph mapping = new Dungeon2Graph(dungeon);

		System.out.println("Rooms : " + dungeon.getRooms().size());
		System.out.println("Nodes : " + mapping.getGraph().getNodes().size());
		System.out.println("Start : " + mapping.mappedNode(dungeon.getRoomA()));
		System.out.println("End : " + mapping.mappedNode(dungeon.getRoomB()));
		}
	}

