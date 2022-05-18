import java.util.ArrayList;
import java.util.List;

class SSP implements IState {
	private int cost; // cost from the receiver to its father
	private String s;

	public SSP(String str) {
		this(str, 0);        
	}

	public SSP(String str, int cost) {
		s = str;
		this.cost = cost;
	}

	public boolean equals(Object that) {
		if (that instanceof SSP) {
			SSP b = ((SSP) that);
			return s.equals(b.s);
		} else
			return false;
	}

	public boolean isGoal(IState that) {
		return this.equals(that);
	}

	public String toString() {
		return s;
	}

	/**
	 * @return a list with all configuration states which are reachable from the
	 *         receiver, when the rules of our problem are applied.
	 */


	/*********************************************************************
	// first try to understand 

{
case 0:
	// for posN  1 j2
	System.out.println("case 0 =  "+ posE);
	if (s.charAt(1)=='R'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 1);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	} else if (s.charAt(2)=='R'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 2);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}
	// for posN  3 j6
	if (s.charAt(3)=='R'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 3);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	} else if (s.charAt(6)=='R'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 6);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}
	break; 

case 1:
	// for posN 0 nj
	System.out.println("case 1 =  "+ posE);
	if (s.charAt(0)=='B'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 0);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}
	// for posN 2 nj
	if (s.charAt(2)=='R'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 2);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}
	// for posN 4 j7
	if (s.charAt(4)=='R'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 4);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}else if (s.charAt(7)=='R'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 7);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}
	break;

case 2:
	// for posN 1 j0
	System.out.println("case 2 =  "+ posE);
	if (s.charAt(1)=='B'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 1);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}else if (s.charAt(0)=='B'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 0);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}
	// for posN 5 j8
	if (s.charAt(5)=='R'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 4);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}else if (s.charAt(8)=='R'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 8);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}
	break;

case 3:
	// for posN 0 nj
	System.out.println("case 3 =  "+ posE);
	if (s.charAt(0)=='B'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 0);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}
	// for posN 6 nj
	if (s.charAt(6)=='R'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 6);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}
	// for posN 4 j5
	if (s.charAt(4)=='R'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 4);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}else if (s.charAt(5)=='R'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 5);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}
	break;

case 4:	
	// for posN 1 nj
	System.out.println("case 4 =  "+ posE);
	if (s.charAt(1)=='B'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 1);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}
	// for posN 3 nj
	if (s.charAt(3)=='B'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 3);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}
	// for posN 5 nj
	if (s.charAt(5)=='R'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 5);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}
	// for posN 7 nj
	if (s.charAt(7)=='R'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 7);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}
	break;

case 5:
	// for posN 2 nj
	System.out.println("case 5 =  "+ posE);
	if (s.charAt(2)=='B'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 2);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}
	// for posN 4 j3
	if (s.charAt(4)=='B'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 4);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}else if (s.charAt(3)=='B'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 3);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}
	// for posN 8 j11
	if (s.charAt(8)=='R'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 8);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}else if (s.charAt(11)=='R'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 11);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}
	break; 

case 6:
	// for posN 3 j0
	System.out.println("case 6 =  "+ posE);
	if (s.charAt(3)=='B'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 3);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}else if (s.charAt(0)=='B'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 0);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}
	// for posN 7 j8
	if (s.charAt(7)=='R'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 7);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}else if (s.charAt(8)=='R'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 8);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}
	break; 

case 7:
	// for posN 6 nj
	System.out.println("case 7 =  "+ posE);
	if (s.charAt(6)=='B'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 6);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}
	// for posN 4 j1
	if (s.charAt(4)=='B'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 4);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}else if (s.charAt(1)=='B'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 1);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}
	// for posN 8 j9
	if (s.charAt(8)=='R'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 8);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}else if (s.charAt(9)=='R'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 9);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}
break; 

case 8:
	// for posN 5 j2
	System.out.println("case 8 =  "+ posE);
	if (s.charAt(5)=='B'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 5);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}else if (s.charAt(2)=='B'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 2);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}
	// for posN 7 j6
	if (s.charAt(7)=='B'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 7);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}else if (s.charAt(6)=='B'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 6);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}
	// for posN 9 j10
	if (s.charAt(9)=='R'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 9);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}else if (s.charAt(10)=='R'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 10);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}
	// for posN 11 j14
	if (s.charAt(11)=='R'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 11);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}else if (s.charAt(14)=='R'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 14);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}
	break;

case 9:
	// for posN 10 nj
	System.out.println("case 9 =  "+ posE);
	if (s.charAt(10)=='R'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 10);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}
	// for posN 8 j7
	if (s.charAt(8)=='B'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 8);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}else if (s.charAt(7)=='B'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 7);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}
	// for posN 12 j15
	if (s.charAt(12)=='R'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 12);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}else if (s.charAt(15)=='R'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 15);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}
	break; 

case 10:
	// for posN 9 j8
	System.out.println("case 10 =  "+ posE);
	if (s.charAt(9)=='B'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 9);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}else if (s.charAt(8)=='B'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 8);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}
	// for posN 13 j16
	if (s.charAt(13)=='R'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 13);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}else if (s.charAt(16)=='R'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 16);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}
	break;

case 11:
	// for posN 8 j5
	System.out.println("case 11 =  "+ posE);
	if (s.charAt(8)=='B'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 8);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}else if (s.charAt(5)=='B'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 5);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}
	// for posN 12 j13
	if (s.charAt(12)=='R'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 12);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}else if (s.charAt(13)=='R'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 13);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}
	// for posN 14 nj
	if (s.charAt(14)=='R'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 14);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}
	break;

case 12:	
	// for posN 9 nj
	System.out.println("case 12 =  "+ posE);
	if (s.charAt(9)=='B'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 9);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}
	// for posN 11 nj
	if (s.charAt(1)=='B'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 11);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}
	// for posN 13 nj
	if (s.charAt(13)=='R'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 13);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}
	// for posN 15 nj
	if (s.charAt(15)=='R'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 15);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}
	break; 

case 13:
	// for posN 10 nj
	System.out.println("case 13 =  "+ posE);
	if (s.charAt(10)=='B'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 10);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}
	// for posN 16 nj
	if (s.charAt(16)=='R'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 16);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}
	// for posN 12 j11
	if (s.charAt(12)=='B'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 12);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}else if (s.charAt(11)=='B'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 11);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}
	break; 

case 14:
	// for posN 11 j8
	System.out.println("case 14 =  "+ posE);
	if (s.charAt(11)=='B'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 11);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}else if (s.charAt(8)=='B'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 8);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}
	// for posN 15 j16
	if (s.charAt(15)=='R'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 15);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}else if (s.charAt(16)=='R'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 16);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}
	break;
case 15:
	// for posN 12 j9
	System.out.println("case 15 =  "+ posE);
	if (s.charAt(12)=='B'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 12);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}else if (s.charAt(9)=='B'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 9);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}
	// for posN 14 nj
	if (s.charAt(14)=='B'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 14);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}
	// for posN 16 nj
	if (s.charAt(16)=='R'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 16);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}
	break; 
case 16:
	// for posN 13 j10
	System.out.println("case 16 =  "+ posE);
	if (s.charAt(13)=='B'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 13);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}else if (s.charAt(10)=='B'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 10);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}
	// for posN 15 j14
	if (s.charAt(15)=='B'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 15);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}else if (s.charAt(14)=='B'){
		StringBuffer schild = new StringBuffer(s);
		Swap(schild, posE, 14);
		child = new SSP(schild.toString(), 1);
		l.add(child);
	}

	break; 	
}

	 ****************************************************************/

