package no.hvl.dat108;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Graf {
	/**
	 * Lager liste med noder
	 */
	private LinkedList<Node> noder = new LinkedList<Node>();
	private ArrayList<Kant> kanter = new ArrayList<Kant>();
	
	/**
	 * Legger til en node i grafen
	 * 
	 * @param Node
	 *            n
	 */
	public void leggtilNode(Node n) {
		noder.add(n);
	}

	/**
	 * Fjerner en node fra grafen
	 * 
	 * @param String
	 *            node (navnet) til en node du vil slette
	 */
	public Node fjernNode(Node node) {
		Node aktuell = null;
		for (Iterator<Node> iter = noder.listIterator(); iter.hasNext();) {
			Node a = iter.next();
			if (a.getNodeNavn().equals(node.getNodeNavn())) {
				aktuell = a;
			}
		}
		for (Kant k : aktuell.getKanter()) {
			System.out.println(k.toString() + ": Går ikke lenger mellom to noder, og har blitt fjernet");
			kanter.remove(k);
		}
		noder.remove(aktuell);
		return aktuell;
	}
	
	/**
	 * Legger til en kant i grafen
	 * 
	 * @param kanten
	 *            k
	 */
	public void leggTilKant(Kant k) {
		kanter.add(k);
	}

	/**
	 * Fjerner en kant fra grafen mellom node 1 og 2
	 * 
	 * @param noder
	 *            der du vil fjerne kanten i mellom
	 */
	public void fjernKant(Node n1, Node n2) {
		for (Iterator<Kant> iter = kanter.listIterator(); iter.hasNext();) {
			Kant a = iter.next();
			if (a.getN1() == n1 && a.getN2() == n2) {
				iter.remove();
			}
		}
		if (!harKant(n1)) {
			System.out.println(n1.getNodeNavn() + " har ingen kant og vil bli slettet.");
			noder.remove(n1);
		} else if (!harKant(n2)) {
			System.out.println(n2.getNodeNavn() + " har ingen kant og vil bli slettet.");
			noder.remove(n2);
		}
	}

	/**
	 * 
	 * @param node
	 * @return om noden har en kant eller ikke
	 */
	public boolean harKant(Node n) {
		boolean harKant = false;
		for (Kant k : kanter) {
			if (n == k.getN1() || n == k.getN2()) {
				harKant = true;
			}
		}
		return harKant;
	}

	/**
	 * Kø kø 
	 * kø.leggTil (node) 
	 * så lenge kø.ikkeTom () 
	 * 		Node n = kø.taUt () 
	 * 		hvis n ikke er besøkt 
	 * 			kø.leggTil (alle ubesøkte naboer av n) 
	 * 			merk n som besøkt
	 * 			behandle n
	 */
	public void breddeFørst(Node n) {
		Queue<Node> kø = new LinkedList<Node>();
		boolean besokt [] = new boolean[noder.size()];
		int index = noder.indexOf(n);
		besokt[index] = true;
		kø.add(n);
		while (!kø.isEmpty()) {
			n = kø.poll();
			System.out.print(n.getNodeNavn() + ", ");
			for(Kant k  : n.getKanter()) {
				int index1 = noder.indexOf(k.getN1());
				int index2 = noder.indexOf(k.getN2());
				if(!besokt[index1]) {
					besokt[index1] = true;
					kø.add(k.getN1());
				} else if (!besokt[index2]){
					besokt[index2] = true;
					kø.add(k.getN2());
				}
			}
		}
	}

	/**
	 * prim(node) 
	 * Haug haug 
	 * haug.leggTil(alle kanter ut fra node) 
	 * så lenge haug.ikkeTom() 
	 * 		Kant k = haug.taUtMinste() 
	 * 		hvis ikke begge nodene til k er i MST 
	 * 			Node n = noden til k som ikke er i MST 
	 * 			MST.leggTil(n) 
	 * 			haug.leggTil(alle kanter mellom n og noder som ikke er med i MST)
	 */
	public LinkedList<Node> primMST(Node n) {
		PriorityQueue<Kant> haug = new PriorityQueue<Kant>();	 //Haugen med kanter
		LinkedList<Node> mst = new LinkedList<Node>();			//MST av noder
		//int vekt = 0;
		haug.addAll(n.getKanter());
		mst.add(n);
		while (!haug.isEmpty()) {
			Kant k = haug.poll();
			if (!mst.contains(k.getN1())) {
				n = k.getN1();
				mst.add(n);
				haug.addAll(n.getKanter());
			} else if (!mst.contains(k.getN2())) {
				n = k.getN2();
				mst.add(n);
				haug.addAll(n.getKanter());
			}
		}
		return mst;
	}
	/**
	 * dybdeFørst(node)
			Stabel stabel
			stabel.stable(node)
			så lenge stabel.ikkeTom()
				Node n = stabel.avstable()
				hvis n ikke er besøkt
					stabel.stable(alle ubesøktenaboer av n)
					merk n som besøkt
					behandle n
	 */
	public void depthFirst(Node n) {
		LinkedList<Node> stabel = new LinkedList<Node>();
		boolean besokt [] = new boolean[noder.size()];
		int index = noder.indexOf(n);
		besokt[index] = true;
		stabel.add(n);
		while (!stabel.isEmpty()) {
			n = stabel.pollLast();
			System.out.print(n.getNodeNavn() + ", ");
			for(Kant k  : n.getKanter()) {
				int index1 = noder.indexOf(k.getN1());
				int index2 = noder.indexOf(k.getN2());
				if(!besokt[index1]) {
					besokt[index1] = true;
					stabel.add(k.getN1());
				} else if (!besokt[index2]) {
					besokt[index2] = true;
					stabel.add(k.getN2());
				}
			}
		}
	}
	
	public int lengde() {
		return noder.size();
	}
	
	public boolean erTom() {
		return noder.size() == 0;
	}
	
	public boolean erNaboer(Node n1, Node n2) {
		return n1.equals(n2);
	}
	
	public boolean erGrafenSammenhengende() {
		//TODO
		return false;
	}
	
	/**
	 * Dijkstra algoritme
	 * Dijkstra(v1, v2):
			for each vertex  v:                            // Initialization
				v's distance := infinity.
				v's previous  := none.
			v1's distance := 0.
			List := {all vertices}.

			while List is not empty:
				v := remove List vertex with minimum distance.
				mark v as visited.
				for each  unvisited neighbor  n of v:
					dist := v's distance + edge (v, n)'s weight.

					if dist is smaller than n's distance:
						n's distance := dist.
						n's previous  := v.

			reconstruct  path  from v2 back to v1,
			following  previous pointers.
	 */
	public void kortesteSti() {
		//TODO
	}
	public void naboMatrise() {
		//TODO
	}
	public ArrayList<Node> naboListe() {
		ArrayList<Node> liste = new ArrayList<Node>();
		return liste;
	}
	@Override
	public String toString() {
		return "Nodelisten: " + noder.toString() + " Kantlisten: " + kanter.toString();
	}
}
