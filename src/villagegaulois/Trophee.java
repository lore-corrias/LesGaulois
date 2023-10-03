package villagegaulois;

import personnages.Equipement;
import personnages.Gaulois;

public class Trophee {
	private Gaulois gaulois;
	private Equipement equipement;
	
	public Trophee(Gaulois gaulois, Equipement equipement) {
		this.gaulois = gaulois;
		this.equipement = equipement;
	}
	
	public Equipement getEquipement() {
		return equipement;
	}
	
	public Gaulois getGaulois() {
		return gaulois;
	}
	
	public String donnerNom() {
		return this.gaulois.getNom();
	}
}
