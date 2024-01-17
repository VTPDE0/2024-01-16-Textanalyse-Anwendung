package org.example;

// dank * (Sternchen) importieren wir hier alle Klassen, Schnittstellen und Enumerationen, die sich im java.util-Paket befinden.
// Das schließt Map, HashMap und viele andere nützliche Klassen ein.
//also z.B. extra java.util.Map muss ich nicht importieren, es ist schon dabei
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Gib einen Text ein (Tippe 'exit' zum Beenden):");

        // _______________________Benutzerangaben-Leser_______________________
        // nextLine(): Diese Methode liest die gesamte Eingabe bis zum Zeilenende (bis der Benutzer Enter drückt).
        // dank nextLine sie erfasst eine vollständige Zeile, unabhängig davon, wie viele Wörter oder Zeichen sie enthält.
        String text = scanner.nextLine();

        // _______________________Beenden des Programms, wenn der Benutzer "exit" schreibt_______________________
        // text.equalsIgnoreCase("exit") überprüft,
        // ob der Inhalt von text (unabhängig von der Groß- und Kleinschreibung) gleich dem String "exit" ist
        if(text.equalsIgnoreCase("exit")) {
            System.out.println("Programm beendet.");
            return;
        }

        // _______________________Zeichenzählung_______________________
        // Die Methode length() gibt die Länge des Strings text zurück
        int zeichenAnzahl = text.length();

        // Wort_______________________Wortzählung_______________________
        // Hier wird ein Array von Strings deklariert
        // .split(" "): Diese Methode ist ein Teil der String-Klasse in Java und wird verwendet, um einen String in mehrere Teile zu teilen.
        String[] worte = text.split(" ");
        // .length (ohne Klammern) ist eine Eigenschaft von Arrays in Java, die die Anzahl der Elemente im Array angibt.
        int wortAnzahl = worte.length;
        // Das Ergebnis ist ein Array von Strings, wobei jedes Element ein Wort aus dem ursprünglichen Text ist.

        // _______________________Durchschnittliche Wortlänge_______________________
        // Hier definiere ich eine Variable gesamtWortlänge, um die Gesamtlänge aller Wörter zu speichern.
        // Sie wird zu Beginn auf 0 gesetzt.
        int gesamtWortlänge = 0;
        // for-Schleife, die jedes Element im Array worte durchläuft
        for(String wort : worte) {
            // Operator += hinzufügt aktuelle Länge des Wortes zur Gesamtsumme gesamtWortlänge
            gesamtWortlänge += wort.length();
        }
        // Gesamtlänge aller Wörter durch die Anzahl der Wörter geteilt wird und in double durchschnittlicheWortlänge gespeichert wird
        double durchschnittlicheWortlänge = gesamtWortlänge / (double)wortAnzahl;

        // _______________________Häufigstes Wort_______________________
        // Hier definieren wir eine Map. Der Schlüssel ist vom Typ String (für Wörter) und der Wert vom Typ Integer (für deren Häufigkeiten)
        // wortHäufigkeit: Der Name unserer Map. Es ist eine Variable.
        // Erstellt eine neue Instanz einer HashMap
        Map<String, Integer> wortHäufigkeit = new HashMap<>();
        // hier ist for Schleife, die zur Iteration über eine HashMap verwendet wird
        // String wort deklariert eine Variable wort vom Typ String, die in jedem Durchlauf der Schleife den Wert eines Elements aus dem Array worte annimmt.
        for(String wort : worte) {

            // getOrDefault gibt den Wert für den gegebenen Schlüssel (wort) zurück. Falls der Schlüssel in der Map nicht existiert, wird der Standardwert 0 zurückgegeben
            // + 1 Erhöht die Häufigkeit des Wortes um 1. Dies bedeutet, dass bei jedem Vorkommen eines Wortes in worte seine Zählung in der Map um eins erhöht wird
            wortHäufigkeit.put(wort, wortHäufigkeit.getOrDefault(wort, 0) + 1);
        }
        // = "" initialisiert die Variable mit einem leeren String. Das bedeutet, dass zu Beginn noch kein Wort als das häufigste identifiziert war
        String häufigstesWort = "";
        // Variable maxHäufigkeit maximale Häufigkeit eines Wortes speichert
        // dann ich initialisiere Variable mit dem Wert 0
        int maxHäufigkeit = 0;
        // for-each-Schleife, die über jedes Schlüssel-Wert-Paar in der Map wortHäufigkeit iteriert
        // Map.Entry repräsentiert ein Schlüssel-Wert-Paar in einer Map.
        // jedes solche Objekt kann verwendet werden, um auf den Schlüssel und den dazugehörigen Wert in der Map zuzugreifen.
        // wortHäufigkeit.entrySet() ruft eine Menge von Map-Einträgen ab
        for(Map.Entry<String, Integer> eintrag : wortHäufigkeit.entrySet()) {
            // hier if überprüft, ob der Wert des aktuellen Eintrags größer als die bisher größte Häufigkeit ist.
            if(eintrag.getValue() > maxHäufigkeit) {
                // weist das aktuelle Wort als das häufigste zu, wenn es die Bedingung erfüllt.
                häufigstesWort = eintrag.getKey();
                // aktualisiert die maximale Häufigkeit mit dem Wert des aktuellen Eintrags.
                maxHäufigkeit = eintrag.getValue();
            }
        }

        // _______________________Ausgabe der Ergebnisse_______________________
        System.out.println("Anzahl der Zeichen: " + zeichenAnzahl);
        System.out.println("Anzahl der Wörter: " + wortAnzahl);
        System.out.println("Durchschnittliche Wortlänge: " + durchschnittlicheWortlänge);
        System.out.println("Häufigstes Wort: '" + häufigstesWort + "' mit " + maxHäufigkeit + " Vorkommen");
        scanner.close();
    }
}
