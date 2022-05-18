
import java.util.Iterator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		String aString = sc.nextLine();     // input the current state 
		String fgoal = sc.nextLine(); // input the goal state

		// doFB(aString,fgoal); 
		// doGreedy(aString,fgoal);
		// doAstar(aString,fgoal); 
		// doIDS(aString, fgoal);
		doIDAstar(aString, fgoal);                   



	}


	private static void doIDAstar(String aString, String fgoal) {
		IDAstar sss = new IDAstar();

		Iterator<IDAstar.Node> it = sss.solve(new SSP(aString), new SSP(fgoal));

		if (it == null)
			System.out.println("Uniform cost(IDAstar), no solution found");
		else {
			while (it.hasNext()) {
				IDAstar.Node node = it.next();
				if (!it.hasNext())
				  System.out.println(node.getG());

			}
		}

	}
	public static void doFB(String aString, String fgoal){

		BestFirst sss = new BestFirst();

		Iterator<BestFirst.Node> it = sss.solve(new SSP(aString), new SSP(fgoal));

		if (it == null)
			System.out.println("Uniform cost(Bestfirst), no solution found");
		else {
			while (it.hasNext()) {
				BestFirst.Node node = it.next();
				if (!it.hasNext())
				System.out.println(node.getG());

			}
		}
	}
	public static void doGreedy(String aString, String fgoal){

		Greedy sss = new Greedy();

		Iterator<Greedy.Node> it = sss.solve(new SSP(aString), new SSP(fgoal));

		if (it == null)
			System.out.println("Greedy, no solution found");
		else {
			while (it.hasNext()) {
				Greedy.Node node = it.next();
				if (!it.hasNext())
				 System.out.println(node.getG());

			}
		}
	}
	public static void doAstar(String aString, String fgoal){

		Astar sss = new Astar();

		Iterator<Astar.Node> it = sss.solve(new SSP(aString), new SSP(fgoal));

		if (it == null)
			System.out.println("Astar, no solution found");
		else {
			while (it.hasNext()) {
				Astar.Node node = it.next();
				
				if (!it.hasNext()){
				  System.out.println(node.getG());
				}
			}
		}	
	}
	public static void doIDS(String aString, String fgoal){

		IDS sss = new IDS();
		int limit=0;
		Iterator<IDS.Node> it = null;
		do{
			limit++;
			it = sss.solve(new SSP(aString), new SSP(fgoal), limit);

		}while (it == null && limit<100);


		if (it == null)
			System.out.println("IDS, no solution found");
		else {
			while (it.hasNext()) {
				IDS.Node node = it.next();
				if (!it.hasNext())
				 System.out.println(node.getG());

			}
		}	
	}
	public static void doIDAs(String aString, String fgoal){

		IDAs sss = new IDAs();

		Iterator<IDAs.Node> it = sss.solve(new SSP(aString), new SSP(fgoal));

		if (it == null)
			System.out.println("Astar, no solution found");
		else {
			while (it.hasNext()) {
				IDAs.Node node = it.next();
				if (!it.hasNext())
				  System.out.println(node.getG());

			}
		}	
	}
}