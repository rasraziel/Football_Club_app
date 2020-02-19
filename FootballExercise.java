import java.util.*;
import java.io.*;

public class FootballExercise {

static Scanner input = new Scanner(System.in);
static MyLinkedList list = new MyLinkedList();
static Scanner myScanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException{
        Scanner rd = new Scanner(new File("C:\\Users\\rasra\\Desktop\\idea\\src\\players.txt"));

        while(rd.hasNextLine()){
            MemberPlayer myPlayer = new MemberPlayer(rd.next(), rd.next(), rd.nextInt(), rd.next());
            list.insert(list, myPlayer);
        }
        menu();
    }

    public static void menu() throws IOException{
        System.out.println("Welcome to the Football Club app!");
        System.out.println("Please select an option:\n1 - Create new players/members\n2 - List all members/players");
        System.out.println("3 - Search for a player\n4 - Delete a player\n5 - Search for the players of a team\n6 - Search within age group");
        System.out.println("0 - To exit");
        selection();
    }

    public static void selection() throws IOException{
        int sel = input.nextInt();
        switch (sel){
            case 1:
                MemberPlayer myPlayer = new MemberPlayer();
                System.out.println("Enter the first name of the player:");
                myPlayer.setFirstName(myScanner.next());
                System.out.println("Enter the last name of the player:");
                myPlayer.setLastName(myScanner.next());
                System.out.println("Enter the age of the player:");
                myPlayer.setAge(myScanner.nextInt());
                System.out.println("Enter the the team of the player:");
                myPlayer.setTeam(myScanner.next());
                list.insert(list, myPlayer);
                menu();
            case 2:
                list.printList(list);
                menu();
            case 3:
                System.out.println("Please enter the last name of the player you want to find:\n");
                String x = myScanner.next();
                list.searchPL(x, list);
                menu();
            case 4:
                System.out.println("Please enter the last name of the player to be deleted:\n");
                x = myScanner.next();
                list.remove(x, list);
                menu();
            case 5:
                System.out.println("Please enter the team you want to see the players of:");
                x = myScanner.next();
                list.searchByTeam(x, list);
                menu();
            case 6:
                System.out.println("Please enter the age span of the players you want to see:");
                int startingAge = myScanner.nextInt();
                int endingAge = myScanner.nextInt();
                list.search(startingAge, endingAge, list);
                menu();
            case 0:
                list.writeToFile(list);
                System.exit(0);
            default:
                System.out.println("Wrong selection. Try again!");
                menu();
        }
    }
}
