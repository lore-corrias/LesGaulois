package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	
	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.villageois = new Gaulois[nbVillageoisMaximum];
	}
	
	public void ajouterHabitant(Gaulois habitant) {
		this.villageois[nbVillageois++] = habitant;
	}
	
	public Gaulois trouverHabitant(int nbHabitant) {
		return this.villageois[nbHabitant];
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void afficherVillageois() {
		if(this.chef != null) {
			System.out.println("Dans le village du chef " + this.chef.getNom() + " vivent les légendaires gaulois:");
		} else {
			System.out.println("Dans le village " + this.nom + " vivent les légendaires gaulois:");
		}
		for(int i = 0; i < this.nbVillageois; i++) {
			System.out.println("- " + this.villageois[i].getNom());
		}
	}
	
	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles", 30);
		Chef abraracourcix = new Chef("Abraracourcix", 6, village);
		Gaulois asterix = new Gaulois("Astérix", 8);
		Gaulois obelix = new Gaulois("Obélix", 25);
//		village.trouverHabitant(30);
		village.setChef(abraracourcix);
		village.ajouterHabitant(asterix);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();
		
		/*
		 * Le valeur de retour est "null" parce que le tableau "villageois"
		 * ne contient que un seul élément, qui se trouve à la position "0"
		 */
//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);
	}
}
