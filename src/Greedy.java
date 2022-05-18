import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;



class Greedy {
	public class Node {
		private int h; // step from goal
		private IState state;
		private Node father;
		private int g; // cost from the current to the initial node

		public Node(IState l, Node n) {
			state = l;
			father = n;
			g = l.getCost();
			if (father != null)
				g += father.g;
			
		}
		
		// to set the h (the step from the goal) for current node 
		public void set_h(Node ns){
			for (int ind=0;ind<objective.toString().length();ind++){
				if ( objective.toString().charAt(ind) != ns.toString().charAt(ind) ){
					h=h+1;
				}
									
			}
						 
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

	private Queue<Node> abertos;
	private List<Node> fechados;
	private Node actual;
	private IState objective;

	final private List<Node> sucessores(Node n) {
		
		List<Node> sucsP = new ArrayList<Node>();
		List<Node> sucs = new ArrayList<Node>();
		
		List<IState> the_children = n.state.children();
		
		// System.out.println("No of C="+the_children.size());
		int hh=0,s_h=0;
		
		for (IState e : the_children) {
			               
			if (n.father == null || !e.equals(n.father.state)) {
				// System.out.println("there is C="+n.father);
				Node nn = new Node(e, n);
				nn.set_h(nn); //          this will set h for each child 
				sucsP.add(nn);  // all the children
				
			}
			
			
			// System.out.println("there is No C="+n.father);
		}
		s_h=smallest_h(sucsP); // find smallest h
		// System.out.println("smallest h "+s_h+"\t sucsP size "+sucsP.size());
		// make a list with only smallest h		
		for(int index=0; index<sucsP.size();index++){
			if(sucsP.get(index).h==s_h){
				Node nnn=sucsP.get(index);
				// System.out.println("\t\t\t\t "+nnn.getState());
				sucs.add(nnn);   
			}
				
		}
		
		return sucs;
	}

	
// find the smallest h from children list
	private int smallest_h(List<Node> sucsP) {

		int sh=1000;
		for (int index=0;index<sucsP.size();index++){
			// System.out.println(" hhh "+sucsP.get(index).h);
			if (sh>sucsP.get(index).h )
				sh=sucsP.get(index).h;
		}
		return sh;
	}



	final public Iterator<Node> solve(IState s, IState goal) {
		
		objective = goal;
		List<Node> fechados = new ArrayList<Node>();
		// Queue<Node> abertos = new PriorityQueue<Node>(10, new NodeComparator());
		Queue<Node> abertos = new PriorityQueue<Node>(30, new NodeComparatorG());
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

class NodeComparatorG implements Comparator<Greedy.Node> {

	public int compare(Greedy.Node s1, Greedy.Node s2) {
		if (s1.getG() > s2.getG())
			return 1;
		else if (s1.getG() == s2.getG())
			return 0;
		else
			return -1;
	}
}