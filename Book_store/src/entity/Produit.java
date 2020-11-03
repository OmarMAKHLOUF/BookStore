package entity;

import java.util.Scanner;

public class Produit {
private int id ;
private String designation;
private String description ;
private int prixuni ;
private int qte_stock ;
 
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getPrixuni() {
	return prixuni;
}
public void setPrixuni(int prixuni) {
	this.prixuni = prixuni;
}
public int getQte_stock() {
	return qte_stock;
}
public void setQte_stock(int qte_stock) {
	this.qte_stock = qte_stock;
}
public Produit(int id, String designation, String description, int prixuni, int qte_stock) {
	super();
	this.id = id;
	this.designation = designation;
	this.description = description;
	this.prixuni = prixuni;
	this.qte_stock = qte_stock;
}
public Produit() {
	super();
 }
Scanner scanner = new Scanner( System.in );
public Produit creer() {
	 System.out.println("saisir id");

	  this.id = scanner.nextInt();
	  System.out.println("saisir designation");
	  this.designation = scanner.next();
	  System.out.println("saisir description");
	  this.description = scanner.next();
	  System.out.println("saisir prixuni");
	  this.prixuni = scanner.nextInt();
	  System.out.println("saisir qte_stock");
	  this.qte_stock = scanner.nextInt();
 
	return new Produit(this.id,this.designation,this.description,this.prixuni,this.qte_stock);
 
}
 
public String afficheProduit() {
	return "Produit [id=" + id + ", designation=" + designation + ", description=" + description + ", prixuni="
			+ prixuni + ", qte_stock=" + qte_stock + "]";
}

}
