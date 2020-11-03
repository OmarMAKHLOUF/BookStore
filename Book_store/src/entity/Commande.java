package entity;

import java.util.Date;

public class Commande {
private int id;
private Date date_cmd;
private int prix_total;
//getter setter
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Date getDate_cmd() {
	return date_cmd;
}
public void setDate_cmd(Date date_cmd) {
	this.date_cmd = date_cmd;
}
public int getPrix_total() {
	return prix_total;
}
public void setPrix_total(int prix_total) {
	this.prix_total = prix_total;
}
//constructeur 
public Commande() {
	super();
	// TODO Auto-generated constructor stub
}
public Commande(int id, Date date_cmd, int prix_total) {
	super();
	this.id = id;
	this.date_cmd = date_cmd;
	this.prix_total = prix_total;
}

public void passer_Commande() {
	//for(int i=0;i<sous_somme.length;i++) {
	//	this.prix_total=prix_total +sous_somme[i];
	//}
		
}
}
