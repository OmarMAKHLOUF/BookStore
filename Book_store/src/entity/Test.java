package entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

public class Test {
private static String choix;
private static ArrayList <Produit> stock ;
private static ArrayList <Personne> users ;
private static ArrayList <Commande> commandes ;

private static Panier panier ;
private static int id_user;
//methods
public static void afficheListProduit ( ) {Produit p = new Produit(); 
	for (int i=0;i<stock.size();i++)
	{  System.out.println(stock.get(i).afficheProduit());
	}
 }
public static void afficheListUsers ( ) {User u = new User(); 
for (int i=0;i<users.size();i++) {
		System.out.println(users.get(i).afficheUser());
 }
}
public static void ModifierUser() {
	Scanner scanner = new Scanner( System.in );

	System.out.println("saisir id user à modifier  "); 
	int id = scanner.nextInt();
	for (int i=0;i<users.size();i++)
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

	}
	
}
public static void ModifierProduit() {
	Scanner scanner = new Scanner( System.in );

	System.out.println("saisir id Produit à modifier  "); 
	int id = scanner.nextInt();
	for (int i=0;i<stock.size();i++)
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

	}
	
}
public static void rechercheProduit ( ) {
Scanner scanner = new Scanner( System.in );

	System.out.println("saisir designation produit  "); 
	String des = scanner.nextLine();
 
	for (int i=0;i<stock.size();i++)
	{					

		if (des.toString().equals(stock.get(i).getDesignation().toString())) {
 
			  System.out.println(
			 			 stock.get(i).afficheProduit()
			 			 );
		}	else  System.out.println("produit introuvable");

	}
}
public static void supprimerUser ( ) {
Scanner scanner = new Scanner( System.in );

	System.out.println("saisir id User à supprimer"); 
	int id = scanner.nextInt();
	Personne p = new Personne(); 

	for (int i=0;i<users.size();i++)
	{
		if (id== users.get(i).getId()) {
			 users.remove(i);
			System.out.println("user  supprimer");
		}
	}
}
public static void supprimerProduit ( ) {

	Scanner scanner = new Scanner( System.in );

	System.out.println("saisir id produit à supprimer"); 
	int id = scanner.nextInt();
	Produit p = new Produit(); 

	for (int i=0;i<stock.size();i++)
	{
		if (id== stock.get(i).getId()) {
			 stock.remove(i);
			System.out.println("produit  supprimer");
		}
	}
}
public static  void rechercheUser ( ) {
Scanner scanner = new Scanner( System.in );

System.out.println("introduit votre identifiant   "); 
int id = scanner.nextInt();
 id_user=id;
	for (int i=0;i<=users.size();i++)
	{					

		if (id==users.get(i).getId()) {
			System.out.println("welcome "+users.get(i).getPrenom());
			 return;
		}	  	}
	System.out.println("identifiant invalide");
}
public static void ajouterPanier(  ) {
	  Scanner scanner = new Scanner( System.in );
	afficheListProduit();
	System.out.println("choisir produit a ajouter dans le panier  "); 
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
	}
}
public static void afficher_panier ( ) {
	System.out.println(" prix total: "+ panier.getPrix_sous_total()+"\n -------------\n" );

	for (int i=0;i<panier.getItem().size();i++)
{  
		System.out.print("Produit: "+panier.getItem().get(i).getDesignation());
		System.out.print(" quantité: "+ panier.getQte().get(i).toString());
		System.out.println("\n ");

}
}
public static void passer_commande() {
	afficher_panier(); 
	Scanner scanner = new Scanner( System.in );
	   
	  System.out.println("confirmez vous la commande ? "+"\n"+"1:oui    0:non  ");
	  int decision = scanner.nextInt();
	  if (decision==1) {
			Date date_cmd =new Date();
			 
			int prix = panier.getPrix_sous_total();
		 Commande c =new Commande( date_cmd, prix,panier, id_user);
		 System.out.println(c.toString());
		 commandes.add(c);
		 System.out.println("merci pour votre confiance  ");

	  }else afficher_panier();
}


public static void main(String[] args) {
	try {
		//Panier panier =new Panier();
		stock =new ArrayList <Produit>();
		users =new ArrayList <Personne>();
		commandes =new ArrayList <Commande>();
        Personne admin =new Personne(1997,"admin","admin","admin@gmail.com",53525313);
		panier =new Panier();
		int  id_user;

	do {
		  
		  Scanner scanner = new Scanner( System.in );
		  System.out.println("entre 1 pour admin  ");
		  System.out.println("entre 2 pour user  ");
		  choix = scanner.next();
		  

		  if ( choix.charAt(0) == '1') {do {
			   scanner = new Scanner( System.in );

			  System.out.println("Donner votre login"); 
			  String login = scanner.next();
	
			  if(login.toString().equals(admin.getNom())) {
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
			  }
			  else {
				  System.out.println("Login incorrect");

				  choix="0";
			  }
			  switch(choix.charAt(0)) {
			  case '1': afficheListUsers();
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
			  case '5': {
				  Produit p =new Produit();
				  afficheListProduit();
 			  };
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
			  case '9': {
				  for (int i=0;i<commandes.size();i++)
					{  
					  System.out.println(commandes.get(i).toString());
					}
			  }
			  break;
			  case '0': System.out.println("connectez vous ");
			  break;
			  }
		  }while(choix.charAt(0) !='0');
  
		  }
		  else if ( choix.charAt(0) =='2') {
			  rechercheUser();
			  do {
			   System.out.println("bienvenu dans votre espace  user  ");
			  System.out.println(  
					  	"\n 1: afficher produits"
				  		+ "\n 2: ajouter produit au panier"
				  		+ "\n 3: Afficher panier"
 				  		+ "\n 4: recherche  Produit par designation"
				  		+ "\n 5: passer commande"
				  		+ "\n 0: deconecté ");
			  choix = scanner.next();
			  switch(choix.charAt(0)) {
			  case '1': afficheListProduit();
			  break;
			  case '2': ajouterPanier();
			  break;
			  case '3': afficher_panier();
			  break;
			   
			  case '4': rechercheProduit( ); 
			  break;
			  case '5': passer_commande();
			  break;
			  case '0': System.out.println("connectez vous");
			  break;
 
			  }
		  
		  
		  }while(choix.charAt(0) !='0');}
}while(true);
		 
	
	
	
	
	
	}
	catch(Exception e ) {
		System.out.print("erreur");
	}
	
	
	}

}
