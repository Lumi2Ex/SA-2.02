package sae.solver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import sae.dungeon.Coord;
import sae.graph.Graph;
import sae.graph.Node;

public class SolverWithAstar extends SolverGeneric{
	
	private Set<Node> visited;
    private Map<Node, Node> predecessors;
    private boolean found;

	public SolverWithAstar(Node start, Node end) {
		super(start, end);
	}
	
	public int heuristic(Node start, Node end) {
		Coord a = start.getCoord();
	    Coord b = end.getCoord();

	    return Math.abs(a.getX() - b.getX()) +
	           Math.abs(a.getY() - b.getY());
	}
	
	public void AStar(Node start, Node end) {

	    Set<Node> closedSet = new HashSet<>();

	    Map<Node, Integer> gScore = new HashMap<>();
	    Map<Node, Integer> fScore = new HashMap<>();

	    PriorityQueue<Node> openList = new PriorityQueue<>(
	        (n1, n2) -> Integer.compare(
	            fScore.getOrDefault(n1, Integer.MAX_VALUE),
	            fScore.getOrDefault(n2, Integer.MAX_VALUE)
	        )
	    );

	    gScore.put(start, 0);
	    fScore.put(start, heuristic(start, end));

	    openList.add(start);

	    while (!openList.isEmpty()) {

	        Node current = openList.poll();

	        if (current.equals(end)) {
	            found = true;
	            return;
	        }

	        closedSet.add(current);

	        for (Node neighbor : current.neighbors()) {
	        	incSteps();
	            if (closedSet.contains(neighbor)) {
	                continue;
	            }

	            int tentativeG = gScore.get(current) + 1;

	            if (tentativeG < gScore.getOrDefault(neighbor, Integer.MAX_VALUE)) {

	                predecessors.put(neighbor, current);
	                gScore.put(neighbor, tentativeG);
	                fScore.put(neighbor, tentativeG + heuristic(neighbor, end));

	                if (!openList.contains(neighbor)) {
	                    openList.add(neighbor);
	                }
	            }
	        }
	    }
	}
	@Override
	protected void resolve() {
		visited = new HashSet<>();
        predecessors = new HashMap<>();
        found = false;
        
        AStar(getStartingNode(), getEndingNode());
        
        if (found) {
            reconstructPath();
        }		
	}
	private void reconstructPath() {
        List<Node> path = new ArrayList<>();
        Node current = getEndingNode();
        
        while (current != null) {
            path.add(current);
            current = predecessors.get(current);
        }
        
        Collections.reverse(path);
        
        for (Node node : path) {
            getGraphSoluce().add(node);
        }
    }
}
