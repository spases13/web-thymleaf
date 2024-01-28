package com.magasin.dao;

import java.io.Serializable;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produit implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numproduit;
	private String nomproduit;
	private double prix;

	public Produit(String nomproduit, double prix) {
		super();
	
		this.nomproduit = nomproduit;
		this.prix = prix;
	}

	public Produit() {
		super();
	}

	public int getNumproduit() {
		return numproduit;
	}

	public void setNumproduit(int numproduit) {
		this.numproduit = numproduit;
	}

	public String getNomproduit() {
		return nomproduit;
	}

	public void setNomproduit(String nomproduit) {
		this.nomproduit = nomproduit;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	
	
}
