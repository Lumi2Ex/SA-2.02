import java.util.HashMap;
import java.util.Map;

import sae.dungeon.Dungeon;
import sae.dungeon.Room;

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
        // pour chaque Room :
    	for ( Room room : dungeon.getRooms()) {	// Pour chaque room présente dans la "list" Room
    		Node node = createNode(room);		//on appel un constructeur qui luis meme extraiera les donné de la Room pour les placé dans le constructeur de la class graph.Node
    		graph.addNode(node);				//on ajoute le noeud créer au graph
    		roomToNode.put(room, node);			// peut tu réexpliqué cela je n'est pas comprisx
    	}
        // 1. créer un Node
        // 2. l'ajouter au graph
        // 3. mémoriser Room -> Node
    }
    
    private Node createNode(Room room) {
        sae.dungeon.Coord roomCoord = room.getCoords();
        graph.Coord nodeCoord = new graph.Coord(roomCoord.getX(), roomCoord.getY());
        return new Node(room.getName(), nodeCoord);
    }

    private void createEdges() {
        // pour chaque Room :
        // 1. retrouver son Node
        // 2. parcourir ses voisins avec getNextRooms()
        // 3. relier les Node correspondants
    }

    public Node mappedNode(Room room) {
        return roomToNode.get(room);
    }

    public Graph getGraph() {
        return graph;
    }
}
