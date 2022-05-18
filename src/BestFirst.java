import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;



class BestFirst {
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
		
		
		public void show(){
			System.out.println();
			System.out.println(state.toString().charAt(0)+" "+state.toString().charAt(1)+" "+state.toString().charAt(2));
			System.out.println(state.toString().charAt(3)+" "+state.toString().charAt(4)+" "+state.toString().charAt(5));
			System.out.println(state.toString().charAt(6)+" "+state.toString().charAt(7)+" "+state.toString().charAt(8)+" "+state.toString().charAt(9)+" "+state.toString().charAt(10));
			System.out.println("    "+state.toString().charAt(11)+" "+state.toString().charAt(12)+" "+state.toString().charAt(13));
			System.out.println("    "+state.toString().charAt(14)+" "+state.toString().charAt(15)+" "+state.toString().charAt(16));
			System.out.println();
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
				G++;                                       //    count the no. of nodes
				Node nn = new Node(e, n);
				//nn.show();
				sucs.add(nn);
			}
			// System.out.println("there is No C="+n.father);
		}

		return sucs;
	}

	final public Iterator<Node> solve(IState s, IState goal) {

		objective = goal;
		List<Node> fechados = new ArrayList<Node>();
		// Queue<Node> abertos = new PriorityQueue<Node>(10, new NodeComparator());
		Queue<Node> abertos = new PriorityQueue<Node>(30, new NodeComparator());
		abertos.add(new Node(s, null));
		// System.out.println("STATE="+s);
		// System.out.println("STATEabertos="+abertos.size());
		List<Node> sucs;
		for (;;) {
			if (abertos.isEmpty()) {
				// System.out.println("null");
				return null;
			}
			actual = abertos.poll();
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
			} else {
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
						abertos.add(e);
				}
			}
		}
	}
}

class NodeComparator implements Comparator<BestFirst.Node> {

	public int compare(BestFirst.Node s1, BestFirst.Node s2) {
		// System.out.println("gost 1 and 2 = "+s1.getG()+" "+s2.getG());
		if (s1.getG() > s2.getG())
			return 1;
		else if (s1.getG() == s2.getG())
			return 0;
		else
			return -1;
	}
}
