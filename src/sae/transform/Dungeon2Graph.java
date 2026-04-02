package sae.transform;

import java.util.HashMap;
import java.util.Map;

import sae.graph.Graph;
import sae.graph.GraphSoluce;
import sae.graph.Node;
import sae.dungeon.*;

public class Dungeon2Graph {

    private Dungeon dungeon;
    private Graph graph;
    private Map<Room, Node> roomToNode; //bibliotheque de donjon vers graph
    private Map<Node, Room> nodeToRoom;	//bibliotheque de graph vers donjon

    
    
    public Dungeon2Graph(Dungeon dungeon) {
        this.dungeon = dungeon;
        this.graph = new Graph();
        this.roomToNode = new HashMap<>();
        this.nodeToRoom = new HashMap<>();

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
    		nodeToRoom.put(node, room);			// ajout de la mémorisation dans l'autre sens
    	}
    }
    
    private Node createNode(Room room) {
        Coord roomCoord = room.getCoords();
        Coord nodeCoord = new Coord(roomCoord.getX(), roomCoord.getY());
        return new Node(room.getName(), nodeCoord);
    }

    private void createEdges() {								// similaire a create node
    	for (Room room : dungeon.getRooms()) {					// pour chaque Room 
    		Node origin = roomToNode.get(room);					//retrouver son Node
    		for (Room voisin : room.getNextRooms().values()) {	//parcourir ses voisins avec getNextRooms
    			Node nodeVoisin = roomToNode.get(voisin);		//relier les Node correspondants
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
    
    public DungeonSoluce transform(GraphSoluce graphSoluce) {
        DungeonSoluce dungeonSoluce = new DungeonSoluce();
        List<Node> nodes = graphSoluce.getSoluce();

        for (int i = 0; i < nodes.size() - 1; i++) {
            Node currentNode = nodes.get(i);
            Node nextNode = nodes.get(i + 1);

            Room currentRoom = nodeToRoom.get(currentNode);
            Room nextRoom = nodeToRoom.get(nextNode);

            Direction direction = findDirection(currentRoom, nextRoom);

            if (direction != null) {
                dungeonSoluce.addDirection(direction);
            }
        }

        return dungeonSoluce;
    }
    
    private Direction findDirection(Room from, Room to) {
        for (Map.Entry<Direction, Room> entry : from.getNextRooms().entrySet()) {
            if (entry.getValue().equals(to)) {
                return entry.getKey();
            }
        }
        return null;
    }
    
    
}
