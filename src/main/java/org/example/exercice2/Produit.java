package org.example.exercice2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Produit {
    private long id;
    private String nom;
    private String marque;
    private double prix;
    private String description;
    private int nombreEnStock;

    public Produit(long id, String nom, String marque, double prix, String description, int nombreEnStock) {
        this.id = id;
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
        this.description = description;
        this.nombreEnStock = nombreEnStock;
    }

    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getMarque() {
        return marque;
    }

    public double getPrix() {
        return prix;
    }

    public String getDescription() {
        return description;
    }

    public int getNombreEnStock() {
        return nombreEnStock;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", marque='" + marque + '\'' +
                ", prix=" + prix +
                ", description='" + description + '\'' +
                ", nombreEnStock=" + nombreEnStock +
                '}';
    }
}

interface IMetier<T> {
    void add(T o);
    List<T> getAll();
    T findById(long id);
    void delete(long id);
}

class MetierProduitImpl implements IMetier<Produit> {
    private List<Produit> produits;

    public MetierProduitImpl() {
        this.produits = new ArrayList<>();
    }

    @Override
    public void add(Produit o) {
        produits.add(o);
    }

    @Override
    public List<Produit> getAll() {
        return produits;
    }

    @Override
    public Produit findById(long id) {
        for (Produit produit : produits) {
            if (produit.getId() == id) {
                return produit;
            }
        }
        return null;
    }

    @Override
    public void delete(long id) {
        Produit produit = findById(id);
        if (produit != null) {
            produits.remove(produit);
        }
    }
}

 class Application {
    public static void main(String[] args) {
        MetierProduitImpl metierProduit = new MetierProduitImpl();
        Scanner scanner = new Scanner(System.in);

        int choix;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Afficher la liste des produits.");
            System.out.println("2. Rechercher un produit par son id.");
            System.out.println("3. Ajouter un nouveau produit dans la liste.");
            System.out.println("4. Supprimer un produit par id.");
            System.out.println("5. Quitter ce programme.");
            System.out.print("Entrez votre choix: ");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    afficherListeProduits(metierProduit);
                    break;
                case 2:
                    rechercherProduitParId(scanner, metierProduit);
                    break;
                case 3:
                    ajouterNouveauProduit(scanner, metierProduit);
                    break;
                case 4:
                    supprimerProduitParId(scanner, metierProduit);
                    break;
                case 5:
                    System.out.println("Programme terminé.");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez entrer un nombre entre 1 et 5.");
            }
        } while (choix != 5);
    }

    private static void afficherListeProduits(MetierProduitImpl metierProduit) {
        System.out.println("Liste des produits:");
        for (Produit produit : metierProduit.getAll()) {
            System.out.println(produit);
        }
    }

    private static void rechercherProduitParId(Scanner scanner, MetierProduitImpl metierProduit) {
        System.out.print("Entrez l'id du produit à rechercher: ");
        long id = scanner.nextLong();
        Produit produit = metierProduit.findById(id);
        if (produit != null) {
            System.out.println("Produit trouvé: " + produit);
        } else {
            System.out.println("Aucun produit trouvé avec l'id " + id);
        }
    }

    private static void ajouterNouveauProduit(Scanner scanner, MetierProduitImpl metierProduit) {
        System.out.print("Entrez l'id du nouveau produit: ");
        long id = scanner.nextLong();
        scanner.nextLine();
        System.out.print("Entrez le nom du nouveau produit: ");
        String nom = scanner.nextLine();
        System.out.print("Entrez la marque du nouveau produit: ");
        String marque = scanner.nextLine();
        System.out.print("Entrez le prix du nouveau produit: ");
        double prix = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Entrez la description du nouveau produit: ");
        String description = scanner.nextLine();
        System.out.print("Entrez le nombre en stock du nouveau produit: ");
        int nombreEnStock = scanner.nextInt();

        Produit nouveauProduit = new Produit(id, nom, marque, prix, description, nombreEnStock);
        metierProduit.add(nouveauProduit);
        System.out.println("Nouveau produit ajouté avec succès.");
    }

    private static void supprimerProduitParId(Scanner scanner, MetierProduitImpl metierProduit) {
        System.out.print("Entrez l'id du produit à supprimer: ");
        long id = scanner.nextLong();
        metierProduit.delete(id);
        System.out.println("Produit supprimé avec succès.");
    }
}
