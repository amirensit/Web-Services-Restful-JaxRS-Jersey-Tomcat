package metier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import metier.entities.Categorie;
import metier.entities.Produit;

public class CatalogueMetierImpl implements ICatalogueMetier {
	
	private Map<Long, Categorie>categories=new HashMap<Long,Categorie>();
	private Map<Long, Produit>produits=new HashMap<Long,Produit>();

	@Override
	public Categorie addCategorie(Categorie c) {
		categories.put(c.getIdCategorie(), c);
		return c;
	}

	@Override
	public Produit addProduit(Produit p) {
		p.setCategorie( getCategorie( p.getCategorie().getIdCategorie() ) );
		produits.put(p.getIdProduit(), p);
		return p;
	}

	@Override
	public List<Categorie> listCategories() {
		
		return new ArrayList<Categorie>(categories.values());
	}

	@Override
	public List<Produit> produitParCat(Long idCat) {
		ArrayList<Produit> prods=new ArrayList<Produit>();
		for(Produit p : produits.values())
			if(p.getCategorie().getIdCategorie()==idCat )
				prods.add(p);
		
		return prods;
	}

	@Override
	public List<Produit> listProduit() {
		return new ArrayList<Produit>(produits.values());
	}

	

	@Override
	public Categorie updateCategorie(Categorie c) {
		categories.put(c.getIdCategorie(),c);
		return c;
	}

	@Override
	public boolean deleteProduit(Long idProd) {
		if(produits.get(idProd)!=null)
		{
			produits.remove(idProd);
			return true;
		}
		else
			
			throw new RuntimeException("produit untrouvable");
			
			
	}

	@Override
	public Produit updateProduit(Produit p) {
		produits.put(p.getIdProduit(), p);
		return p;
	}

	@Override
	public Categorie getCategorie(Long idCat) {
		 return categories.get(idCat);
		
	}

	@Override
	public Produit getProduit(Long idProd) {
		
		return produits.get(idProd);
	}

	@Override
	public List<Produit> produitParMC(String mc) {
		ArrayList<Produit> prods=new ArrayList<Produit>();
		for(Produit p : produits.values())
			if(p.getDesignation().contains(mc) )
				prods.add(p);
		
		return prods;
	}
	
	public void initialiserCatalogue()
	{
		addCategorie(new Categorie(1L,"ordinateurs","ordinateurs.jpg"));
		addCategorie(new Categorie(2L,"imprimantes","imprimantes.jpg"));
		addCategorie(new Categorie(3L,"televizeurs","televizeurs.jpg"));
		addProduit(new Produit(1L,6500,"ord1.jpg",getCategorie(1L),"HP Pavillon 17-f227nf PC PORT"));
		addProduit(new Produit(2L,6500,"ord2.jpg",getCategorie(1L),"ASUS Pc Portable"));
		addProduit(new Produit(3L,5500,"impr1.jpg",getCategorie(2L),"HP Imprimante Lazer"));
	}

}
