package solver;

import graph.Node;

public abstract class SolverGeneric implements Solver{

    private Node startingNode;
    private Node endingNode;
    private int steps;

    public SolverGeneric(Node start, Node end) {
        this.startingNode = start;
        this.endingNode = end;
    }
    
    public GraphSoluce getGraphSoluce() {
    	return (GraphSoluce)null;
    }
    
    public int getSteps() {
        return steps;
    }
    
    public void incSteps() {
    	steps++;
    }
    
    public Node getStartingNode() {
        return startingNode;
    }

    public Node getEndingNode() {
        return endingNode;
    }

    public void solve() {
        initializeResolution();
        solve();
    }

    protected void resolve() {
    	return;
    }
    
    private void initializeResolution() {
        this.steps = 0;
    }
}