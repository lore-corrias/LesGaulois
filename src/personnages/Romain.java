package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	public String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
//	public void recevoirCoup(int forceCoup) {
//		int forceCurr = this.force;
//		if(force >= 0) {
//			System.out.println("la force d’un Romain est positive");
//		}
//		this.force -= forceCoup;
//		if(force > 0) {
//			parler("Aïe");
//		} else {
//			parler("J'abandonne...");
//		}
//		if(forceCurr > this.force) {
//			System.out.println("la force d’un Romain a diminué");
//		}
//	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = CalculResistanceEquipement(forceCoup);
		force -= forceCoup;
		// if (force > 0) {
		// parler("Aïe");
		// } else {
		// equipementEjecte = ejecterEquipement();
		// parler("J'abandonne...");
		// }
		// S1301: redefinition from switch to if
		if(force > 0) {
			parler("Aïe");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		// post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;
	}
	
	private int CalculResistanceEquipement(int forceCoup) {
		// S1450: redefinition as a local variable
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		// S1940: from !(==) to !=
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			// S127: refactoring to include i++ inside the for loop
			for (int i = 0; i < nbEquipement; i++) {
				// S125: simplify the expression
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			// S2757: mirrored += operator
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		if(forceCoup < 0)
			forceCoup = 0;
		return forceCoup;
	}
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		// S1858: call to toString() unnecessary
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		// S1135: removal of TO DO comment
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			// S3626: redundant jump removal
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}

	private boolean possedeEquipement(Equipement equipement) {
		for(int i = 0; i < this.nbEquipement; i++) {
			if(this.equipements[i] == equipement) {
				return true;
			}
		}
		return false;
	}
	
	private void ajouteEquipement(Equipement equipement) {
		this.equipements[this.nbEquipement++] = equipement;
		System.out.println("Le soldat " + this.nom + " s'équipe avec un " + equipement + ".");
	}
	
	public void sEquiper(Equipement equipement) {
		switch(this.nbEquipement) {
			case 2:
				System.out.println("Le soldat " + this.nom + " est déjà bien protégé !");
				break;
			case 1:
				if(possedeEquipement(equipement)) {
					System.out.println("Le soldat Minus possède déjà un " + equipement + " !");
				} else {
					ajouteEquipement(equipement);
				}
				break;
			case 0:
				ajouteEquipement(equipement);
				break;
		}
	}
	
	public int getForce() {
		return force;
	}
	
	public static void main(String[] args) {
//		Romain minus = new Romain("Minus", -6);
		Romain minus = new Romain("Minus", 6);
		
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
}
