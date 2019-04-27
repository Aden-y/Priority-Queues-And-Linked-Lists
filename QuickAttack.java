
public class QuickAttack extends BattleEvent {
   public QuickAttack(Actor target, Actor owner){
       super(target,owner);
        this.damage=-10;
        this.priority=-1;
      
    }
        public void doEvent() {
        System.out.println(this.owner.getName()+"Attacks "+this.target.getName()+" for damage of "+this.damage+"!");
        this.target.takeDamage(this.damage);
       // System.out.println("***********************"+target.getHealth());
        if(target.getHealth()==0){
            System.out.println(this.target.getName()+" Was Killed");
            BattleEngine.remove(this.target);
        }
    }


    
}
