package entity;

import java.util.ArrayList;

public class Panier {
	private int id;
	private int [] prix_sous_total;
	private int qte;
	private int nb_produit=0;
 	private static ArrayList <Panier> panier ;
	
 	
 	//constructeur 
 	public Panier() {
		super();
		// TODO Auto-generated constructor stub
	}
  public Panier(int id, int[] prix_sous_total, int qte, int nb_produit) {
		super();
		this.id = id;
		this.prix_sous_total = prix_sous_total;
		this.qte = qte;
		this.nb_produit = nb_produit;
	}

//getter & setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int[] getPrix_sous_total() {
		return prix_sous_total;
	}
	public void setPrix_sous_total(int[] prix_sous_total) {
		this.prix_sous_total = prix_sous_total;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	public int getNb_produit() {
		return nb_produit;
	}
	public void setNb_produit(int nb_produit) {
		this.nb_produit = nb_produit;
	}
	public static ArrayList<Panier> getPanier() {
		return panier;
	}
	public static void setPanier(ArrayList<Panier> panier) {
		Panier.panier = panier;
	}
	//methods
	/*
	public void ajouterPanier(int qte, Produit p) {
		if(qte<=  stock.get.getQte_stock() ) {
			//panier[nb_produit]=p;
			nb_produit++;
			 System.out.println("produit ajouter au pannier");
			 
		}
		else 
			 System.out.println("produit out of stock");
	}
	public void calcul_sous_prix() {
		for (int i=0;i<panier.size();i++)
		{
			//prix_sous_total[i] =  panier[i].getPrixuni() * qte  ;
		}
		System.out.println("prix sous total dans le panier "+prix_sous_total);
	}
	public void addCart (int qte, stock p) {
		
	}*/
}
