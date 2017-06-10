package metier;

import java.util.List;

import metier.entities.Categorie;
import metier.entities.Produit;

public interface ICatalogueMetier {

	public Categorie addCategorie(Categorie c); 
	public Produit addProduit(Produit p);
	public List<Categorie> listCategories();
	public List<Produit> produitParCat(Long idCat);
	public List<Produit> listProduit();
	public List<Produit> produitParMC(String mc);
	public Categorie updateCategorie(Categorie c);
	public boolean deleteProduit(Long idProd);
	public Produit updateProduit(Produit p);
	public Categorie getCategorie(Long idCat);
	public Produit getProduit(Long idProd);
	
	

}
