package no.hvl.dat108;

public class Test {
	public static void main(String[] args) {
		// Lager en graf
		Graf graf = new Graf();
		// Lager noder
		Node a = new Node("a");
		Node b = new Node("b");
		Node c = new Node("c");
		Node d = new Node("d");
		Node e = new Node("e");
		// Lager kanter
		Kant ab = new Kant(a, b, 3);
		Kant bc = new Kant(b, c, 2);
		Kant ca = new Kant(c, a, 1);
		Kant ce = new Kant(c, e, 3);
		Kant ed = new Kant(e, d, 4);
		// Legger til noder
		graf.leggtilNode(a);
		graf.leggtilNode(b);
		graf.leggtilNode(c);
		graf.leggtilNode(d);
		graf.leggtilNode(e);
		// Legger til naboer
		a.leggTilNabo(ab);
		b.leggTilNabo(ab);
		b.leggTilNabo(bc);
		c.leggTilNabo(bc);
		c.leggTilNabo(ca);
		a.leggTilNabo(ca);
		c.leggTilNabo(ce);
		e.leggTilNabo(ce);
		e.leggTilNabo(ed);
		d.leggTilNabo(ed);
		// Legger til kanter
		graf.leggTilKant(ab);
		graf.leggTilKant(bc);
		graf.leggTilKant(ca);
		graf.leggTilKant(ce);
		graf.leggTilKant(ed);
		// Tester metodene i oppgave b)
		System.out.println(graf.toString());
//		graf.fjernNode(a);
//		graf.fjernKant(e, d);
//		System.out.println(graf.toString());
		// Tester breddeførst i c)
		System.out.print("Bredde først søk:\t[");
		graf.breddeFørst(a);
		System.out.println("]");
		System.out.println("Prims MST algoritme:\t" + graf.primMST(a));
	}

}
