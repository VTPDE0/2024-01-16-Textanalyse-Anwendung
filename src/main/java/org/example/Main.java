package org.example;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Gib einen Text ein (Tippe 'exit' zum Beenden):");

        String text = scanner.nextLine();

        // Beenden des Programms, wenn der Benutzer "exit" eingibt
        if(text.equalsIgnoreCase("exit")) {
            System.out.println("Programm beendet.");
            return;
        }

        // Zeichenzählung
        int zeichenAnzahl = text.length();


        // Ausgabe der Ergebnisse
        System.out.println("Anzahl der Zeichen: " + zeichenAnzahl);

        scanner.close();
    }
}
