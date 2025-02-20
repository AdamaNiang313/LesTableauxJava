import entity.Clients;
import entity.Dettes;
import java.util.Scanner;

public class Main {
    private static final int N = 10;
    private static Clients[] clients = new Clients[N];
    private static Scanner sc = new Scanner(System.in);
    private static int idClient;
    public static void main(String[] args) {
        menu();

    }

    public static Clients saisiClient(){
        System.out.println("Saisir un client");
        System.out.println("Nom");
        String nom = sc.nextLine();
        System.out.println("Téléphone");
        String telephone = sc.nextLine();
        System.out.println("Adresse");
        String adresse = sc.nextLine();
        Clients client = new Clients(++idClient,nom,telephone,adresse);
        String rep;
         do {
            System.out.println("Voulez-vous ajouté une dette?");
            rep = sc.next();
            if (rep.compareToIgnoreCase("oui") == 0) {
                Dettes dette = saisiDette();
                client.addDette(dette);
            }
            
        } while (rep.compareToIgnoreCase("oui") == 0 && client.getNombreDettes() < N);

        return client;

    }

    public static Dettes saisiDette(){
        System.out.println("Veuillez saisir le Montant:");
        float montantDette = sc.nextFloat();
        Dettes dette = new Dettes();
        dette.setMontantDette(montantDette);
        dette.setMontantPaye(montantDette);

       return dette;
    }

    public static boolean seachClientByPhone(String telephone){
        Clients clients1 = new Clients(telephone);
        for (int i = 0; i < clients.length; i++) {
            if (clients[i] != null){
                if (clients[i].equals(clients1)){
                    return true;
                }
            }
        }
        return false;
    }

    public static int seachClientByPhonePosition(String telephone){
        Clients clients1 = new Clients(telephone);
        for (int i = 0; i < clients.length; i++) {
            if (clients[i] != null){
                if (clients[i].equals(clients1)){

                    return i;
                }
            }
        }
        return -1;
    }

    public static Clients seachClientByPhoneClient(String telephone){
        Clients clients1 = new Clients(telephone);
        for (int i = 0; i < clients.length; i++) {
            if (clients[i] != null){

                if (clients[i].equals(clients1)){
                    return clients[i];
                }
            }
        }
        return null;
    }

    public static void afficherDettes(Dettes[] dette, int nombreDettes) {
        if (nombreDettes == 0) {
            System.out.println("Ce client n'a pas de dettes.");
        } else {
            System.out.println("nombre de dettes"+nombreDettes);
            for (int i = 0; i < nombreDettes; i++) {
                System.out.println(dette[i].toString());
            }
        }
    }

    public static void ajouterClient(Clients client){
        if (idClient-1 < N){
            clients[idClient-1] = client;
        }else {
            System.out.println("Le tableau est plein");
        }
    }

    public static void afficherClient() {
        if (idClient == 0) {
            System.out.println("Aucun client à afficher.");
        } else {
            for (int i = 0; i < idClient; i++) {
                System.out.println(clients[i].toString());
            }
        }
    }

    public static void menu() {
        int choix;
        do {
            System.out.println("Faire votre choix:");
            System.out.println("1. Ajouter un client avec dette:");
            System.out.println("2. Afficher client:");
            System.out.println("3. Chercher un numéro:");
            System.out.println("4. Ajouter dette à un client:");
            System.out.println("5. Quitter:");
            System.out.println();
            choix = sc.nextInt();
            sc.nextLine(); 
           
    
            switch (choix) {
                case 1:
                    Clients client = saisiClient();
                    
                    ajouterClient(client);
                    break;
                case 2:
                    afficherClient();
                    break;
                case 3:
                    System.out.println("Entrer le numéro à chercher");
                    String tel = sc.next();
                    client = seachClientByPhoneClient(tel);
                    if (client != null) {

                       afficherDettes(client.getDettes(), client.getNombreDettes());
                    }else{
                        System.out.println("Numéro non trouvé");
                    }
                    break;
                case 4:
                    System.out.println("Entrer le numéro à chercher");
                    tel = sc.next();
                    client = seachClientByPhoneClient(tel);
                    if (client != null) {

                        Dettes dette = saisiDette();
                        client.addDette(dette);
                    }else{
                        System.out.println("Numéro non trouvé");
                    }
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        } while (choix != 5);
    }



}