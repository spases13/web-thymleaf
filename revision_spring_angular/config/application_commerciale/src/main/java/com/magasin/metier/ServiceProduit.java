package com.magasin.metier;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.magasin.dao.Produit;
import com.magasin.dao.ProduitRepository;

@Service
public class ServiceProduit implements IProduit{
	
	@Autowired
	public ProduitRepository  produitrepository;

	@Override
	public List<Produit> allproducts() {
		
		return produitrepository.findAll();
	}

	@Override
	public Produit getproduct(int id) {
		
		return produitrepository.findById(id).orElse(null);
	}

	@Override
	public void deleteproduct(int id) {
		produitrepository.deleteById(id);
		
	}

	@Override
	public void updateproduct(Produit p) {
		Produit prod=getproduct(p.getNumproduit());
		if(prod !=null)
		{
			
		prod.setNomproduit(p.getNomproduit());	
		prod.setPrix(p.getPrix());
		produitrepository.save(prod);
		
		}
		
	}

	@Override
	public void addproduct(Produit p) {
		produitrepository.save(p);
		
	}

}
