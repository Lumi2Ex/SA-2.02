package sae.solver;

import sae.dungeon.Coord;
import sae.graph.Graph;
import sae.graph.Node;
import sae.solver.SolverWithAstar;
import sae.solver.SolverWithBFS;
import sae.solver.SolverWithDFS;

import java.util.List;

public class SolverTest {

    public static void main(String[] args) {

        Graph graph = new Graph();

        Node[][] nodes = new Node[3][3];

        // Créer Noeuds
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                nodes[x][y] = new Node("Test", new Coord(x, y));
                graph.addNode(nodes[x][y]);
            }
        }

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {

                if (x > 0) graph.addEdge(nodes[x][y], nodes[x - 1][y]);
                if (x < 2) graph.addEdge(nodes[x][y], nodes[x + 1][y]);
                if (y > 0) graph.addEdge(nodes[x][y], nodes[x][y - 1]);
                if (y < 2) graph.addEdge(nodes[x][y], nodes[x][y + 1]);
            }
        }

        Node start = nodes[0][0];
        Node end = nodes[2][2];

        System.out.println("=== DFS ===");
        testDFS(start, end);

        System.out.println("\n=== BFS ===");
        testBFS(start, end);

        System.out.println("\n=== A* ===");
        testAStar(start, end);
    }

    private static void testDFS(Node start, Node end) {
        SolverWithDFS solver = new SolverWithDFS(start, end);
        solver.resolve();
        System.out.println(solver.getGraphSoluce());
    }

    private static void testBFS(Node start, Node end) {
        SolverWithBFS solver = new SolverWithBFS(start, end);
        solver.resolve();
        System.out.println(solver.getGraphSoluce());
    }

    private static void testAStar(Node start, Node end) {
        SolverWithAstar solver = new SolverWithAstar(start, end);
        solver.resolve();
        System.out.println(solver.getGraphSoluce());
    }

    private static void printPath(List<Node> path) {
        if (path == null || path.isEmpty()) {
            System.out.println("Pas de chemin");
            return;
        }

        for (Node node : path) {
            Coord c = node.getCoord();
            System.out.print("(" + c.getX() + "," + c.getY() + ") ");
        }
        System.out.println();
    }
}