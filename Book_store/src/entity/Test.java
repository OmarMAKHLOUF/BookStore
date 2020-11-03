package entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Test {
private static String choix;
private static ArrayList <Produit> stock ;
private static ArrayList <Personne> users ;
private static ArrayList <Panier> panier ;
private static ArrayList <Integer> item ;

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
 
	for (int i=0;i<users.size();i++)
	{					

		if (id==users.get(i).getId()) {
			System.out.println("welcome "+users.get(i).getPrenom());
			 break;
		}	else  System.out.println("identifiant invalide");
		  break;
	}
}
public static void ajouterPanier(  ) {
	  Scanner scanner = new Scanner( System.in );
	afficheListProduit();
	System.out.println("choisir produit a ajouter dans le panier  "); 
	int id = scanner.nextInt();
	System.out.println("donner qte desiré  "); 
	int qte = scanner.nextInt();
	for (int i=0;i<=stock.size();i++) {
		if(id==stock.get(i).getId()) {
				if(qte<=  stock.get(i) .getQte_stock() ) {
					int qte_stock=stock.get(i).getQte_stock();
				}
				 
				item.add(stock.get(i).getId(),qte);
		 
 
	}
	}
}


public static void main(String[] args) {
		//Panier panier =new Panier();
		stock =new ArrayList <Produit>();
		users =new ArrayList <Personne>();
		panier =new ArrayList <Panier>();
		item =new ArrayList <Integer>();

	do {
		  
		  Scanner scanner = new Scanner( System.in );
		  System.out.println("entre 1 pour admin  ");
		  System.out.println("entre 2 pour user  ");
		  choix = scanner.next();
		  

		  if ( choix.charAt(0) == '1') {do {
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
			  case '9': System.out.println("afficher commande passer par user");
			  break;
			  case '0': System.out.println("connectez vous ");
			  break;
			  }
		  }while(choix.charAt(0) !='0');
  
		  }
		  else if ( choix.charAt(0) =='2') {do {
			   
			   
			  System.out.println("bienvenu dans votre espace  user  ");
			  System.out.println(  
					  	"\n 1: afficher produits"
				  		+ "\n 2: ajouter produit au panier"
				  		+ "\n 3: modifier quantité de produit dans  panier"
				  		+ "\n 4: supprimer produit dans  panier"
				  		+ "\n 5: recherche  Produit par designation"
				  		+ "\n 6: passer commande"
				  		+ "\n 0: deconecté ");
			  choix = scanner.next();
			  switch(choix.charAt(0)) {
			  case '1': afficheListProduit();
			  break;
			  case '2': System.out.println("ajouter produit au panier");
			  break;
			  case '3': System.out.println("modifier quantité de produit dans  panier");
			  break;
			  case '4': System.out.println("supprimer produit dans  panier");
			  break;
			  case '5': { rechercheProduit( ); };
			  break;
			  case '6': System.out.println("passer commande");
			  break;
			  case '0': System.out.println("connectez vous");
			  break;
 
			  }
		  
		  
		  }while(choix.charAt(0) !='0');}
}while(true);
		 
	
	
	
	
	
	
	
	
	}

}
