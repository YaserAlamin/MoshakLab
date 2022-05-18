import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Stack;






class IDAstar {
	public class Node {
		private IState state;
		private Node father;
		private int g; // cost from the current to the initial node
		// private int f;
		private int h;


		public Node(IState l, Node n) {
			state = l;
			father = n;
			g = l.getCost();
			if (father != null)
				g = g + father.g;

		}

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
		public int getF(){
			return g+h;
		}
	}
	public static int G; // numbers of nodes generated !!!!!!
	// private Queue<Node> abertos;
	// private List<Node> fechados;
	private Node actual;
	private IState objective;

	public static int limit;

	final private List<Node> sucessores(Node n) {

		List<Node> sucs = new ArrayList<Node>();

		List<IState> the_children = n.state.children();


		for (IState e : the_children) {
			if (n.father == null || !e.equals(n.father.state)) {
				Node nn = new Node(e, n);
				nn.set_h(nn);
				G++;
				sucs.add(nn);
			}
		}

		return sucs;
	}
	final public  Iterator<Node> solve(IState s, IState goal) {
		objective=goal;

		Node limitNode = new Node(s,null);
		limitNode.set_h(limitNode);
		int lm = limitNode.getF();
		limit = lm;
//		limit=51;
		IDAstar ssss = new IDAstar();
		Iterator<IDAstar.Node> its = null;
		while (its==null ){
			its = ssss.solve(s, goal,true);

		}



		return its;

	}
	final public Iterator<Node> solve(IState s, IState goal, boolean b) {

		objective=goal; 

		List<Node> fechados = new ArrayList<Node>();
		List<Node> forf = new ArrayList<Node>();
		Stack<Node> abertos = new Stack<Node>();
		
		
		abertos.push(new Node(s, null));
		/*
		Node s_ =new Node(s, null);
		s_.set_h(s_);
		abertos.push(s_);
		*/
		
		// System.out.println("STATE="+s);
		List<Node> sucs;
		int newlimit;

		for (;;) {
			// System.out.println(limit+" limit;;LOOP");
			
			if (abertos.empty()) {
				newlimit=smallest_f(forf);
				//limit=1000;
				//System.out.println("nullllllllllllllllllllll  newlimit " +newlimit);
				
				limit=newlimit;
				
				return null;
			}



			
			
			
				actual = abertos.pop();
				
				// System.out.println(" abertos size "+abertos.size());
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
				} else if (actual.getF() <= limit){
					// System.out.println("else if "+limit); 
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

						//if(abertos.size()!=0)


					}



				}else {
					
					forf.add(actual);
					
				}




			

		}




	}


	public int smallest_f(List<Node> findf) {
		int sf=10000;

		for (int index=0;index<findf.size();index++){

			// System.out.print(" "+abertos2.get(index).getF());
			if (sf>findf.get(index).getF()){
				sf=findf.get(index).getF();

			}

		}
		//System.out.println("sf= "+sf);
		return sf;

	}

}