	public List<IState> children() 
	{
		int n;
		List<IState> l = new ArrayList<IState>();
		SSP child;


		// \children for pazzel /

		int posE=empPos();			

		switch (posE)

		{
		case 0: 
		case 8:
		case 16:
			// System.out.println("case 0 ou 16 =  "+ posE);

			if (posE != 16 && s.charAt(posE + 1)=='R' ){
				StringBuffer schild = new StringBuffer(s);
				Swap(schild, posE, posE + 1);
				child = new SSP(schild.toString(), 1);
				l.add(child);
				Swap(schild, posE+1, posE );
			} else if (posE != 16 && s.charAt(posE + 2)=='R'){
				StringBuffer schild = new StringBuffer(s);
				Swap(schild, posE, posE + 2);
				child = new SSP(schild.toString(), 1);
				l.add(child);
				Swap(schild, posE+2, posE);
			}
			// for posN  3 j6
			if (posE != 16 && s.charAt(posE + 3)=='R'){
				StringBuffer schild = new StringBuffer(s);
				Swap(schild, posE, posE + 3);
				child = new SSP(schild.toString(), 1);
				l.add(child);
				Swap(schild, posE+1, posE);
			} else if (posE != 16 && s.charAt(posE + 6)=='R'){
				StringBuffer schild = new StringBuffer(s);
				Swap(schild, posE, posE + 6);
				child = new SSP(schild.toString(), 1);
				l.add(child);
				Swap(schild, posE+1, posE);
			} 
			if ( posE != 0 && s.charAt(posE - 3)=='B'){
				StringBuffer schild = new StringBuffer(s);
				Swap(schild, posE, posE - 3);
				child = new SSP(schild.toString(), 1);
				l.add(child);
			}
			else if(posE != 0 && s.charAt(posE - 6) == 'B'){
				StringBuffer schild = new StringBuffer(s);
				Swap(schild, posE, posE - 6);
				child = new SSP(schild.toString(), 1);
				l.add(child);
				Swap(schild, posE-6, posE);
			}
			// for posN 3 nj
			if (posE != 0 && s.charAt(posE - 1)=='B'){
				StringBuffer schild = new StringBuffer(s);
				Swap(schild, posE, posE - 1);
				child = new SSP(schild.toString(), 1);
				l.add(child);
				Swap(schild, posE-1, posE);
			}
			else if(posE != 0 && s.charAt(posE - 2) == 'B'){
				StringBuffer schild = new StringBuffer(s);
				Swap(schild, posE, posE - 2);
				child = new SSP(schild.toString(), 1);
				l.add(child);
				Swap(schild, posE-2, posE);
			}
			break;
		case 1:
		case 9:
			// System.out.println("case 1  ou 9 =  "+ posE);	
			if (s.charAt(posE - 1)=='B'){
				StringBuffer schild = new StringBuffer(s);
				Swap(schild, posE, posE - 1);
				child = new SSP(schild.toString(), 1);
				l.add(child);
				Swap(schild, posE-1, posE);
			}
			else if (posE == 9 && s.charAt(posE - 2)=='B'){
				StringBuffer schild = new StringBuffer(s);
				Swap(schild, posE, posE - 2);
				child = new SSP(schild.toString(), 1);
				l.add(child);
			}
			if (s.charAt(posE + 1)=='R'){
				StringBuffer schild = new StringBuffer(s);
				Swap(schild, posE, posE + 1);
				child = new SSP(schild.toString(), 1);
				l.add(child);
				Swap(schild, posE+1, posE);
			}
			if (s.charAt(posE + 3)=='R'){
				StringBuffer schild = new StringBuffer(s);
				Swap(schild, posE, posE + 3);
				child = new SSP(schild.toString(), 1);
				l.add(child);
				Swap(schild, posE+3, posE);
			}
			
			else if (s.charAt(posE + 6)=='R' ){
				StringBuffer schild = new StringBuffer(s);
				Swap(schild, posE, posE + 6);
				child = new SSP(schild.toString(), 1);
				l.add(child);
				Swap(schild, posE+6, posE);
			}
			break;
		case 2:
		case 10:
			// System.out.println("case 2 ou 10 =  "+ posE);
			if (s.charAt(posE - 1)=='B'){
				StringBuffer schild = new StringBuffer(s);
				Swap(schild, posE, posE - 1);
				child = new SSP(schild.toString(), 1);
				l.add(child);
				Swap(schild, posE-1, posE );
			}
			else if (s.charAt(posE - 2)=='B'){
				StringBuffer schild = new StringBuffer(s);
				Swap(schild, posE, posE - 2);
				child = new SSP(schild.toString(), 1);
				l.add(child);
				Swap(schild, posE-2, posE);
			}
			if (s.charAt(posE + 3 )=='R'){
				StringBuffer schild = new StringBuffer(s);
				Swap(schild, posE, posE + 3);
				child = new SSP(schild.toString(), 1);
				l.add(child);
				Swap(schild, posE+3, posE);
			}
			else if (s.charAt(posE + 6)=='R'){
				StringBuffer schild = new StringBuffer(s);
				Swap(schild, posE, posE + 6);
				child = new SSP(schild.toString(), 1);
				l.add(child);
				Swap(schild, posE+6, posE);
			}
			break;
		case 3:
		case 11:
			// System.out.println("case 3 ou 11 =  "+ posE);
			if (s.charAt(posE - 3)=='B'){
				StringBuffer schild = new StringBuffer(s);
				Swap(schild, posE, posE - 3);
				child = new SSP(schild.toString(), 1);
				l.add(child);
				Swap(schild, posE-3, posE);
			}
			else if (posE == 11 && s.charAt(posE - 6)=='B'){
				StringBuffer schild = new StringBuffer(s);
				Swap(schild, posE, posE - 6);
				child = new SSP(schild.toString(), 1);
				l.add(child);
				Swap(schild, posE-6, posE);
			}
			if (s.charAt(posE + 3)=='R'){
				StringBuffer schild = new StringBuffer(s);
				Swap(schild, posE, posE + 3);
				child = new SSP(schild.toString(), 1);
				l.add(child);
				Swap(schild, posE+3, posE);
			}
			if (s.charAt(posE + 1)=='R'){
				StringBuffer schild = new StringBuffer(s);
				Swap(schild, posE, posE + 1);
				child = new SSP(schild.toString(), 1);
				l.add(child);
				Swap(schild, posE+1, posE);
			}
			else if (s.charAt( posE + 2)=='R'){
				StringBuffer schild = new StringBuffer(s);
				Swap(schild, posE, posE + 2);
				child = new SSP(schild.toString(), 1);
				l.add(child);
				Swap(schild, posE+2, posE);
			}
			break;
		case 4:
		case 12:
			// System.out.println("case 4 ou 12 =  "+ posE);
			if (s.charAt(posE - 3)=='B'){
				StringBuffer schild = new StringBuffer(s);
				Swap(schild, posE, posE - 3);
				child = new SSP(schild.toString(), 1);
				l.add(child);
				Swap(schild, posE-3, posE);
			}
			if (s.charAt(posE - 1)=='B'){
				StringBuffer schild = new StringBuffer(s);
				Swap(schild, posE, posE - 1);
				child = new SSP(schild.toString(), 1);
				l.add(child);
				Swap(schild, posE-1, posE );
			}
			if (s.charAt(posE + 1)=='R'){
				StringBuffer schild = new StringBuffer(s);
				Swap(schild, posE, posE + 1);
				child = new SSP(schild.toString(), 1);
				l.add(child);
				Swap(schild, posE+1, posE );
			}
			if (s.charAt(posE + 3)=='R'){
				StringBuffer schild = new StringBuffer(s);
				Swap(schild, posE, posE + 3);
				child = new SSP(schild.toString(), 1);
				l.add(child);
				Swap(schild, posE+3, posE);
				
			}
			break;
		case 5:
		case 13:
			// System.out.println("case 5 ou 13 =  "+ posE);
			if (s.charAt(posE - 3)=='B'){
				StringBuffer schild = new StringBuffer(s);
				Swap(schild, posE, posE - 3);
				child = new SSP(schild.toString(), 1);
				l.add(child);
				Swap(schild, posE-3, posE);
			}
			if (s.charAt(posE - 1)=='B'){
				StringBuffer schild = new StringBuffer(s);
				Swap(schild, posE, posE - 1);
				child = new SSP(schild.toString(), 1);
				l.add(child);
				Swap(schild, posE-1, posE);
			}
			else if (s.charAt(posE - 2)=='B'){
				StringBuffer schild = new StringBuffer(s);
				Swap(schild, posE, posE - 2);
				child = new SSP(schild.toString(), 1);
				l.add(child);
				Swap(schild, posE-2, posE);
			}
			if (s.charAt(posE + 3)=='R'){
				StringBuffer schild = new StringBuffer(s);
				Swap(schild, posE, posE + 3);
				child = new SSP(schild.toString(), 1);
				l.add(child);
				Swap(schild, posE+3, posE );
			}
			else if (posE == 5 && s.charAt(posE + 6)=='R'){
				StringBuffer schild = new StringBuffer(s);
				Swap(schild, posE, posE + 6);
				child = new SSP(schild.toString(), 1);
				l.add(child);
				Swap(schild, posE+6, posE);
			}
			break;
		case 6:
		case 14:
			// System.out.println("case 6 ou 14 =  "+ posE);
			if (s.charAt(posE - 3)=='B'){
				StringBuffer schild = new StringBuffer(s);
				Swap(schild, posE, posE - 3);
				child = new SSP(schild.toString(), 1);
				l.add(child);
				Swap(schild, posE-3, posE );
			}
			else if (s.charAt(posE - 6)=='B'){
				StringBuffer schild = new StringBuffer(s);
				Swap(schild, posE, posE - 6);
				child = new SSP(schild.toString(), 1);
				l.add(child);
				Swap(schild, posE-6, posE );
			}
			if (s.charAt(posE + 1)=='R'){
				StringBuffer schild = new StringBuffer(s);
				Swap(schild, posE, posE + 1);
				child = new SSP(schild.toString(), 1);
				l.add(child);
				Swap(schild, posE+1, posE);
			}
			else if (s.charAt(posE + 2)=='R'){
				StringBuffer schild = new StringBuffer(s);
				Swap(schild, posE, posE + 2);
				child = new SSP(schild.toString(), 1);
				l.add(child);
				Swap(schild, posE+2, posE);
			}
			break;
		case 7:
		case 15:
			// System.out.println("case 7 ou 15 =  "+ posE);
			if (s.charAt(posE - 1)=='B'){
				StringBuffer schild = new StringBuffer(s);
				Swap(schild, posE, posE - 1);
				child = new SSP(schild.toString(), 1);
				l.add(child);
				Swap(schild, posE-1, posE);
			}
			if (s.charAt(posE - 3 )=='B'){
				StringBuffer schild = new StringBuffer(s);
				Swap(schild, posE, posE - 3);
				child = new SSP(schild.toString(), 1);
				l.add(child);
				Swap(schild, posE-3, posE );
			}
			else if (s.charAt(posE - 6)=='B'){
				StringBuffer schild = new StringBuffer(s);
				Swap(schild, posE, posE - 6);
				child = new SSP(schild.toString(), 1);
				l.add(child);
				Swap(schild, posE-6, posE);
			}
			if (s.charAt(posE + 1)=='R'){
				StringBuffer schild = new StringBuffer(s);
				Swap(schild, posE, posE + 1);
				child = new SSP(schild.toString(), 1);
				l.add(child);
				Swap(schild, posE+1, posE);
			}
			else if (posE == 7 && s.charAt(posE + 2)=='R'){
				StringBuffer schild = new StringBuffer(s);
				Swap(schild, posE, posE + 2);
				child = new SSP(schild.toString(), 1);
				l.add(child);
				Swap(schild, posE+2, posE);
			}	
			break;
		}   

		// System.out.println("-----------> tam l.size = " + l.size());
		return l;//     return all possible children --------------------------------
	}


	public void show(List<IState> A)
	{
		//System.out.println("size = " + A.size());

		for(int i = 0; i < A.size(); i++)
		{
			//System.out.println("->" + A.get(i));
		}
	}
	public int empPos()
	{

		for (int i=0;i<s.length();i++){

			if(s.charAt(i)=='E')
			{
				//System.out.println("emPos = " + i);
				return i;  // return the position of Empty place
			}

		}

		return -1;

	}


	public int getHfunc()					// for AStar algoritm
	{
		int res = 0;

		for (int i= 0; i < s.length();i++)
		{
			if(this.s.charAt(i)==s.charAt(i))
				res++;
		}

		return res;
	}

	public int getCost() 
	{
		return cost;
	}



	private void Swap(StringBuffer s, int i, int j)
	{
		char c = s.charAt(i);
		char d = s.charAt(j);
		s.setCharAt(i, d);
		s.setCharAt(j, c);

	}



}
