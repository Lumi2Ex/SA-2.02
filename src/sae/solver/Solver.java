package sae.solver;

import sae.graph.GraphSoluce;

public interface Solver {
	public void solve();
	public GraphSoluce getGraphSoluce();
	public int getSteps();
}
