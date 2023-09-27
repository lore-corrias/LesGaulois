package personnages;

public class Greek {
	private String nom;
	private int age;
	
	public Greek(String nom, int age) {
		this.nom = nom;
		this.age = age;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
}
