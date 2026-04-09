package sae.solver;

import sae.graph.Graph;
import sae.graph.GraphSoluce;
import sae.graph.Node;

public abstract class SolverGeneric implements Solver{

    @Override
	public String toString() {
		return this.nom;
	}

	private Node startingNode;
    private Node endingNode;
    private int steps;
    
    private GraphSoluce GraphSoluce;
	private String nom;
    
    public SolverGeneric(Node start, Node end, String nom) {
    	this.startingNode = start;
        this.endingNode = end;
        this.steps = 0;
        this.GraphSoluce = new GraphSoluce();
        this.nom = nom;
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
        resolve();
    }

    protected abstract void resolve();
    
    private void initializeResolution() {
        this.steps = 0;
        this.GraphSoluce = new GraphSoluce();
    }
}