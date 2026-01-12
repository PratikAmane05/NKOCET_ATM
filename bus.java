import java.util.*;
public class bus {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int seats=40;
        String Name;
        System.out.println("Welcome to the Bus Reservation System");
        System.out.print("Enter your name: ");
        Name=sc.nextLine(); 
        System.out.println("Hello, " + Name + "! There are " + seats + " seats available.");
        System.out.print("Do you want to book a seat? (yes/no): "); 
        String response = sc.nextLine();
        if(response.equalsIgnoreCase("yes")) {
            if(seats > 0) {
                seats--;
                System.out.println("Seat booked successfully. Seats remaining: " + seats);
            } else {
                System.out.println("Sorry, no seats available.");
            }
        } else {
            System.out.println("Thank you for visiting the Bus Reservation System.");
        }
        sc.close(); 
    }
}
