import  java.util.*;
public class VirtualEscapePuzzle {

    private final ArrayList<Room> rooms = new ArrayList<>();
    int lives = 3;
    int score = 0;

    public Room createRoom(String roomName, String puzzle, String answer) {
        return new Room(roomName, puzzle, answer);
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Room findRoomByName(String name) {
        for (Room room : rooms) {
            if (room.roomName.equalsIgnoreCase(name)) {
                return room;
            }
        }
        return null;
    }

    public void displayPuzzle(Room room) {
        if (room != null) {
            System.out.println("Solve the riddle : \" " + room.puzzle+" \"");
        } else {
            System.out.println("No room found !");
        }
    }

    public boolean solvePuzzle(String name, String answer) {

        Room room = findRoomByName(name);

        if (room == null) {
            System.out.println("No room found !");
        } else {
            if (room.answer.equalsIgnoreCase(answer)) {
                room.isSolved = true;
                System.out.println("Congratulations! Puzzle solved.");
                score++;
                return true;
            } else {
                System.out.println("Incorrect Answer! Try again.");
                lives--;
                return false;
            }
        }
        return true;
    }

    public void listUnsolvedRooms() {

        int count = 0;
        int i=0;
        for (Room room : rooms) {
            if (!room.isSolved) {
                System.out.println("Room "+(++i)+" : "+room.roomName);
                count++;
            }
        }

        if (count == 0) {
            System.out.println("All rooms are solved ! \nCongratulations! You have escaped the Virtual Escape Room!..");
        }
    }
}
