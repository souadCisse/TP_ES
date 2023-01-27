package application;

import classes.MetierProduitImpl;
import classes.Produit;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int x ;int chose;Long id ;String nom; String marque; float prix; String description; int nb_stock;
        MetierProduitImpl metier= new MetierProduitImpl();
        FileInputStream fileStream = new FileInputStream("products.dat");
        ObjectInputStream objStream = new ObjectInputStream(fileStream);
        do{
            System.out.println("1.View product list.\n" +
                    "2.Search for a product by its id.\n" +
                    "3.Add a new product to the list.\n" +
                    "4.Delete a product by id.\n" +
                    "5.Save products.\n"+
                    "6.Exit this program.");
            System.out.println("chose a number : ");
            Scanner sc = new Scanner(System.in);
            x= sc.nextInt();
            switch (x){
                case 1:
                    metier.getAll();
                    break;
                case 2:
                    System.out.println("write the is of the product you searching for:");
                    Scanner idSc= new Scanner(System.in);
                    id=idSc.nextLong();
                    metier.findById(id);
                    if (metier.findById(id)==null)System.out.println("product not found!");
                    break;
                case 3:
                    Produit prod = new Produit();

                    System.out.println("entre id :");
                    id = sc.nextLong();
                    prod.setId(id);
                    if(metier.findById(id) != null){
                        System.out.println("Id already exists!");
                        break;
                    }
                    System.out.println("enter the name of the product :");
                    nom = sc.next();
                    prod.setNom(nom);

                    System.out.println("enter the brand :");
                    marque = sc.next();
                    prod.setMarque(marque);

                    System.out.println("enter the price :");
                    prix = sc.nextFloat();
                    prod.setPrix(prix);

                    System.out.println("enter the description :");
                    description = sc.next();
                    prod.setDescription(description);

                    System.out.println("entre the quantity in stock  :");
                    nb_stock = sc.nextInt();
                    prod.setNb_stock(nb_stock);
                    metier.add(prod);
                    break;
                case 4 :
                    System.out.println("enter the id of the product you want to delete :");
                    id = sc.nextLong();
                    metier.delete(id);
                    break;
                case 5 :
                    metier.saveAll();
                    break;
                case 6 :
                    System.out.println("GoodBye!!");
                    break;
                default:
                    System.out.println("please chose a number between 1 and 6 !");
                    break;
            }
        }while (x<=6);
    }
}
