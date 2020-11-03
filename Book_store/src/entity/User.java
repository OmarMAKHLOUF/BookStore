package entity;

public class User  extends Personne{
private String role ="user";

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}

public User() {
	super();
	// TODO Auto-generated constructor stub
}

public User(int id, String nom, String prenom, String email, int tel,String role) {
	super(id, nom, prenom, email, tel);
	this.role=role;
 }

 


}
