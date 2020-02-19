public class Node {
    public MemberPlayer myPlayer;
    public Node next;

    // Constructor
    Node(MemberPlayer myPlayer, Node next) {
        this.myPlayer = myPlayer;
        this.next = next;
    }
}
