package no.hvl.dat108;

public class Node {
	
	private String nodeNavn;
	private int distanse;
	
	public Node() {
		
	}
	public Node(String nodeNavn, int distanse) {
		super();
		this.nodeNavn = nodeNavn;
		this.distanse = distanse;
	}
	public String getNodeNavn() {
		return nodeNavn;
	}
	public void setNodeNavn(String nodeNavn) {
		this.nodeNavn = nodeNavn;
	}
	public int getDistanse() {
		return distanse;
	}
	public void setDistanse(int distanse) {
		this.distanse = distanse;
	}
	@Override
	public String toString() {
		return "Node [nodeNavn=" + nodeNavn + ", distanse=" + distanse + "]";
	}
	
	
	
	
}
