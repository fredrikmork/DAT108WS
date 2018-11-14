package no.hvl.dat108;

public class Kant {
	private Node n1;
	private Node n2;
	private int vekt;

	public Kant() {
		this.n1 = null;
		this.n2 = null;
		this.vekt = 0;
	}
	public Kant(Node n1, Node n2, int vekt) {
		this.n1 = n1;
		this.n2 = n2;
		this.vekt = vekt;
	}

	public Node getN1() {
		return n1;
	}

	public void setN1(Node n1) {
		this.n1 = n1;
	}

	public Node getN2() {
		return n2;
	}

	public void setN2(Node n2) {
		this.n2 = n2;
	}

	public int getVekt() {
		return vekt;
	}

	public void setVekt(int vekt) {
		this.vekt = vekt;
	}

	@Override
	public String toString() {
		return "Kanten " + n1.getNodeNavn() + " & " + n2.getNodeNavn() + ", vekten: " + vekt;
	}

}
