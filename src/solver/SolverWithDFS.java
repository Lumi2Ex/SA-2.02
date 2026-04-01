package solver;

import graph.Node;
import java.util.*;

public class SolverWithDFS extends SolverGeneric {

    private Set<Node> visited;
    private Map<Node, Node> predecessors;
    private boolean found;

    public SolverWithDFS(Node startingNode, Node endingNode) {
        super(startingNode, endingNode);
    }

    @Override
    protected void resolve() {
        visited = new HashSet<>();
        predecessors = new HashMap<>();
        found = false;
        
        // Start DFS from the starting node
        dfsRecursive(getStartingNode());
        
        // If path found, reconstruct it
        if (found) {
            reconstructPath();
        }
    }

    private void dfsRecursive(Node current) {
        if (found) return; // Stop if we already found the target
        
        visited.add(current);
        
        // Check if we reached the destination
        if (current.equals(getEndingNode())) {
            found = true;
            return;
        }
        
        // Explore neighbors
        for (Node neighbor : current.neighbors()) {
            if (!visited.contains(neighbor) && !found) {
                predecessors.put(neighbor, current); // Track the path
                incSteps(); // Count this step
                dfsRecursive(neighbor);
            }
        }
    }

    private void reconstructPath() {
        List<Node> path = new ArrayList<>();
        Node current = getEndingNode();
        
        // Backtrack from end to start using predecessors
        while (current != null) {
            path.add(current);
            current = predecessors.get(current);
        }
        
        // Reverse to get path from start to end
        Collections.reverse(path);
        
        // Add to graph solution
        for (Node node : path) {
            getGraphSoluce().add(node);
        }
    }
}