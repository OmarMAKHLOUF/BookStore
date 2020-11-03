package entity;

import java.util.Date;

public class Commande {
private int id;
private Date date_cmd;
private int prix_total;
private Panier panier;
private int user;
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
public Commande( Date date_cmd, int prix_total,Panier panier ,int user) {
	super();
	this.user=user;
	this.panier=panier;
	this.date_cmd = date_cmd;
	this.prix_total = prix_total;
}
@Override
public String toString() {
	return "Commande  a été passeé le " + date_cmd + ", par l utilisateur identifier par "+ user +" avec somme de " + prix_total;
}
 

 
}
