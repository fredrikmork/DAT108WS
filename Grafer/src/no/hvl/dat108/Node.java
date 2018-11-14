package no.hvl.dat108;

import java.util.ArrayList;

public class Node {
	
	private String navn;
	private ArrayList<Kant> kanter;
	
	public Node() {
		this.navn = "";
		this.kanter = new ArrayList<Kant>();
	}
	public Node(String navn) {
		this.navn = navn;
		this.kanter = new ArrayList<Kant>();
	}
	
	public void leggTilNabo(Kant kant) {
		if (!this.kanter.contains(kant)) {
			this.kanter.add(kant);
		}
	}
	


	/**
	 * legger til en kant fra denne noden mellom en valgt node
	 * @param node
	 * @param vekt
	 */
	public void lagKant(Node node, int vekt) {
		kanter.add(new Kant(this, node, vekt));
	}
	
	public String getNodeNavn() {
		return navn;
	}
	public void setNodeNavn(String nodeNavn) {
		this.navn = nodeNavn;
	}
	
	
	public ArrayList<Kant> getKanter() {
		return kanter;
	}
	@Override
	public String toString() {
		return navn;
	}
	
}
