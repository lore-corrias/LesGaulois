package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipement = new Equipement[2];
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
	
	public void recevoirCoup(int forceCoup) {
		int forceCurr = this.force;
		if(force >= 0) {
			System.out.println("la force d’un Romain est positive");
		}
		this.force -= forceCoup;
		if(force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
		if(forceCurr > this.force) {
			System.out.println("la force d’un Romain a diminué");
		}
	}

	private boolean possedeEquipement(Equipement equipement) {
		for(int i = 0; i < this.nbEquipement; i++) {
			if(this.equipement[i] == equipement) {
				return true;
			}
		}
		return false;
	}
	
	private void ajouteEquipement(Equipement equipement) {
		this.equipement[this.nbEquipement++] = equipement;
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
	
	public static void main(String[] args) {
//		Romain minus = new Romain("Minus", -6);
		Romain minus = new Romain("Minus", 6);
		
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
}
