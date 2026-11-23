/*
Kod bazowy programu Commit4_0: 
• Program dodaje do prostej bazy danych (pliku db.txt) dane odnośnie Studentów.
• Studenci dodawani są w klasie Main.
• Wszyscy studenci są wypisywani na końcu klasy Main.
• Klasa Service obsługuje odczyt i zapis do pliku bazy danych.
• Klasa Student reprezentuje pojedynczego studenta (Imię, Wiek).
*/

import java.io.IOException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    try {
      Service s = new Service();
      Scanner scanner = new Scanner(System.in);
      boolean running = true;
      
      while (running) {
        System.out.println("\nWybierz opcję:");
        System.out.println("1 - Dodaj nowego studenta:");
        System.out.println("2 - Wypisz wszystkich studentów:");
        System.out.println("0 - Wyjście");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice){
          case 1:
            System.out.print("Podaj imię: ");
            String name = scanner.nextLine();
            System.out.print("Podaj wiek: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            s.addStudent(new Student(name, age));
            System.out.println("Dodano studenta.");
            break;

          case 2:
            var students = s.getStudents();
            for (Student current : students){
              System.out.println(current.ToString());
            }
            break;

          case 0:
            running = false;
            break;

          default:
            System.out.println("Nieznana opcja.");
        }
      }
      scanner.close();
     
    } catch (IOException e) {
      System.out.println("Blad operacji na pliku: ");

    }
  }
}