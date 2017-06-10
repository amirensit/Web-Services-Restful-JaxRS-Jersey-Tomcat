package metier.entities;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonSetter;

public class Produit implements Serializable {
	
	private Long idProduit;
	private double prix;
	private String photo;
	private Categorie categorie;
	private String designation;
	public Long getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	@JsonIgnore
	public Categorie getCategorie() {
		return categorie;
	}
	@JsonSetter
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Produit() {
		super();
	}
	public Produit(Long idProduit, double prix, String photo, Categorie categorie, String designation) {
		super();
		this.idProduit = idProduit;
		this.prix = prix;
		this.photo = photo;
		this.categorie = categorie;
		this.designation = designation;
	}
	
	

}
