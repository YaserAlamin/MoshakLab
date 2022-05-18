import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;



class IDS {
	public class Node {
		private IState state;
		private Node father;
		private int g; // cost from the current to the initial node

		public Node(IState l, Node n) {
			state = l;
			father = n;
			g = l.getCost();
			if (father != null)
				g = g + father.g;
			
		}

		public IState getState() {
			return state;
		}

		public String toString() {
			return "(" + state.toString() + ", " + g + ") ";
		}

		public int getG() {
			return g;
		}
	}
	public static int G; // numbers of nodes generated !!!!!!
	private Queue<Node> abertos;
	private List<Node> fechados;
	private Node actual;
	private IState objective;

	final private List<Node> sucessores(Node n) {
		
		List<Node> sucs = new ArrayList<Node>();
		
		List<IState> the_children = n.state.children();
		
		// System.out.println("No of C="+the_children.size());
		
		for (IState e : the_children) {
			if (n.father == null || !e.equals(n.father.state)) {
				// System.out.println("there is C="+n.father);
				Node nn = new Node(e, n);
				G++;
				sucs.add(nn);
			}
			// System.out.println("there is No C="+n.father);
		}
		
		return sucs;
	}

	final public Iterator<Node> solve(IState s, IState goal, int limit) {
		
		objective = goal;

			
			List<Node> fechados = new ArrayList<Node>();
			// Queue<Node> abertos = new PriorityQueue<Node>(10, new NodeComparator());
			Stack<Node> abertos = new Stack<Node>();
			abertos.push(new Node(s, null));
			// System.out.println("STATE="+s);
			// System.out.println("STATEabertos="+abertos.size());
			List<Node> sucs;
			for (;;) {
				if (abertos.empty()) {
					// System.out.println("null");
					return null;
				}
				actual = abertos.pop();
				if (goal.isGoal(actual.state)) {
					class IT implements Iterator<Node> {
					private Node last;
					private Stack<Node> stack;

					public IT() {
						last = actual;
						stack = new Stack<Node>();
						while (last != null) {
							stack.push(last);
							last = last.father;
						}
					}

					public boolean hasNext() {
						return !stack.empty();
					}

					public Node next() {
						return stack.pop();
					}

					public void remove() {
						throw new UnsupportedOperationException();
					}
				}
					return new IT();
				} else if (actual.getG() < limit){
					// System.out.println("else"); 
					sucs = sucessores(actual);
					fechados.add(actual);
					boolean contains;
					for (Node e : sucs) {
						contains = false;
						for (Node f : fechados)
							if (f.state.equals(e.state))
								contains = true;
						if (!contains)
							abertos.push(e);
					}
				}
			}
		}
		
}

