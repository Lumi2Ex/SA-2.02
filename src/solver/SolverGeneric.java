package solver;

public abstract class SolverGeneric {
	Node startingNode = new Node();
	Node endingNode = new Node();
	
	int steps;
	
	public SolverGeneric(Node start, Node end);
	
	public GraphSoluce getGraphSoluce();

	public Node getStartingNode() {
		return startingNode;
	}

	public Node getEndingNode() {
		return endingNode;
	}

	public int getSteps() {
		return steps;
	}
	
	public void solve();
	
	protected void resolve();
	
	private initializeResolution();
	
}
