package sae.solver;

import java.util.*;

import sae.graph.Node;

public class SolverWithDFS extends SolverGeneric {

    private Set<Node> visited;
    private Map<Node, Node> predecessors;
    private boolean found;

    public SolverWithDFS(Node start, Node end) {
        super(start, end, "DFS");
    }

    @Override
    protected void resolve() {
        visited = new HashSet<>();
        predecessors = new HashMap<>();
        found = false;
        
        DFS(getStartingNode());
        
        if (found) {
            reconstructPath();
        }
    }

    private void DFS(Node current) {
        if (found) return;
        
        visited.add(current);
        
        if (current.equals(getEndingNode())) {
            found = true;
            return;
        }
        
        for (Node neighbor : current.neighbors()) {
            if (!visited.contains(neighbor) && !found) {
                predecessors.put(neighbor, current);
                incSteps();
                DFS(neighbor);
            }
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