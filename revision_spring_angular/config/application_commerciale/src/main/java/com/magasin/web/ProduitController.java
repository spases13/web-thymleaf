package com.magasin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.magasin.dao.Produit;
import com.magasin.metier.IProduit;

@Controller
public class ProduitController {
	
	@Autowired
	IProduit serviceproduit;
	
	@RequestMapping(value = "/products" ,method = RequestMethod.GET)
	public String products(Model model)
	{
		model.addAttribute("produits",serviceproduit.allproducts() );
		 return "products";
	}
	
	@RequestMapping(value = "/addproduct" ,method = RequestMethod.POST)
	public String addproduct(Model model,@RequestParam String nom,@RequestParam double prix)
	{
		serviceproduit.addproduct(new Produit(nom, prix));
		model.addAttribute("produits", serviceproduit.allproducts());
		 return "products";
	}
	
	
	@RequestMapping(value = "/newproduct" ,method = RequestMethod.GET)
	public String addproduct(Model model)
	{
			
		 return "newproduct";
	}
	
}







