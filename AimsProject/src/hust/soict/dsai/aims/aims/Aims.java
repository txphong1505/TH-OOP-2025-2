package hust.soict.dsai.aims.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;
import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        initSampleData();
        showMenu();
    }

    private static void initSampleData() {
        store.addMedia(new DigitalVideoDisc(1, "The Lion King", "Animation", "Roger Allers", 89, 19.95f));
        store.addMedia(new Book(2, "Java Programming", "Education", 29.99f));
        CompactDisc cd = new CompactDisc(3, "Thriller", "Pop", "Quincy Jones", "Michael Jackson", 15.5f);
        cd.addTrack(new Track("Billie Jean", 5));
        cd.addTrack(new Track("Beat It", 4));
        store.addMedia(cd);
    }

    public static void showMenu() {
        while (true) {
            System.out.println("AIMS: ");
            System.out.println("--------------------------------");
            System.out.println("1. View store");
            System.out.println("2. Update store");
            System.out.println("3. See current cart");
            System.out.println("0. Exit");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2-3: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: viewStoreMenu(); break;
                case 2: updateStoreMenu(); break;
                case 3: viewCartMenu(); break;
                case 0: System.out.println("Goodbye!"); return;
                default: System.out.println("Invalid option.");
            }
        }
    }

    private static void viewStoreMenu() {
        store.print();
        while (true) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. See a media's details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2-3-4: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) return;
            System.out.print("Enter media title: ");
            String title = scanner.nextLine();
            Media media = store.searchByTitle(title);
            if (media == null) {
                System.out.println("Media not found.");
                continue;
            }
            switch (choice) {
                case 1: System.out.println(media.toString()); break;
                case 2: cart.addMedia(media); break;
                case 3: 
                    if (media instanceof Playable) ((Playable) media).play();
                    else System.out.println("This media cannot be played.");
                    break;
                case 4: cart.print(); break;
                default: System.out.println("Invalid option.");
            }
        }
    }

    private static void updateStoreMenu() {
        System.out.println("1. Add media to store");
        System.out.println("2. Remove media from store");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        if (choice == 1) {
            store.addMedia(new Book((int)(Math.random()*1000), title, "General", 10.0f));
        } else if (choice == 2) {
            Media media = store.searchByTitle(title);
            if (media != null) store.removeMedia(media);
        }
    }

    private static void viewCartMenu() {
        cart.print();
        while (true) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Filter medias in cart");
            System.out.println("2. Sort medias in cart");
            System.out.println("3. Remove a media from cart");
            System.out.println("4. Play a media");
            System.out.println("5. Place order");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2-3-4-5: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) return;
            switch (choice) {
                case 1:
                    System.out.println("1. By ID");
                    System.out.println("2. By Title");
                    int filterChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (filterChoice == 1) {
                        System.out.print("Enter ID: ");
                        System.out.println(cart.searchById(scanner.nextInt()));
                    } else {
                        System.out.print("Enter Title: ");
                        System.out.println(cart.searchByTitle(scanner.nextLine()));
                    }
                    break;
                case 2:
                    System.out.println("1. By Title");
                    System.out.println("2. By Cost");
                    int sortChoice = scanner.nextInt();
                    if (sortChoice == 1) cart.sortByTitle();
                    else cart.sortByCost();
                    cart.print();
                    break;
                case 3:
                    System.out.print("Enter Title to remove: ");
                    Media m = cart.searchByTitle(scanner.nextLine());
                    if (m != null) cart.removeMedia(m);
                    break;
                case 4:
                    System.out.print("Enter Title to play: ");
                    Media p = cart.searchByTitle(scanner.nextLine());
                    if (p instanceof Playable) ((Playable) p).play();
                    else System.out.println("Cannot play this item.");
                    break;
                case 5:
                    System.out.println("Order has been placed successfully!");
                    cart.clear();
                    return;
            }
        }
    }
}