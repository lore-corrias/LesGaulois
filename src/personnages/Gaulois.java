package personnages;

import villagegaulois.Musee;

public class Gaulois {
	private String nom;
	private int force;
	/* rule S1659: declare on separate lines
	 * rule S116: make variable name compliant to standard expression
	 */
	private int nbTrophees;
	private int effetPotion = 1;
	private Equipement[] trophees = new Equipement[10];
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	
//	private String prendreParole() {
//		return "Le Gaulois " + nom + " : "; 
//	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : "; // rule S1488, immediately return value
	}
	
//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
//		romain.recevoirCoup(force / 3 * effetPotion	);
//	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		/*
		 * rule S1197: array qualifiers in front of type
		 * rule S1488: no shadowing variables
		 */
		Equipement[] tropheesCoup = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; tropheesCoup != null && i < tropheesCoup.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = tropheesCoup[i];
		}
		// rule S626: no return without a value for a void method
	}
	
	public void boirPotion(int forcePotion) {
		effetPotion = forcePotion;
		if(forcePotion == 3) {
			parler("Merci Druide, je sens que ma force est 3 fois décuplée.");
		}
	}
	
	public void faireUneDonnation(Musee musee) {
		if(this.nbTrophees > 0) {
			String texte = "Je donne aux musee tous mes trophees: ";
			for(int i = 0; i < this.nbTrophees; i++) {
				texte += "\n" + this.trophees[i];
				musee.donnerTrophees(this, this.trophees[i]);
			}
			parler(texte);
		}
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		Romain romolo = new Romain("Romolo", 8);
		
		asterix.prendreParole();
		asterix.parler("Bonjour!");
		asterix.boirPotion(3);
		asterix.frapper(romolo);
		
		romolo.prendreParole();
		romolo.parler("Ciao!");
		romolo.recevoirCoup(3);
	}
}
