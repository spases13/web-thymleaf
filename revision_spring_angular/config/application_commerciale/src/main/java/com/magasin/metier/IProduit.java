package com.magasin.metier;
import  java.util.*;
import com.magasin.dao.*;
public interface IProduit {

	public  List<Produit>  allproducts();
	public Produit getproduct(int id);
	public void deleteproduct(int id);
	public void updateproduct(Produit p);
	public void addproduct(Produit p);
	
	
}
