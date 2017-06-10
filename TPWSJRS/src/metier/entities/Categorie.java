package metier.entities;

import java.io.Serializable;

public class Categorie implements Serializable {
	
	private long idCategorie;
	private String nomCategorie;
	private String photo;
	public long getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(long idCategorie) {
		this.idCategorie = idCategorie;
	}
	public String getNomCategorie() {
		return nomCategorie;
	}
	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Categorie() {
		super();
	}
	public Categorie(long idCategorie, String nomCategorie, String photo) {
		super();
		this.idCategorie = idCategorie;
		this.nomCategorie = nomCategorie;
		this.photo = photo;
	}
	
	

}
