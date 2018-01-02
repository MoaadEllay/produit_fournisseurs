package Model;

public class Produit {
	
	private int id;
	private String label;
	
	private double prix;
	private int id_fournisseur;
	
	public Produit(int id, String label, double prix, int id_fournisseur) {
		super();
		this.id = id;
		this.label = label;
		this.prix = prix;
		this.id_fournisseur = id_fournisseur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getId_fournisseur() {
		return id_fournisseur;
	}

	public void setId_fournisseur(int id_fournisseur) {
		this.id_fournisseur = id_fournisseur;
	}
	
	
	
	
	
	
	
	

}
