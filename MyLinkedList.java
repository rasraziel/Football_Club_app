import java.io.*;

public class MyLinkedList {

    Node front; // front of list

    //Search Player
    public void searchByTeam(String x, MyLinkedList list) {
        boolean flag = false;
        if(list.front == null){
            System.out.println("The are no players in the list!");
        } else {
            Node last = list.front;
            System.out.println("List of players/members:");
            System.out.println("------------------------");
            System.out.printf("%25s%25s%25s%25s%n","|FIRST NAME|","|LAST NAME|","|AGE|","|TEAM|");
            System.out.printf("%25s%25s%25s%25s%n","------------","-----------","-----","------");
            while(last != null){
                if(last.myPlayer.getTeam().equals(x)){
                    System.out.printf("%25s%25s%25s%25s%n",last.myPlayer.getFirstName(), last.myPlayer.getLastName(), last.myPlayer.getAge(), last.myPlayer.getTeam());
                    flag = true;
                }
                last = last.next;
            }
        }
        if(!flag) System.out.println("No players found!");
    }

    //Search Player
    public void searchPL(String x, MyLinkedList list) {
        boolean flag = false;
        if(list.front == null){
            System.out.println("The are no players in the list!");
        } else {
            Node last = list.front;
            System.out.println("List of players/members:");
            System.out.println("------------------------");
            System.out.printf("%25s%25s%25s%25s%n","|FIRST NAME|","|LAST NAME|","|AGE|","|TEAM|");
            System.out.printf("%25s%25s%25s%25s%n","------------","-----------","-----","------");
            while(last != null){
                if(last.myPlayer.getLastName().equals(x)){
                    System.out.printf("%25s%25s%25s%25s%n",last.myPlayer.getFirstName(), last.myPlayer.getLastName(), last.myPlayer.getAge(), last.myPlayer.getTeam());
                    flag = true;
                }
                last = last.next;
            }
        }
        if(!flag) System.out.println("No players found!");
    }

    //method to remove a node
    public void remove(String x, MyLinkedList list) {
        if (list.front.myPlayer.getLastName().equals(x)) {
            list.front = list.front.next;
        } else {
            Node current = list.front;
            Node spot = null;
            while(current.next != null) {
                if (current.next.myPlayer.getLastName().equals(x)) {
                    spot = current;
                }
                current = current.next;
            }
            if (spot != null){
                spot.next = spot.next.next;
                System.out.println("The player " + x + " has been deleted!");
            }

        }
    }

    public static void search(int startingAge, int endingAge, MyLinkedList list){
        boolean flag = false;
       if(list.front == null){
           System.out.println("The are no players in the list!");
       } else {
           Node last = list.front;
           System.out.println("List of players/members:");
           System.out.println("------------------------");
           System.out.printf("%25s%25s%25s%25s%n","|FIRST NAME|","|LAST NAME|","|AGE|","|TEAM|");
           System.out.printf("%25s%25s%25s%25s%n","------------","-----------","-----","------");
           while(last != null){
            if(last.myPlayer.getAge()>=startingAge && last.myPlayer.getAge()<=endingAge){
                System.out.printf("%25s%25s%25s%25s%n",last.myPlayer.getFirstName(), last.myPlayer.getLastName(), last.myPlayer.getAge(), last.myPlayer.getTeam());
                flag = true;
            }
            last = last.next;
           }
       }
        if(!flag) System.out.println("No players found!");
    }

    // Method to insert a new node
    public static void insert(MyLinkedList list, MemberPlayer myPlayer) {
        // Create a new node with given data
        //Node new_node = new Node(obj);
        //new_node.next = null;

        // If the Linked List is empty,
        // then make the new node as front
        if (list.front == null|| list.front.myPlayer.getAge() >= myPlayer.getAge()) {
            list.front = new Node(myPlayer, list.front);
        } else {
            // Else traverse till the last node
            // and insert the new_node there

            Node last = list.front;
            while (last.next != null && last.next.myPlayer.getAge() < myPlayer.getAge()) {
                last = last.next;
            }

            // Insert the new_node at last node
            last.next = new Node(myPlayer, last.next);
        }
    }

    // Method to print the LinkedList.
    public static void printList(MyLinkedList list)
    {
        Node currNode = list.front;

        System.out.println("List of players/members:");
        System.out.println("------------------------");
        System.out.printf("%25s%25s%25s%25s%n","|FIRST NAME|","|LAST NAME|","|AGE|","|TEAM|");
        System.out.printf("%25s%25s%25s%25s%n","------------","-----------","-----","------");

        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.printf("%25s%25s%25s%25s%n",currNode.myPlayer.getFirstName(), currNode.myPlayer.getLastName(), currNode.myPlayer.getAge(), currNode.myPlayer.getTeam());

            // Go to next node
            currNode = currNode.next;
        }
    }

    public static void writeToFile(MyLinkedList list) throws IOException {
        PrintStream wr = new PrintStream(new FileOutputStream("C:\\Users\\rasra\\Desktop\\idea\\src\\players.txt"));
        if(list.front == null){
            System.out.println("The are no players in the list to be written to file!");
        } else {
            Node last = list.front;
            while(last != null){
                wr.print(last.myPlayer.toString());
                last = last.next;
                if(last != null) wr.println();
            }
            wr.close();
        }
    }


}
