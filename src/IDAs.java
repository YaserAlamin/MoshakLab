import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;





public class IDAs {

	public class Node {
		private IState state;
		private Node father;
		private int g; // cost from the current to the initial node
		private int h;
		
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
		
		public int getF(){
			return g+h;
		}
		
		public void set_h(Node ns){
			
			for (int ind=0;ind<objective.toString().length();ind++){
				if ( objective.toString().charAt(ind) != ns.toString().charAt(ind) ){
					h=h+1;
				}

			}

		}


	}

	private Queue<Node> abertos;
	private List<Node> fechados;
	private Node actual;
	private IState objective;

	public static int limit;
	
	final private List<Node> sucessores(Node n) {
		
		List<Node> sucs = new ArrayList<Node>();
		
		List<IState> the_children = n.state.children();
		
		// System.out.println("No of C="+the_children.size());
		
		for (IState e : the_children) {
			if (n.father == null || !e.equals(n.father.state)) {
				// System.out.println("there is C="+n.father);
				Node nn = new Node(e, n);
				sucs.add(nn);
			}
			// System.out.println("there is No C="+n.father);
		}
		
		return sucs;
	}
	final public  Iterator<Node> solve(IState s, IState goal) {
		objective=goal;

		Node limitNode = new Node(s,null);
		limitNode.set_h(limitNode);
		int lm = limitNode.getF();
		limit = lm;

		IDAs ssss = new IDAs();
		Iterator<IDAs.Node> its = null;
		while (its==null ){
			System.out.println(limit+"<--limit"); //  *****************limit+"<--limit"
			its = ssss.solve(s, goal,true);

		}

		

		return its;

	}
	
	final public Iterator<Node> solve(IState s, IState goal, boolean b) {
		
		objective = goal;
		List<Node> fechados = new ArrayList<Node>();
		// Queue<Node> abertos = new PriorityQueue<Node>(10, new NodeComparator());
		Queue<Node> abertos = new PriorityQueue<Node>(30, new NodeComparatorIDAs());
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
			} else if (actual.getF() <= limit){  // use f as limit 
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
				
				 int newlimit = smallest_f(abertos);
			}
		}
	}
	
	 public int smallest_f(Queue<Node> abertos2) {
		int sf=1000;
		for (int index=0;index<abertos2.size();index++){
			// System.out.println("sf sf sf "+abertos2.get(index).getF());
			//if (sf>abertos2.poll(index).getF())
			//	sf=abertos2.get(index).getF();
		}
		//System.out.println("sf= "+sf);
		return 1000;

	} 
}

class NodeComparatorIDAs implements Comparator<IDAs.Node> {

	public int compare(IDAs.Node s1, IDAs.Node s2) {
		// System.out.println("gost 1 and 2 = "+s1.getG()+" "+s2.getG());
		if (s1.getF() > s2.getF())
			return 1;
		else if (s1.getF() == s2.getF())
			return 0;
		else
			return -1;
	}
}
