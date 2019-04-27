
import java.util.ArrayList;
import java.util.Scanner;


public class Assignment3 {
    private static Scanner scanner=new Scanner(System.in);
    private static ArrayList<Actor> actors=new ArrayList<Actor>();
    private static Actor player;
    private static boolean battleOn;
    private static boolean newEnemyAdded;
    private static int turns=0;
   private static Actor Goblin =new Actor("Goblin");
    public static char menu(){
        
        System.out.println("a. Check the status of the combatants\n" +
                "b. Quick Attack\n" +
                "c. Normal Attack\n" +
                "d. Precise Attack\n" +
                "e. Quick Heal\n" +
                "f. Normal Heal\n" +
                "g. Long Heal\n" +
                "h. Quit");
              return scanner.next().toLowerCase().charAt(0);

                    }
    public static Actor helper(){
        System.out.println("Enter the name of the actor you want to attack:");
        String name=scanner.next().toLowerCase();
        Actor toAttack=null;
        for(int i=0;i<actors.size();i++){
           // System.out.println(actors.get(i).getName());
            String curentName=actors.get(i).getName().toLowerCase();
            boolean equal=true;
            if(curentName.length()==name.length()){
                            for(int j=0;j<curentName.length();j++){
                if(curentName.charAt(j)!=name.charAt(j)){
                    equal=false;
                    break;
                }
            }
            }else{
                equal=false;
               // System.out.println("Name  "+name.length());
                // System.out.println("NameInList  "+curentName.length());
            }
            if(equal){
               // System.out.println("Fine");
                toAttack=actors.get(i);
                break;
            }

        }
            if(toAttack== null){
            System.out.println("No such name among fighters");
        }
        return toAttack;
    }
    public static void runTurn(){
        turns+=1;
        Actor Imp=new Actor("Imp");
        if(!newEnemyAdded && turns>=3){
            //Add new Enemy
            actors.add(Imp);
            System.out.println("Imp has joined the fight!"); 
            newEnemyAdded=true;
        }
        BattleEngine.add(new Attack(player,Goblin));
        if(actors.contains(Imp)){
         BattleEngine.add(new QuickAttack (player,Imp));
        }
        BattleEngine.print();
        while(!BattleEngine.isEmpty()){
            battleOn=true;
            Actor target=BattleEngine.executeNext();
            if (target.isDead()){
                actors.remove(target);
            }
            if(actors.size()<=1){
                battleOn=false;
                System.out.println("Game Over!");
                System.exit(0);
            }
        }
        
    }
    
    public static void main(String []args){
         
        player=new Actor("Player");
        actors.add(player);
        actors.add(Goblin);
        battleOn=true;
        
        char input;
        do{
            System.out.println("What do you want to do?");
            input=menu();
            if(input=='a'){
              for(int i=0; i<actors.size();i++){
                  System.out.println(actors.get(i).getName()+" has "+actors.get(i).getHealth()+" left");
              }
            
        }else if(input=='b'){
            Actor toAttack=null;
            while(toAttack==null){
               toAttack= helper();
            }
            BattleEngine.add(new QuickAttack(toAttack,player));
            runTurn();
        }else if (input=='c'){
              Actor toAttack=null;
            while(toAttack==null){
                toAttack=helper();
            }
            BattleEngine.add(new Attack(toAttack,player));
            runTurn();
        }else if(input=='d'){
             Actor toAttack=null;
            while(toAttack==null){
                toAttack=helper();
            }
            BattleEngine.add(new PreciseAttack(toAttack,player));
            runTurn();
        }else if(input=='e'){

            BattleEngine.add(new QuickHeal(player,null));
            runTurn();
        }else if(input=='f'){
             BattleEngine.add(new Heal(player,null));
             runTurn();
        }else if(input=='g'){
             BattleEngine.add(new LongHeal(player,null));
             runTurn();
        }else if(input=='h'){
                System.out.println("Exiting........");
                System.exit(0);
        }
        else{
                System.out.println("Invalid input");
        }
         //   input=menu();
        }while(battleOn && input!='h');
        
    }
}
