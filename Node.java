
public class Node {
    private BattleEvent data;
    private Node next;
    public Node(BattleEvent data){
        this.data=data;
        this.next=null;
    }
    public Node next(){
        return this.next;
    }
    public BattleEvent getData(){
        return this.data;
    }
    public void setNext(Node next){
        this.next=next;
    }
}
