package entity;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class Test {
private static String choix;
private static ArrayList <Produit> stock ;
private static ArrayList <Personne> users ;
private static ArrayList <Commande> commandes ;

private static Panier panier ;
private static int id_user;



//methods
 
public static int getId_user() {
	return id_user;
}
public static void setId_user(int id_user) {
	Test.id_user = id_user;
}


//////////////////////////////
public static void afficheCommande() throws ClassNotFoundException, SQLException 
{   	MyConnection c=new MyConnection();
 
try {
	java.sql.PreparedStatement istmt = c.c.prepareStatement("SELECT  id_cmd,date_cmd, prix_totalfinal, prenom  FROM commande c, personne u, panier p where c.id_panier in (select p.id from panier where p.id_personne in (select u.id from personne))"); 
	ResultSet rs = (ResultSet) istmt.executeQuery();
	int i=0;
	while (rs.next()) {
	    i++;
    System.out.println("commande n° "+i);
    System.out.println("la commande : " + rs.getString("id_cmd")+" passer le "+rs.getString("date_cmd")+" avec prix total "+rs.getString("prix_totalfinal")+" dinars de la part de client "+ rs.getString("prenom"));
    
}}
catch(SQLException e)
{e.printStackTrace();}



 }
/////////////////////////////////
public static void ModifierUser() throws ClassNotFoundException {
	Scanner scanner = new Scanner( System.in );
 	try {
	MyConnection c=new MyConnection();
	Statement istmt=c.c.createStatement();
	System.out.println("saisir id user à modifier  "); 
	int id = scanner.nextInt();
	  System.out.println("saisir nom");
	  String nom = scanner.next();
	  System.out.println("saisir prenom");
	  String prenom = scanner.next();
	  System.out.println("saisir email");
	  String email = scanner.next( );
	  System.out.println("saisir tel");
	 int tel = scanner.nextInt();
	 
 	 String req=" UPDATE personne SET nom ='"+ nom+"' ,prenom = '"+prenom+"', email= '"+email+"', tel= "+tel+" where id="+id;
 	int n = istmt.executeUpdate(req); 
	if(n!=0) 
		{
			System.out.println(" user updated  "); 
		}
	else 
		{
			System.out.println("cant find this id user  "); 
		}
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	} 	
 
	
	////////////////////////////////////////////////////
	/*for (int i=0;i<users.size();i++)
	{					
		if ( id== users.get(i).getId()) 
		{
			System.out.println("user trouver vous pouvez le changer "); 

			System.out.println("changer id user  "); 
			int idd = scanner.nextInt();
			users.get(i).setId(idd);
			
			System.out.println("changer nom user  "); 
			String nomm = scanner.next();
			users.get(i).setNom(nomm);
			
			System.out.println("changer prenom user  "); 
			String prenom = scanner.next ();
			users.get(i).setPrenom(prenom);
			
			System.out.println("changer email user  "); 
			String email = scanner.next ();
			users.get(i).setEmail(email);
			
			System.out.println("changer tel user  "); 
			int tel = scanner.nextInt();
			users.get(i).setTel(tel);
			 
			
		}	else  System.out.println("user introuvable");

	}*/
	
}
public static void ModifierProduit() throws ClassNotFoundException {
	Scanner scanner = new Scanner( System.in );

  	try {
		MyConnection c=new MyConnection();
		Statement istmt=c.c.createStatement();
		System.out.println("saisir id produit à modifier  "); 
		int id = scanner.nextInt();
		  System.out.println("saisir designation");
		  String designation = scanner.next();
		  System.out.println("saisir description");
		  String description = scanner.next();
		  System.out.println("saisir date release");
		  String date_relase = scanner.next( );
		  System.out.println("saisir prix unite");
		 int prixuni = scanner.nextInt();
		 System.out.println("saisir quantite stock");
		 int qte_stock = scanner.nextInt();
		 
		 
	 	 String req=" UPDATE book SET designation ='"+designation+"' ,description = '"+description+"', date_relase= '"+date_relase+"', prixuni= "+prixuni+" ,qte_stock ="+qte_stock+" where id="+id;
	 	int n = istmt.executeUpdate(req); 
		if(n!=0) 
			{
				System.out.println(" book updated  "); 
			}
		else 
			{
				System.out.println("cant find this book  "); 
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		} 	
	////////////////////////////////////////////////////////////////////
	/*for (int i=0;i<stock.size();i++)
	{					
		if ( id== stock.get(i).getId()) 
		{
			System.out.println("Produit trouver vous pouvez le changer "); 

			System.out.println("changer id produit  "); 
			int idd = scanner.nextInt();
			stock.get(i).setId(idd);
			
			System.out.println("changer Designation produit  "); 
			String des = scanner.next();
			stock.get(i).setDesignation(des);
			
			System.out.println("changer description produit  "); 
			String descri = scanner.next ();
			stock.get(i).setDescription(descri);
			
			System.out.println("changer prix produit  "); 
			int prix = scanner.nextInt ();
			stock.get(i).setPrixuni(prix);
			
			System.out.println("changer quantité produit  "); 
			int qte = scanner.nextInt();
			stock.get(i).setQte_stock(qte);
			 
			
		}	else  System.out.println("produit introuvable");

	}*/
	
}
public static void rechercheProduit ( ) throws ClassNotFoundException {
	Scanner scanner = new Scanner( System.in );

	System.out.println("saisir identifiant  produit  "); 
	int id = scanner.nextInt();
 
	try {
		MyConnection c=new MyConnection();
		java.sql.PreparedStatement istmt = c.c.prepareStatement("SELECT * FROM Book where id= "+id+""); 
	ResultSet rs = (ResultSet) istmt.executeQuery();
	int i=0;
	while (rs.next()) {
	    i++;
	    System.out.println("Book n° "+i);
	    System.out.println("id : " + rs.getString("id"));
	    System.out.println("designation : " + rs.getString("designation"));
	    System.out.println("description : " + rs.getString("description"));
	    System.out.println("date_relase : " + rs.getString("date_relase"));
	    System.out.println("prixuni: " + rs.getString("prixuni"));
	    System.out.println("qte_stock: " + rs.getString("qte_stock"));
	}}
	catch(SQLException e)
	{
		e.printStackTrace();
		System.out.println("cant find this book  "); 

	}

}
public static void supprimerUser ( ) throws ClassNotFoundException {
	/*Scanner scanner = new Scanner( System.in );
	System.out.println("saisir id User à supprimer"); 
	int id = scanner.nextInt();
	Personne p = new Personne(); 

	for (int i=0;i<users.size();i++)
	{
		if (id== users.get(i).getId()) {
			 users.remove(i);
			System.out.println("user  supprimer");
		}
	}*/
	
	try {
		Scanner scanner = new Scanner( System.in );

		System.out.println("saisir id utilisateur à supprimer"); 
		int id = scanner.nextInt();
		MyConnection c=new MyConnection();
		Statement istmt=c.c.createStatement();

		int n = istmt.executeUpdate("delete  FROM personne where id= "+id); 
		if(n!=0) 
			{
				System.out.println(" user deleted  "); 
			}
		else 
			{
				System.out.println("cant find this id user  "); 
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		} 	
}
public static void supprimerProduit ( ) throws ClassNotFoundException {

	
	/*Produit p = new Produit(); 

	for (int i=0;i<stock.size();i++)
	{
		if (id== stock.get(i).getId()) {
			 stock.remove(i);
			System.out.println("produit  supprimer");
		}
	}*/
	try {
		Scanner scanner = new Scanner( System.in );

		System.out.println("saisir id produit à supprimer"); 
		int id = scanner.nextInt();
		MyConnection c=new MyConnection();
		Statement istmt=c.c.createStatement();

		int n = istmt.executeUpdate("delete  FROM Book where id= "+id); 
		/*ResultSet rs = (ResultSet) istmt.executeQuery();
	int i=0;
	while (rs.next()) {
	    i++;
	    System.out.println("Book n° "+i);
	    System.out.println("id : " + rs.getString("id"));
	    System.out.println("designation : " + rs.getString("designation"));
	    System.out.println("description : " + rs.getString("description"));
	    System.out.println("date_relase : " + rs.getString("date_relase"));
	    System.out.println("prixuni: " + rs.getString("prixuni"));
	    System.out.println("qte_stock: " + rs.getString("qte_stock"));
	}*/
		if(n!=0) {
	System.out.println(" book deleted  "); 
		}else {
			System.out.println("cant find this book  "); 

		}
	}
	catch(SQLException e)
	{
		e.printStackTrace();

	} 



	 
}
public static  void rechercheUser ( ) throws ClassNotFoundException {
Scanner scanner = new Scanner( System.in );

System.out.println("introduit votre identifiant   "); 
int id = scanner.nextInt();
 id_user=id;
	/*for (int i=0;i<=users.size();i++)
	{					

		if (id==users.get(i).getId()) {
			System.out.println("welcome "+users.get(i).getPrenom());
			 return;
		}	  	}
	System.out.println("identifiant invalide");*/
 
 try {
		MyConnection c=new MyConnection();
		java.sql.PreparedStatement istmt = c.c.prepareStatement("SELECT * FROM personne where id= "+id+""); 
	ResultSet rs = (ResultSet) istmt.executeQuery();
	 
	while (rs.next()) {
						System.out.println("id : " + rs.getString("id"));
						System.out.println("nom : " + rs.getString("nom"));
						System.out.println("prenom : " + rs.getString("prenom"));
						System.out.println("email : " + rs.getString("email"));
						System.out.println("tel: " + rs.getString("tel"));
 					}
	}
	catch(SQLException e)
	{
		e.printStackTrace();
		System.out.println("cant find this user  "); 

	}
 
}

// To Doooooooooooo
public static void ajouterPanier(  ) throws ClassNotFoundException, SQLException {
	  Scanner scanner = new Scanner( System.in );
	   Produit.afficheProduit2();
	   /*System.out.println("choisir produit a ajouter dans le panier  "); 
	int id = scanner.nextInt();
	System.out.println("donner qte desiré  "); 
	int qte = scanner.nextInt();
	for (int i=0;i<stock.size();i++) {
		if(id==stock.get(i).getId()) {
				if(qte<=  stock.get(i).getQte_stock() ) {
					//int qte_stock=stock.get(i).getQte_stock();
					panier.ajouter_au_panier(stock.get(i),qte);
				}
				else {
					System.out.println("Out of stock"); 
				}
			}
	}*/
 	System.out.println("choisir produit a ajouter dans le panier  "); 
    Scanner sc1 = new Scanner( System.in );
    int idBook   = sc1.nextInt();
	System.out.println("donner qte desiré  "); 
    Scanner sc2 = new Scanner( System.in );
    int quantite   = sc2.nextInt();
     try {
    	 MyConnection c=new MyConnection();
     PreparedStatement pstmt,stmt;
    	 pstmt =  (PreparedStatement) c.c.prepareStatement("INSERT INTO item (id_produit,qte) VALUES ("+idBook+","+quantite+")");
    	 	//pstmt.setNString(1, null  );
     	    //pstmt.setInt(1, idBook  );
    	     //pstmt.setInt(2, quantite );
    	     pstmt.executeUpdate();
    	     String query = "Select * from item";
    	     ResultSet rs = (ResultSet) pstmt.executeQuery(query);
    	     rs.last();
    	     String query2 = "Select prixuni from book where id="+idBook;
    	     ResultSet rs2 = (ResultSet) pstmt.executeQuery(query2);
     	      System.out.print("ID: "+rs.getInt("ID")+", ");
     	      int prix_total =rs2.getInt("prixuni")*rs.getInt("qte");
    	     
    	     pstmt =  (PreparedStatement) c.c.prepareStatement("INSERT INTO panier (id_item,prix_total,id_personne) VALUES ( "+rs.getInt("id_item")+","+prix_total+","+getId_user()+")");
     	    //pstmt.setNString(1, null );
     	    //pstmt.setInt(2,rs.getInt("id_item")  );
     	     //pstmt.setInt(3, prix_total );
     	    //pstmt.setInt(4, getId_user() );
     	     pstmt.executeUpdate();
     	    System.out.println("addition with success");
    	    
             
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
}
public static void afficher_panier ( int id_user) throws ClassNotFoundException {
	System.out.println(" prix total: "+ panier.getPrix_sous_total()+"\n -------------\n" );
/*
	for (int i=0;i<panier.getItem().size();i++)
{  
		System.out.print("Produit: "+panier.getItem().get(i).getDesignation());
		System.out.print(" quantité: "+ panier.getQte().get(i).toString());
		System.out.println("\n ");

}*/
	

	try {
		MyConnection c=new MyConnection();
		java.sql.PreparedStatement istmt = c.c.prepareStatement("select designation , qte , prix_total from panier p, item i, book b where p.iditem in ( select * from item) and p.id =i.id_panier and i.id_produit = b.id and p.id_personne ="+getId_user());
				 
	ResultSet rs = (ResultSet) istmt.executeQuery();
	int i=0;
	while (rs.next()) {
	     
	     
	    System.out.println("designation : " + rs.getString("designation"));
	    System.out.println("qte desire: " + rs.getString("qte"));
	    System.out.println("prix_total: " + rs.getString("prix_total"));
	     
	}}
	catch(SQLException e)
	{
		e.printStackTrace();
		System.out.println("cant find this book  "); 

	}
}
public static void passer_commande() {
	//afficher_panier(); 
	Scanner scanner = new Scanner( System.in );
	   
	  System.out.println("confirmez vous la commande ? "+"\n"+"1:oui    0:non  ");
	  int decision = scanner.nextInt();
	  if (decision==1) {
			Date date_cmd =new Date();
			 
			//int prix = panier.getPrix_sous_total();
		// Commande c =new Commande( date_cmd, prix,panier, id_user);
		// System.out.println(c.toString());
		 //commandes.add(c);
		 System.out.println("merci pour votre confiance  ");

	  }//else afficher_panier();
}
///////////////

public static void main(String[] args) {
	try {
	 
        Personne admin =new Personne(1997,"admin","admin","admin@gmail.com",53525313);
		panier =new Panier();
		int  id_user;
		MyConnection c=new MyConnection();
		// choisir l'interface admin ou client 
		do { 
		  Scanner scanner = new Scanner( System.in );
		  System.out.println("entre 1 pour admin  ");
		  System.out.println("entre 2 pour user  ");
		  choix = scanner.next();
		  //en cas choix admin
		  if ( choix.charAt(0) == '1') 
		  	 {			
			   scanner = new Scanner( System.in );
               Object login;
               //verification de login de l'administrateur
               do {
            	   System.out.println("Donner votre login"); 
            	   login = scanner.next();
            	   //en cas de login faux il retour pour choisir interface admin ou client 
            	   if(!login.toString().equals(admin.getNom()))
            	   	   {
            		   System.out.println("Login incorrect");
            		   choix="0";
            		   break;
            	   	   }
                   }while(!login.toString().equals(admin.getNom()));
               //en cas login vrie
			  if(login.toString().equals(admin.getNom())) {

			do {
 			  System.out.println("bienvenu dans votre espace  admin  "
			  		+ "\n 1: afficher user"
			  		+ "\n 2: ajouter user"
			  		+ "\n 3: Modifier user"
			  		+ "\n 4: supprimer user"
			  		+ "\n 5: afficher Produit"
			  		+ "\n 6: ajouter Produit"
			  		+ "\n 7: Modifier Produit"
			  		+ "\n 8: supprimer Produit"
			  		+ "\n 9: afficher commande passer par user"
			  		+ "\n 0: deconecté");
			  choix = scanner.next();
			  
		
			  switch(choix.charAt(0)) {
			  case '1': Personne.afficheUser2();
			  break;
			  case '2': {Personne u =new Personne();
			  u.creerPersonne();
			  users.add(u);	
				  break;	  
			  }
			  case '3': ModifierUser();
			  break;
			  case '4': supprimerUser();
			  break;
			  case '5': {Produit.afficheProduit2(); };
			  break;
			  case '6': {
				  Produit p =new Produit();
				  p.creer();
				  stock.add(p);	
 				  break;			  
			  }
			  case '7': ModifierProduit();
			  break;
			  case '8': { supprimerProduit( ); };
			  break;
			  case '9': {afficheCommande();
				   
			  }
			  break;
			  case '0': System.out.println("connectez vous ");
			  break;
			  }
		  }while(choix.charAt(0) !='0');
			  }
		  }
		  else if ( choix.charAt(0) =='2') {
			  rechercheUser();
			  do {
			   System.out.println("bienvenu dans votre espace  user  ");
			  System.out.println(  
					  	"\n 1: afficher produits"
				  		+ "\n 2: ajouter produit au panier"
				  		+ "\n 3: Afficher panier"
 				  		+ "\n 4: recherche  Produit par id"
				  		+ "\n 5: passer commande"
				  		+ "\n 0: deconecté ");
			  choix = scanner.next();
			  switch(choix.charAt(0)) {
			  case '1': Produit.afficheProduit2();
			  break;
			  case '2': ajouterPanier();
			  break;
			  case '3': afficher_panier(getId_user());
			  break;
			   
			  case '4': rechercheProduit( ); 
			  break;
			  case '5': passer_commande();
			  break;
			  case '0': System.out.println("connectez vous");
			  break;
 
			  }
		  
		  
		  }while(choix.charAt(0) !='0');
			  
		  }
				}while(true);

	
	}
	catch(Exception e ) {
		System.out.print("erreur");
	}
	
	
	}

}
