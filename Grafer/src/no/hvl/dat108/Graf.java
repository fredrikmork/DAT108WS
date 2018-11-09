package no.hvl.dat108;

import java.util.LinkedList;

public class Graf {
	/**
	 * Lager liste med noder
	 */
	private LinkedList<Node> noder = new LinkedList<Node>();
	/**
	 * 
	 */
	public void fjernNode() {

	}

	/**
	 * 
	 */
	public void fjernKant() {

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
	public Node breddeFørst(Node n) {
		//TODO
		return n;
	}
	/**
	 * 
	prim(node)
		Haug haug 
		haug.leggTil(alle kanter ut fra node)
		så lenge haug.ikkeTom()
			Kant k = haug.taUtMinste()
			hvis ikke begge nodene til k er i MST
				Node n = noden til k som ikke er i MST
				MST.leggTil(n)
				haug.leggTil(alle kanter mellom n og noder som ikke er med i MST)
	 */
	public LinkedList<Node> prim(Node n) {
		//TODO
		return noder;
	}
}
