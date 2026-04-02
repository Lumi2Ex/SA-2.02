package sae.solver;

import java.util.*;

import sae.graph.Node;
public class SolverWithBFS extends SolverGeneric {

    private Set<Node> visited;

    private Map<Node, Node> predecessors;

    private boolean found;

    public SolverWithBFS(Node start, Node end) {
        super(start, end);
    }

    public void BFS(Node start) {

        Queue<Node> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty() && !found) {

            Node current = queue.poll();

            for (Node neighbor : current.neighbors()) {
                incSteps();
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    predecessors.put(neighbor, current);
                    if (neighbor.equals(getEndingNode())) {
                        found = true;
                        return;
                    }
                    queue.add(neighbor);
                }
            }
        }
    }
    @Override
    protected void resolve() {
        visited = new HashSet<>();
        predecessors = new HashMap<>();
        found = false;

        BFS(getStartingNode());

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