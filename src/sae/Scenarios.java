package sae;
//by prof
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import sae.dungeon.Dungeon;
import sae.dungeon.DungeonBuilder;
import sae.dungeon.DungeonSoluce;
import sae.graph.GraphSoluce;
import sae.graph.Node;
import sae.solver.Solver;
import sae.solver.SolverWithAstar;
import sae.solver.SolverWithBFS;
import sae.solver.SolverWithDFS;
import sae.transform.Dungeon2Graph;

public class Scenarios {

	private static final int NB_ATTEMPTS = 10000;
	private static int cptDungeon = 1;
	
	private static final Logger logger = Logger.getLogger("mon logger");

	public static void main(String[] args) {
		
		initLogger();

		DungeonBuilder builder = new DungeonBuilder();

		solveDungeon(builder.createThirdDungeon());
		
		solveDungeon(builder.createFirstDungeon());
		solveDungeon(builder.createSecondDungeon());
		
		solveDungeon(builder.createFourthDungeon());
		solveDungeon(builder.createFifthDungeon());
		solveDungeon(builder.createSixthDungeon());
		
	}

	private static void initLogger() {
		
        Logger rootLogger = Logger.getLogger("");
        rootLogger.setLevel(Level.OFF);
        for (Handler handler : rootLogger.getHandlers()) {
            rootLogger.removeHandler(handler);
        }

        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        handler.setFormatter(new SimpleFormatter() {
            @Override
            public synchronized String format(LogRecord lr) {
                return String.format("%s%n", lr.getMessage());
            }
        });

        logger.addHandler(handler);
        logger.setLevel(Level.INFO); 
	}

	private static void solveDungeon(Dungeon dungeon) {

		logger.info("***************************");
		logger.info(() -> "   Résolution du donjon " + cptDungeon++);
		logger.info("---------------------------");

		Dungeon2Graph mapping = new Dungeon2Graph(dungeon);
		
		//Ligne de debugage// lors des premier test les resultat était aberrant j'ai donc voulu vérifié les resultat produit par GenerateDungeonfrom malgré la probabilité casi null que le fichier fourni est été modifié par l'un d'entre nous par erreur.
//		System.out.println("1.\n");
//		System.out.println("A room = " + dungeon.getRoomA());
//		System.out.println("B room = " + dungeon.getRoomB());
//
//		for (sae.dungeon.Room room : dungeon.getRooms()) {
//		    System.out.println(room.getName() + " " + room.getCoords() + " -> " + room.getNextRooms());
//		}
		//Ligne de debugage//
		

		Node nodeA = mapping.mappedNode(dungeon.getRoomA());
		Node nodeB = mapping.mappedNode(dungeon.getRoomB());
		
		//Ligne de debugage// comparaison de logique avec le debugage des room, mais la structure semble identique le probleme n'est pas la (j'aurai du m'en douté c'est mon code il est forcement parfait)
//		System.out.println("2.\n");
//		System.out.println("Node A = " + nodeA);
//		System.out.println("Node B = " + nodeB);
//
//		for (sae.graph.Node node : mapping.getGraph().getNodes()) {
//		    System.out.println(node + " -> voisins = " + node.neighbors());
//		}
		//ligne de debugage//
		
		solveWithSolver(mapping, new SolverWithDFS(nodeA, nodeB));
		solveWithSolver(mapping, new SolverWithBFS(nodeA, nodeB));
		solveWithSolver(mapping, new SolverWithAstar(nodeA, nodeB));
		
		
	}

	private static void solveWithSolver(Dungeon2Graph mapping, Solver solver) {
		logger.info(() -> "Résolution avec " + solver);

		long startingTime = System.currentTimeMillis();
		
		for (int i = 0; i < NB_ATTEMPTS; i++) {
			solver.solve();
		}
		long endingTime = System.currentTimeMillis();
		long duration = endingTime - startingTime;
		
		GraphSoluce soluceGraphBFS = solver.getGraphSoluce();
		
		//Ligne de debugage// print du chemin pour verifier qu'il ne ce teleporte pas, mais nan c logique 
//		System.out.println("3.\n");
//		System.out.println("Chemin graphe :");
//		for (Node n : soluceGraphBFS.getSoluce()) {
//		    System.out.println(n);
//		}
//		System.out.println("Nb noeuds chemin = " + soluceGraphBFS.getSoluce().size());
		//Ligne de debugage//
		
		DungeonSoluce soluceDonjonBFS = mapping.transform(soluceGraphBFS);

		logger.info("Solution   => " + soluceDonjonBFS.getSoluce());
		logger.info(() ->  "Temps (ms) => " + duration);
		logger.info(() -> "Steps      => " + solver.getSteps());
		logger.info(() -> "---------------------------");
	}
}