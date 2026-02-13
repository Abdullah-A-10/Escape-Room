import java.util.*;
public class Main {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            VirtualEscapePuzzle p = new VirtualEscapePuzzle();
            
            p.addRoom(p.createRoom(
                    "Ancient Library",
                    "I speak without a mouth and hear without ears. I have no body, but I come alive with wind. What am I?",
                    "Echo"));
            
            p.addRoom(p.createRoom(
                    "Crystal Cavern",
                    "The more you take, the more you leave behind. What are they?",
                    "Footsteps"));
            
            p.addRoom(p.createRoom(
                    "Clock Tower",
                    "I have hands but cannot clap. What am I?",
                    "Clock"));
            
            p.addRoom(p.createRoom(
                    "Shadow Hall",
                    "I follow you all the time and copy your every move, but you can’t touch me or catch me. What am I?",
                    "Shadow"));
            
            p.addRoom(p.createRoom(
                    "Treasure Vault",
                    "What has keys but can’t open locks?",
                    "Piano"));
            
            p.addRoom(p.createRoom(
                    "Frozen Chamber",
                    "What can travel around the world while staying in a corner?",
                    "Stamp"));
            
            p.addRoom(p.createRoom(
                    "Mystic Garden",
                    "What has roots that nobody sees, is taller than trees, up, up it goes, and yet never grows?",
                    "Mountain"));
            
            p.addRoom(p.createRoom(
                    "Enchanted Armory",
                    "What gets wetter the more it dries?",
                    "Towel"));
            
            p.addRoom(p.createRoom(
                    "Obsidian Gate",
                    "I shave every day, but my beard stays the same. What am I?",
                    "Barber"));
            
            p.addRoom(p.createRoom(
                    "Celestial Observatory",
                    "The more of this there is, the less you see. What is it?",
                    "Darkness"));
            
            boolean exit = false;
            
            while (!exit) {
                
                System.out.println("\nWelcome to the Virtual Escape Room !\n");
                System.out.println("1- List unsolved rooms.");
                System.out.println("2- Solve puzzle");
                System.out.println("3- Exit Game");
                System.out.println("Enter your choice : ");
                
                int choice = sc.nextInt();
                sc.nextLine();
                
                switch (choice) {
                    
                    case 1 -> p.listUnsolvedRooms();
                    
                    case 2 -> {
                        System.out.println("Enter room name : ");
                        String name = sc.nextLine();
                        
                        Room room = p.findRoomByName(name);
                        p.displayPuzzle(room);
                        
                        if (room != null) {
                            
                            boolean check = false;
                            
                            while (!check) {
                                
                                System.out.println("Lock your answer :");
                                String answer = sc.nextLine();
                                
                                check = p.solvePuzzle(name, answer);
                                if(!check)
                                    if (p.lives == 0) {
                                        System.out.println(">> 0 lives left !\nGame End!");
                                        exit = true;
                                        check = true;
                                    } else {
                                        System.out.println(">> "+p.lives + " lives left!");
                                        System.out.println("> Score : "+p.score);
                                    }
                            }
                        }
                    }
                    
                    case 3 -> {
                        exit = true;
                        System.out.println("Game End!\nScore : " + p.score);
                    }
                    
                    default -> System.out.println("Invalid choice!");
                }
            }
        }
    }
}
