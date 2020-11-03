package entity;

import java.util.Scanner;

public class Personne {

	private int id;
	private String nom;
	private String prenom;
	private String email;
	private int tel;
	
	//constructeur 
	public Personne(int id, String nom, String prenom, String email, int tel) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.tel = tel;
	}
	public Personne() {
		super();
		// TODO Auto-generated constructor stub
	}
//getter & setter 	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	
	 
	public String afficheUser() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", tel=" + tel + "]";
	}

	Scanner scanner = new Scanner( System.in );
	public Personne creerPersonne( ) {
		  System.out.println("saisir id");
		  this.id = scanner.nextInt();
		  System.out.println("saisir nom");
		  this.nom = scanner.next();
		  System.out.println("saisir prenom");
		  this.prenom = scanner.next();
		  System.out.println("saisir email");
		  this.email = scanner.next();
		  System.out.println("saisir tel");
		  this.tel = scanner.nextInt();
		   
		return new Personne(this.id,this.nom,this.prenom,this.email,this.tel);
	 
	}

 
	
}
