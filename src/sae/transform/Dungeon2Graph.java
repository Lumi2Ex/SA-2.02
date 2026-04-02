package sae.transform;

import java.util.HashMap;
import java.util.Map;

import sae.graph.Graph;
import sae.graph.Node;
import sae.dungeon.*;

public class Dungeon2Graph {

    private Dungeon dungeon;
    private Graph graph;
    private Map<Room, Node> roomToNode;

    public Dungeon2Graph(Dungeon dungeon) {
        this.dungeon = dungeon;
        this.graph = new Graph();
        this.roomToNode = new HashMap<>();

        buildGraph();
    }

    private void buildGraph() {
        createNodes();
        createEdges();
    }

    private void createNodes() {
    	for ( Room room : dungeon.getRooms()) {	// Pour chaque room présente dans la "list" Room
    		Node node = createNode(room);		//on appel un constructeur qui luis meme extraiera les donné de la Room pour les placé dans le constructeur de la class graph.Node
    		graph.addNode(node);				//on ajoute le noeud créer au graph
    		roomToNode.put(room, node);			// "mémorisation" de la correspondance room/node dans une map
    	}
    }
    
    private Node createNode(Room room) {
        Coord roomCoord = room.getCoords();
        Coord nodeCoord = new Coord(roomCoord.getX(), roomCoord.getY());
        return new Node(room.getName(), nodeCoord);
    }

    private void createEdges() {
    	for ( Room room : dungeon.getRooms()) {					// pour chaque Room 
    		Node origin = roomToNode.get(room);					//1. retrouver son Node
    		for (Room voisin : room.getNextRooms().values()) {	// 2. parcourir ses voisins avec getNextRooms
    			Node nodeVoisin = roomToNode.get(voisin);		// 3. relier les Node correspondants
    			graph.addEdge(origin, nodeVoisin); 				//ligne qui fabrique le chemin
    		}
    	}
    }

    public Node mappedNode(Room room) {
        return roomToNode.get(room);
    }

    public Graph getGraph() {
        return graph;
    }
}
