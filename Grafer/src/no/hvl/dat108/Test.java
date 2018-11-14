package no.hvl.dat108;

public class Test {
	public static void main(String[] args) {
		// Lager en graf
		Graf graf = new Graf();
		// Lager noder
		Node a = new Node("a");
		Node b = new Node("b");
		Node c = new Node("c");
		// Lager kanter
		Kant k1 = new Kant(a, b, 3);
		Kant k2 = new Kant(b, c, 2);
		Kant k3 = new Kant(c, a, 1);

		a.leggTilNabo(k1);
		a.leggTilNabo(k3);
		b.leggTilNabo(k3);
		b.leggTilNabo(k1);
		c.leggTilNabo(k2);
		c.leggTilNabo(k3);
		// Legger til noder
		graf.leggtilNode(a);
		graf.leggtilNode(b);
		graf.leggtilNode(c);
		// Legger til kanter
		graf.leggTilKant(k1);
		graf.leggTilKant(k2);
		graf.leggTilKant(k3);
		// Tester metodene i oppgave b)
		System.out.println(graf.toString());
		// graf.fjernNode(a);
		// graf.fjernKant(a, b);
		System.out.println(graf.toString());
		// Tester breddeførst i c)
		graf.breddeFørst(a);
	}

}
