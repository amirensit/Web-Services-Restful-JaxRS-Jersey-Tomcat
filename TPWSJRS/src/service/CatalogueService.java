package service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.spi.resource.Singleton;

import metier.CatalogueMetierImpl;
import metier.entities.Categorie;
import metier.entities.Produit;
@Singleton  //indiquer à Jersey que cette classe s'instantie une seule fois
@Path("/catalogue")
@Produces(MediaType.APPLICATION_JSON +"; charset=utf-8")
public class CatalogueService {
	
	private CatalogueMetierImpl metier;
	
	 public CatalogueService()
	 {
		 metier=new CatalogueMetierImpl();
		 metier.initialiserCatalogue();
	 }
	 
	 @GET
	 @Path("/categories")
	 public List<Categorie> consulterCategories()
	 {
		 return metier.listCategories();
	 }
	 @GET
	 @Path("/categories/{idCat}/produits")	
	 public List<Produit>produitsParCat(@PathParam(value="idCat") long idCat)
	 {
		 return metier.produitParCat(idCat);
	 }
	 
	 @GET
	 @Path("/produits")	 
	 public List<Produit>produitsParMC(@QueryParam(value="mc") String mc)
	 {
		 return metier.produitParMC(mc);
	 }
	 
	 @GET
	 @Path("/allProduits")	 
	 public List<Produit>produits()
	 {
		 return metier.listProduit();
	 }
	 @GET
	 @Path("/categories/{idCat}")	 
	 public Categorie getCategorie( @PathParam(value="idCat")Long idCat)
	 {
		 return metier.getCategorie( idCat);
	 }
	 
	 @GET
	 @Path("/produits/{idProd}")
	 public Produit getProduit( @PathParam(value="idProd")Long idProd)
	 {
		 return metier.getProduit(idProd);
	 }
	 @POST
	 @Path("/categories")
	 @Consumes(MediaType.APPLICATION_JSON)  			//obliger au client de fournir les données sous format JSON;si on précise rien,on peut envoyer les données avec différents formats
	 public Categorie saveCategorie(Categorie c)
	 {
		 return metier.addCategorie(c);
	 }
	 @DELETE
	 @Path("/produits")
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 public boolean deleteProduit(@FormParam(value="idProd") Long idProd)
	 {
		 return metier.deleteProduit(idProd);
	 }
	 @PUT  //pour la mise à jour
	 @Path("/produits")
	 public Produit updateProd(Produit p)
	 {
		 return metier.updateProduit(p);
	 }
	 
	 @POST
	 @Path("/produits")
	 @Consumes(MediaType.APPLICATION_JSON)  			
	 public Produit saveProduit(Produit p)
	 {
		 return metier.addProduit(p);
	 }

}
