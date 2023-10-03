package villagegaulois;

import personnages.Equipement;
import personnages.Gaulois;

public class Musee {
	private Trophee[] trophees = new Trophee[200];
	private int nbTrophees = 0;
	
	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		this.trophees[nbTrophees++] = new Trophee(gaulois, equipement);
	}
	
	public String extraireInstructionsCaml() {
		String texte = "let musee = [";
		for(int i = 0; i < this.nbTrophees; i++) {
			texte += "\n     \"" + this.trophees[i].donnerNom() + "\", ";
			texte += "\"" + this.trophees[i].getEquipement() + "\";";
		}
		texte += "\n]";
		return texte;
	}
}
