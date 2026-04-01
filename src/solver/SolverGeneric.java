package solver;

import graph.Node;

public abstract class SolverGeneric implements Solver{

    private Node startingNode;
    private Node endingNode;
    private int steps;
    
    private GraphSoluce GraphSoluce;
    
    public SolverGeneric(Node Node) {
    	this.startingNode = startingNode;
        this.endingNode = endingNode;
        this.steps = 0;
        this.GraphSoluce = new GraphSoluce();
    }
    
   @Override 
    public GraphSoluce getGraphSoluce() {
    	return this.GraphSoluce;
    }
    
   @Override
    public int getSteps() {
        return this.steps;
    }
    
    public void incSteps() {
    	this.steps++;
    }
    
    public Node getStartingNode() {
        return this.startingNode;
    }

    public Node getEndingNode() {
        return this.endingNode;
    }
    
    @Override
    public void solve() {
        initializeResolution();
        solve();
    }

    protected abstract void resolve();
    
    private void initializeResolution() {
        this.steps = 0;
        this.GraphSoluce = new GraphSoluce();
        // Additional initialization logic here
    }
}