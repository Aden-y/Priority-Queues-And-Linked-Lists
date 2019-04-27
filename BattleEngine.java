
 
public class BattleEngine{
    private static Node head;
   public static boolean isEmpty(){
       if(BattleEngine.count()==0){
           return true;
       }
       else{
           return false;
       }
   }
   public static int count(){
       int count=0;
       Node current=head;
       while(current!=null){
           count++;
           current=current.next();
       }
       return count;
   }
    public static void print(){
        Node current=head;
        System.out.println("Battle Event queue is: ");
        while(current!=null){
            System.out.println(current.getData().toString());
            current=current.next();
        }
    }
    public static Actor executeNext(){
        Node event=head;
        if(event!=null){ 
            event.getData().doEvent();
             Actor target=event.getData().getTarget();
            // head=event.next();
            BattleEngine.delete(event);
            return target;
        }
        else {
            return null;
        }
    }
    public static void remove(Actor actor){
        Node current=head;
        while(current!=null){
            if(current.getData().getOwner().equals(actor) ||current.getData().getTarget().equals(actor)){
               delete(current);
            }
            current=current.next();
        }
    }
    public static void  delete(Node node){
        Node current=head, previous=null;
        while(current!=null){
            if(current.equals(node)){
                if(previous==null){
                    head=current.next();
                    current=null;
                }else{
                 previous.setNext(current.next());
                current=null;
                }
            }else{
                           previous=current;
            current=current.next(); 
            }

        }
    }
    public static void add(BattleEvent event){
        Node node=new Node(event);
       if(head==null){
            head=node;
            head.setNext(null);
          
        }else{
            Node current=head;
            Node following=current.next();
            if(following!=null){
                while(current!=null){
                if(current.getData().getPriority()<event.getPriority() && following.getData().getPriority()>=event.getPriority()){
                    current.setNext(node);
                    node.setNext(following);
                    break;
                }
                current=following;
                following=following.next();
            }
            }else{
                if(current.getData().getPriority()<event.getPriority()){
                    current.setNext(node);
                    node.setNext(null);
                   
                }else{
                    node.setNext(current);
                    current.setNext(null);
                    head=node;
                }
            }
        }
    }
    
    
    
}
